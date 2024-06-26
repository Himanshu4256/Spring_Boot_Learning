package com.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.file.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		try {
		
		if (file.isEmpty()) 
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File is Empty");
		}
		
//		if(file.getContentType().equals("image/jpeg")) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only jpeg Files are allowed");
//		}
		
		//file upload code
		boolean uploadFile = fileUploadHelper.uploadFile(file);
		if (uploadFile) {
			return ResponseEntity.ok("File is Successfully uploaded at :"+ ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
		}
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some went wrong");
	}
}
