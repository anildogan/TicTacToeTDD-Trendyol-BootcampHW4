import java.util.Random;
import java.util.Scanner;


public class TicTacToe {
    //    private char[][] table = {{'_','|','_','|','_'},{'_', '|', '_','|','_'},{' ','|',' ','|',' '}};
    private int turn=0;
    static int playerScore = 0;
    static int computerScore = 0;
    static Scanner input = new Scanner(System.in);


    public TicTacToe() {
    }

    public void play(char[][] table) {
        int move=0;
        System.out.println("Please make a move. (1-9)");

            Scanner input=new Scanner(System.in);
            if(input.hasNextInt()) {
                 move = input.nextInt();
                boolean result = checkBoardPositionIsValid(move, table);
                boolean resultCheck = checkCanPlay(move);

                while (!result && !resultCheck) {
                    System.out.println("Sorry! Invalid Move. Try again");
                    move = input.nextInt();
                    result = checkBoardPositionIsValid(move, table);
                    resultCheck = checkCanPlay(move);
                }

                System.out.println("Player moved at position " + move);
                checkIfWin(move, 1, table);
            }
            else
            {
                System.out.println("Input is not an integer value");
                play(table);
            }
    }

    private static void checkIfWin(int position, int player, char[][] gameBoard) { // Updates Board
        char character;

        if (player == 1) {
            character = 'X';
        } else {
            character = 'O';
        }
        switch (position) {

            case 1:
                gameBoard[0][0] = character;
                printBoard(gameBoard);
                break;
            case 2:
                gameBoard[0][2] = character;
                printBoard(gameBoard);
                break;
            case 3:
                gameBoard[0][4] = character;
                printBoard(gameBoard);
                break;
            case 4:
                gameBoard[1][0] = character;
                printBoard(gameBoard);
                break;
            case 5:
                gameBoard[1][2] = character;
                printBoard(gameBoard);
                break;
            case 6:
                gameBoard[1][4] = character;
                printBoard(gameBoard);
                break;
            case 7:
                gameBoard[2][0] = character;
                printBoard(gameBoard);
                break;
            case 8:
                gameBoard[2][2] = character;
                printBoard(gameBoard);
                break;
            case 9:
                gameBoard[2][4] = character;
                printBoard(gameBoard);
                break;
            default:
                break;

        }

    }

    public static void printBoard(char[][] gameBoard) {

        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static boolean checkBoardPositionIsValid(int move, char[][] gameBoard) {
        switch (move) {
            case 1:
                if (gameBoard[0][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (gameBoard[0][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (gameBoard[0][4] == '_') {
                    return true;
                } else {
                    return false;
                }

            case 4:
                if (gameBoard[1][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (gameBoard[1][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 6:
                if (gameBoard[1][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 7:
                if (gameBoard[2][0] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 8:
                if (gameBoard[2][2] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 9:
                if (gameBoard[2][4] == ' ') {
                    return true;
                } else {
                    return false;
                }

            default:
                return false;
        }
    }

    private boolean checkCanPlay(int val) {
        if (0 < val && val < 10) {
            return true;
        } else {
            return false;
        }
    }

    public static void computerMove(char[][] gameBoard) {

        Random rand = new Random();
        int move = rand.nextInt(9) + 1;

        boolean result = checkBoardPositionIsValid(move, gameBoard);

        while (!result) {
            move = rand.nextInt(9) + 1;
            result = checkBoardPositionIsValid(move, gameBoard);
        }

        System.out.println("Computer moved at position " + move);
        checkIfWin(move, 2, gameBoard);
    }

    public int getTurn() {
        return turn;
    }

    public static boolean isGameOver(char[][] gameBoard) {

        //Horizontal Win
        if (gameBoard[0][0] == 'X' && gameBoard[0][2] == 'X' && gameBoard[0][4] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameBoard[0][0] == 'O' && gameBoard[0][2] == 'O' && gameBoard[0][4] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }
        if (gameBoard[1][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[1][4] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameBoard[1][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[1][4] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }
        if (gameBoard[2][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameBoard[2][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }

        //Vertical Wins

        if (gameBoard[0][0] == 'X' && gameBoard[1][0] == 'X' && gameBoard[2][0] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameBoard[0][0] == 'O' && gameBoard[1][0] == 'O' && gameBoard[2][0] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }

        if (gameBoard[0][2] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][2] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameBoard[0][2] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][2] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }

        if (gameBoard[0][4] == 'X' && gameBoard[1][4] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameBoard[0][4] == 'O' && gameBoard[1][4] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }

        //Diagonal Wins
        if (gameBoard[0][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[2][4] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameBoard[0][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[2][4] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }

        if (gameBoard[2][0] == 'X' && gameBoard[1][2] == 'X' && gameBoard[0][4] == 'X') {
            System.out.println("Player Wins");
            playerScore++;
            return true;
        }
        if (gameBoard[2][0] == 'O' && gameBoard[1][2] == 'O' && gameBoard[0][4] == 'O') {
            System.out.println("Computer Wins");
            computerScore++;
            return true;
        }

        if (gameBoard[0][0] != '_' && gameBoard[0][2] != '_' && gameBoard[0][4] != '_' && gameBoard[1][0] != '_' &&
                gameBoard[1][2] != '_' && gameBoard[1][4] != '_' && gameBoard[2][0] != ' ' && gameBoard[2][2] != ' ' && gameBoard[2][4] != ' ') {
            System.out.println("Its a tie");
            return true;
        }
        return  false;
    }

    public static void resetBoard(char [][] gameBoard){
        gameBoard[0][0] = '_';
        gameBoard[0][2] = '_';
        gameBoard[0][4] = '_';
        gameBoard[1][0] = '_';
        gameBoard[1][2] = '_';
        gameBoard[1][4] = '_';
        gameBoard[2][0] = ' ';
        gameBoard[2][2] = ' ';
        gameBoard[2][4] = ' ';

    }
}