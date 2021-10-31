package Hanoi.Game;

import Hanoi.Draw.Draw;
import Hanoi.Main;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Play extends Draw { //TODO Autoplay

    public static final String statsFile = "assets/stats.txt";

    public Play(Game game) {
        super(game);
        startGame();
    }

    //Starts the game
    private void startGame() {

        boolean ok;

        do { //Choose Pole
            ok = true;
            try {
                move();
            }
            catch (NumberFormatException e) {
                ok = false;
                JOptionPane.showMessageDialog(null, Main.numberFormatExc);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                ok = false;
                JOptionPane.showMessageDialog(null, Main.arrayOutOfBounds);
            }

        } while (!ok);
    }

    private void move() {

        int posFrom, posTo;

        do {
            posFrom = Integer.parseInt(getText("Choose pole (0 - " + (Main.POLES - 1) + ")") );

            if (game.getPoles()[posFrom].isEmpty() ) {
                JOptionPane.showMessageDialog(null, "No disks in pole, try a different one!");
            }
            else {
                System.out.println(game.getPoles()[posFrom].getPosition() + " selected");

                posTo = Integer.parseInt(getText("Choose pole (0 - " + (Main.POLES - 1) + ")") );

                if (posFrom == posTo) {
                    JOptionPane.showMessageDialog(null, "You can't choose the same pole");
                }
                else { //If move is successful
                    game.getPoles()[posFrom].moveTo(game.getPoles()[posTo]);

                    run();
                    game.printAllArrays();
                }
            }

        } while (!game.isFinished() );

        stats();
    }

    private void stats() {

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
                        "Congratulations, you won!\nIt took you " + Main.turns + " turns" + '\n' +
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
            new Play(game);
        }
    }

    private int readFile() { //TODO Test

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
            if (!writeToFile(records) ) {
                System.out.println("Can't write to file");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
            writeToFile(records);
        }
        return record;
    }

    private boolean writeToFile(int[] records) { //TODO Test

        try (PrintWriter writer = new PrintWriter(new FileWriter(statsFile, false) ) ) {

            writer.println("Number of disks:\t|\tPrevious record was");

            for (int i = 2; i < records.length; i++) {

                writer.printf("%16s %4s %10s %n", i, '|', records[i] + " turns.");
            }
        }
        catch (IOException e) {
            System.out.println("File not found!");
            return false;
        }
        return true;
    }
}
