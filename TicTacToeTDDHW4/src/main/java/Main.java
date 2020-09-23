
import java.util.Scanner;

public class Main {

    public static void main(String [] args){

        Scanner input = new Scanner(System.in);
        TicTacToe ticTacToe = new TicTacToe();
        System.out.println("Game is starting...");

        while(true) {
            char turn = ticTacToe.getTurn()%2==0 ? 'X': 'O';
            System.out.println("Play for " + turn + ": ");
            String coords = input.nextLine();
            if(coords.matches("\\d{1}[,]{1}\\d{1}")) {
                try {
                    int coordX = Integer.parseInt(coords.split(",")[0]);
                    int coordY = Integer.parseInt(coords.split(",")[1]);

                    ticTacToe.play(coordX,coordY,turn);
                    ticTacToe.printBoard();
                }
                catch (CannotPlayException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            else {
                System.out.println("Coordination wrong");
            }
        }
    }}


