package com.example.mysocket;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: kai·yang
 * @Date: 2024/4/22 17:58
 * @Description:
 */
public class TestMain {


    public static void main(String[] args) {
        String originalString = "6af9c941cb678a0d";
        String encryptedString = encrypt(originalString);
        System.out.println("Original String: " + originalString);
        System.out.println("Encrypted String: " + encryptedString);
    }


    public static String encrypt(String input) {
        try {
            // 创建 MessageDigest 实例并指定算法为 MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算摘要
            byte[] messageDigest = md.digest(input.getBytes());
            // 将摘要转换为十六进制字符串
            BigInteger no = new BigInteger(1, messageDigest);
            String hashText = no.toString(16);
            // 如果转换后的字符串长度不足32位，需要在前面补0
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            return hashText;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }
}
