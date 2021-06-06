package ru.vsu.cs.map;

import java.util.ArrayList;
import java.util.List;

public class MyMapImpl<K, V> {

    private MyElement[] elements = new MyElement[10];
    private int size = 0;

    public boolean put(K key, V value) {

        if (containsKey(key)){
            System.out.println("Element with key " + key + " already exists.");
            return false;
        }

        MyElement newElement = new MyElement(key, value);

        if (size == elements.length) {
            MyElement[] temp = new MyElement[elements.length + (elements.length * 2 / 3) + 1];
            for (int i = 0; i < elements.length; i++) {
                temp[i] = elements[i];
            }
            elements = temp;
        }

        elements[size] = newElement;
        size++;
        return true;
    }

    public boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {
            MyElement e = elements[i];
            if (e.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        elements = new MyElement[10];
        size = 0;
    }

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            MyElement<K, V> e = elements[i];
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        System.out.println("Object with key " + key + " doesn't exist.");
        return null;
    }

    public boolean remove(K key) {
        if (!containsKey(key)) {
            System.out.println("Object with " + key + " doesn't exist.");
            return false;
        }

        MyElement[] temp = new MyElement[elements.length - 1];

        int index = 0;
        for (int i = 0; i < size; i++) {

            MyElement element = elements[i];

            if (element.getKey().equals(key)) {
                continue;
            }

            temp[index] = element;
            index++;
        }

        elements = temp;

        size--;
        return true;
    }

    public List<V> toList() {
        List<V> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add((V) elements[i].getValue());
        }
        return list;
    }
}
