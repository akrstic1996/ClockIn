package org.krstic;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Enter anything to clock in: \n\n\n");
        Boolean isClockedIn = false;
        Scanner scan = new Scanner(System.in);
        LocalDateTime timeClockedIn = null;
        LocalDateTime timeClockedOut;
        int totalTimeElapsed = Integer.parseInt(
                new String(Files.readAllBytes(Paths.get("src/main/resources/time.txt"))).trim());


        while(scan.nextLine() != "") {
            if (isClockedIn){
                timeClockedOut = LocalDateTime.now();
                long timeElapsed = timeClockedIn.until(timeClockedOut, ChronoUnit.SECONDS);
                totalTimeElapsed += timeElapsed;
                String ttStr = String.valueOf(totalTimeElapsed);
                Files.write(Paths.get("src/main/resources/time.txt"), ttStr.getBytes());

                int seconds = (int) (timeElapsed % 60);
                int minutes = (int) (timeElapsed / 60) % 60;
                int hours = (int) (timeElapsed / 360);

                int tseconds = (int) (totalTimeElapsed % 60);
                int tminutes = (int) (totalTimeElapsed / 60) % 60;
                int thours = (int) (totalTimeElapsed / 360);

                System.out.println("Clocking out\n\nTime Elapsed: " + hours + " hours and "
                        + minutes + " minutes and " + seconds + " seconds." + "Total time: " +
                        thours + " hours " + tminutes + " minutes and " + tseconds
                        + " seconds.\n\nEnter anything to clock back in." );

                isClockedIn = false;
            } else {
                System.out.println("Clocking in!\n\nEnter anything to clock out.");
                isClockedIn = true;
                timeClockedIn = LocalDateTime.now();
            }
        }


    }
}