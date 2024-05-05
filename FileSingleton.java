package ru.itis.inf304.lab8;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileSingleton {
    private static FileSingleton instanse;
    private String filePath = "example.txt";

    private FileSingleton() {}

    public static FileSingleton getInstance(){
        if (instanse == null){
            synchronized (FileSingleton.class) {
                if (instanse == null) {
                    instanse = new FileSingleton();
                }
            }
        }
        return instanse;
    }

    public String readFile() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return content.toString();
    }

    public void writeFile(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}