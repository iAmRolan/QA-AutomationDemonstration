package Utilities;

import org.python.antlr.base.stmt;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rolan Abdualiev , Dec 2021
 * @project QA-AutomationDemonstration
 */
public class ManageDB extends CommonOps {

    // Make connection
    public static void initSQLConnection() throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
        statement = connection.createStatement();
    }

    // Get data from DB column by column
    public static List<String> getCredentials(String query) throws SQLException {
        List<String> credentials = new ArrayList<String>();
        resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            credentials.add(resultSet.getString(1));
        }

        return credentials;
    }

    // Close connection to DB
    public static void closeDBCon() throws SQLException {
        connection.close();
    }
}
