package ru.vsu.cs;

import ru.vsu.cs.map.MyMapImpl;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        int s = readNumberFromKeyboard("S");

        MyMapImpl<Integer, Integer> myMap = new MyMapImpl<>();
        myMap.put(1, 1);
        myMap.put(2, 2);
        myMap.put(3, 3);
        myMap.put(4, 4);
        myMap.put(5, 5);
        myMap.put(6, 6);
        myMap.put(7, 7);

        List<Integer> list = myMap.toList();

        List<List<Integer>> result = Main.solution(list, s);
        Main.print(result);
    }
    
    public static int readNumberFromKeyboard(String name) {
        System.out.println("Input " + name + ":");
        Scanner scanner = new Scanner(System.in);
        String row = scanner.nextLine();
        int num = Integer.parseInt(row);
        return num;
    }
}
