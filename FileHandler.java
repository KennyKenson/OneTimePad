import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    /**
     * Imports a text file into the program by turning it into a character arraylist.
     *
     * @param fileName Name of the imported file.
     * @return Character arraylist containing all the file's text information.
     */
    public static ArrayList<Character> importFile(String fileName) {
        ArrayList<Character> text = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int input = reader.read();
            while (input != -1) {
                text.add((char) input);
                input = reader.read();
            }
            reader.close();
        } catch (IOException iox) {
            System.out.println("Failed to import file.");
        }
        return text;
    }

    /**
     * Exports a character arraylist into a text file named "ExportedMessage.txt".
     *
     * @param file The arraylist that is turned into a text file.
     * @return A boolean that returns true if the file export was successful.
     */
    public static boolean exportFile(ArrayList<Character> file) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("ExportedMessage.txt"));
            for (char output : file) {
                writer.write(output);
            }
            writer.close();
            return true;
        } catch (IOException iox) {
            System.out.print("Failed to export file.");
            return false;
        }
    }

    /**
     * Exports a character arraylist into a text file with a custom name.
     *
     * @param file The arraylist that is turned into a text file.
     * @param fileName The name of the exported file.
     * @return A boolean that returns true if the file export was successful.
     */
    public static boolean exportFile(ArrayList<Character> file, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (char output : file) {
                writer.write(output);
            }
            writer.close();
            return true;
        } catch (IOException iox) {
            System.out.print("Failed to export file.");
            return false;
        }
    }

    /**
     * Takes a text file and prints it in its entirety onto the console.
     *
     * @param fileName Name of the text file that will be printed.
     */
    public static void printFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int input = reader.read();
            while (input != -1) {
                System.out.print((char) input);
                input = reader.read();
            }
        } catch (IOException iox) {
            System.out.print("Failed to print file to console.");
        }
    }
}