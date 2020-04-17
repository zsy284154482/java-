package com.zsy.nio.zerocopy;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewNIOClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.connect(new InetSocketAddress("127.0.0.1",7001));

        String fileName="/home/zsy/Desktop/docs.zip";

        //得到文件的channel
        FileChannel channel = new FileInputStream(fileName).getChannel();

        //准备发送
        long startTime = System.currentTimeMillis();

        //在linux下一个transferTo  方法就可以完成传输  底层使用了零拷贝
        long transferCount = channel.transferTo(0, channel.size(), socketChannel);

        System.out.println("发送的总的字节数="+transferCount+"  耗时: "+(System.currentTimeMillis()-startTime));
        //关闭通道
        channel.close();
    }
}
