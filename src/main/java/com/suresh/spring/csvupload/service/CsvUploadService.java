package com.suresh.spring.csvupload.service;

import org.springframework.web.multipart.MultipartFile;

public interface CsvUploadService {

	String uploadCsvFile(MultipartFile file);
}
