package ru.sbertech.test.lesson15.homework;


import java.io.*;
import java.net.Socket;

public class Client {
    public static final String HOST = "localhost";
    public static final int PORT = 3333;
    Socket socket;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    BufferedReader bufferedReaderConsole;

    public Client() throws IOException {
        socket = new Socket(HOST, PORT);
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedReaderConsole = new BufferedReader(new InputStreamReader(System.in));
    }


    private void run() {
        new Thread(new Listner()).start();
        try {
            Thread.currentThread().join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!socket.isClosed()) {
            System.out.println("Enter you message: ");
            String userString = null;
            try {
                userString = bufferedReaderConsole.readLine();
            } catch (IOException e) {
                System.out.println("Не смогли прочитать с консоли "+e);
            }
            if (userString.equals("exit") || userString.length() == 0) {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Не смогли закрыть сокет "+e);
                }
                break;
            } else {
                try {
                    bufferedWriter.write(userString);
                    bufferedWriter.write("\n");
                    bufferedWriter.flush();
                } catch (IOException e) {
                    System.out.println("Не смогли отправить сообщение с клиента "+e);

                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        (new Client()).run();
    }

    class Listner implements Runnable{
        @Override
        public void run() {
            String lineFromServer = null;
            while (!socket.isClosed()) {
                try {
                    lineFromServer = bufferedReader.readLine();
                    if (lineFromServer != null) {
                        System.out.println("Сервер прислал: "+ lineFromServer);
                    } else if (lineFromServer == null) {
                        socket.close();
                    }

                } catch (IOException e) {
                    System.out.println("Отключаюсь...."+e);
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
