import java.util.ArrayList;
import java.util.Random;

public class CypherHandler {
    public static void main(String args[]){
        ArrayList<Character> key = FileHandler.importFile("key01.txt");
        ArrayList<Character> message = FileHandler.importFile("sisters.txt");
        ArrayList<Character> EncryptedMessage = encryptMessage(message, key);
        ArrayList<Character> DecryptedMessage = decryptMessage(EncryptedMessage, key);
        ArrayList<Character> shavedMessage = shaveMessage(message);
        ArrayList<Character> shavedKey = shaveMessage(key);
        for (char c : message) {
            System.out.print(c);
        }
        System.out.println("\n");
        for (char c : shavedMessage) {
            System.out.print(c);
        }
        System.out.println("\n");
        for (char c : shavedKey) {
            System.out.print(c);
        }
        System.out.println("\n");
        for (char c : EncryptedMessage) {
            System.out.print(c);
//            System.out.print((int)c + " ");
        }
        System.out.println("\n");
        for (char c : DecryptedMessage) {
            System.out.print(c);
//            System.out.print((int)c + " ");
        }

    }

    public static ArrayList<Character> shaveMessage(ArrayList<Character> message) {
        ArrayList<Character> shavedMessage = new ArrayList<>();
        int counter = 0;
        for (char letter : message) {
            if ((letter > 64 && letter < 91) || (letter > 96 && letter < 123)) {
                if (letter > 96) {
                    letter -= 32;
                }
                shavedMessage.add(letter);
            }
        }
        return shavedMessage;
    }

    public static ArrayList<Character> encryptMessage(ArrayList<Character> message, ArrayList<Character> key){
        int counter = 1;
        Random random = new Random();
        int currentLetter;
        ArrayList<Character> shavedMessage = shaveMessage(message);
        ArrayList<Character> shavedKey = shaveMessage(key);
        ArrayList<Character> hiddenMessage = new ArrayList<Character>();
        for (int i = 0; i < key.size(); i++){
            try {
                currentLetter = (shavedMessage.get(i) + shavedKey.get(i) - 128);
                if (counter % 5 == 1 && counter != 1) {
                    hiddenMessage.add((char)32);
                }
                if (counter % 25 == 1){
                    hiddenMessage.add((char)10);
                }
                if (currentLetter > 26){
                    hiddenMessage.add((char) (currentLetter + 64 - 26));
                } else {
                    hiddenMessage.add((char) (currentLetter + 64));
                }
                counter++;
            } catch (IndexOutOfBoundsException ibe) {
                while (counter % 5 == 1 && counter != 1) {
                    hiddenMessage.add((char)(random.nextInt(26) + 65));
                    counter++;
                }
                break;
//                hiddenMessage.add((char)(random.nextInt(26) + 64));
            }

        }
        return hiddenMessage;
    }

    public static ArrayList<Character> decryptMessage(ArrayList<Character> message, ArrayList<Character> key){
        int currentLetter;
        int counter = 1;
        Random random = new Random();
        ArrayList<Character> shavedMessage = shaveMessage(message);
        ArrayList<Character> shavedKey = shaveMessage(key);
        ArrayList<Character> crackedMessage = new ArrayList<Character>();
        for (int i = 0; i < key.size(); i++){
            try {
                currentLetter = (shavedMessage.get(i) - shavedKey.get(i));
                if (counter % 5 == 1 && counter != 1) {
                    crackedMessage.add((char)32);
                }
                if (counter % 25 == 1){
                    crackedMessage.add((char)10);
                }
                if (currentLetter < 0){
                    crackedMessage.add((char) (90 + currentLetter));
                } else {
                    crackedMessage.add((char) (currentLetter + 64));
                }
                counter++;
            } catch (IndexOutOfBoundsException ibe) {
                break;
//                crackedMessage.add((char)(random.nextInt(26) + 65));
            }
        }
        return crackedMessage;
    }
}
