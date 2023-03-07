package ro.ase.acs.sql.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseOperation {
    void execute(Connection connection) throws SQLException;
}
