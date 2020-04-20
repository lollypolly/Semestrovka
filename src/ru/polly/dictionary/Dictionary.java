package ru.polly.dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dictionary {
    private BufferedReader reader;
    private String text;
    private TreeMap<String, EndlessArray<String>> arr;
    private EndlessArray<String> eng;
    private EndlessArray<String> rus;

    public Dictionary(String filename) throws IOException {
        reader = new BufferedReader(new FileReader(filename));
        arr = new TreeMap<>();
        eng = new EndlessArray<>();
        rus = new EndlessArray<>();
        reader.readLine();

        while ((text = reader.readLine()) != null) {
            String[] engRus = text.split("-");
            eng.add(engRus[0]);
            rus.add(engRus[1]);
            String[] rus = engRus[1].split(",");

            for (int i = 0; i < rus.length; i++) rus[i] = rus[i].trim().toLowerCase();
            arr.put(engRus[0].trim().toLowerCase(), new EndlessArray<>(rus));
        }
    }

    public void show() {
        int maxEngLen = 0;
        for (Map.Entry<String, EndlessArray<String>> node : arr.entrySet())
            if (node.getKey().length() > maxEngLen) maxEngLen = node.getKey().length();

        System.out.printf("%" + (maxEngLen) + "s", "Слово:");
        System.out.print("   Перевод:");
        System.out.println();

        for (Map.Entry<String, EndlessArray<String>> node : arr.entrySet()) {
            System.out.printf("%" + (maxEngLen) + "s", node.getKey());
            System.out.print(" - ");
            System.out.print(node.getValue());
            System.out.println();
        }
    }

    public void insert(String k, String v) {
        String[] values = v.split(",");
        for (int i = 0; i < values.length; i++) values[i] = values[i].trim().toLowerCase();

        arr.put(k.toLowerCase(), new EndlessArray<>(values));
    }

    public void delete(String k) {
        arr.remove(k.toLowerCase());
    }

    public Set<String> unique() {
        Set<String> returned = new HashSet<>();
        for (Map.Entry<String, EndlessArray<String>> node : arr.entrySet()) {
            if (node.getValue().size() == 1) returned.add(node.getKey());
        }

        return returned;
    }

    public int numLen1() {
        int count = 0;
        for (Map.Entry<String, EndlessArray<String>> node : arr.entrySet()) {
            for (int i = 0; i < node.getValue().size(); i++) {
                if (node.getValue().get(i).length() >= node.getKey().length() - 1 ||
                        node.getValue().get(i).length() <= node.getKey().length() + 1) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public String translate(String text) {
        String[] tranlated = text.split(" ");

        for (int i = 0; i < tranlated.length; i++) {
            tranlated[i] = tranlated[i].trim().toLowerCase();
            if (arr.containsKey(tranlated[i])) tranlated[i] = arr.get(tranlated[i]).get(0);
        }

        String returned = "";
        for (int i = 0; i < tranlated.length; i++) returned = returned + " " + tranlated[i];
        return returned.trim();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;

        Dictionary that = (Dictionary) obj;
        if (arr.size() != that.arr.size()) return false;

        if (eng.equals(that.eng) && rus.equals(that.rus)) return true;
        else return false;
    }
}
