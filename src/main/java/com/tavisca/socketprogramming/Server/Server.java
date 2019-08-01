package com.tavisca.socketprogramming.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("Waiting for clients..");
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        System.out.println("Connnection established ..");
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int number = Integer.parseInt(in.readLine());
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("factorial of" + number + "is" + factorial(number));

    }

    private static int factorial(int number) {
        int fact = 1;
        for (int i = 1; i <= number; i++)
            fact = fact * i;
        return fact;
    }

}
