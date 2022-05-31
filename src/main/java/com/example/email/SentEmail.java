package com.example.email;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.StringJoiner;

/**
 * @author kai·yang
 * @Date 2022/5/31 17:07
 */
public class SentEmail {
    /**
     * 发送邮件
     * @param to 收件人,多人以","分隔开
     * @param cc 抄送人,数组
     * @param subject 邮件主题
     * @param content 邮件正文
     * @param fromHost 发件人smtp host
     * @param fromUsername 发件人邮箱
     * @param fromPassword 发件人密码
     */
    public boolean sendMail(String to, String[] cc,String subject, String content
            , String fromHost, String fromUsername, String fromPassword) {
        if (to == null || to.trim().isEmpty()) {
            return false;
        }
        Transport transport = null;
        try {
            Properties prop = new Properties();
            Session session = Session.getInstance(prop);
            MimeMessage message = new MimeMessage(session);
            // 发件人
            InternetAddress fromAddress = new InternetAddress(fromUsername);
            // 收件人
            String[] tos = to.split(",");
            InternetAddress[] toAddresses = new InternetAddress[tos.length];
            for (int i = 0; i < tos.length; i++) {
                toAddresses[i] = new InternetAddress(tos[i]);
            }
            message.setFrom(fromAddress);
            //收件人
            message.setRecipients(Message.RecipientType.TO, toAddresses);
            //抄送人
            if (cc != null || cc.length > 0) {
                String ccString = getCCString(cc);
                message.setRecipients(Message.RecipientType.CC, ccString);
            }
            // 主题
            message.setSubject(subject);
            // 正文，HTML格式
            message.setContent(content, "text/html;charset=UTF-8");

            transport = session.getTransport("smtp");
            transport.connect(fromHost, fromUsername, fromPassword);
            transport.sendMessage(message, message.getAllRecipients());

        } catch (AddressException e) {
            e.printStackTrace();
            return false;
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
            return false;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (transport != null) {
                try {
                    transport.close();
                } catch (MessagingException e) {

                }
            }
        }
        return true;
    }

    /**
     * 抄送人
     * @param cc
     * @return
     */
    private String getCCString(String[] cc){
        StringJoiner sj = new StringJoiner(",");
        for (String s : cc) {
            sj.add(s);
        }
        return sj.toString();
    }
}
