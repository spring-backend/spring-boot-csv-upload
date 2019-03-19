package com.suresh.spring.csvupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.suresh.spring.csvupload.service.CsvUploadService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/file-upload")
@CrossOrigin(origins = "*")
@Api(tags={"File Upload Controller"})
public class CsvUploadController {

	@Autowired
	private CsvUploadService csvUploadService;
	
	@PostMapping
	public String uploadCsv(@RequestParam("file") MultipartFile file) {
		return csvUploadService.uploadCsvFile(file);
	}
}
