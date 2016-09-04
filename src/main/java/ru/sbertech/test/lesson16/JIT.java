package ru.sbertech.test.lesson16;


import java.util.HashMap;

public class JIT {
    HashMap<Integer,String> hashMap;
    int i;
    public JIT(HashMap<Integer,String> hashMap) {
        this.hashMap = hashMap;
    }

    void run() {
        i=100000;
        for (Integer j = 0; j < i; j++) {
            hashMap.put(j,"value" +j);

        }

        System.out.println(hashMap.get(0));
    }


    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap<>();
        (new JIT(hashMap)).run();
        System.out.println("Hello world");
        (new JIT(hashMap)).run();
    }
}
