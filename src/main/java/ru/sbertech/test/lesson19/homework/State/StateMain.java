package ru.sbertech.test.lesson19.homework.State;


public class StateMain {
    public static void main(String[] args) {
        Human human = new Human();
        human.setState(new Work());
        for (int i = 0; i < 9; i++) {
            human.doSomething();
        }
    }
}
