package vl_2020_11_05;

import vl_2020_11_05.TicTacToe.Field;
import vl_2020_11_05.TicTacToe.Player;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicTacToeTest {
    private static Field[][] state1 = new Field[][]{
            {
                    Field.NONE, Field.NONE, Field.NONE
            },
            {
                    Field.NONE, Field.NONE, Field.NONE
            },
            {
                    Field.NONE, Field.NONE, Field.NONE
            }
    };

    private static Field[][] state2 = new Field[][]{
            {
                    Field.X, Field.X, Field.X
            },
            {
                    Field.NONE, Field.NONE, Field.NONE
            },
            {
                    Field.NONE, Field.NONE, Field.NONE
            }
    };

    private static Field[][] state3 = new Field[][]{
            {
                    Field.X, Field.NONE, Field.NONE
            },
            {
                    Field.X, Field.NONE, Field.NONE
            },
            {
                    Field.X, Field.NONE, Field.NONE
            }
    };

    private static Field[][] state4 = new Field[][]{
            {
                    Field.O, Field.NONE, Field.NONE
            },
            {
                    Field.NONE, Field.O, Field.NONE
            },
            {
                    Field.NONE, Field.NONE, Field.O
            }
    };

    @ParameterizedTest
    @MethodSource("hasWon")
    void hasWon(Field[][] state, Player winner, boolean hasWinner) {
        TicTacToe ttt = new TicTacToe(3);
        ttt.setState(state);
        if (hasWinner) {
            assertEquals(true, ttt.hasWon(winner));
        } else {
            assertEquals(false, ttt.hasWon(Player.O));
            assertEquals(false, ttt.hasWon(Player.X));
        }
    }

    static Stream<Arguments> hasWon() {
        return Stream.of(
                Arguments.of(state1, null, false),
                Arguments.of(state2, Player.X, true),
                Arguments.of(state3, Player.X, true),
                Arguments.of(state4, Player.O, true)
        );
    }
}