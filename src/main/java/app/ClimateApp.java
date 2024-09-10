package app;

import java.util.ArrayList;

public class ClimateApp {
    // private static final String DATABASE = "jdbc:sqlite:C:/Users/ASUS/Downloads/climateData.db";
    public static void main(String[] args) {
        JDBCClimate jdbc = new JDBCClimate();
        
        System.out.println("Available Years for temperature: ");
        ArrayList<Integer> availableTempYear = new ArrayList<Integer>();
        availableTempYear = jdbc.getAvailableYearTemp();
        for (Integer year : availableTempYear) {
            System.out.println(year);
        }

        System.out.println("----------------------------------------------------------------------------");

        System.out.println("Available Years for population: ");
        ArrayList<Integer> availablePopulationYear = new ArrayList<Integer>();
        availablePopulationYear = jdbc.getAvailableYearPopulation();
        for (Integer year : availablePopulationYear) {
            System.out.println(year);
        }

        System.out.println("----------------------------------------------------------------------------");

        
    }
}
