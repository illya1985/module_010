package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

@Data
@Builder
@AllArgsConstructor
public class Person {

     public String name;
     String age;

}
