package com.expenses.tracker.Services;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public void uploadFile(MultipartFile multipartFile);
}
