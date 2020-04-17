package com.zsy.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioFileChannelRead {
    public static void main(String[] args) throws Exception {
        File file=new File("/home/zsy/Desktop/zsy01.txt");
        FileInputStream fileInputStream=new FileInputStream(file);

        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer=ByteBuffer.allocate((int) file.length());

        fileChannel.read(byteBuffer);

        String s=new String(byteBuffer.array());

        System.out.println(s);

        fileInputStream.close();
    }
}
