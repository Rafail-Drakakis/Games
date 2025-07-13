package model.Board;

import model.Color.Color;
import model.Square.*;

import java.io.Serializable;

import static GameDimensions.GameDim.SquaresDim;

/**
 * Represents the game board. The board is composed of rows and columns of squares,
 * and each square has a specific type and behavior.
 */
public class Board implements Serializable {
    private final int rows;
    private final int columns;
    private final Square[][] squares;

    /**
     * Constructs a new game board with the specified number of rows and columns.
     *
     * @param rows    The number of rows in the board.
     * @param columns The number of columns in the board.
     */
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.squares = new Square[rows][columns];
        initializeBoard();
    }

    /**
     * Initializes the game board by creating and assigning squares based on the provided configuration.
     * The configuration is obtained from the `SquaresDim` list.
     */
    private void initializeBoard() {
        // Initialize the board squares
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                SquareType squareType = SquaresDim.get(row).get(col);
                if(SquaresDim.get(row).get(col) != null) {
                    switch (squareType) {
                        case RED_SLIDE_START:
                            squares[row][col] = new StartSlideSquare(Color.RED);
                            break;
                        case RED_SLIDE_MEDIUM:
                            squares[row][col] = new InternalSlideSquare(Color.RED);
                            break;
                        case RED_SLIDE_END:
                            squares[row][col] = new EndSlideSquare(Color.RED);
                            break;
                        case RED_HOME:
                            squares[row][col] = new HomeSquare(Color.RED);
                            break;
                        case RED_SAFETY_ZONE:
                            squares[row][col] = new SafetyZoneSquare(Color.RED);
                            break;
                        case GREEN_SLIDE_START:
                            squares[row][col] = new StartSlideSquare(Color.GREEN);
                            break;
                        case GREEN_SLIDE_MEDIUM:
                            squares[row][col] = new InternalSlideSquare(Color.GREEN);
                            break;
                        case GREEN_SLIDE_END:
                            squares[row][col] = new EndSlideSquare(Color.GREEN);
                            break;
                        case GREEN_HOME:
                            squares[row][col] = new HomeSquare(Color.GREEN);
                            break;
                        case GREEN_SAFETY_ZONE:
                            squares[row][col] = new SafetyZoneSquare(Color.GREEN);
                            break;
                        case YELLOW_SLIDE_START:
                            squares[row][col] = new StartSlideSquare(Color.YELLOW);
                            break;
                        case YELLOW_SLIDE_MEDIUM:
                            squares[row][col] = new InternalSlideSquare(Color.YELLOW);
                            break;
                        case YELLOW_SLIDE_END:
                            squares[row][col] = new EndSlideSquare(Color.YELLOW);
                            break;
                        case YELLOW_HOME:
                            squares[row][col] = new HomeSquare(Color.YELLOW);
                            break;
                        case YELLOW_SAFETY_ZONE:
                            squares[row][col] = new SafetyZoneSquare(Color.YELLOW);
                            break;
                        case BLUE_SLIDE_START:
                            squares[row][col] = new StartSlideSquare(Color.BLUE);
                            break;
                        case BLUE_SLIDE_MEDIUM:
                            squares[row][col] = new InternalSlideSquare(Color.BLUE);
                            break;
                        case BLUE_SLIDE_END:
                            squares[row][col] = new EndSlideSquare(Color.BLUE);
                            break;
                        case BLUE_HOME:
                            squares[row][col] = new HomeSquare(Color.BLUE);
                            break;
                        case BLUE_SAFETY_ZONE:
                            squares[row][col] = new SafetyZoneSquare(Color.BLUE);
                            break;
                        case SIMPLE_SQUARE:
                            squares[row][col] = new SimpleSquare();
                            break;
                    }
                }
            }
        }

    }

    /**
     * Gets the square at the specified row and column on the board.
     *
     * @param row The row index of the square.
     * @param col The column index of the square.
     * @return The square at the specified position or null if the position is invalid.
     */
    public Square getSquare(int row, int col) {
        if (isValidPosition(row, col)) {
            return squares[row][col];
        }
        return null;
    }

    /**
     * Checks if the given row and column indices represent a valid position on the board.
     *
     * @param row The row index to check.
     * @param col The column index to check.
     * @return True if the position is valid, false otherwise.
     */
    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < columns && squares[row][col] != null;
    }
}