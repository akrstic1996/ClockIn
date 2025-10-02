package org.krstic;


import java.io.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Enter anything to clock in: \n\n\n");
        Boolean isClockedIn = false;
        Scanner scan = new Scanner(System.in);
        LocalDateTime timeClockedIn = null;
        LocalDateTime timeClockedOut = null;
        char[] array = new char[9];


        while(scan.nextLine() != "") {
            if (isClockedIn){
                FileOutputStream out = new FileOutputStream("src/main/resources/time.txt");
                FileInputStream in = new FileInputStream("src/main/resources/time.txt");
                InputStreamReader reader = new InputStreamReader(in);
                OutputStreamWriter writer = new OutputStreamWriter(out);
                reader.read(array);
                String timestr = array.toString();
                int totalTimeElapsed = Integer.parseInt(timestr);
                timeClockedOut = LocalDateTime.now();
                long timeElapsed = timeClockedIn.until(timeClockedOut, ChronoUnit.SECONDS);

                totalTimeElapsed += timeElapsed;
                String ttStr = String.valueOf(totalTimeElapsed);
                writer.write(ttStr);
                int seconds = (int) (timeElapsed % 60);
                int minutes = (int) (timeElapsed / 60);
                System.out.println("Clocking out\n\n Time Elapsed: " + minutes + " minutes and " + seconds + " seconds." + "Total time " +
                        totalTimeElapsed + "\n\nEnter anything to clock back in." );



                isClockedIn = false;
            } else {
                System.out.println("Clocking in!\n\n Enter anything to clock out.");
                isClockedIn = true;
                timeClockedIn = LocalDateTime.now();
            }
        }


    }
}