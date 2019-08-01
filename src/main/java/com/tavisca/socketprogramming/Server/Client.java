package com.tavisca.socketprogramming.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        System.out.println("Client Started..");

        Socket socket =new Socket("localhost",8888);
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your input : ");
        int input=Integer.parseInt(in.readLine());
        PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
        out.println(input);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());

    }
}
