package ru.sbertech.test.lesson15.UDP;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerUDP {
    public static final int PORT = 3333;
    public static final String HOST = "localhost";
    public static final int BUFFER_SIZE = 256;

    public static void main(String[] args) throws IOException {
        try (DatagramSocket socket = new DatagramSocket(PORT)){
            byte[] buffer = new byte[BUFFER_SIZE];
            String command ="";

            do {
                DatagramPacket datagram = new DatagramPacket(buffer,buffer.length);
                socket.receive(datagram);
                command = new String(datagram.getData(),0,datagram.getLength());
                System.out.println(command);
            } while (!command.equals("exit"));
        }
    }

}
