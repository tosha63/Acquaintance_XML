package ru.shtanko.xml;

import ru.shtanko.xml.converter.Converter;
import ru.shtanko.xml.db.WorkDB;

public class Main {
    public static void main(String[] args) {
        WorkDB.insertDB(100);
        Converter.convertToXml();
        Converter.transformXml();
        Converter.convertToCsv();
    }
}
