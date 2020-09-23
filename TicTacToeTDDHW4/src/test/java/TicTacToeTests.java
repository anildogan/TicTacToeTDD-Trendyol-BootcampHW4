import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeTests {

    @Test
    public void it_should_get_the_initial_boards_of_3x3(){
        //Given
        TicTacToe sut = new TicTacToe();

        //When
        char[][] table = sut.getTable();

        //Then
        char[][] expectedTable = new char[3][3];
        Arrays.stream(expectedTable).forEach(a -> Arrays.fill(a, '_'));


        assertTrue(Arrays.deepEquals(table, expectedTable));
    }

    @Test
    public void it_should_play_x_on_startup(){
        //Given
        TicTacToe sut = new TicTacToe();

        //When
        boolean canPlayX = sut.canPlayX();//initial value 0 so, even
        boolean canPlayO = sut.canPlayO();


        //Then
        assertEquals(canPlayX, true);
        assertEquals(canPlayO, false);
    }
    @Test
    public void it_should_play_o_when_odd_number_of_turn(){
        //Given
        TicTacToe sut = new TicTacToe();

        //When
        sut.play(1,1,'X');
        boolean canPlayX = sut.canPlayX();//turn is now 1, so odd; false
        boolean canPlayO = sut.canPlayO();


        //Then
        assertEquals(canPlayX, false);
        assertEquals(canPlayO, true);
    }
    @Test
    public void it_should_change_coordinate_when_play_is_made() {
        //Given
        TicTacToe sut = new TicTacToe();

        //When
        char[][] table = sut.getTable();
        sut.play(2,2,'X');

        //Then
        char[][] expectedTable = new char[3][3];
        Arrays.stream(expectedTable).forEach(a -> Arrays.fill(a, '_'));
        expectedTable[2][2] = 'X';


        assertTrue(Arrays.deepEquals(table, expectedTable));
    }


    @Test
    public void it_should_throw_exception_when_its_not_turn(){
        //Given
        TicTacToe sut = new TicTacToe();

        //When
        sut.play(1,1,'X');
        boolean canPlayX = sut.canPlayX();//turn is now 1, so odd; false
        boolean canPlayO = sut.canPlayO();


        //Then
        Assertions.assertThrows(CannotPlayException.class, () -> {
            sut.play(2 , 2 ,'X');
        });
    }
    @Test
    public void it_should_update_table_when_move_valid_move_made() {
        //Given
        TicTacToe sut = new TicTacToe();

        //When
        sut.play(1,1,'X');
        sut.play(2,2,'O');
        sut.play(1,2,'X');


        //Then
        char[][] expectedTable = new char[3][3];
        Arrays.stream(expectedTable).forEach(a -> Arrays.fill(a, '_'));

        expectedTable[1][1] = 'X';
        expectedTable[2][2] = 'O';
        expectedTable[1][2] = 'X';

        assertTrue(Arrays.deepEquals(sut.getTable(), expectedTable));
    }

    @Test
    public void it_should_throw_exception_when_coordination_limit_exceeded(){
        //Given
        TicTacToe sut = new TicTacToe();

        //When

        //Then
        Assertions.assertThrows(CannotPlayException.class, () -> {
            sut.play(4 , 1 ,'X');
        });
        Assertions.assertThrows(CannotPlayException.class, () -> {
            sut.play(1 , 4 ,'O');
        });
    }

    @Test
    public void it_should_increase_turn_counter_when_play_made(){
        //Given
        TicTacToe sut = new TicTacToe();

        //When
        sut.play(0,1,'X');
        sut.play(0,2,'O');
        sut.play(1,2,'X');

        //Then
        assertEquals(sut.getTurn() , 3);
    }

    @Test
    public void it_should_throw_exception_when_already_played_position_playing() {
        //Given
        TicTacToe sut = new TicTacToe();

        //When
        sut.play(0,1,'X');

        //Then

        Assertions.assertThrows(CannotPlayException.class, () -> {
            sut.play(0,1,'O');
        });
    }



    @Test
    public void it_should_check_if_a_position_win(){
        //Given
        TicTacToe sut = new TicTacToe();

        char[][] expectedTable = new char[3][3];
        Arrays.stream(expectedTable).forEach(a -> Arrays.fill(a, '_'));

        expectedTable[0][0] = 'X';
        expectedTable[0][1] = 'X';
        expectedTable[0][2] = 'X';

        sut.setGameBoard(expectedTable);

        //When

        //Then
        assertEquals('X' , sut.isGameOver());
    }
    @Test
    public void it_should_check_if_game_tie(){
        //Given
        TicTacToe sut = new TicTacToe();

        char[][] expectedTable = new char[3][3];
        Arrays.stream(expectedTable).forEach(a -> Arrays.fill(a, '_'));

        expectedTable[0][0] = 'X';
        expectedTable[0][1] = 'O';
        expectedTable[0][2] = 'X';
        expectedTable[1][0] = 'O';
        expectedTable[1][1] = 'X';
        expectedTable[1][2] = 'O';
        expectedTable[2][0] = 'X';
        expectedTable[2][1] = 'O';
        expectedTable[2][2] = 'X';

        sut.setGameBoard(expectedTable);

        //When

        //Then
        assertEquals(true , sut.isGameTie());
    }


}



