package app;

import java.util.ArrayList;

public class ClimateApp {
    // private static final String DATABASE = "jdbc:sqlite:database/climateData.db";
    public static void main(String[] args) {
        JDBCClimate jdbc = new JDBCClimate();
        System.out.println("Available Years for temperature: ");
        ArrayList<Integer> availableTempYear = new ArrayList<Integer>();
        availableTempYear = jdbc.getAvailableYearTemp();
        for (Integer year : availableTempYear) {
            System.out.println(year);
        }
    }
}
