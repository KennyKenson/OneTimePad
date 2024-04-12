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

    public static void exportFile(ArrayList<Character> file) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/ExportedMessage.txt"));
            for (char output : file) {
                writer.write(output);
            }
            writer.close();
        } catch (IOException iox) {
            System.out.println("Failed to export file.");
        }
    }

    public static void exportFile(ArrayList<Character> file, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (char output : file) {
                writer.write(output);
            }
            writer.close();
        } catch (IOException iox) {
            System.out.println("Failed to export file.");
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
            System.out.println("Failed to print file to console.");
        }
    }
}