import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) throws FileNotFoundException {
        File myObj = new File("ENG_words.txt");
        Scanner myReader = new Scanner(myObj);
        Scanner input = new Scanner(System.in);

        List<String> dictionary = new ArrayList<>();

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            dictionary.add(data);
        }

        String slogan = dictionary.get((int) (Math.random() * dictionary.size()));
        System.out.println(slogan);

        List<Character> playerGuesses = new ArrayList<>();
        int wrongGuesses = 0;
        while(true) {

            PrintHangman(wrongGuesses);
            if(wrongGuesses >= 6){
                System.out.println("You lose! The word was " + slogan);
                break;
            }
            printWordState(slogan, playerGuesses);
            if(!getPlayerGuess(input, slogan, playerGuesses)){
                wrongGuesses++;
            }
            else if (printWordState(slogan, playerGuesses)) {
                System.out.println("You win");
                break;
            }
        }
    }

    private static void PrintHangman(int wrongGuesses) {
        if(wrongGuesses == 1){
            System.out.println("  +-----+");
            System.out.println("  |     |");
            System.out.println("  O     |");
            System.out.println("        |");
            System.out.println("       ===");
        }
        else if (wrongGuesses == 2){
            System.out.println("  +-----+");
            System.out.println("  |     |");
            System.out.println("  O     |");
            System.out.println("  |     |");
            System.out.println("       ===");
        }
        else if (wrongGuesses == 3){
            System.out.println("  +-----+");
            System.out.println("  |     |");
            System.out.println("  O     |");
            System.out.println(" /|     |");
            System.out.println("       ===");
        }
        else if (wrongGuesses == 4) {
            System.out.println("  +-----+");
            System.out.println("  |     |");
            System.out.println("  O     |");
            System.out.println(" /|\\    |");
            System.out.println("       ===");
        }
        else if (wrongGuesses == 5) {
            System.out.println("  +-----+");
            System.out.println("  |     |");
            System.out.println("  O     |");
            System.out.println(" /|\\    |");
            System.out.println(" /      ===");
        }
        else if (wrongGuesses == 6) {
            System.out.println("  +-----+");
            System.out.println("  |     |");
            System.out.println("  O     |");
            System.out.println(" /|\\    |");
            System.out.println(" / \\   ===");
        }
    }

    private static boolean getPlayerGuess(Scanner input, String slogan, List<Character> playerGuesses) {
        System.out.println(("Enter a letter"));
        String letterGuess = input.nextLine();
        playerGuesses.add(letterGuess.charAt(0));

        return slogan.contains(letterGuess);
    }

    private static boolean printWordState(String slogan, List<Character> playerGuesses) {
        int correctGuesses = 0;

        for(int i = 0; i < slogan.length(); i++){
            if (playerGuesses.contains(slogan.charAt(i))){
                System.out.print(slogan.charAt(i));
                correctGuesses++;
            }
            else{
                System.out.print("-");
            }
        }
        System.out.println();
        return (slogan.length() == correctGuesses);
    }
}
