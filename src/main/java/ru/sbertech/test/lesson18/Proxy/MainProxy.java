package ru.sbertech.test.lesson18.Proxy;


public class MainProxy {
    public static void main(String[] args) {
        Text text = new RealText("Работаем через реальный объект");
        Text text1 = new VirtualText("Работаем через заместитиеля на реальном объекте");
        text.print();
        text1.print();
    }
}
