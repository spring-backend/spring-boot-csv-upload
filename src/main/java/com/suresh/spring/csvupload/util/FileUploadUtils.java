package com.suresh.spring.csvupload.util;

import java.util.Arrays;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtils {

	public static String[] VALID_FILE_EXTENSIONS = {"csv", "CSV"};
	
	public static Boolean isReceivedFileEmpty(MultipartFile uploadFile) {
		
		if (null == uploadFile) {
			return Boolean.TRUE;
		}
		
		return uploadFile.isEmpty();
	}
	
	public static boolean isValidFileExtension(MultipartFile uploadFile) {
		
		boolean validFileExtension = Boolean.FALSE;
		
		if (uploadFile == null) {
			return validFileExtension;
		}
		
		String originalFileName = uploadFile.getOriginalFilename();
		
		if (StringUtils.isEmpty(originalFileName)) {
			return validFileExtension;
		}
		
		String fileExtension = FilenameUtils.getExtension(originalFileName);
		
		if (Arrays.asList(VALID_FILE_EXTENSIONS).contains(fileExtension)) {
			validFileExtension = Boolean.TRUE;
		}
		
		return validFileExtension;
	}
}
