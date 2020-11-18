package vl_2020_11_05;

import java.util.Arrays;

public class TicTacToe {
    // States a field can be in
    public enum Field {
        NONE,
        X,
        O
    }

    // Players available
    public enum Player {
        X,
        O
    }

    public TicTacToe(int size) {
        this.activePlayer = Player.X;
        this.gameOver = false;
        this.state = new Field[size][size];
        for (Field[] f : this.state)
            Arrays.fill(f, Field.NONE);
    }

    // Private game state variables
    private Field state[][];
    private Player activePlayer;
    private Player winner;
    private boolean gameOver;

    public void setState(Field[][] state) {
        this.state = state;
    }

    public Field[][] getState() {
        return state;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    // switch to the other player
    public void changePlayer() {
        activePlayer = (activePlayer == Player.X) ? Player.O : Player.X;
    }

    // check if the game is a draw
    public boolean isDraw() {
        boolean allFieldsSet = true;

        for (int y = 0; y < state.length; y++) {
            for (int x = 0; x < state[y].length; x++) {
                if (state[y][x] == Field.NONE) allFieldsSet = false;
            }
        }

        if (!hasWon(Player.X) && !hasWon(Player.O) && allFieldsSet)
            return true;

        return false;
    }

    public boolean hasWon(Player p) {
        Field pf = (p == Player.O) ? Field.O : Field.X;

        // check for row and column wins
        for (int y = 0; y < state.length; y++) {
            boolean xWin = true;
            boolean yWin = true;

            for (int x = 0; x < state[y].length; x++) {
                if (state[y][x] != pf) xWin = false;
                if (state[x][y] != pf) yWin = false;
            }

            if (xWin || yWin) return true;
        }

        // check for diagonal wins
        boolean topWin = true;
        boolean bottomWin = true;

        for (int i = 0; i < state.length; i++) {
            int indexBottomY = state.length - i - 1;
            int indexBottomX = state[i].length - i - 1;
            if (state[indexBottomY][indexBottomX] != pf) {
                topWin = false;
            }
            if (state[i][i] != pf) {
                bottomWin = false;
            }
        }

        return (bottomWin || topWin);
    }

    public boolean setSymbol(int x, int y, Field f) {
        // Check out-of-bounds and empty field
        if (state.length <= y
                || state[y].length <= x
                || state[y][x] != Field.NONE)
            return false;

        // Set field
        state[y][x] = f;
        return true;
    }
}
