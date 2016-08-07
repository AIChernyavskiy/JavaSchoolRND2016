package ru.sbertech.test.lesson8;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator {

    public static <T> Iterator<T> getIterator(final T[] array) {
        return new Iterator<T>() {

            private int count = array.length;
            private int index = 0;

            @Override
            public boolean hasNext() {

                return index < count;
            }

            @Override
            public T next() {
                if (index < count) {
                    return array[index++];
                } else {
                    throw new NoSuchElementException("NoSuchElementException");
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Нельзя удалять элементы из массива");
            }
        };
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{0, 1, 2, 3, 4, 5, 6};

        Iterator<Integer> integerIterator = getIterator(integers);

        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }

    }

}

