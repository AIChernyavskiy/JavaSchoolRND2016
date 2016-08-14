package ru.sbertech.test.lesson10.homework;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleArrayList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(-5);
        list.add(-4);
        list.add(-3);
        list.add(-2);
        list.add(-1);

        List<Integer> list2 = new ArrayList();
        list2.add(0);
        list2.add(2);
        list2.add(1);
        list2.add(4);
        list2.add(3);
        list2.add(3);
        list2.add(3);

        mergeArrayList<List<Integer>,List<Integer>> merge = (a,b)-> {
            List<Integer> mList = new ArrayList(a);
            mList.addAll(b);
            Collections.sort(mList);
            return mList;
        };

        List<Integer> mergeList = merge.mergeArrayList(list,list2);
        mergeList.forEach(System.out::println);

        System.out.println("--------------------------------------");

        List<Integer> positiveList = mergeList.stream()
        .distinct()
        .filter(d->d>0)
        .collect(Collectors.toList());

        positiveList.forEach(System.out::println);
    }
}

@FunctionalInterface
interface mergeArrayList<T, T1> {
    T mergeArrayList(T A1, T1 A2);
}