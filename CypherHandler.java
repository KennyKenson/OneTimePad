import java.util.ArrayList;
import java.util.Random;
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

//    public static ArrayList<Character> encryptMessage(ArrayList<Character> message, ArrayList<Character> cypher) {
//        ArrayList<Character> encryptedMessage = new ArrayList<>();
//        int currentLetter;
//        Random random = new Random();
//        if (message.size() > cypher.size()) {
//            System.out.println("This message is too long to be encrypted.");
//            return null;
//        }
//        for (int i = 0; i < cypher.size(); i++) {
//            if (i % 5 == 0) {
//                encryptedMessage.add(' ');
//            } else {
//                try {
//                    currentLetter = message.get(i);
//                    if (currentLetter > 96 && currentLetter < 123) {
//                        currentLetter -= 32;
//                    }
//                    if (currentLetter > 64 && currentLetter < 91) {
//                        currentLetter += cypher.get(i) - 64;
//                        if (currentLetter > 90) {
//                            currentLetter -= 26;
//                            encryptedMessage.add((char) currentLetter);
//                        }
//                    }
//                } catch (IndexOutOfBoundsException ibe) {
//                    encryptedMessage.add((char) (random.nextInt(25)+64));
//                }
//            }
//        }
//        return encryptedMessage;
//    }

}
