package cn.f33v.app.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Administrator
 */
public interface AliOssService {
    void createBucket();

    String upload(MultipartFile file);

    void download(String filename);

    void listFile();

    void deleteFile(String filename);
}
