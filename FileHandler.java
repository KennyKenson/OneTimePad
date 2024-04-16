import java.io.*;
import java.util.ArrayList;

public class FileHandler {

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