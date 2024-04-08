/**
 * @Time: 2024/4/4 9:40
 * @Author: guoxun
 * @File: RequsetSandBoxService
 * @Description:
 */

package com.pipi.xoj.sandbox.service;

import com.pipi.xoj.common.core.response.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class RequestSandBoxService {

    @Value("${sandbox.host}")
    private String host;

    @Value("${sandbox.port}")
    private int port;

    @Value("${sandbox.connectTimeout}")
    private int connectTimeout;

    @Value("${sandbox.readTimeout}")
    private int readTimeout;

    public R<StringBuilder> request(String requestMethod, String paramJson){
//        HttpURLConnection connection = null;
//        BufferedReader reader = null;
        StringBuilder response = new StringBuilder();

        try {
            // 创建URL对象
            URL url = new URL("http://" + host + ":" + port + "/run");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(requestMethod);
            connection.setConnectTimeout(connectTimeout * 1000);
            connection.setReadTimeout(readTimeout * 1000);

            connection.setDoOutput(true);
            connection.setDoInput(true);

            // 设置请求参数
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            // 向服务器发送数据
            try {
                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
                writer.write(paramJson);
                writer.flush();
            } catch (Exception e){
                e.printStackTrace();
            }

            // 读取响应
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                System.out.println(response.toString());
            }

            connection.disconnect();

        } catch (Exception e){
            e.printStackTrace();
        }
        return R.successResponse(response);
    }
}
