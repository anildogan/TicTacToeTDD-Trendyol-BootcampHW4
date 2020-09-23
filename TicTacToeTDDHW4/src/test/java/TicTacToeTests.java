import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeTests {

    @Test
    public void it_should_get_the_initial_boards_of_3x3(){
        //Given
        TicTacToe sut = new TicTacToe();

        //When
//        String[][] table = sut.getTable();

        //Then
        String[][] expectedTable = new String[3][3];
        Arrays.stream(expectedTable).forEach(a -> Arrays.fill(a, null));


//        assertTrue(Arrays.deepEquals(table, expectedTable));
    }

    @Test
    public void it_should_play_x_on_startup(){
        //Given
        TicTacToe sut = new TicTacToe();

        //When
//        boolean canPlayX = sut.canPlayX();//initial value 0 so, even
//        boolean canPlayO = sut.canPlayO();


        //Then
//        assertEquals(canPlayX, true);
//        assertEquals(canPlayO, false);
    }
    @Test
    public void it_should_play_o_when_odd_number_of_turn(){
        //Given
        TicTacToe sut = new TicTacToe();

        //When
//        sut.play(1,1);
//        boolean canPlayX = sut.canPlayX();//turn is now 1, so odd; false
//        boolean canPlayO = sut.canPlayO();


        //Then
//        assertEquals(canPlayX, false);
//        assertEquals(canPlayO, true);
    }
    @Test
    public void it_should_throw_exception_when_its_not_turn(){
        //Given
        TicTacToe sut = new TicTacToe();

        //When
//        sut.play(1,1,"X");
//        boolean canPlayX = sut.canPlayX();//turn is now 1, so odd; false
//        boolean canPlayO = sut.canPlayO();


        //Then
//        Assertions.assertThrows(CannotPlayException.class, () -> {
//            sut.play(2 , 2 ,"X");
//        });
    }
    @Test
    public void it_should_update_table_when_move_valid_move_made() {
        //Given
        TicTacToe sut = new TicTacToe();

        //When
//        sut.play(1,1,"X");
//        sut.play(2,2,"O");
//        sut.play(1,2,"X");


        //Then
        String[][] expectedTable = new String[3][3];
        Arrays.stream(expectedTable).forEach(a -> Arrays.fill(a, null));

        expectedTable[1][1] = "X";
        expectedTable[2][2] = "O";
        expectedTable[1][2] = "X";

//        assertTrue(Arrays.deepEquals(sut.getTable(), expectedTable));
    }

    @Test
    public void it_should_throw_exception_when_coordination_limit_exceeded(){
        //Given
        TicTacToe sut = new TicTacToe();

        //When

        //Then
//        Assertions.assertThrows(CannotPlayException.class, () -> {
//            sut.play(4 , 1 ,"X");
//        });
//        Assertions.assertThrows(CannotPlayException.class, () -> {
//            sut.play(1 , 4 ,"X");
//        });
    }

    @Test
    public void it_should_increase_turn_counter_when_play_made(){
        //Given
        TicTacToe sut = new TicTacToe();

        //When
//        sut.play(0,1,"X");
//        sut.play(0,2,"O");
//        sut.play(1,2,"X");

        //Then
        assertEquals(sut.getTurn() , 3);
    }

    @Test
    public void it_should_throw_exception_when_already_played_position_playing() {
        //Given
        TicTacToe sut = new TicTacToe();

        //When
//        sut.play(0,1,"X");
//
//        //Then
//
//        Assertions.assertThrows(CannotPlayException.class, () -> {
//            sut.play(0,1,"O");
//        });
    }

    @Test
    public void it_should_check_if_a_position_win(){
        //Given
        TicTacToe sut = new TicTacToe();

        //When
//        sut.play(0,1,"X");
//        sut.play(0,2,"O");
//        sut.play(1,2,"X");

        //Then
        assertEquals(sut.getTurn() , 3);
    }


}
