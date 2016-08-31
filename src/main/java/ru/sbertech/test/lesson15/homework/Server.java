package ru.sbertech.test.lesson15.homework;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static final int DEFAULT_PORT = 3333;
    ServerSocket serverSocket;
    public  List<NewClient> clients = new ArrayList<>();
    int i=0;

    public Server() {
        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
        } catch (IOException e) {
            System.out.println("Не получилось создать сервер " +e);
        }
    }

    private Socket createNewConnection() {
        Socket socket = null;
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return socket;
    }

    void listen() {

        while (true) {
            Socket socket = createNewConnection();
            if (socket!=null) {
                try {
                    clients.add(new NewClient(socket));
                } catch (IOException e) {
                    System.out.println("Не удалось создать клиента "+e);
                }
                Thread thread = new Thread(clients.get(i));
                thread.setDaemon(true);
                thread.start();
                i++;
            }
        }
    }




    private class NewClient implements Runnable {
        Socket socket;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;

        public NewClient(Socket socketS) throws IOException {
            socket = socketS;
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }

        public synchronized void send(String line) {
            try {
                bufferedWriter.write(line);
                bufferedWriter.write("\n");
                bufferedWriter.flush();
            } catch (IOException e) {
                System.out.println("Не удалось отправить сообщение "+e);
                close();
            }

        }

        @Override
        public void run() {
            String line = null;
            synchronized (clients) {
                if (clients.size()>=3) {
                    send("Сервер превысил кол-во клиентов, попробуйте чуть позже.");
                    close();
                    //send("");
                }
            }

            while (!socket.isClosed()) {
                try {
                    line = bufferedReader.readLine();
                } catch (IOException e) {
                    System.out.println(e);
                }
                if ((line == null) || (line.equals("exit")) ) {
                    close();
                } else {
                    for (NewClient NC:clients) {
                        NC.send(line);
                    }
                }
            }
        }

        public synchronized void close() {
            clients.remove(this);
            if (!socket.isClosed()) {
                try {
                    socket.close();
                    bufferedReader.close();
                    bufferedWriter.close();
                } catch (IOException ignored) {}
            }

            i--;
        }

    }


    public static void main(String[] args) throws IOException {
        (new Server()).listen();
    }
}
