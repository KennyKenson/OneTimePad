import java.io.*;
import java.util.ArrayList;


public class CypherHandler {

    public static ArrayList<Character> shaveMessage(ArrayList<Character> message) {
        ArrayList<Character> shavedMessage = new ArrayList<>();
        for (char letter : message) {
            if ((letter > 64 && letter < 91) || (letter > 96 && letter < 123) || letter == 10) {
                if (letter > 96) {
                    letter -= 32;
                }
                shavedMessage.add(letter);
            }
        }
        return shavedMessage;
    }

    public static ArrayList<Character> EncryptFile(ArrayList<Character> file, ArrayList<Character> key){
        int currentLetter;
        ArrayList<Character> shavedMessage = shaveMessage(file);
        ArrayList<Character> hiddenMessage = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            currentLetter = shavedMessage.get(i);
            currentLetter += key.get(i);
            if (currentLetter > 90) {
                currentLetter -= 26;
            }
            hiddenMessage.add((char) currentLetter);
        }
        return hiddenMessage;
    }

    public static ArrayList<Character> DecryptFile(ArrayList<Character> file, ArrayList<Character> key){
        int currentLetter;
        ArrayList<Character> shavedMessage = shaveMessage(file);
        ArrayList<Character> revealedMessage = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            currentLetter = shavedMessage.get(i);
            currentLetter -= key.get(i);
            if (currentLetter < 65) {
                currentLetter += 26;
            }
            revealedMessage.add((char) currentLetter);
        }
        return revealedMessage;
    }
}
