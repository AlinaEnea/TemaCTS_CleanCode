package ro.ase.acs.sql.classes;

import ro.ase.acs.sql.interfaces.DatabaseOperation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable implements DatabaseOperation {
    private static final String DROP_TABLE_SQL = "DROP TABLE IF EXISTS employees";
    private static final String CREATE_TABLE_SQL = "CREATE TABLE employees(id INTEGER PRIMARY KEY, name TEXT, address TEXT, salary REAL)";
    @Override
    public void execute(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        statement.executeUpdate(DROP_TABLE_SQL);
        statement.executeUpdate(CREATE_TABLE_SQL);
        statement.close();
        connection.commit();
    }
}
