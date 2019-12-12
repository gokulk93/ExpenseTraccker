package com.expenses.tracker.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@Service
public class FileServiceImpl implements FileService {
    private final String directory="C:\\Users\\gkumar24\\Desktop\\report\\";

    @Override
    public void uploadFile(MultipartFile multipartFile) {

    }
}
