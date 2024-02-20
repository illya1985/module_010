package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Task_1 {
    public static final String TEL_REGEX = "\\d\\d\\d(-)\\d\\d\\d(-)\\d\\d\\d\\d|[(]\\d\\d\\d[)]\\s\\d\\d\\d(-)\\d\\d\\d\\d";
    public static void main(String[] args) {

        File file = new File("src/main/files/phone_numbers.txt");
        if (file.exists()) {
            try (FileInputStream fIs = new FileInputStream(file);
                 Scanner fileScanner = new Scanner(fIs)) {
                while (fileScanner.hasNext()) {
                    String num=fileScanner.nextLine();
                    boolean matches = num.matches(TEL_REGEX);
                    if(matches){
                        System.out.println(num);
                    }}
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("File was not found");
        }

    }
}
