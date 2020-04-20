package ru.polly.dictionary;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Dictionary dictionary = new Dictionary("C:\\Users\\Полин о4чка\\Desktop\\dict.txt");
            System.out.println(" Просмотр словаря:");
            dictionary.show();
            System.out.println();
            dictionary.insert("ability","способность, возможность");
            System.out.println(" Просмотр словаря с добавлением нового слова:");
            dictionary.show();
            dictionary.delete("ability");
            System.out.println();
            System.out.println(" Просмотр словаря с удалением добавленного нового слова:");
            dictionary.show();
            System.out.println();
            System.out.println(" Просмотр уникальных слов:");
            System.out.println(dictionary.unique());
            System.out.println();
            System.out.println(" Перевод текста:");
            System.out.println(dictionary.translate("hello everyone this my semester work polly"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
