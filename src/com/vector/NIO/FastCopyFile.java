package com.vector.NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by 12345 on 2018-7-4.
 */
public class FastCopyFile {
    public static void main(String[] args) throws Exception {
        String inFile = "D:\\≤‚ ‘\\from.txt";
        String outFile = "D:\\≤‚ ‘\\to.txt";

        FileInputStream inputStream = new FileInputStream(inFile);
        FileOutputStream outputStream = new FileOutputStream(outFile);

        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outputChannel = outputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while(true){
            buffer.clear();
            int r = inputChannel.read(buffer);
            if(r == -1){
                break;
            }
            buffer.flip();
            outputChannel.write(buffer);
        }
    }
}
