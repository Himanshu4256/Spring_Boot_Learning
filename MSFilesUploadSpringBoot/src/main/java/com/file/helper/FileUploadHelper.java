package com.file.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	// This is the Static location where your file will upload if you want to run this on different machine then you have to change this
	//public final String UPLOAD_DIR = "/Users/*****/eclipse-workspace/MSFilesUploadSpringBoot/src/main/resources/static/image";
	
	//Here Dynamic Path take  "ClassPathResource" it takes by default inside Resources Folder path
	public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath(); //	 files are at -> /Users/*****/eclipse-workspace/MSFilesUploadSpringBoot/target/classes/static/image

	
	public FileUploadHelper() throws IOException{
		
	}
	
	public boolean uploadFile(MultipartFile multipartFile) {
		boolean upload = false;
		try {
//			InputStream is = multipartFile.getInputStream();
//			byte data[] = new byte[is.available()];
//			is.read(data);
//			
//			//write 
//			FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
//			fileOutputStream.write(data);
//			fileOutputStream.flush();
//			fileOutputStream.close();
			
			//-- In sort of above code 
			Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			upload = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return upload;
	}
}
