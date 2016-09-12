package ru.sbertech.test.lesson19.Observer;


import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        MeteoStation meteo = new MeteoStation();
        Observer cons = new ConsoleObserver();

        meteo.addObserver(cons);

        meteo.setData(30,750);
        meteo.setData(31,751);
    }
}

interface Observable {
    void notifyObserver(Observer observer);
    void addObserver(Observer o);
    void removeObserver (Observer o);
}

interface Observer {
    void onChange(int temperature, int pressure);
}

class MeteoStation implements Observable {
    List<Observer> observers = new ArrayList<>();

    @Override
    public void notifyObserver(Observer observer) {
        for (Observer observ:observers) {
            observer.onChange(temperature,pressure);
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    int temperature;
    int pressure;

    void setData(int temperature, int pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
    }
}

class  ConsoleObserver implements Observer {
    @Override
    public void onChange(int temperature, int pressure) {
        System.out.println("Temp: " + temperature +", "+pressure);
    }
}
