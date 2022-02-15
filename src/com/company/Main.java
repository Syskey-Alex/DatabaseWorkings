package com.company;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Database");
        Database db = new Database("Database.txt", 10);
        System.out.println("worksMain"); db.appendRecord("1.ABCDEFGH");
        db.appendRecord("2.ABABABAB");
        db.appendRecord("3.ABCDEFGH");
        db.appendRecord("4.ABCDEFGH");
        System.out.println(db.getRecordCount(2));   // should be "3.ABCDEFGH"

        System.out.println(db.findRecord("EBCDEFGHIJ")); // false
        System.out.println(db.findRecord("2.ABCDEFGH")); // true
        // System.out.println("count = " + db.getRecordCount()); // 4
        FileHandler fh= new FileHandler();
        fh.writeToFile("Database.txt","123 ",true);

    }

}
