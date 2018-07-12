package com.vector.NIO;

import java.nio.ByteBuffer;

/**
 * Created by 12345 on 2018-7-4.
 */
public class TypesInByteBuffer {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.putInt(1);
        byteBuffer.putFloat(0.05f);
        byteBuffer.putFloat(3.10f);
        byteBuffer.putDouble(Math.PI);
        byteBuffer.putDouble(3.333f);

        byteBuffer.flip();
        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getFloat());
        System.out.println(byteBuffer.getFloat());
        System.out.println(byteBuffer.getDouble());
        System.out.println(byteBuffer.getDouble());
    }
}
