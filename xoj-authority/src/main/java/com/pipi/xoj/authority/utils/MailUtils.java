/**
 * @Time: 2024/3/30 15:35
 * @Author: guoxun
 * @File: MailUtils
 * @Description:
 */

package com.pipi.xoj.authority.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class MailUtils {

    private static String sendEmail;
    private static String authorityCode;
    private static String host;

    @Autowired
    public MailUtils(@Value("${mailConfig.sendEmail}") String sendEmail,
                     @Value("${mailConfig.authorityCode}") String authorityCode,
                     @Value("${mailConfig.host}") String host) {
        MailUtils.sendEmail = sendEmail;
        MailUtils.authorityCode = authorityCode;
        MailUtils.host = host;
    }

    /**
     * 发送验证码到邮箱
     * @param randomCode 验证码
     * @param targetEmail 收件人邮箱地址
     */
    public static void sendMessage(String randomCode, String targetEmail, String subject, String text, int time){

        // 系统属性
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        // 获取默认会话对象
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名、授权码
                return new PasswordAuthentication(sendEmail, authorityCode);
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // 头部字段
            message.setFrom(new InternetAddress(sendEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(targetEmail));
            message.setSubject(subject);
            message.setText(text + randomCode + "\n有效时间为: " + time + "分钟。");
            // 发送邮件
            Transport.send(message);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
