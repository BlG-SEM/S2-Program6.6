package ru.vsu.cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int s = readNumberFromKeyboard("S");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<List<Integer>> result = solution(list, s);
        print(result);
    }

    public static int readNumberFromKeyboard(String name) {
        System.out.println("Input " + name + ":");
        Scanner scanner = new Scanner(System.in);
        String row = scanner.nextLine();
        int num = Integer.parseInt(row);
        return num;
    }

    public static List<List<Integer>> solution(List<Integer> list, int s) {
        List<List<Integer>> result = new ArrayList<>();

        List<List<Integer>> allCombinations = generateAllCombinations(list);

        for (List<Integer> l:
            allCombinations) {
            if (calculateSum(l) == s) {
                result.add(l);
            }
        }

        return result;
    }

    public static List<List<Integer>> generateAllCombinations(List<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> helper = new ArrayList<>(3);
        for (int i = 0; i < list.size(); i++) {
            helper.add( 0, list.get(i));

            for (int j = i + 1; j < list.size(); j++) {

                helper.add(1, list.get(j));

                for (int k = j + 1; k < list.size(); k++) {

                    helper.add(2, list.get(k));

                    result.add(new ArrayList<>(helper));

                    helper.remove(2);
                }

                helper.remove(1);
            }

            helper.remove(0);
        }

        return result;
    }

    public static int calculateSum(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static void print(List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("List №" + (i + 1) + ": ");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
