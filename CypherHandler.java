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
}
