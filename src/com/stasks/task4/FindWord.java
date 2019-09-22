package com.stasks.task4;

import com.stasks.output;

import java.util.Scanner;

public class FindWord implements output {
    public static final int MAX_INPUT_COUNT = 2;
    private String text;
    private String word;
    private int count;

    public FindWord readInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите текст:");
        this.text = input.nextLine();

        System.out.println("Введите слово для поиска:");
        this.word = input.next();

        input.close();

        return this;
    }

    public void find() {
        int index = 0;
        int wLen = this.word.length();
        String wText = this.text.toLowerCase();

        while(index != -1) {
            index = wText.indexOf(this.word.toLowerCase(), index);

            if(index != -1) {
                this.count++;
                index += wLen;
            }
        }
    }

    public int getCount(){
        return this.count;
    }

    @Override
    public void printTask() {
        System.out.println("Найдено повторений: " + this.getCount());
    }
}
