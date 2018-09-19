package com.example.merwinmudavamkunnel.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * Created by merwinmudavamkunnel on 16.12.17.
 */

public class client_network {

    int port;
    String host;
    Socket socket;
    int result;
    int test;

    public client_network(){
        this.port = 5000;
        this.host = "192.168.0.14";
        this.test = 0;
    }
    public int test() {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
try{
    socket = new Socket(host,port);
    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
    DataInputStream dis = new DataInputStream(socket.getInputStream());
    dos.write(3);
    dos.flush();
    result = dis.read();
}
                    catch (Exception exception)
                        {exception.printStackTrace();}
                }

        });

        thread.start();
        return result;
    }
    }
