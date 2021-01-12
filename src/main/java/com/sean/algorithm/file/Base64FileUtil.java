package com.sean.algorithm.file;

import org.apache.commons.io.FileUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class Base64FileUtil {


    private static String targetFilePath = "E:\\wenming\\exporter-after\\exporter-after.zip";


    public static void main(String[] args) throws Exception {
//        String fileStr = getFileStr("E:\\wenming\\exporter.zip");
//
//        FileUtils.writeStringToFile(new File("E:\\\\wenming\\\\exporter-after\\\\exporter.txt"), fileStr, StandardCharsets.UTF_8);

        generateFile(FileUtils.readFileToString(new File("E:\\wenming\\exporter-after\\exporter.txt"), StandardCharsets.UTF_8), targetFilePath);
    }


    /**
     * 文件转化成base64字符串
     * 将文件转化为字节数组字符串，并对其进行Base64编码处理
     */
    public static String getFileStr(String filePath) throws IOException {
        byte[] data = FileUtils.readFileToByteArray(new File(filePath));
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回 Base64 编码过的字节数组字符串
        return encoder.encode(data);
    }


    /**
     * base64字符串转化成文件，可以是JPEG、PNG、TXT和AVI等等
     *
     * @param base64FileStr
     * @param filePath
     * @return
     * @throws Exception
     */
    public static void generateFile(String base64FileStr, String filePath) throws Exception {
        // 数据为空
        if (base64FileStr == null) {
            System.out.println("data is null");
        }
        BASE64Decoder decoder = new BASE64Decoder();
        // Base64解码,对字节数组字符串进行Base64解码并生成文件
        byte[] byt = decoder.decodeBuffer(base64FileStr);

        FileUtils.writeByteArrayToFile(new File(filePath), byt);
    }

}