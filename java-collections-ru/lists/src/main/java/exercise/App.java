package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String characterList, String word) {
        String[] separateCharacters = characterList.split("");
        List<String> charsOfCharacterList = new ArrayList<>(Arrays.asList(separateCharacters));
        String[] separateCharacters2 = word.toLowerCase().split("");
        List<String> charsOfWord = new ArrayList<>(Arrays.asList(separateCharacters2));

            for (String letter : charsOfCharacterList) {
                charsOfWord.remove(letter);
            }

            return charsOfWord.isEmpty();
    }

}
//END
