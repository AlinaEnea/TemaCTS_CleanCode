package ro.ase.acs.sql.main;

import ro.ase.acs.sql.classes.CreateTable;
import ro.ase.acs.sql.classes.InsertData;
import ro.ase.acs.sql.classes.ReadData;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    private static final String DB_URL = "jdbc:sqlite:database.db";
    private static final String CLASS_NAME = "org.sqlite.JDBC";
    public static void main(String[] args) {
        CreateTable createTable = new CreateTable();
        InsertData insertData = new InsertData();
        ReadData readData = new ReadData();

        try {
            Class.forName(CLASS_NAME);
            Connection connection = DriverManager.getConnection(DB_URL);
            connection.setAutoCommit(false);

            createTable.execute(connection);
            insertData.execute(connection);
            readData.execute(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
