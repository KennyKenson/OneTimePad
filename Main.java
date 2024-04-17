import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        boolean ticket = false;
        while (!ticket) {
            ticket = mainMenu(ticket);
        }
    }

    public static boolean mainMenu(boolean ticket) {
        System.out.print("""
                ---------------------------------
                S-E-C-R-E-T-+-M-E-S-S-E-N-G-E-R
                ---------------------------------

                1. Encrypt a file
                2. Decrypt a file
                3. View  the contents of a file
                4. Exit
                
                > """);
        try {
            switch (Integer.parseInt(reader.nextLine())) {
                case 1:
                    encryptMenu();
                    break;
                case 2:
                    decryptMenu();
                    break;
                case 3:
                    viewFileMenu();
                    break;
                case 4:
                    ticket = true;
                    break;
                default:
                    System.out.println("Please enter a valid option!");
                    System.out.print("Enter any key to continue...");
                    reader.nextLine();
            }
        } catch (IllegalArgumentException iae) {
            System.out.println("Please enter a valid option!");
            System.out.print("Enter any key to continue...");
            reader.nextLine();
        }
        return ticket;
    }

    public static void encryptMenu() {
        boolean success;
        System.out.print("""
                -+-+-+-+-+-+-+-
                FILE DECRYPTION
                -+-+-+-+-+-+-+-
                
                Enter the filename of the plaintext message: """);
        try {
            String plainTextFile = reader.nextLine();
            System.out.print("Enter the filename of the encryption key: ");
            String encryptKeyFile = reader.nextLine();
            System.out.print("Enter the filename of the plaintext message: ");
            String cipherTextFile = reader.nextLine();
            ArrayList<Character> plainText = FileHandler.importFile(plainTextFile);
            ArrayList<Character> encryptKey = FileHandler.importFile(encryptKeyFile);
            ArrayList<Character> cipherText = CypherHandler.encryptMessage(plainText, encryptKey);
            if (plainTextFile.isEmpty()) {
                success = FileHandler.exportFile(cipherText);
            } else {
                success = FileHandler.exportFile(cipherText, cipherTextFile);
            }
            if (success) {
                System.out.println("Your message has been encrypted!\n");
            }
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("One or more of these files cannot be found.\n");
        }
    }

    public static void decryptMenu() {
        boolean success;
        System.out.print("""
                -+-+-+-+-+-+-+-
                FILE DECRYPTION
                -+-+-+-+-+-+-+-
                
                Enter the filename of the ciphertext message: """);
        try {
            String cipherTextFile = reader.nextLine();
            System.out.print("Enter the filename of the decryption key: ");
            String decryptKeyFile = reader.nextLine();
            System.out.print("Enter the filename of the plaintext message: ");
            String plainTextFile = reader.nextLine();
            ArrayList<Character> cipherText = FileHandler.importFile(cipherTextFile);
            ArrayList<Character> decryptKey = FileHandler.importFile(decryptKeyFile);
            ArrayList<Character> plainText = CypherHandler.decryptMessage(cipherText, decryptKey);
            if (plainTextFile.isEmpty()) {
                success = FileHandler.exportFile(plainText);
            } else {
                success = FileHandler.exportFile(plainText, plainTextFile);
            }
            if (success) {
                System.out.println("Your message has been decrypted!\n");
            }
        } catch (IndexOutOfBoundsException ibe) {
            System.out.println("One or more of these files cannot be found.\n");
        }
    }

    public static void viewFileMenu() {
        System.out.print("""
                +-+-+-+-+-+
                FILE VIEWER
                +-+-+-+-+-+
                                
                Enter the filename of the file to view: """);
        String file = reader.nextLine();
        System.out.println("-+- Begin view-+-\n");
        FileHandler.printFile(file);
        System.out.println("\n\n-+- End view-+-\n");
    }
}