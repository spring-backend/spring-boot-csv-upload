package com.suresh.spring.csvupload.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.suresh.spring.csvupload.service.CsvUploadService;
import com.suresh.spring.csvupload.util.FileUploadUtils;

@Service
public class CsvUploadServiceImpl implements CsvUploadService {

	@Override
	public String uploadCsvFile(MultipartFile file) {
		String message = "Success";
		
		doPreValidationForFileUpload(file);
		
		uploadFileToPersistentStore(file);
		
		doPostValidationForFileUpload(file);
		
		return message;
	}

	/**
	 * 1. Update the status of the file upload
	 * 2. Trigger an update/message to any integration systems about file upload status.
	 * 3. 
	 */
	private void doPostValidationForFileUpload(MultipartFile file) {
		
	}

	/**
	 * 1. Update the file to persistent store
	 * 2. 
	 */
	private void uploadFileToPersistentStore(MultipartFile file) {
		//When saving to a persistent store, use @Transactional adhering to ACID compliance. 
	}

	/**
	 * 1. Allow only supported file formats. (Alternatively a filter can also be used). 
	 * 2. Check for max file size limit
	 * 3. Check for empty file
	 * 4.  
	 */
	private void doPreValidationForFileUpload(MultipartFile file) {
		
		if (null == file) {
			//Log it and throw exception
			return;
		}
		
		if (FileUploadUtils.isReceivedFileEmpty(file)) {
			//Log it and throw exception
			return;
		}
		
		if (!FileUploadUtils.isValidFileExtension(file)) {
			//Log it and throw exception
			return;
		}
		
	}
}
