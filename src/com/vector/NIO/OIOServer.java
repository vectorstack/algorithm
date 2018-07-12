package com.vector.NIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 12345 on 2018-7-12.
 */
public class OIOServer {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //����socket����,����10101�˿�
        ServerSocket server=new ServerSocket(10101);
        System.out.println("������������");
        while(true){
            //��ȡһ���׽��֣�������
            final Socket socket = server.accept();
            System.out.println("����һ���¿ͻ��ˣ�");
            newCachedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    //ҵ����
                    handler(socket);
                }
            });

        }
    }

    /**
     * ��ȡ����
     * @param socket
     * @throws Exception
     */
    public static void handler(Socket socket){
        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();

            while(true){
                //��ȡ���ݣ�������
                int read = inputStream.read(bytes);
                if(read != -1){
                    System.out.println(new String(bytes, 0, read));
                }else{
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                System.out.println("socket�ر�");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}