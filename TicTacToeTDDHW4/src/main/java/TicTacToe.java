import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class TicTacToe {
    public void setGameBoard(char[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    private char[][] gameBoard = new char[3][3];
    private int turn=0;
    private int xScore = 0;
    private int oScore = 0;

    public TicTacToe() {
        Arrays.stream(this.gameBoard).forEach(a -> Arrays.fill(a, '_'));
    }

    public char[][] getTable() {
        return this.gameBoard;
    }

    public boolean canPlayX() {
        if(turn % 2 == 0) return true ;
        else return false ;
    }

    public boolean canPlayO() {
        if(turn % 2 != 0) return true ;
        else return false ;
    }

    public void play(int coordX, int coordY, char player) {
        if(!(checkCanPlay(player) && checkBoardPositionIsValid(coordX, coordY))){
            throw new CannotPlayException("Board position invalid");
        }
        this.gameBoard[coordX][coordY] = player ;
        this.turn++;

        checkGameResult();
    }

    public boolean isGameTie(){
        return !(Arrays.stream(this.gameBoard).anyMatch(e -> e[0] == '_' || e[1] == '_'));
    }

    private void checkGameResult() {
        switch (isGameOver()) {
            case 'X':
                System.out.println("X wins!");
                resetGame();
                this.xScore++;
                break;
            case 'O':
                System.out.println("O wins!");
                resetGame();
                this.oScore++;
                break;
            case '_':
                if(isGameTie()){
                    System.out.println("Game is tie!");
                    resetGame();
                }
                break;
        }
    }

    private void resetGame() {
        this.turn = 0 ;
        Arrays.stream(this.gameBoard).forEach(a -> Arrays.fill(a, '_'));
    }

    private boolean checkBoardPositionIsValid(int coordX, int coordY) {
        if(!(coordX > 2 || coordY > 2) && !(coordX < 0 || coordY < 0) && (this.gameBoard[coordX][coordY] == '_')) return true ;
        else return false ;
    }

    private boolean checkCanPlay(char val) {
        if(val=='X'){
            return canPlayX();
        }
        else if(val=='O'){
            return canPlayO();
        }
        else {
            return false ;
        }
    }

    public int getTurn() {
        return this.turn;
    }

    public char isGameOver() {
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
                case 0:
                    line = Character.toString(gameBoard[0][0]) + gameBoard[0][1] + gameBoard[0][2];
                    break;
                case 1:
                    line = Character.toString(gameBoard[1][0]) + gameBoard[1][1] + gameBoard[1][2];
                    break;
                case 2:
                    line = Character.toString(gameBoard[2][0]) + gameBoard[2][1] + gameBoard[2][2];
                    break;
                case 3:
                    line = Character.toString(gameBoard[0][0]) + gameBoard[1][0] + gameBoard[2][0];
                    break;
                case 4:
                    line = Character.toString(gameBoard[0][1]) + gameBoard[1][1] + gameBoard[2][1];
                    break;
                case 5:
                    line = Character.toString(gameBoard[0][2]) + gameBoard[1][2] + gameBoard[2][2];
                    break;
                case 6:
                    line = Character.toString(gameBoard[0][0]) + gameBoard[1][1] + gameBoard[2][2];
                    break;
                case 7:
                    line = Character.toString(gameBoard[0][2]) + gameBoard[1][1] + gameBoard[2][0];
                    break;
            }
            if (line.equals("XXX")) {
                return 'X';
            } else if (line.equals("OOO")) {
                return 'O';
            }
            }
        return '_' ;
    }
    public void printBoard() {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }


}