package com.example.utils.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * @Author: Cc
 * @Date: 2021/8/11 15:29
 */
public class Base64Util {
    /**
     * @param imgStr base64编码字符串
     * @param path   图片路径-具体到文件
     */
    public static boolean generateImage(String imgStr, String path) {
        if (imgStr == null)
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // 解密
            byte[] b = decoder.decodeBuffer(imgStr);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(path);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }


    /**
     * 图片转化成base64字符串
     * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
     * @return
     */
        public static String getImageStr(){
            //待处理的图片
            String imgFile = "C:\\Users\\lenovo\\Desktop\\word-seal.jpg";
            FileInputStream in;
            byte[] data = null;
            //读取图片字节数组
            try {
                in = new FileInputStream(imgFile);
                data = new byte[in.available()];
                in.read(data);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //对字节数组Base64编码
            BASE64Encoder encoder = new BASE64Encoder();
            //返回Base64编码过的字节数组字符串
            return encoder.encode(data);
        }
    }
