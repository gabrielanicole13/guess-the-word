package GUESS_THE_WORD;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        WordBank bank = new WordBank();
        String rand = bank.getRandomWord();
        wordGame game = new wordGame(rand);

        System.out.println("WELCOME TO THE GUESS THE WORD GAME");
        System.out.println("Type in lowerCase");
        System.out.print("Type 's' to start: ");
        char start = input.next().charAt(0);
        input.nextLine();

        if(start == 's'){
                System.out.println("Enter your guess letter: ");
                String guessWord = input.nextLine();

                if(guessWord.length() == 1){
                    char letter = guessWord.charAt(0);
                    game.guess(letter);
                }else{
                    game.guessWord(guessWord);
                }
                System.out.println(game.getMaskedWord());
                System.out.println("Lives: " + game.getLiveLeft());
            }

            if(game.isWon()){
                System.out.println("CONGRATULATIONS! You won the game.");
            }else{
                System.out.println(rand);
            }
        }
    }
}
