package com.stasks.task3;

import com.stasks.output;

import java.util.Scanner;
import java.util.Arrays;

public class TextWords implements output {
    private String text;
    private int textWordsCount;
    private String[] wordsArray;


    public static String toText(String[] words) {
        return String.join(" ", words);
    }

    public void readInput() {
        Scanner input = new Scanner(System.in);

        this.text = input.nextLine();
        input.close();
    }


    public String[] sortWords(String[] str) {
        String[] sortArray = str;

        Arrays.sort(sortArray);

        return sortArray;
    }

    public String[] getWithoutPunctuation() {

        return this.removePunctuation(this.text).split("\\s+");
    }

    public String[] textToArray(String str) {
        this.wordsArray = str.split("\\s+");
        this.textWordsCount = this.wordsArray.length;
        return this.wordsArray;
    }

    public String[] getWordsFirstUpperCase() {
        int length = this.wordsArray.length;
        String[] words = new String[length];
        for (int i = 0; i < length; i++) {
            String word = this.wordsArray[i];
            word = word.substring(0, 1).toUpperCase() + word.substring(1);
            words[i] = word;
        }

        return words;
    }

    public String[] getWordsArray() {
        return this.wordsArray;
    }

    public int getWordsCount() {
        return this.textWordsCount;
    }

    public String getText() {
        return this.text;
    }

    private String removePunctuation(String str) {
        return str.replaceAll(",|\\.|:|;|\\?|!", "");
    }

    @Override
    public void printTask() {
        //получаем введенный текст
        String txt = this.getText();
        //получаем массив слов введенного текста
        String[] txtArray = this.textToArray(txt);
        //получаем массив слов без знаков припенания
        String[] withoutPunctuation = this.getWithoutPunctuation();

        //выводим количество слов в предложении
        System.out.println("Количество слов в предложении: " + this.getWordsCount());
        //выводим отсортированные слова
        System.out.println("Сортируем слова: " + TextWords.toText(this.sortWords(withoutPunctuation)));
        //выводим все словас большой буквы
        System.out.println("Слова с заглавной:" + TextWords.toText(this.getWordsFirstUpperCase()));
    }
}
