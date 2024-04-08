/**
 * @Time: 2024/4/7 20:28
 * @Author: guoxun
 * @File: MinioFileUploadController
 * @Description:
 */

package com.pipi.xoj.minio.controller;

import com.pipi.xoj.common.core.response.R;
import com.pipi.xoj.minio.utils.MinioUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@RestController
@RequestMapping("/minio")
public class MinioFileUploadController {

    @Autowired
    private MinioUtils minioUtils;

    @PostMapping("/upload")
    public R uploadFile(@RequestParam("file")MultipartFile file, String fileName){
        boolean uploadStatus = minioUtils.upload(file, fileName);
        if (uploadStatus)
            return R.successResponse("文件上传成功");
        else
            return R.errorResponse("文件上传失败");
    }

    @GetMapping("/download")
    public R downloadFile(@RequestParam("fileName") String fileName){
        return minioUtils.download(fileName);
    }

    @GetMapping("/getUrl")
    public R<HashMap<String, String>> getFileUrl(@RequestParam("fileName") String fileName){
        HashMap<String, String> map = new HashMap<>();
        map.put("fileUrl", minioUtils.getFileUrl(fileName));
        return R.successResponse(map);
    }

    @GetMapping("/test")
    public R test(){
        return R.successResponse("test");
    }
}
