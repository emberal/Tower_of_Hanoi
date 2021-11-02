package Hanoi.Game;

import Hanoi.Main;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Stats {

    public static long start;
    private static final String statsFile = "assets/stats.dat";

    public static void stats(Game game) {

        long timeMs = System.currentTimeMillis() - start;
        System.out.println(timeMs + "ms");

        int record = readFile();

        String recordLine = "";
        if (record > 0) {
            recordLine = ("The previous record was: " + record + '\n');
        }

        boolean ok; char answer = ' ';
        do {
            ok = true;
            try {
                answer = Character.toLowerCase(JOptionPane.showInputDialog("Board size: " + Main.POLES + '\n' +
                        "Number of disks: " + Main.DISKS + '\n' +
                        "Congratulations, you won!\nIt took you " + Main.turns + " turns and " + calcTime(timeMs) + '\n' +
                        recordLine +
                        "Would you like to play again? (Y/N)").charAt(0) );
            }
            catch (StringIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null,"Input can't be empty");
                ok = false;
            }
            catch (NullPointerException ignored) {}

            if (ok) {
                if (answer != 'y' && answer != 'n') {
                    JOptionPane.showMessageDialog(null,
                            "Wrong input, please type 'Y' for yes or 'N' for no");
                    ok = false;
                }
            }
        } while (!ok);

        if (answer == 'y') {
            game.resetBoard();
            Main.setUp();
        }
    }

    //Calculates the time from ms to seconds and minutes
    private static String calcTime(long ms) {

        StringBuilder builder = new StringBuilder();

        long sec = (ms + 500) / 1000; //Total number of seconds (+ 500) either round up or down
        long min = sec / 60;
        sec = sec % 60;

        builder.append(min).append(" minute");
        if (min > 1) {
            builder.append("s");
        }

        builder.append(", ").append(sec).append(" second");
        if (sec > 1) {
            builder.append("s");
        }

        return builder.toString();
    }

    private static int readFile() { //TODO Test

        File stats = new File(statsFile);
        int[] records = new int[11]; //Max disks to play with + 2
        int record = 0;

        try (Scanner scanner = new Scanner(stats) ) {

            scanner.nextLine(); //Skips over the first line

            int diskNr = 2;
            while (scanner.hasNextInt() ) {

                { //Skips over first integer and divider, for each line
                    scanner.nextInt();
                    scanner.next();
                }

                records[diskNr] = scanner.nextInt(); //Saves the old records
                scanner.nextLine();

                if (diskNr == Main.DISKS) {

                    record = records[diskNr];
                    if (Main.turns < records[diskNr] || records[diskNr] == 0) {
                        records[diskNr] = Main.turns;
                    }
                }
                diskNr++;
            }
            writeToFile(records);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found! Trying to create new file: " + statsFile);

            if (writeToFile(records) ) {
                readFile();
            }
        }
        return record;
    }

    private static boolean writeToFile(int[] records) { //TODO Test

        try (PrintWriter writer = new PrintWriter(new FileWriter(statsFile, false) ) ) {

            writer.printf("%15s %2s %-10s %n", "Number of disks", '|', "Previous record was");

            for (int i = 2; i < records.length; i++) {

                writer.printf("%15s %2s %-5s %1s %n", i, '|', records[i], "turns.");
            }
        }
        catch (IOException e) {
            System.out.println("File could not be created!");
            return false;
        }
        return true;
    }
}
