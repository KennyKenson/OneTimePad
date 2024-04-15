import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {

    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        boolean ticket = false;
        while (!ticket) {
            ticket = mainMenu(ticket);
        }
    }

    public static boolean mainMenu(boolean ticket) {
        boolean ticket2 = false;
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
                    break;
                case 2:
                    break;
                case 3:
                    viewFileMenu();
                    break;
                case 4:
                    ticket = true;
                    break;
            }
        } catch (IllegalArgumentException iae) {
            System.out.println("Invalid input.");
        }
        return ticket;
    }

    public static void viewFileMenu() {
        System.out.print("Enter the filename of the file to view: ");
        String file = reader.nextLine();
        System.out.println("-+- Begin view-+-\n");
        FileHandler.printFile(file);
        System.out.println("\n\n-+- End view-+-\n");
        System.out.println("Enter any key to continue...");
        reader.nextLine();
    }
}