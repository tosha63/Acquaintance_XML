package ru.shtanko.xml;

import ru.shtanko.xml.converter.Converter;
import ru.shtanko.xml.db.WorkDB;

public class Main {
    public static void main(String[] args) {
        WorkDB.insertDB(100);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Converter.convertToXml();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Converter.transformXml();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Converter.convertToCsv();
    }
}
