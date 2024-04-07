package com.omnie.forms.json;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class ConfigurationFactory {
	
	private static final String CLASSPATH = "classpath:";

	private static final String CONFIG_FILE = "CONFIG_FILE";
	
	private static final String CONFIG_DIR = "CONFIG_DIR";
	
	private String configDir=CLASSPATH+"/";

	private String configPath=CLASSPATH+"application.properties";
	
	private static ConfigurationFactory configurationFactory;
	
	private ConcurrentHashMap<String, Object> configurationCache=new ConcurrentHashMap<String, Object>();
	
	private ConfigurationFactory() {
	}

	public static ConfigurationFactory getFactory() {
		if(configurationFactory==null) {
			synchronized (ConfigurationFactory.class) {
				configurationFactory=new ConfigurationFactory();
			}
		}
		return configurationFactory;
	}
	
	public ConfigurationFactory loadFromArgs(String[] args) {
		for (String arg : args) {
			if(arg.contains("=")) {
				String[] props = arg.split("=");
				getConfigurationCache().put(props[0].trim(), props[1].trim());
			}
		}
		setConfigDir(getConfigurationCache().getOrDefault(CONFIG_DIR, configDir).toString());
		setConfigFile(getConfigurationCache().getOrDefault(CONFIG_FILE, configPath).toString());
		return configurationFactory;
	}
	
	public void setConfigFile(String configFile) {
		try {
			loadFromFile(configFile);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		this.configPath = configFile;
	}
	
	public ConfigurationFactory loadFromFile(String path) throws MalformedURLException {
		URL resource= path.startsWith(CLASSPATH) ?  Thread.currentThread().getContextClassLoader().getResource(path.split(CLASSPATH)[1]) : new File(path).toURI().toURL();
		if(resource==null) {
			throw new RuntimeException("Invalid { "+CONFIG_FILE+ "} path : "+path);
		}
		try {
			Properties properties =new Properties();
			properties.load(resource.openStream());
			properties.forEach((key,value)->{
				getConfigurationCache().put(key.toString().trim(), value.toString().trim());
			});
		} catch (IOException  e) {
			e.printStackTrace();
		}
		return configurationFactory;
	}
	
	public ConcurrentHashMap<String, Object> getConfigurationCache() {
		return configurationCache;
	}
	
	protected void setConfigDir(String configDir) {
		this.configDir=configDir;
	}
	
	public String getConfigDir() {
		return configDir;
	}
	
	public URL getConfigDirURL() {
		String path = getConfigDir();
		try {
			return path.startsWith(CLASSPATH) ?  Thread.currentThread().getContextClassLoader().getResource(path.split(CLASSPATH)[1]) : new File(path).toURI().toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public URL getConfigDirURLForChild(String folder) {
		String path = getConfigDir();
		try {
			if(path.startsWith(CLASSPATH)) {
				String resourcePath = path.split(CLASSPATH)[1];
				if("/".equals(resourcePath)) {
					resourcePath="";
				}
				URL resource = Thread.currentThread().getContextClassLoader().getResource(resourcePath+ folder);
				return resource;
			} else {
				return new File(path +folder).toURI().toURL();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}                                                                     
		return null;
	}

	public String findAsString(String key) {
		Object object = getConfigurationCache().get(key);
		if(object==null) {
			return "";
		}
		return String.valueOf(object);
	}
	
	public Integer findAsInt(String key) {
		String findAsString = findAsString(key);
		return Integer.valueOf(findAsString==null || findAsString.trim().isEmpty() ? "0" : findAsString);
	}
	
	public Boolean findAsBol(String key) {
		return Boolean.valueOf(findAsString(key));
	}
	
}
