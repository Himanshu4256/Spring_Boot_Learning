package com.omnie.forms.json;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.spi.FileSystemProvider;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.omnie.forms.model.FormComponent;

public class FormMetaDataFactory {

	final ConcurrentHashMap<String, FormComponent> cache = new ConcurrentHashMap<String, FormComponent>();

	final String schema_root = "schema";

	// singleton pattern
	private static FormMetaDataFactory instance = null;

	public ConcurrentHashMap<String, FormComponent> getCache() {
		return cache;
	}

	public static FormMetaDataFactory getInstance() {
		synchronized (FormMetaDataFactory.class) {
			if (instance == null) {
				instance = new FormMetaDataFactory();
			}
			return instance;
		}
	}

	private FormMetaDataFactory() {
		this.init();
	}

	private void init(){
		try {
			URL resource = ConfigurationFactory.getFactory().getConfigDirURLForChild(schema_root);
			URI uri = resource.toURI();
			if("jar".equals(uri.getScheme())){
			    for (FileSystemProvider provider: FileSystemProvider.installedProviders()) {
			        if (provider.getScheme().equalsIgnoreCase("jar")) {
			            try {
			                provider.getFileSystem(uri);
			            } catch (FileSystemNotFoundException e) {
						    provider.newFileSystem(uri, Collections.emptyMap());
			            }
			        }
			    }
			}
			Path path = Paths.get(uri);
			
			if(!path.toFile().exists()) {
				return;
			}
			
			Files.list(path).forEach(file -> {
				load(file);
			});
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	private void load(Path file) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			InputStream inJson = file.toUri().toURL().openStream();
			TypeReference<List<FormComponent>> typeReference = new TypeReference<List<FormComponent>>() {
			};
			List<FormComponent> formComponentList = objectMapper.readValue(inJson, typeReference);
			for (FormComponent formComponent : formComponentList) {
				getCache().put(formComponent.getId(), formComponent);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(FormMetaDataFactory.getInstance().getCache());
	}

	public FormComponent findByid(String clientId) {
		return getCache().get(clientId);
	}
}
