package main;

import processors.HockeyTeamIntake;


/**
 * Simple NHL tool to visualize statistical data from: 
 *  https://www.naturalstattrick.com/
 * 
 * @author Shane
 */
public class NhlApp {
    public static void main(String... args) {       
        HockeyTeamIntake.processTeamStatsCsv();
    }
}
