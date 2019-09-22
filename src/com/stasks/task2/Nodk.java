package com.stasks.task2;

import com.stasks.output;
import java.util.Scanner;

public class Nodk implements output {
    public static final int MAX_INPUT_COUNT = 2;
    private long a;
    private long b;

    public void readInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите последовательно 2 числа:");
        for (int i = 0; i < MAX_INPUT_COUNT; i++) {
            System.out.print("Число " + (i + 1) + ": ");
            while (!input.hasNextLong()) {
                System.out.println("Ошибка! Введите целое число:");
                input.next();
            }

            switch (i) {
                case 0:
                    this.a = input.nextLong();
                    break;
                case 1:
                    this.b = input.nextLong();
                    break;
                default:
                    break;
            }
        }

        input.close();
    }

    //наибольший общий делитель (НОД)
    public long Gcd(long a, long b) {
        while (b != 0) {
            long mod = a % b;
            a = b;
            b = mod;
        }
        return a;
    }

    //наименьшее общее кратное (НОК)
    public long Lcm(long a, long b) {
        return a * (b / Gcd(a, b));
    }

    @Override
    public void printTask() {
        long gcd = this.Gcd(this.a, this.b);
        long lcm = this.Lcm(this.a, this.b);
        System.out.println("*Для чисел " + this.a + " и " + this.b + "*");
        System.out.println("Наибольший общий делитель: " + gcd);
        System.out.println("Наименьшее общее кратное: " + lcm);
    }
}
