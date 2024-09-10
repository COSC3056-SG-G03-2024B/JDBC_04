package app;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCClimate {
    private static final String DATABASE = "jdbc:sqlite:C:/Users/ASUS/Downloads/climateData.db";

    public JDBCClimate() {
        System.out.println("Object created: \n");
    }

    //Get the available year for Temperature
    public ArrayList<Integer> getAvailableYearTemp() {
        ArrayList<Integer> availableYears = new ArrayList<Integer>();
        // Setup connection
        Connection connection = null;

        try {
            // Connect to JDBC database
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT MIN(year) AS year FROM global_yearly_land_temp;";
            
            // Get Result
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                Integer year = result.getInt("year");

                // Store the movieName in the ArrayList to return
                availableYears.add(year);
            }

            String query2 = "SELECT MAX(year) AS year FROM global_yearly_land_temp;";

            //Get Result
            ResultSet result2 = statement.executeQuery(query2);

            while (result2.next()) {
                Integer year2 = result2.getInt("year");
                availableYears.add(year2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return availableYears;
    }

    public ArrayList<Integer> getAvailableYearPopulation() {
        ArrayList<Integer> availableYears = new ArrayList<Integer>();
        Connection connection = null;

        try {
            // Connect to JDBC database
            connection = DriverManager.getConnection(DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT MIN(year) AS year FROM dim_population;";
            
            // Get Result
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                Integer year = result.getInt("year");

                // Store the movieName in the ArrayList to return
                availableYears.add(year);
            }

            String query2 = "SELECT MAX(year) AS year FROM dim_population;";

            //Get Result
            ResultSet result2 = statement.executeQuery(query2);

            while (result2.next()) {
                Integer year2 = result2.getInt("year");
                availableYears.add(year2);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, lets just pring the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return availableYears;
    }
}
