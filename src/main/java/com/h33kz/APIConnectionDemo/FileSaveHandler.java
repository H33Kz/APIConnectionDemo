package com.h33kz.APIConnectionDemo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.thoughtworks.xstream.XStream;

public class FileSaveHandler {

    public static void saveToJsonFile(String filename, String responseBody) {
        try {
            FileWriter fileWriter = new FileWriter("./test/" + filename + ".json");
            fileWriter.write(responseBody);
            fileWriter.close();
            System.out.println("JSON file saved\n\n");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void saveToCsvFile(String filename, ArrayList<University> universities) {
        try {
            FileWriter fileWriter = new FileWriter("./test/" + filename + ".csv");
            // Using opencsv library to save list of objects as csv file
            StatefulBeanToCsv<University> beanToCsv = new StatefulBeanToCsvBuilder<University>(fileWriter).build();
            beanToCsv.write(universities);
            fileWriter.close();
            System.out.println("CSV file saved\n\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void saveToXmlFile(String filename, ArrayList<University> universities) {
        try {
            FileWriter fileWriter = new FileWriter("./test/" + filename + ".xml");
            XStream xStream = new XStream();
            xStream.alias("universities", ArrayList.class);
            fileWriter.write(xStream.toXML(universities));
            fileWriter.close();
            System.out.println("XML file saved\n\n");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
