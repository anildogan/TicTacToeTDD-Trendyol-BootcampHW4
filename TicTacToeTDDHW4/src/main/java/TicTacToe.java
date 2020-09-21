import java.util.Arrays;


public class TicTacToe {
    private String[][] table = new String[3][3];
    private int turn;

    public TicTacToe() {
        Arrays.stream(this.table).forEach(a -> Arrays.fill(a, null));
        this.turn = 0 ;
    }

    public String[][] getTable() {
        return this.table;
    }

    public boolean canPlayX() {
        if(turn % 2 == 0) return true ;
        else return false ;
    }

    public boolean canPlayO() {
        if(turn % 2 != 0) return true ;
        else return false ;
    }

    public void play(int coordX , int coordY, String val) {

        if(!(checkCanPlay(val) && checkBoardPositionIsValid(coordX, coordY))){
            throw new CannotPlayException("Board position invalid");
        }

        this.table[coordX][coordY] = val ;
        this.turn++;

        checkIfWin();
    }

    private void checkIfWin() {
        //TODO
    }

    private boolean checkBoardPositionIsValid(int coordX, int coordY) {
        if(!(coordX > 2 || coordY > 2) && (this.table[coordX][coordY] == null)) return true ;
        else return false ;

    }

    private boolean checkCanPlay(String val) {
        if(val.equals("X")){
            return canPlayX();
        }
        else if(val.equals("O")){
            return canPlayO();
        }
        else {
            return false ;
        }
    }

    public int getTurn() {
        return turn;
    }
}
