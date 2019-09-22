package com.stasks.task1;

import com.stasks.output;

import java.util.Scanner;

public class Numbers implements output {
    private int number;

    public void readInput() {
        Scanner input = new Scanner(System.in);

        while (!input.hasNextInt()) {
            System.out.println("Ошибка! Введите целое число:");
            input.next();
        }

        this.number = input.nextInt();
        input.close();
    }

    private boolean isEven(int num) {
        return (num % 2) == 0;
    }

    private boolean isPrime(int num) {
        if (num < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private void printIsEvenType() {
        String typeNumber = this.isEven(this.number) ? "Да" : "Нет";
        System.out.println("Число " + this.number + " четное? " + typeNumber);
    }

    private void printIsPrimeType() {
        String typeNumber = this.isPrime(this.number) ? "Да" : "Нет";
        System.out.println("Число " + this.number + " простое? " + typeNumber);
    }

    @Override
    public void printTask() {
        this.printIsEvenType();
        this.printIsPrimeType();
    }
}
