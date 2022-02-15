package com.company;

import static java.lang.String.format;
import java.lang.*;


public class Database {

    public static String data;
    private String filename;
    private static int rowWidth;
    private static int recordCount;

    public Database(String filename, int rowWidth) {
        this.filename = filename;
        this.rowWidth = rowWidth;
        recordCount = countRecords();
    }

    private int countRecords() {
        int count = 0;
        String record = getRecordCount(count);
        while (record != null) {
            count++;
            record = getRecordCount(count);
        }
        recordCount = count;
        return count;
    }

    public static String appendRecord(String s) {
//TODO pad the data to correct reocrd width
        //TODO If data too long give error

        //pad the data structure
        //Pad data to the correct width
        int currentLength = data.length();
        int paddingNeeded = rowWidth - currentLength;
        String paddedData = data;
        // add a padding space
        for (int i = 0; i < paddingNeeded; i++) paddedData = paddedData + " ";
        if (currentLength > 10) {
            System.out.println("ERROR!!: TRIED TO WRITE " + data + "to field width of " + rowWidth);
        } else {
            FileHandler.writeToFile("Database.txt", paddedData, true);
            recordCount--; //remember to decrement record,
        }

        String textToConvert = "Database.txt";
        String convertedText = appendRecord("4.ABCDEFGH");
        System.out.println(convertedText);
        return textToConvert;
    }

    public static void appendPadRecord(String str) {
        String appendRecord;format("|%-10d|", 101);
        System.out.println(appendRecord("4.ABCDEFGH"));

    }

    public String getRecordCount(int i) {
        int count = 0;
        String record = getRecordCount(count); //faulty line //TODO fix this somehow idk..
        while(record != null) {
            record = getRecordCount(count);
            count++;
        }
        return FileHandler.readLineAt("Database.txt"); // or you can do return count-1;
    }

    public boolean findRecord(String searchRecord) {
        //TODO FIX THIS!!!!! DOESNT WORK!
        int i = 0;
        while (i < recordCount) {
            String testRecord = getRecordCount(i);
            if (testRecord.equals(searchRecord)) {
                i++;
                return true;
            }
            //use testRecord.equals(searchRecord)) instead of "==" because the program will look for the file in the memory rather than the program
        }

        return false;
    }

}


