package ro.ase.acs.sql.main;

import ro.ase.acs.sql.classes.CreateTable;
import ro.ase.acs.sql.classes.InsertData;
import ro.ase.acs.sql.classes.ReadData;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        CreateTable createTable = new CreateTable();
        InsertData insertData = new InsertData();
        ReadData readData = new ReadData();

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
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
