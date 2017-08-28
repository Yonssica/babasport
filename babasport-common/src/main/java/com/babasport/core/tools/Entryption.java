package com.babasport.core.tools;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 * Created by hwd on 2017/8/27.
 */
public class Entryption {

    /**
     * 对字符串进行加密
     * @param str
     * @return
     */
    public static String entrypt(String str) {
        String pwd = null;
        try {
            // 使用md5加密方式
            MessageDigest instance = MessageDigest.getInstance("md5");
            // 开始加密，参数需要将字符串转成字节数组，返回的也是字节数组
            byte[] digest = instance.digest(str.getBytes());
            // 将字节数组转成十六进制字符串
            char[] encodeHex = Hex.encodeHex(digest);
            pwd = new String(encodeHex);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return pwd;

    }
}
