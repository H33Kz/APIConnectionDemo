package com.h33kz.APIConnectionDemo;

import java.net.http.HttpResponse;
import java.util.Scanner;

public class CommandLinePrompter {
    private Scanner scanner;
    private RequestHandler requestHandler;
    private HttpResponse<String> response;
    private FileSaveHandler fileSaveHandler;

    public CommandLinePrompter(Scanner scanner, RequestHandler requestHandler, FileSaveHandler fileSaveHandler) {
        this.scanner = scanner;
        this.requestHandler = requestHandler;
        this.fileSaveHandler = fileSaveHandler;
    }

    public void appLoop() throws Exception {
        mainloop: while (true) {

            switch (mainMenuPrompt()) {
                case 1:
                    demoPrompt();
                    break;
                case 2:
                    if (response == null) {
                        System.out.println("Response body empty\n\n");
                    } else {
                        // TODO Data manipulation routine
                    }
                    break;
                case 3:
                    if (response == null) {
                        System.out.println("Response body empty\n\n");
                    } else {
                        fileSavePrompt();
                    }
                    break;
                case 4:
                    if (response == null) {
                        System.out.println("Response body empty\n\n");
                    } else {
                        System.out.println(response.body());
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break mainloop;
            }
        }
    }

    private int mainMenuPrompt() {
        System.out.println("Choose option:\n" +
                "1. API demo(default)\n" +
                "2. Data manipulation\n" +
                "3. Save data as file\n" +
                "4. Show response\n" +
                "5. Exit\n");

        int chosen = 1;

        try {
            chosen = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Wrong input. Resorting to default value");
        }

        return chosen;
    }

    private void demoPrompt() throws Exception {
        System.out.println("Choose option:\n" +
                "1. Search all\n" +
                "2. Filter by name\n" +
                "3. Filter by country\n");

        int chosen = 1;

        try {
            chosen = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Wrong input. Resorting to default value");
        }
        scanner.nextLine(); // Consumes \n - needed because nextInt() doesn't, which messes with next input

        if ((chosen != 1) && (chosen != 4)) {
            System.out.println("Enter filtering string:");
        }
        String filter = switch (chosen) {
            case 1 -> filter = "";
            case 2 -> filter = "name=" + scanner.nextLine();
            case 3 -> filter = "country=" + scanner.nextLine();
            default -> filter = "";
        };

        requestHandler.createRequest("http://universities.hipolabs.com/search?", filter);
        response = requestHandler.sendRequest();
        return;
    }

    private void fileSavePrompt() {
        System.out.println("Choose option:\n" +
                "1. Save as JSON(default)\n" +
                "2. Save as CSV\n" +
                "3. Save as XML\n" +
                "4. Exit\n");

        int chosen = 1;
        try {
            chosen = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Wrong input. Resorting to default value");
        }
        scanner.nextLine(); // Consumes \n - needed because nextInt() doesn't, which messes with next input

        System.out.println("Enter file name: \n");
        String filename = scanner.nextLine();

        switch (chosen) {
            case 1 -> fileSaveHandler.saveToJsonFile(filename, response.body());
            case 2 -> fileSaveHandler.saveToCsvFile(filename, response.body());
            case 3 -> fileSaveHandler.saveToXmlFile(filename, response.body());
            case 4 -> System.out.println();
            default -> System.out.println("Wrong input");
        }
        return;
    }
}
