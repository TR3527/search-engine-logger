package com.pluralsight;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    public static void main(String[] args) throws IOException {


        Scanner read = new Scanner(System.in);

        //BufferedWriter.write() — writes text to a file.
        //- logRecording() — method that will use the writer to record an action.

        logRecording("launch","");


        String searchTerm;

        do{
            System.out.print("Enter a search term(X to exit): ");
            searchTerm = read.nextLine();
            if (!searchTerm.equalsIgnoreCase("x")){
                logRecording("search",searchTerm);
            }
        } while (!searchTerm.equalsIgnoreCase("X"));

        logRecording("exit", "");



    }

    public static void logRecording(String logAction, String searchTerm) throws IOException {

        LocalDateTime rightNow = LocalDateTime.now();

        DateTimeFormatter timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ");

        // System.out.println(rightNow.format(timeStamp));

        FileWriter fileWriter = new FileWriter("logs.txt", true);
        BufferedWriter bufWriter = new BufferedWriter(fileWriter);


        if (logAction.equals("launch")){

            bufWriter.write(rightNow.format(timeStamp) + logAction);

        }else if(logAction.equals("search")){

            bufWriter.write(rightNow.format(timeStamp) + logAction + " : " + searchTerm);
        }
        else{

            bufWriter.write(rightNow.format(timeStamp)  + logAction);


        }
        bufWriter.newLine();
        bufWriter.close();





    }
}
