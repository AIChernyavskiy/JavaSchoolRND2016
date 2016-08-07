package ru.sbertech.test.lesson4.homework;


import java.util.Iterator;


class Box<T> {

    public T[] val;
    int iter = -1;


    public Box(T arg) {
        val = (T[]) new Object[10];
    }


    public int size() {
        int count = 0;
        for (int i = 0; i < val.length; i++)
            if (val[i] != null) count++;
            else
                break;
        return count;

    }

    public void add(T E) {
        if (val.length == size()) {
            T[] oldData = val;
            int oldSize = size();
            int nLn = (size() * 3) / 2 + 1;
            val = (T[]) (new Object[nLn]);
            System.arraycopy(oldData, 0, val, 0, oldSize);
            val[oldSize] = E;

        } else
            val[size()] = E;


    }

    public void add(int index, T E) {
        if (val.length == size()) {
            T[] oldData = val;
            int oldSize = size();
            int nLn = (size() * 3) / 2 + 1;
            val = (T[]) (new Object[nLn]);
            System.arraycopy(oldData, 0, val, 0, oldSize);
            System.arraycopy(val, index, val, index + 1, oldSize - index);
            val[index] = E;

        } else
            System.arraycopy(val, index, val, index + 1, size() - index);
        val[index] = E;
    }

    public T get(int index) {
        return val[index];
    }

    public Iterator<T> iterator() {

        return new Iterator<T>() {

            public boolean hasNext() {
                if (iter<size()-1) return true;
                return false;
            }

            public T next() {
                if (hasNext()) return val[++iter];
                return null;
            }
        };
    }
}

public class MyArrayList {
    public static void main(String[] args) {

        Box<Integer> value1 = new Box(new Integer(10));
        value1.add(new Integer(0));
        value1.add(new Integer(1));
        value1.add(new Integer(2));
        value1.add(new Integer(3));
        value1.add(new Integer(4));
        value1.add(new Integer(5));
        value1.add(new Integer(6));
        value1.add(new Integer(7));
        value1.add(new Integer(8));
        value1.add(new Integer(9));
        //value1.add(new Integer(10));
        /*value1.add(new Integer(11));
        value1.add(new Integer(12));
        value1.add(new Integer(13));
        */
        Iterator it = value1.iterator();
        it.hasNext();
        Object kl =  it.next();
        Object k2 =  it.next();
        value1.add(5,new Integer(100));
        int k = value1.get(5);
        System.out.println(k);
    }
}