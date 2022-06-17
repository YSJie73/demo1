package com.example.config;

public class MiniAppConfig {
    private static String uploadPath;

    public static String getUploadPath() {
        return uploadPath;
    }

    public static void setUploadPath(String uploadPath) {
        MiniAppConfig.uploadPath = uploadPath;
    }
}
