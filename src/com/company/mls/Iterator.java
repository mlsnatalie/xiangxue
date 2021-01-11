package com.company.mls;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Iterator {
    public static void main(String[] str) {
        ReverseList<String> list = new ReverseList<>();
        list.add("apple");
        list.add("orange");
        list.add("per");

        for (String s: list) {
            System.out.println(s);
        }
    }
}

class ReverseList<T> implements Iterable<T> {

    private List<T> list = new ArrayList<>();

    public void add(T t) {
        list.add(t);
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new ReverseIterator(list.size());
    }

    class ReverseIterator implements java.util.Iterator<T> {
        int index;

        public ReverseIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            index--;
            return ReverseList.this.list.get(index);
        }
    }
}