package com.company;

import java.io.*;


public class FileHandler {
    public static void readFromFile(String fileName, int lineNumber) {
        // read and print out the contents of a text file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String fileName, String text, boolean append) {  // write text to fileName
        try (
                FileWriter fw = new FileWriter(fileName, false);
                PrintWriter pw = new PrintWriter(fw);
        ) {
            pw.println(text);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error!");
        }
    }

    public static String readLineAt(String fileName) {
        try (RandomAccessFile rf = new RandomAccessFile("Database.txt", "rws")) {
            long start = 0;
            rf.seek(start);
            return rf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Database.txt";
    }

public static int appendLine(String filename, String data) {
        //make sure you write some text to end of file
        boolean append = true;
        try(PrintWriter pr = new PrintWriter(new FileWriter(filename, append))) {
            pr.println(data);
            return 0;

        }
        catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}




