package com.tavisca.socketprogramming.Server;

import java.io.*;
import java.net.Socket;

public class MyClient {

    public static void main(String[] args) throws IOException {

        System.out.println("Client Started ..");
        Socket socket = new Socket("localhost", 5891);

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String readString = "", respondString = "";
        while(!readString.equals("Bye"))

    {
        readString = bufferedReader.readLine();
        dataOutputStream.writeUTF(readString);
        dataOutputStream.flush();

        respondString = dataInputStream.readUTF();

        System.out.println("Server :"+respondString);
    }
        dataOutputStream.close();
        socket.close();
}
}
