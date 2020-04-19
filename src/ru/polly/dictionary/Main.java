package ru.polly.dictionary;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Dictionary dictionary = new Dictionary("C:\\Users\\Полин о4чка\\Desktop\\dict.txt");
            dictionary.show();
            System.out.println();
            System.out.println(dictionary.unique());
            System.out.println();
            System.out.println(dictionary.translate("polly apple"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
