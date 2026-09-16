package GUESS_THE_WORD;

import java.util.HashSet;
import java.util.Set;

public class wordGame {

    String secret_word;
    int maximum_life = 5;
    Set<Character> guessLetters = new HashSet<>();



    public wordGame(String secret_word){
        this.secret_word = secret_word.toLowerCase();
    }

    public void guess(char c){
        if(guessLetters.contains(c)){ //check if the char is already guessed
            return;
        }else{ //if not, add it in the set container
            guessLetters.add(c);
            if(!secret_word.contains(String.valueOf(c))){
                maximum_life -= 1;
            }
        }
    }

    public void guessWord(String word){
        if(word.equals(secret_word)){
            char[] convertLetters = secret_word.toCharArray();
            for(int i = 0; i < secret_word.length(); i++){
                guessLetters.add(convertLetters[i]);
            }
        }else{
            maximum_life -= 1;
        }
    }

    public String getMaskedWord(){

        char[] convertLetters = secret_word.toCharArray(); //convert the string into char
        StringBuilder hiddenWord = new StringBuilder();

        for(int i = 0; i < secret_word.length(); i++){
            if(guessLetters.contains(convertLetters[i])){
                hiddenWord.append(convertLetters[i]);
            }else{
                hiddenWord.append("_");
            }
        }

        return hiddenWord.toString();
    }

    public boolean isWon(){
        if(!getMaskedWord().contains("_")){
            return true;
        }
        return false;
    }

    public boolean isLoss(){
        if(maximum_life == 0){
            return true;
        }
        return false;
    }

    public int getLiveLeft(){
        return maximum_life;
    }


}
