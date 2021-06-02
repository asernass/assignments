import java.util.Scanner;


public class Assignment2 {
    public static void main(String[] args) {
        int chances = 5, guessed, numToGuess = (int) (Math.random() * 100);
        boolean wonGame = false;
        Scanner readInput = new Scanner(System.in);
        System.out.println("please guess a number within +- 10 of that number");
        while (chances > 0 && !wonGame) {
            try {
               guessed = readInput.nextInt();
                if ((numToGuess - 10) <= guessed && ((numToGuess + 10) >= guessed)) {
                    System.out.println("You guessed correctly the answer is: " + numToGuess);
                    wonGame = true;
                } else {
                    chances--;
                    System.out.println("You guessed incorrectly. You have " + chances + " chances");

                }
            } catch (Exception e) {
                System.out.println("Input not an integer. Please enter a valid Integer");
                readInput.next(); // clear the invalid integer from input
                continue;
            }
        }
        readInput.close();
        if (wonGame) {
            System.out.println("You gussed correctly with in range of 10. The answer was " + numToGuess);
        } else {
            System.out.println("Sorry you did not guess correctly. The answer was " + numToGuess);
        }
        
    }
    
}
