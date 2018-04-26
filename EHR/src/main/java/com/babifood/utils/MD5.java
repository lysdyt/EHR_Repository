package com.babifood.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public static String gtePasswordMd5(String password){
		StringBuffer buffer = null;
		try {
			// 得到一个信息摘要器
			MessageDigest digest = MessageDigest.getInstance("md5");
			byte[] result = digest.digest(password.getBytes());
	        buffer = new StringBuffer();
	        // 把每一个byte 做一个与运算 0xff;
	        for (byte b : result) {
	            // 与运算
	            int number = b & 0xff;// 加盐
	            String str = Integer.toHexString(number);
	            if (str.length() == 1) {
	                buffer.append("0");
	            }
	            buffer.append(str);
	        }
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return buffer.toString();
	}
}
