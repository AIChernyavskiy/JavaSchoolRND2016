package ru.sbertech.test.lesson11_2.classwork;


public class Test implements Runnable {
    private  boolean endFlag = false;

    public synchronized boolean isEndFlag() {
        return endFlag;
    }

    public synchronized void setEndFlag(boolean endFlag) {
        this.endFlag = endFlag;
    }

    public void  end() {
        setEndFlag(true);
    }
    public void run() {
        while (!isEndFlag()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw  new RuntimeException();
            }
        }
    }
}
