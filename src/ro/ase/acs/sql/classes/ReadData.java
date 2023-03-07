package ro.ase.acs.sql.classes;

import ro.ase.acs.sql.interfaces.DatabaseOperation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData implements DatabaseOperation {
    private static final String SELECT_SQL = "SELECT * FROM employees";
    @Override
    public void execute(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_SQL);
        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            System.out.println("id: " + id);
            String name = resultSet.getString(2);
            System.out.println("name: " + name);
            String address = resultSet.getString("address");
            System.out.println("address: " + address);
            double salary = resultSet.getDouble("salary");
            System.out.println("salary: " + salary);
        }
        resultSet.close();
        statement.close();
    }
}
