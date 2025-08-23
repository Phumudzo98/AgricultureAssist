package com.agriculture.project.service.initialization;

import org.springframework.web.multipart.MultipartFile;

public interface GeminiService {

    String analyzeImage(String prompt, MultipartFile file) throws Exception;
}
