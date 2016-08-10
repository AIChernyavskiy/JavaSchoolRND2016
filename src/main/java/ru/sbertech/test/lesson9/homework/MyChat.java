package ru.sbertech.test.lesson9.homework;

import java.io.*;

public  class MyChat {
    static class Message implements Serializable {
        long id;
        String user;
        String message;

        Message(String user, String message) {
            this.id = System.currentTimeMillis();
            this.user = user;
            this.message = message;
        }

        String getKey() {
            return "" + System.identityHashCode(Thread.currentThread()) + user + id;
        }
    }

    private static void showUsage() {
        System.err.println("Use first argument to identify app mode: client | server");
    }
    static class Client {
        MessageServiceThroughFileSerialization messageService;

        Client(MessageServiceThroughFileSerialization messageService) {
            this.messageService = messageService;
        }

        void start() {
            Console console = System.console();
           // if (console == null) {
               // throw new IllegalStateException("Can't use console");
           // }
            System.out.print("Enter your username: ");
            String username = console.readLine();

            String line;
            System.out.print("Enter message:");
            while ((line = console.readLine()) != null) {
                Message message = new Message(username, line);
                messageService.send(message);
                System.out.print("Enter message:");
            }
            System.out.println("End client!");
        }
    }
    private static class MessageServiceThroughFileSerialization  {

        private File messageFile;

        public MessageServiceThroughFileSerialization(String messageFile) {
            this.messageFile = new File(messageFile);
        }


        public void send(Message message) {
            try {
                SerializableUtils.serialize(messageFile.getAbsolutePath(), message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        public Message receive() {
            while (true) {
                if (messageFile.exists() && messageFile.lastModified() < System.currentTimeMillis() - 500L) {
                    try {
                        Message message = (Message) SerializableUtils.deserialize(messageFile.getAbsolutePath());
                        messageFile.delete();
                        return message;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    static class SerializableUtils {
        public static void serialize(String filename, Object object) throws IOException {
            try (FileOutputStream fos = new FileOutputStream(filename);
                 ObjectOutputStream out = new ObjectOutputStream(fos))
            {
                out.writeObject(object);
            }
        }

        public static Object deserialize(String filename) throws IOException, ClassNotFoundException {
            try (FileInputStream fis = new FileInputStream(filename);
                 ObjectInputStream in = new ObjectInputStream(fis))
            {
                return in.readObject();
            }
        }
    }
    public static void main(String[] args) {
        MessageServiceThroughFileSerialization messageService = new MessageServiceThroughFileSerialization("d:\\JavaSchool\\Task001\\src\\JavaSchoolRND2016\\src\\main\\java\\ru\\sbertech\\test\\lesson9\\homework\\Text.txt");
        new Client(messageService).start();
    }
}
