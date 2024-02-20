package org.example;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.*;

public class Task_2 {
         public static void main(String[] args) {
            File file = new File("src/main/files/user.txt");
            String name;
            List<Person> personList = new ArrayList<Person>();
            if (file.exists()) {
                try (FileInputStream fIs = new FileInputStream(file);
                     Scanner fileScanner = new Scanner(fIs)) {
                    name = fileScanner.nextLine();
                    while (fileScanner.hasNext()) {
                        String names = fileScanner.next();
                        String ages = fileScanner.next();
                        Person person;
                        person = Person.builder()
                                .name(names)
                                .age(ages)
                                .build();
                        personList.add(person);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("File was not found");
            }
             Gson gsonMapper = new GsonBuilder().setPrettyPrinting().create();
            String customerJson = gsonMapper.toJson(personList);
             try (FileWriter fileWriter = new FileWriter("src/main/files/output.json")) {
                 fileWriter.write(customerJson);
             } catch (IOException e) {
                 e.printStackTrace();
             }
        }
    }

