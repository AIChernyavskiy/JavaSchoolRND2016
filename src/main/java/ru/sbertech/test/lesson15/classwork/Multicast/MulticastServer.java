package ru.sbertech.test.lesson15.classwork.Multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class MulticastServer {
    public static final int PORT = 3333;
    public static final String MULTICAST_GROUP = "224.0.0.22";
    public static final int BUFFER_SIZE = 256;

    public static void main(String[] args) throws IOException {
        try (MulticastSocket socket = new MulticastSocket(PORT)){
            InetAddress multicastAddress = InetAddress.getByName(MULTICAST_GROUP);
            socket.joinGroup(multicastAddress);
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
