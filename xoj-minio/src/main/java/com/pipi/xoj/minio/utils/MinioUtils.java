/**
 * @Time: 2024/4/7 20:20
 * @Author: guoxun
 * @File: MinioUtils
 * @Description:
 */

package com.pipi.xoj.minio.utils;

import com.pipi.xoj.common.core.response.R;
import com.pipi.xoj.minio.config.MinioConfig;
import io.minio.*;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Component
public class MinioUtils {

    @Autowired
    private MinioClient minioClient;

    @Autowired
    private MinioConfig minioConfig;

    /**
     * 判断bucket是否存在，不存在则创建
     * @param name
     * @return
     */
    public boolean existBucket(String name){
        boolean exists;
        try {
            exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(name).build());
            if (!exists){
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(name).build());
                exists = true;
            }
        } catch (Exception e){
            e.printStackTrace();
            exists = false;
        }
        return exists;
    }

    /**
     * 创建bucket
     * @param bucketName
     * @return
     */
    public boolean makeBucket(String bucketName){
        try {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 删除bucket
     * @param bucketName
     * @return
     */
    public boolean removeBucket(String bucketName){
        try {
            minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 使用putObject上传一个文件到存储桶中
     * @param file 文件
     * @param fileName 文件名
     */
    public boolean upload(MultipartFile file, String fileName){
        try {
            InputStream inputStream = file.getInputStream();
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(minioConfig.getBucketName())
                    .object(fileName)
                    .stream(inputStream, file.getSize(), -1)
                    .contentType(file.getContentType()).build());
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据filename获取文件的访问地址
     * @param objectName 对象名称
     * @param time  时间
     * @param timeUnit 单位时间
     * @return
     */
    public String getUrl(String objectName, int time, TimeUnit timeUnit){
        String url = null;
        try {
            url = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                    .method(Method.GET)
                    .bucket(minioConfig.getBucketName())
                    .object(objectName)
                    .expiry(time, timeUnit).build());
        } catch (Exception e){
            e.printStackTrace();
        }
        return url;
    }

    /**
     * 下载文件
     * @param fileName
     * @return
     */
    public R<byte[]> download(String fileName){
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = minioClient.getObject(GetObjectArgs.builder().bucket(minioConfig.getBucketName()).object(fileName).build());
            out = new ByteArrayOutputStream();
            // 封装返回值
            byte[] bytes = out.toByteArray();
            HttpHeaders httpHeaders = new HttpHeaders();
            try {
                httpHeaders.add("Content-Disposition", "attachment;filename=" + URLEncoder.encode(
                        fileName, "UTF-8"));
            } catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }
            httpHeaders.setContentLength(bytes.length);
            httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            httpHeaders.setAccessControlExposeHeaders(Arrays.asList("*"));
            return R.successResponse(bytes);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return R.errorResponse("文件下载失败");
    }

    /**
     * 根据文件名和桶获取文件路径
     * @param objectFile
     * @return
     */
    public String getFileUrl(String objectFile){
        try {
            return minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                    .method(Method.GET)
                    .bucket(minioConfig.getBucketName())
                    .object(objectFile).build());
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}