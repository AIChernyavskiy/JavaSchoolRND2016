package ru.sbertech.test.lesson9;

import java.io.*;


class Person {
    private String firstName;
    private int age;
    public Person() {
        this.firstName = "Mike";
        this.age = 25;
        System.out.println("sfsdf");
    }
}

public class Student implements Serializable {
    private String group;
    private int avgMark;
    private transient String password;


    public Student() {
        group = "default";
        avgMark = 3;
        password = "My very good password";
        System.out.println("I'am constructor");
    }



    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student();
        System.out.println(student);
        String filename = "student1.bin";
        try (FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(student);
        }
        Student student1;
        try (FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
                student1 = (Student)  ois.readObject();

        }

    }
    }

