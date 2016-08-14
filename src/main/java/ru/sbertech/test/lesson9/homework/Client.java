package ru.sbertech.test.lesson9.homework;

import java.io.*;


public class Client {
    static class Message implements Serializable {
        String username;
        String textMessage;

        Message(String username, String textMessage) {
            this.username = username;
            this.textMessage = textMessage;
        }

    }

    public static void main(String[] args) throws IOException {

        Console console = System.console();
        if (console == null) {
            throw new IllegalStateException("Please, start Client in cmd.");
        }
        //File messageFile = new File("d:\\JavaSchool\\Task001\\src\\JavaSchoolRND2016\\src\\main\\java\\ru\\sbertech\\test\\lesson9\\homework\\object.bin");
        //messageFile.createNewFile();
        System.out.print("Enter username: ");
        String username = console.readLine();
        System.out.print("You message, or emtpy string for exit: ");
        String line = console.readLine();
        String bodyMessage="";
        while (!(line ).isEmpty()) {
            bodyMessage= bodyMessage + " " + line;
            System.out.print("You message, or emtpy string for exit: ");
            line = console.readLine();
        }
        Message message = new Message(username, bodyMessage);
        try (FileOutputStream fos = new FileOutputStream("d:\\JavaSchool\\Task001\\src\\JavaSchoolRND2016\\src\\main\\java\\ru\\sbertech\\test\\lesson9\\homework\\object.bin");
             ObjectOutputStream out = new ObjectOutputStream(fos))
            {
                out.writeObject(message);
            }
    }
}

