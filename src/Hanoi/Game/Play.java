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

        boolean ok; char answer = ' ';
        do {
            ok = true;
            try {
                answer = Character.toLowerCase(JOptionPane.showInputDialog("Board size: " + Main.POLES + '\n' +
                        "Number of disks: " + Main.DISKS + '\n' +
                        "Congratulations, you won!\nIt took you " + Main.turns + " turns" + '\n' +
                        "The previous record was: " + record + '\n' +
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

    private int readFile() {

        File stats = new File(statsFile);
        int[] records = new int[11];
        int record = 0;

        try (Scanner scanner = new Scanner(stats) ) { //TODO save the best value, that's not 0
            //TODO read file, save to "records"
            for (int i = 2; i < records.length; i++) {

                while (scanner.hasNextInt()) {
                    int nr = scanner.nextInt(); //Skips over nr of disks

                    if (scanner.nextInt() < records[i] && scanner.nextInt() != 0) { //FIXME WRONG!
                        records[i] = scanner.nextInt();
                    }

                    if (i == Main.DISKS) {
                        record = records[i];
                    }
                }
            }
            if (!writeToFile(records) ) {
                System.out.println("Can't write to file");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return record;
    }

    private boolean writeToFile(int[] records) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(statsFile, false) ) ) {

            for (int i = 2; i <= 10; i++) {

                writer.print("Number of disks: " + i + "\t\tPrevious record was: ");

                if (i == Main.DISKS) {
                    writer.print(Main.turns);
                }
                else {
                    writer.print(records[i]);
                }
                writer.println(" turns.");
            }

        }
        catch (IOException e) {
            System.out.println("File not found!");
            return false;
        }
        return true;
    }
}
