package com.stasks.task5;

import com.stasks.output;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Palindrome implements output {
    private int number;
    private List<Integer> palindromes = new ArrayList<>();

    public void readInput() {
        Scanner input = new Scanner(System.in);
        while (true) {

            if (!input.hasNextInt()) {
                System.out.println("Ошибка! Введите целое число:");
                input.next();
            } else {
                int inp = input.nextInt();
                if (inp < 0 || inp > 100) {
                    System.out.println("Ошибка! Введите целое число от 0 до 100:");
                } else {
                    this.number = inp;
                    break;
                }
            }

        }
        input.close();
    }

    public List<Integer> getPalindromes() {
        for (int i = 0; i <= this.number; i++) {

            String chekNumber = Integer.toString(i);
            if (isPalindrome(chekNumber)) {
                this.palindromes.add(i);
            }
        }
        return this.palindromes;
    }

    private boolean isPalindrome(String str) {
        StringBuilder reverseStr = new StringBuilder(str);
        return reverseStr.reverse().toString().equals(str);
    }

    @Override
    public void printTask() {
        List<Integer> pl = getPalindromes();
        System.out.println("Числа-палиндромы: ");
        System.out.println(pl);
    }
}
