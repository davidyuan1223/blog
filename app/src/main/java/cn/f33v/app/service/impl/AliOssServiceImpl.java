package cn.f33v.app.service.impl;

import cn.f33v.app.service.AliOssService;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.internal.OSSUtils;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import cn.f33v.app.common.AliOss;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Administrator
 */
@Service
public class AliOssServiceImpl implements AliOssService {
    @Override
    public void createBucket() {
        OSS ossClient = new OSSClientBuilder().build(AliOss.END_POINT, AliOss.ACCESS_KEY_ID, AliOss.ACCESS_KEY_SECRET);
        if (ossClient.doesBucketExist(AliOss.BUKET_NAME)) {
            throw new RuntimeException(AliOss.BUKET_NAME + "对象存储已经存在");
        }
        ossClient.createBucket(AliOss.BUKET_NAME);
        ossClient.shutdown();
    }

    @Override
    public String upload(MultipartFile file) {
        String uploadUrl = "";
        try {
            //创建OSSClient实例
            OSS ossClient = new OSSClientBuilder().build(AliOss.END_POINT, AliOss.ACCESS_KEY_ID, AliOss.ACCESS_KEY_SECRET);
            if (!ossClient.doesBucketExist(AliOss.BUKET_NAME)) {
                ossClient.createBucket(AliOss.BUKET_NAME);
                //设置属性
                ossClient.setBucketAcl(AliOss.BUKET_NAME, CannedAccessControlList.PublicRead);
            }
            //每次上传名字需要不同,因此弄一个不同名字
            //uuid redis 分布式id 雪花算法 定义一个文件格式 yyyy/MM/dd+uuid
            //获取上传文件的文件流
            InputStream inputStream = file.getInputStream();
            //构建日期文件夹路径
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            String dataPath = format.format(date);
            //获取上传文件全名称
            String original = file.getOriginalFilename();
            //获取UUID
            String filenameUuid = UUID.randomUUID().toString().replaceAll("-", "");
            //获取上传文件拓展名
            assert original != null;
            String fileType = original.substring(original.lastIndexOf("."));
            //拼接文件名称
            String newName = filenameUuid + fileType;
            //生成文件夹
            filenameUuid = dataPath + "/" + newName;
            //如果想要实现图片预览效果,需要设置以下几点
            //1. 设置文件,ACL为反转不能为私有,要么是公共读,要么是公共读写
            //2. 需要设置文本类型为(image/jpg)
            ObjectMetadata objectMetadata = new ObjectMetadata();
            //设置公共读权限
            objectMetadata.setObjectAcl(CannedAccessControlList.PublicRead);
            //设置类型
            objectMetadata.setContentType(getContentType(fileType));
            //上传文件到指定存储空间,并将其保存为指定文件名称
            ossClient.putObject(AliOss.BUKET_NAME, filenameUuid, inputStream, objectMetadata);
            //关闭oss
            ossClient.shutdown();
            //获取url地址
            //默认十年不过期
            Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
            uploadUrl = ossClient.generatePresignedUrl(AliOss.BUKET_NAME, filenameUuid, expiration).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uploadUrl;
    }

    private String getContentType(String fileType) {
        if (fileType.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (fileType.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (fileType.equalsIgnoreCase(".jpeg") || fileType.equalsIgnoreCase(".jpg") || fileType.equalsIgnoreCase(".png")) {
            return "image/jpg";
        }
        if (fileType.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (fileType.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (fileType.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        return "image/jpeg";
    }

    @Override
    public void download(String filename) {

    }

    @Override
    public void listFile() {

    }

    @Override
    public void deleteFile(String filename) {
        //删除OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(AliOss.END_POINT, AliOss.ACCESS_KEY_ID, AliOss.ACCESS_KEY_SECRET);
        //删除文件
        ossClient.deleteObject(AliOss.BUKET_NAME, filename);
        //关闭
        ossClient.shutdown();
    }

}
