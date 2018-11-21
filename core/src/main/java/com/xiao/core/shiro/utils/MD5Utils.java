package com.xiao.core.shiro.utils;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

/**
 * MD5加密解密工具类
 */
public class MD5Utils {

    /**
     * 使用Apache的Hex类实现Hex(16进制字符串和)和字节数组的互转
     */
    @SuppressWarnings("unused")
    private static String md5Hex(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(str.getBytes());
            return new String(new Hex().encode(digest));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
            return "";
        }
    }

    /**
     * 加盐MD5加密
     */
    public static String getSaltMD5(String password, String salt) {
        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 + 1);
            char c = salt.charAt(i / 3 + 1);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return String.valueOf(cs);
    }


    public static void main(String[] args) {
        System.out.println(getSaltMD5("123456", "123456123456123456"));
    }

}
