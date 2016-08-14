package ru.sbertech.test.lesson9.homework;


import java.io.*;

import static ru.sbertech.test.lesson9.homework.Client.*;

public class Server {
    static class Message implements Serializable {
        String username;
        String textMessage;

        Message(String username, String textMessage) {
            this.username = username;
            this.textMessage = textMessage;
        }

    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File messageFile = new File("d:\\JavaSchool\\Task001\\src\\JavaSchoolRND2016\\src\\main\\java\\ru\\sbertech\\test\\lesson9\\homework\\object.bin");
        while (true) {
            System.out.println("Waiting for message...");
            if (messageFile.exists() && messageFile.lastModified() < System.currentTimeMillis() - 500L) {
                try (FileInputStream fis = new FileInputStream(messageFile);
                     ObjectInputStream in = new ObjectInputStream(fis)) {
                    Message message = (Message) in.readObject();
                    System.out.println("new message: " + System.currentTimeMillis() );
                    System.out.println("       from: " + message.username);
                    System.out.println("       body: " + message.textMessage);
                }
            }


        }
    }
}

