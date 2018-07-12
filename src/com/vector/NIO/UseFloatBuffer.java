package com.vector.NIO;

import java.nio.FloatBuffer;

/**
 * Created by 12345 on 2018-7-3.
 */
public class UseFloatBuffer {
    public static void main(String[] args) {
        FloatBuffer buffer = FloatBuffer.allocate( 10 );

        for (int i=0; i<buffer.capacity(); ++i) {
            float f = (float)Math.sin( (((float)i)/10)*(2*Math.PI) );
            buffer.put( f );
        }

        buffer.flip();

        while (buffer.hasRemaining()) {
            float f = buffer.get();
            System.out.println( f );
        }
    }
}
