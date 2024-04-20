import java.util.ArrayList;
import java.util.Random;

public class CypherHandler {

    /**
     * Takes a character arraylist and turns all lowercase letters into uppercase,
     * and removes all characters which are not letters or new lines.
     *
     * @param message The character arraylist which is 'shaved'.
     * @return The new 'shaved' arraylist.
     */
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

    /**
     * Takes a character arraylist and encrypts it with another character arraylist that acts as a cipher.
     *
     * @param message The arraylist that is to be encrypted.
     * @param key The arraylist used to encrypt 'message'.
     * @return The new encrypted character arraylist.
     */
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
                if (counter % 25 == 1 && counter!= 1){
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

    /**
     * Takes a character arraylist and decrypts it with another character arraylist that acts as a cipher.
     *
     * @param message The arraylist that is to be decrypted.
     * @param key The arraylist used to decrypt 'message'.
     * @return The decrypted arraylist.
     */
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
