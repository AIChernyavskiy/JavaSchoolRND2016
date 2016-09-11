package ru.sbertech.test.lesson18.Proxy;


public class RealText implements Text {

    public RealText(String textMessage) {
        this.textMessage = textMessage;

    }
    String textMessage;
    @Override
    public void print() {
        System.out.println(textMessage);
    }

}
