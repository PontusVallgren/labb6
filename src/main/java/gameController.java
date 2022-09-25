import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class gameController {
    int numberOfGuesses;
    String theWord;
   hints hintGenerator = new hints();

    public void startHangmanGame() {
        generateWord();
        numberOfGuesses = 0;
        String[] res = {"Noway, i'm out!", "Yes let's go!"};
       int answer = JOptionPane.showOptionDialog(null, "Welcome to the game Hangman! Do you want to start the game?", "Hangman", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, res, 0);
       if(answer == 1) {
           while(numberOfGuesses < 4) {
               guessWord();
               numberOfGuesses++;
           }
       } else {
           System.exit(0);
       }
    }

    /**
     * Generates a random number and selects a word from a ArrayList of words, to be the winner word.
     */
    private void generateWord() {
        Random random = new Random();
        int x = random.nextInt(4-1) + 1;
        ArrayList<String> words = new ArrayList<>();
        words.add("Sweden");
        words.add("Finland");
        words.add("Thailand");
        words.add("Spain");
        Collections.sort(words);
        theWord = words.get(x -1);
    }

    /**
     * If second guess, give a hint.
     * If third guess, give another hint.
     */
    private void guessWord() {
        String guess;
        if(numberOfGuesses == 1) {
            guess = JOptionPane.showInputDialog("Guess the word!, Hint: " + hintGenerator.giveHint(theWord, 1));
            checkCorrectWord(guess);
        } if(numberOfGuesses == 2) {
            guess = JOptionPane.showInputDialog("Guess the word!, Hint: " + hintGenerator.giveHint(theWord, 2));
            checkCorrectWord(guess);
        }
        else {
            guess = JOptionPane.showInputDialog("Guess the word!");
            checkCorrectWord(guess);
        }
    }

    /**
     * Checks if the word matches with the correct word.
     * @param  word player guess.
     */
    public void checkCorrectWord(String word) {
        if(word.equalsIgnoreCase(theWord)) {
            JOptionPane.showMessageDialog(null, "You're the winner!");
            System.exit(0);
        }if(numberOfGuesses == 3) {
            String[] res = {"Exit", "Yes"};
           int answer = JOptionPane.showOptionDialog(null, "You lost! Want to play again?", "Hangman", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, res, 0);
           if (answer == 1) {
               startHangmanGame();
           } else {
               System.exit(0);
           }
        }
    }

}
