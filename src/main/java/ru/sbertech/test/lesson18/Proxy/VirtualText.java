package ru.sbertech.test.lesson18.Proxy;


public class VirtualText implements Text {
    RealText realText;

    public VirtualText(String textMessage) {
        this.textMessage = textMessage;
    }

    String textMessage;
    @Override
    public void print() {
        if (realText == null) {
            realText = new RealText(textMessage);
        }
        realText.print();
    }
}
