package ru.sbertech.test.lesson19.homework.Strategy;


public class StrategyMain  {
    public static void main(String[] args) {
        Client client = new Client();

        int[] Array1 = {7,4,3,6,45,10,2};
        client.setStrategy(new BubleSort());
        client.runStrategy(Array1);

        int[] Array2 = {3,1,0,9,5,12};
        client.setStrategy(new selectionSort());
        client.runStrategy(Array2);

        int[] Array3 = {20,90,74,102,3,10,1};
        client.setStrategy(new quickSort());
        client.runStrategy(Array3);

    }
}
