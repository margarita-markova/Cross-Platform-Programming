/**
 * This code calculates the day of week. It need two parameters. There are year (AD era) and number of the day.
 * After calculation, GUI is unenabled for 30 seconds. Then app restarts it's work.
 * @author Margaret Markova
 * @version 1.0
 * @since March, 2018
 *
 *
 */

package com.marksuree;

/**
 * Main class includes main method. Is is start point of program.
 */
public class Main {
    /**
     * Main method creates object of DayOfWeekCalculator class and use it's method to build GUI
     * and interacts with user. When work finished, thread sleeps and app restarts.
     * @param args This parameter check command-line arguments.
     * @throws InterruptedException This exception uses for sleep() method and work with threads.
     */
    public static void main(String args[]) throws Exception {

        try {
            DayOfWeekCalculator dayOfWeekCalculator = new DayOfWeekCalculator();
            dayOfWeekCalculator.createGraphicalUserInterface();
            Thread.sleep(10000);
            dayOfWeekCalculator.restartApp();
        }

        catch(Exception e)
        {
            DayOfWeekCalculator dayOfWeekCalculator = new DayOfWeekCalculator();
            dayOfWeekCalculator.restartApp();
        }


    }

}
