package tower.of.hanoi.game;

import tower.of.hanoi.Main;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public abstract class Stats {

    public static long start;
    private static final String statsFile = "assets/stats.dat";

    public static void stats() {

        long timeMs = System.currentTimeMillis() - start;
        System.out.println(timeMs + "ms");

        String record = readFile(timeMs);
        String recordLine = "";

        //Prints only if the player has played at least 1 round
        try {
            if (record.charAt(0) != '0') {
                recordLine = ("The previous record was: " + record + ".\n");
            }
        }
        catch (StringIndexOutOfBoundsException ignored) {}

        boolean ok; char answer = ' ';
        do {
            ok = true;
            try {
                answer = Character.toLowerCase(JOptionPane.showInputDialog("Board size: " + Main.POLES + '\n' +
                        "Number of disks: " + Main.disks + '\n' +
                        "Congratulations, you won!\nIt took you " + Main.turns + " turns and " + calcTime(timeMs) + '\n' +
                        recordLine +
                        "Would you like to play again? (Y/N)").charAt(0) );
            }
            catch (StringIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, Main.stringOutOfBounds);
                ok = false;
            }

            if (ok) {
                if (answer != 'y' && answer != 'n') {
                    JOptionPane.showMessageDialog(null,
                            "Wrong input, please type 'Y' for yes or 'N' for no");
                    ok = false;
                }
            }
        } while (!ok);

        if (answer == 'y') {
            Main.turns = 0;
            Main.setUp();
        }
    }

    //Calculates the time from ms to seconds and minutes
    private static String calcTime(long ms) {

        StringBuilder builder = new StringBuilder();

        long sec = (ms + 500) / 1000; //Total number of seconds, (+ 500) either round up or down
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

    private static String readFile(long timeMs) { //TODO Test

        File stats = new File(statsFile);

        int[] records = new int[Main.DISKS_MAX+1]; //Max disks to play with + 2 available slots, index 0 and 1
        long[] times = new long[Main.DISKS_MAX+1];
        String record = "";

        try (Scanner scanner = new Scanner(stats) ) {

            scanner.nextLine(); //Skips over the first line

            int diskNr = Main.DISKS_MIN;
            while (scanner.hasNextLong() ) {

                { //Skips over first integer and divider, for each line
                    scanner.nextInt();
                    scanner.next();
                }

                records[diskNr] = scanner.nextInt(); //Saves the old turn records

                { //Skips "turns |"
                    scanner.next(); scanner.next();
                }

                times[diskNr] = scanner.nextLong(); //Saves the old time records
                scanner.nextLine();

                if (diskNr == Main.disks) {

                    record = records[diskNr] + " turns and " + calcTime(times[diskNr]); //Saves the previous record

                    if (Main.turns < records[diskNr] || records[diskNr] == 0) {
                        records[diskNr] = Main.turns;
                    }
                    if (timeMs < times[diskNr] || times[diskNr] == 0) {
                        times[diskNr] = timeMs;
                    }
                }
                diskNr++;
            }
            if (!Main.autoplay) {
                writeToFile(records, times);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found! Trying to create new file: " + statsFile);

            if (writeToFile(records, times) ) {
                readFile(timeMs);
            }
        }
        return record;
    }

    public static boolean writeToFile(int[] records, long[] times) {

        //Creates folder if it doesn't exist
        File assets = new File("assets");
        if (!assets.exists() ) {
            if (assets.mkdir() ) {
                System.out.println("Folder created!");
            }
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(statsFile, false) ) ) {

            writer.printf("%14s %1s %-10s %n", "Number of disks", '|', "Previous record");

            for (int diskNr = Main.DISKS_MIN; diskNr < records.length; diskNr++) {

                writer.printf("%15s %1s %-5s %1s %1s %1s %1s %n", diskNr, '|', records[diskNr], "turns.", '|', times[diskNr], "ms");
            }
        }
        catch (IOException e) {
            System.out.println("File could not be created!");
            return false;
        }
        return true;
    }
}
