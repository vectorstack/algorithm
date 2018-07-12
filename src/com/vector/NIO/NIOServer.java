package com.vector.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by 12345 on 2018-7-12.
 */
public class NIOServer {
    // ͨ��������
    private Selector selector;

    /**
     * ���һ��ServerSocketͨ�������Ը�ͨ����һЩ��ʼ���Ĺ���
     *
     * @param port
     *            �󶨵Ķ˿ں�
     * @throws IOException
     */
    public void initServer(int port) throws IOException {
        // ���һ��ServerSocketͨ��
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        // ����ͨ��Ϊ������
        serverChannel.configureBlocking(false);
        // ����ͨ����Ӧ��ServerSocket�󶨵�port�˿�
        serverChannel.socket().bind(new InetSocketAddress(port));
        // ���һ��ͨ��������
        this.selector = Selector.open();
        // ��ͨ���������͸�ͨ���󶨣���Ϊ��ͨ��ע��SelectionKey.OP_ACCEPT�¼�,ע����¼���
        // �����¼�����ʱ��selector.select()�᷵�أ�������¼�û����selector.select()��һֱ������
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    /**
     * ������ѯ�ķ�ʽ����selector���Ƿ�����Ҫ������¼�������У�����д���
     *
     * @throws IOException
     */
    public void listen() throws IOException {
        System.out.println("����������ɹ���");
        // ��ѯ����selector
        while (true) {
            // ��ע����¼�����ʱ���������أ�����,�÷�����һֱ����
            selector.select();
            // ���selector��ѡ�е���ĵ�������ѡ�е���Ϊע����¼�
            Iterator<?> ite = this.selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = (SelectionKey) ite.next();
                // ɾ����ѡ��key,�Է��ظ�����
                ite.remove();

                handler(key);
            }
        }
    }

    /**
     * ��������
     *
     * @param key
     * @throws IOException
     */
    public void handler(SelectionKey key) throws IOException {

        // �ͻ������������¼�
        if (key.isAcceptable()) {
            handlerAccept(key);
            // ����˿ɶ����¼�
        } else if (key.isReadable()) {
            handelerRead(key);
        }
    }

    /**
     * ������������
     *
     * @param key
     * @throws IOException
     */
    public void handlerAccept(SelectionKey key) throws IOException {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        // ��úͿͻ������ӵ�ͨ��
        SocketChannel channel = server.accept();
        // ���óɷ�����
        channel.configureBlocking(false);

        // ��������Ը��ͻ��˷�����ϢŶ
        System.out.println("�µĿͻ�������");
        // �ںͿͻ������ӳɹ�֮��Ϊ�˿��Խ��յ��ͻ��˵���Ϣ����Ҫ��ͨ�����ö���Ȩ�ޡ�
        channel.register(this.selector, SelectionKey.OP_READ);
    }

    /**
     * ��������¼�
     *
     * @param key
     * @throws IOException
     */
    public void handelerRead(SelectionKey key) throws IOException {
        // �������ɶ�ȡ��Ϣ:�õ��¼�������Socketͨ��
        SocketChannel channel = (SocketChannel) key.channel();
        // ������ȡ�Ļ�����
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int read = channel.read(buffer);
        if(read > 0){
            byte[] data = buffer.array();
            String msg = new String(data).trim();
            System.out.println("������յ���Ϣ��" + msg);

            //��д����
            ByteBuffer outBuffer = ByteBuffer.wrap("�õ�".getBytes());
            channel.write(outBuffer);// ����Ϣ���͸��ͻ���
        }else{
            System.out.println("�ͻ��˹ر�");
            key.cancel();
        }
    }

    /**
     * ��������˲���
     *
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        NIOServer server = new NIOServer();
        server.initServer(8000);
        server.listen();
    }

}
