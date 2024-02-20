package org.example;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Task_3 {


    public static void main(String[] args) {

        File file = new File("src/main/files/words.txt");
        Map<String, Integer> countWord = new HashMap<>();

        if (file.exists()) {
            try (FileInputStream fIs = new FileInputStream(file);
                 Scanner fileScanner = new Scanner(fIs)) {
                while (fileScanner.hasNext()) {
                    String readWord=fileScanner.next();
                    if (countWord.containsKey(readWord)) {
                        countWord.put(readWord, countWord.get(readWord) + 1);
                    } else {
                        countWord.put(readWord, 1);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("File was not found");
        }

        for (Map.Entry<String, Integer> entry : countWord.entrySet()) {

            System.out.println(entry.getValue()+"--"+entry.getKey());

        }

        LinkedHashMap<String, Integer> sortedCountWord = new LinkedHashMap<>();
        countWord.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedCountWord.put(x.getKey(), x.getValue()));

        for (Map.Entry<String, Integer> entry : sortedCountWord.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }


    }


