package com.tavisca.socketprogramming.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(5891);
        System.out.println("Waiting for client ..");
        Socket socket = serverSocket.accept();
        System.out.println("Connection established ..");

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String readString = "", respondString = "";
        while (!readString.equals("Bye"))
        {
            readString = dataInputStream.readUTF();
            System.out.println("Client :" + readString);

            respondString = in.readLine();
            dataOutputStream.writeUTF(respondString);
            dataOutputStream.flush();
        }
        dataInputStream.close();
        socket.close();
        serverSocket.close();
    }
}
