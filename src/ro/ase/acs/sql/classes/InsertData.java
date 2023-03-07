package ro.ase.acs.sql.classes;

import ro.ase.acs.sql.interfaces.DatabaseOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData implements DatabaseOperation {
    private static final String INSERT_SQL = "INSERT INTO employees(id, name, address, salary) VALUES (?, ?, ?, ?)";
    @Override
    public void execute(Connection connection) throws SQLException {
        String sqlInsert = "INSERT INTO employees VALUES(1, 'Popescu Ion', 'Bucharest', 4000)";

        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlInsert);
        statement.close();

        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);

        preparedStatement.setInt(1, 2);
        preparedStatement.setString(2, "Ionescu Vasile");
        preparedStatement.setString(3, "Brasov");
        preparedStatement.setDouble(4, 4500);
        preparedStatement.executeUpdate();
        preparedStatement.close();

        connection.commit();
    }
}
