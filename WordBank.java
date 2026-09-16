package GUESS_THE_WORD;
import java.util.Random;

public class WordBank {
        String[] words = {"apple", "mechanical", "computer", "orange"};
    Random rand = new Random();

    public String getRandomWord(){
        int randomIndex = rand.nextInt(words.length);
        return words[randomIndex];
    }


}
