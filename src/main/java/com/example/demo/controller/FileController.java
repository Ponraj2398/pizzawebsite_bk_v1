package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Admin;
import com.example.demo.repos.AdminRepo;
import com.example.demo.repos.FileRepo;

// Annotation 
@RestController
@RequestMapping("/file")
public class FileController {
	@Autowired
	private Environment env;
	@Autowired
	private FileRepo fRepo;
	@Autowired
	private AdminRepo adminRepo;

	@PostMapping("/upload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadedFile) {
		if (uploadedFile.isEmpty()) {
			return new ResponseEntity<>("Please select a file!", HttpStatus.OK);
		}
		try {

			byte[] bytes = uploadedFile.getBytes();
			UUID uuid = UUID.randomUUID();
//			String uploadsLocation = env.getProperty("resource.uploads");
			String uploadsLocation = "C:\\SpringWorkspace\\Pizzawebsite\\src\\main\\resources\\Uploads";
			String image = uuid + uploadedFile.getOriginalFilename();
			String fileLocation = uploadsLocation + image;
			Path path = Paths.get(fileLocation);
			Files.write(path, bytes);
			
			Admin ad = new Admin();
            ad.setImage(image);
            adminRepo.save(ad);
//			File file = new File(fileLocation);
			return ResponseEntity.status(HttpStatus.OK).body(image);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.CREATED).body(e.getMessage());

		}
	}

}