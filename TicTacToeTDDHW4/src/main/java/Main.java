
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
/*
    Notes:
        _ | _ | _
        _ | _ | _
          |   |
         Helpful indices
         [0][0] , [0][2] , [0][4]
         [1][0] , [1][2] , [1][4]
         [2][0] , [2][2] , [2][4]
        Player = 1
        Computer = 2
 */
    public static void main(String [] args){
        TicTacToe ticTacToe = new TicTacToe();
        char [][] gameBoard = {{'_','|','_','|','_'},{'_', '|', '_','|','_'},{' ','|',' ','|',' '}};

        ticTacToe.printBoard(gameBoard);

        boolean gameOver = false;
        boolean playAgain = true;


        while(playAgain) {
            System.out.println("Game is starting...");
            while (!gameOver) {

                ticTacToe.play(gameBoard);

                gameOver = ticTacToe.isGameOver(gameBoard);
                if (gameOver) {
                    break;
                }

                ticTacToe.computerMove(gameBoard);
                gameOver = ticTacToe.isGameOver(gameBoard);
                if (gameOver) {
                    break;
                }
            }
            System.out.println("Player Score: " +ticTacToe.playerScore);
            System.out.println("Computer Score: "+ ticTacToe.computerScore);
            System.out.println("Would you like to play again? Y/N");
            String result = input.nextLine();

            switch (result){
                case "Y":
                case "y":
                    playAgain = true;
                    System.out.println("Okay! Let's play again");
                    ticTacToe.resetBoard(gameBoard);
                    gameOver = false;
                    ticTacToe.printBoard(gameBoard);
                    break;

                case "N":
                case "n":
                    playAgain = false;
                    System.out.println("Thanks for playing");
                    break;
                default:
                    break;
            }
        }
    }
}


