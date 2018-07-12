package com.vector.NIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by 12345 on 2018-7-4.
 */
public class CopyFile {
    public static void main(String[] args) throws Exception {
//        if (args.length<2) {
//            System.err.println( "Usage: java CopyFile infile outfile" );
//            System.exit( 1 );
//        }

       String inFile = "D:\\²âÊÔ\\from.txt";
       String outFile = "D:\\²âÊÔ\\to.txt";

       FileInputStream inputStream = new FileInputStream(inFile);
       FileOutputStream outputStream = new FileOutputStream(outFile);

       FileChannel inputChannel = inputStream.getChannel();
       FileChannel outputChannel = outputStream.getChannel();

       ByteBuffer buffer = ByteBuffer.allocate(1024);

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
