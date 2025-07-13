package GameDimensions;

import model.Square.SquareType;

import java.awt.*;
import java.util.*;
import java.util.List;

import static model.Square.SquareType.*;

public class GameDim {

    public static final String[] COLORS = {"red", "yellow", "green", "blue"};
    public static final int ROW = 16;
    public static final int COL = 16;
    public static Rectangle pawn1StartRed1 = new Rectangle(200, 50, 50, 50);
    public static Rectangle pawn1StartRed2 = new Rectangle(250, 50, 50, 50);
    public static Rectangle pawn2StartYellow1 = new Rectangle(550, 700, 50, 50);
    public static Rectangle pawn2StartYellow2 = new Rectangle(500, 700, 50, 50);
    public static Rectangle pawn3StartGreen1 = new Rectangle(50, 550, 50, 50);
    public static Rectangle pawn3StartGreen2 = new Rectangle(50, 500, 50, 50);
    public static Rectangle pawn4StartBlue1 = new Rectangle(700, 200, 50, 50);
    public static Rectangle pawn4StartBlue2 = new Rectangle(700, 250, 50, 50);

    public static Rectangle[][] pawnsStartDim = {
            {pawn1StartRed1, pawn1StartRed2},
            {pawn2StartYellow1, pawn2StartYellow2},
            {pawn3StartGreen1, pawn3StartGreen2},
            {pawn4StartBlue1, pawn4StartBlue2}
    };
    public static Rectangle sorryImageDim = new Rectangle(275, 300, 250, 100);

    /**
     * List of square configurations representing the layout of a game board. Each element in the list is a map that
     * associates a square's position (key) with its type (value) on the game board.
     * The list defines the layout of squares for a specific game.
     *
     * The outer list represents rows, and each inner map represents a row of squares.
     * The key represents the position of the square (0 to 15), and the value represents the type of square (e.g., SIMPLE_SQUARE).
     *
     * The structure of the list should be consistent with the desired game board layout.
     */
    public static List<Map<Integer, SquareType>> SquaresDim = Arrays.asList(
            new HashMap<Integer, SquareType>() {{
                put(0, SIMPLE_SQUARE);
                put(1, RED_SLIDE_START);
                put(2, RED_SLIDE_MEDIUM);
                put(3, RED_SLIDE_MEDIUM);
                put(4, RED_SLIDE_END);
                put(5, SIMPLE_SQUARE);
                put(6, SIMPLE_SQUARE);
                put(7, SIMPLE_SQUARE);
                put(8, SIMPLE_SQUARE);
                put(9, RED_SLIDE_START);
                put(10, RED_SLIDE_MEDIUM);
                put(11, RED_SLIDE_MEDIUM);
                put(12, RED_SLIDE_MEDIUM);
                put(13, RED_SLIDE_END);
                put(14, SIMPLE_SQUARE);
                put(15, SIMPLE_SQUARE);
            }},

            new HashMap<Integer, SquareType>() {{
                put(0, SIMPLE_SQUARE);
                put(15, BLUE_SLIDE_START);
                put(2, RED_SAFETY_ZONE);
            }},
            new HashMap<Integer, SquareType>() {{
                put(0, GREEN_SLIDE_END);
                put(15, BLUE_SLIDE_MEDIUM);
                put(2, RED_SAFETY_ZONE);

                put(9, BLUE_HOME);
                put(10, BLUE_SAFETY_ZONE);
                put(11, BLUE_SAFETY_ZONE);
                put(12, BLUE_SAFETY_ZONE);
                put(13, BLUE_SAFETY_ZONE);
                put(14, BLUE_SAFETY_ZONE);
            }},
            new HashMap<Integer, SquareType>() {{
                put(0, GREEN_SLIDE_MEDIUM);
                put(15, BLUE_SLIDE_MEDIUM);
                put(2, RED_SAFETY_ZONE);
            }},
            new HashMap<Integer, SquareType>() {{
                put(0, GREEN_SLIDE_MEDIUM);
                put(15, BLUE_SLIDE_END);
                put(2, RED_SAFETY_ZONE);
            }},
            new HashMap<Integer, SquareType>() {{
                put(0, GREEN_SLIDE_MEDIUM);
                put(15, SIMPLE_SQUARE);
                put(2, RED_SAFETY_ZONE);
            }},
            new HashMap<Integer, SquareType>() {{
                put(0, GREEN_SLIDE_START);
                put(15, SIMPLE_SQUARE);
                put(2, RED_HOME);
            }},
            new HashMap<Integer, SquareType>() {{
                put(0, SIMPLE_SQUARE);
                put(15, SIMPLE_SQUARE);
            }},
            new HashMap<Integer, SquareType>() {{
                put(0, SIMPLE_SQUARE);
                put(15, SIMPLE_SQUARE);
            }},
            new HashMap<Integer, SquareType>() {{
                put(0, SIMPLE_SQUARE);
                put(15, BLUE_SLIDE_START);
                put(13, YELLOW_HOME);
            }},
            new HashMap<Integer, SquareType>() {{
                put(0, SIMPLE_SQUARE);
                put(15, BLUE_SLIDE_MEDIUM);
                put(13, YELLOW_SAFETY_ZONE);
            }},
            new HashMap<Integer, SquareType>() {{
                put(0, GREEN_SLIDE_END);
                put(15, BLUE_SLIDE_MEDIUM);
                put(13, YELLOW_SAFETY_ZONE);
            }},
            new HashMap<Integer, SquareType>() {{
                put(0, GREEN_SLIDE_MEDIUM);
                put(15, BLUE_SLIDE_MEDIUM);
                put(13, YELLOW_SAFETY_ZONE);
            }},
            new HashMap<Integer, SquareType>() {{
                put(0, GREEN_SLIDE_MEDIUM);
                put(15, BLUE_SLIDE_END);
                put(13, YELLOW_SAFETY_ZONE);

                put(1, GREEN_SAFETY_ZONE);
                put(2, GREEN_SAFETY_ZONE);
                put(3, GREEN_SAFETY_ZONE);
                put(4, GREEN_SAFETY_ZONE);
                put(5, GREEN_SAFETY_ZONE);
                put(6, GREEN_HOME);
            }},
            new HashMap<Integer, SquareType>() {{
                put(0, GREEN_SLIDE_START);
                put(15, SIMPLE_SQUARE);
                put(13, YELLOW_SAFETY_ZONE);
            }},
            new HashMap<Integer, SquareType>() {{
                put(0, SIMPLE_SQUARE);
                put(1, SIMPLE_SQUARE);
                put(2, YELLOW_SLIDE_END);
                put(3, YELLOW_SLIDE_MEDIUM);
                put(4, YELLOW_SLIDE_MEDIUM);
                put(5, YELLOW_SLIDE_MEDIUM);
                put(6, YELLOW_SLIDE_START);
                put(7, SIMPLE_SQUARE);
                put(8, SIMPLE_SQUARE);
                put(9, SIMPLE_SQUARE);
                put(10, SIMPLE_SQUARE);
                put(11, YELLOW_SLIDE_END);
                put(12, YELLOW_SLIDE_MEDIUM);
                put(13, YELLOW_SLIDE_MEDIUM);
                put(14, YELLOW_SLIDE_START);
                put(15, SIMPLE_SQUARE);
            }}
    );
}
