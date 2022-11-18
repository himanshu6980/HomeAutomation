package com.example.vaibhav.iot.utilities;

/**
 * Created by f71ud on 26/09/2017.
 */
import java.io.*;
import java.net.*;

public class Client {
    Socket s;
    BufferedReader r;
    PrintWriter w;
    BufferedReader con;
    int GPIO_NO;
    String ip;
    int port;
    int task;

    public Client(String ip, int GPIO_NO, int task) {
        this.ip = ip;

        this.GPIO_NO = GPIO_NO;
        this.task = task;
    }

   public void connect() {
        try {
            s = new Socket(ip, 3000);
        } catch (Exception e) {
            System.err.println(e);
        }
        sender();

    }

    void sender() {
        try {
            r = new BufferedReader(new InputStreamReader(s.getInputStream()));
            w = new PrintWriter(s.getOutputStream(), true);

        } catch (Exception e) {
            System.err.println(e);
        }
        exeTask();
    }

    void exeTask() {
        try {

            //line = con.readLine();
            w.println(GPIO_NO + " " + task);


        } catch (Exception e) {

            System.err.println(e);
        }
    }
}
