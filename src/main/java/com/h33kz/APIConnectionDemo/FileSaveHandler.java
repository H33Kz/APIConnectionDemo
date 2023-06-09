package com.h33kz.APIConnectionDemo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

public class FileSaveHandler {
    private Gson gson;

    public FileSaveHandler(Gson gson) {
        this.gson = gson;
    }

    public void saveToJsonFile(String filename, String responseBody) {
        try {
            FileWriter fileWriter = new FileWriter(filename + ".json");
            fileWriter.write(responseBody);
            fileWriter.close();
            System.out.println("JSON file saved\n\n");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void saveToCsvFile(String filename, String responseBody) {
        try {
            FileWriter fileWriter = new FileWriter(filename + ".csv");

            // Using gson library to convert json string acquired from API to list of
            // POJO's(University class) created before
            ArrayList<University> universities = gson.fromJson(responseBody, new TypeToken<ArrayList<University>>() {
            }.getType());

            // Using opencsv library to save list of objects as csv file
            StatefulBeanToCsv<University> beanToCsv = new StatefulBeanToCsvBuilder<University>(fileWriter).build();
            beanToCsv.write(universities);
            fileWriter.close();
            System.out.println("CSV file saved\n\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
