package model.Pawn;

import model.Board.Board;
import model.Color.Color;
import model.Square.SquareType;

import java.io.Serializable;

import static GameDimensions.GameDim.*;

/**
 * Represents a Pawn in the "Sorry" game.
 */
public class Pawn implements Serializable {
    private final Color color;
    private int x, y;
    int pawnID;
    boolean isStart = true;
    boolean isHome = false;
    boolean isSafetyZone = false;

    /**
     * Initializes a new Pawn with the specified color and sets its initial position to (x, y).
     *
     * @param color The color of the Pawn.
     * Precondition: color is a valid color for a pawn (e.g., "Red", "Blue", "Yellow", "Green").
     */
    public Pawn(Color color, int pawnID, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.pawnID = pawnID;
    }

    /**
     * Gets the color of the Pawn.
     *
     * @return The color of the Pawn.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Gets the current position of the Pawn on the board as a pair (x, y).
     *
     * @return The current position of the Pawn.
     */
    public int[] getPosition() {
        return new int[]{x, y};
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Moves the Pawn to a specific position on the board.
     *
     * @param newX The new x-coordinate to move the Pawn to.
     * @param newY The new y-coordinate to move the Pawn to.
     * Precondition: newX and newY are valid coordinates on the board.
     */
    public boolean moveToPosition(int newX, int newY, Board board) {
        if (isValidPosition(board, newX, newY)) {
            board.getSquare(y, x).setHasPawn(null);
            x = newX;
            y = newY;
            if(color == Color.RED) {
                if (SquaresDim.get(y).get(x) == SquareType.GREEN_SLIDE_START) {
                    if(y - 3 >= 0 && SquaresDim.get(y - 3).get(x) == SquareType.GREEN_SLIDE_END) {
                        y -= 3;
                        checkOtherPawnCollision(board, x, newY);
                    } else if(y - 4 >= 0 && SquaresDim.get(y - 4).get(x) == SquareType.GREEN_SLIDE_END) {
                        y -= 4;
                        checkOtherPawnCollision(board, x, newY);
                    }
                } else if (SquaresDim.get(y).get(x) == SquareType.YELLOW_SLIDE_START) {
                    if(x - 3 >= 0 && SquaresDim.get(y).get(x - 3) == SquareType.YELLOW_SLIDE_END) {
                        x -= 3;
                        checkOtherPawnCollision(board, newX, y);
                    } else if(x - 4 >= 0 && SquaresDim.get(y).get(x - 4) == SquareType.YELLOW_SLIDE_END) {
                        x -= 4;
                        checkOtherPawnCollision(board, newX, y);
                    }
                } else if (SquaresDim.get(y).get(x) == SquareType.BLUE_SLIDE_START) {
                    if(y + 3 <= 15 && SquaresDim.get(y + 3).get(x) == SquareType.BLUE_SLIDE_END) {
                        y += 3;
                        checkOtherPawnCollision(board, x, newY);
                    } else if(y + 4 <= 15 && SquaresDim.get(y + 4).get(x) == SquareType.BLUE_SLIDE_END) {
                        y += 4;
                        checkOtherPawnCollision(board, x, newY);
                    }
                }
            } else if(color == Color.GREEN) {
                if (SquaresDim.get(y).get(x) == SquareType.RED_SLIDE_START) {
                    if(x + 3 <= 15 && SquaresDim.get(y).get(x + 3) == SquareType.RED_SLIDE_END) {
                        x += 3;
                        checkOtherPawnCollision(board, newX, y);
                    } else if(x + 4 <= 15 && SquaresDim.get(y + 4).get(x + 4) == SquareType.RED_SLIDE_END) {
                        x += 4;
                        checkOtherPawnCollision(board, newX, y);
                    }
                } else if (SquaresDim.get(y).get(x) == SquareType.YELLOW_SLIDE_START) {
                    if(x - 3 >= 0 && SquaresDim.get(y).get(x - 3) == SquareType.YELLOW_SLIDE_END) {
                        x -= 3;
                        checkOtherPawnCollision(board, newX, y);
                    } else if(x - 4 >= 0 && SquaresDim.get(y).get(x - 4) == SquareType.YELLOW_SLIDE_END) {
                        x -= 4;
                        checkOtherPawnCollision(board, newX, y);
                    }
                } else if (SquaresDim.get(y).get(x) == SquareType.BLUE_SLIDE_START) {
                    if(y + 3 <= 15 && SquaresDim.get(y + 3).get(x) == SquareType.BLUE_SLIDE_END) {
                        y += 3;
                        checkOtherPawnCollision(board, x, newY);
                    } else if(y + 4 <= 15 && SquaresDim.get(y + 4).get(x) == SquareType.BLUE_SLIDE_END) {
                        y += 4;
                        checkOtherPawnCollision(board, x, newY);
                    }
                }
            } else if(color == Color.YELLOW) {
                if (SquaresDim.get(y).get(x) == SquareType.RED_SLIDE_START) {
                    if(SquaresDim.get(y).get(x + 3) == SquareType.RED_SLIDE_END) {
                        x += 3;
                        checkOtherPawnCollision(board, newX, y);
                    } else if(SquaresDim.get(y + 4).get(x + 4) == SquareType.RED_SLIDE_END) {
                        x += 4;
                        checkOtherPawnCollision(board, newX, y);
                    }
                } else if (SquaresDim.get(y).get(x) == SquareType.GREEN_SLIDE_START) {
                    if(y - 3 >= 0 && SquaresDim.get(y - 3).get(x) == SquareType.GREEN_SLIDE_END) {
                        y -= 3;
                        checkOtherPawnCollision(board, x, newY);
                    } else if(y - 4 >= 0 && SquaresDim.get(y - 4).get(x) == SquareType.GREEN_SLIDE_END) {
                        y -= 4;
                        checkOtherPawnCollision(board, x, newY);
                    }
                } else if (SquaresDim.get(y).get(x) == SquareType.BLUE_SLIDE_START) {
                    if(y + 3 <= 15 && SquaresDim.get(y + 3).get(x) == SquareType.BLUE_SLIDE_END) {
                        y += 3;
                        checkOtherPawnCollision(board, x, newY);
                    } else if(y + 4 <= 15 && SquaresDim.get(y + 4).get(x) == SquareType.BLUE_SLIDE_END) {
                        y += 4;
                        checkOtherPawnCollision(board, x, newY);
                    }
                }
            } else if(color == Color.BLUE) {
                if (SquaresDim.get(y).get(x) == SquareType.RED_SLIDE_START) {
                    if(SquaresDim.get(y).get(x + 3) == SquareType.RED_SLIDE_END) {
                        x += 3;
                        checkOtherPawnCollision(board, newX, y);
                    } else if(SquaresDim.get(y + 4).get(x + 4) == SquareType.RED_SLIDE_END) {
                        x += 4;
                        checkOtherPawnCollision(board, newX, y);
                    }
                } else if (SquaresDim.get(y).get(x) == SquareType.YELLOW_SLIDE_START) {
                    if(x - 3 >= 0 && SquaresDim.get(y).get(x - 3) == SquareType.YELLOW_SLIDE_END) {
                        x -= 3;
                        checkOtherPawnCollision(board, newX, y);
                    } else if(x - 4 >= 0 && SquaresDim.get(y).get(x - 4) == SquareType.YELLOW_SLIDE_END) {
                        x -= 4;
                        checkOtherPawnCollision(board, newX, y);
                    }
                } else if (SquaresDim.get(y).get(x) == SquareType.GREEN_SLIDE_START) {
                    if(y - 3 >= 0 && SquaresDim.get(y - 3).get(x) == SquareType.GREEN_SLIDE_END) {
                        y -= 3;
                        checkOtherPawnCollision(board, x, newY);
                    } else if(y - 4 >= 0 && SquaresDim.get(y - 4).get(x) == SquareType.GREEN_SLIDE_END) {
                        y -= 4;
                        checkOtherPawnCollision(board, x, newY);
                    }
                }
            }

            if(board.getSquare(y, x).getHasPawn() != null) {
                checkOtherPawnCollision(board, x, y);
            }
            board.getSquare(y, x).setHasPawn(this);
            return true;

        } else {
            System.out.println("Invalid position. " + "(" + newX+ "," + newY + ") by Pawn " + color + ":" + pawnID);
            return false;
        }
    }

    /**
     * Moves the Pawn forward by a specified number of steps.
     *
     * @param steps The number of steps to move the Pawn forward.
     * Precondition: steps is a positive integer.
     */
    public boolean moveForward(int steps, Board board) {
        if(isHome) {
            return false;
        }

        if(isStart) {
            return startLogic(board);
        }

        if(isSafetyZone) {
            return safetyZoneLogic(board, steps);
        }

        int newX = x;
        int newY = y;

        if(x == 0) {
            if(color == Color.GREEN && y >= 13) {
                newY = y - steps;
                if (newY < 13) {
                    newY = 13;
                    isSafetyZone = true;
                    newX += steps - (y - newY);
                }
            } else {
                newY = y - steps;
                if (newY < 0) {
                    newY = 0;
                    newX += steps - (y - newY);
                }
            }
        } else if(x == 15) {
            if(color == Color.BLUE && y <= 2) {
                newY = y + steps;
                if( newY > 2) {
                    newY = 2;
                    isSafetyZone = true;
                    newX -= steps - (newY - y);
                }
            } else {
                newY = y + steps;
                if( newY > 15) {
                    newY = 15;
                    newX -= steps - (newY - y);
                }
            }
        } else if(y == 0) {
            if(color == Color.RED && x <= 2) {
                newX = x + steps;
                if (newX > 2) {
                    newX = 2;
                    isSafetyZone = true;
                    newY += steps - (newX - x);
                }
            } else {
                newX = x + steps;
                if (newX > 15) {
                    newX = 15;
                    newY += steps - (newX - x);
                }
            }
        } else if(y == 15) {
            if(color == Color.YELLOW && x >= 13) {
                newX = x - steps;
                if (newX < 13) {
                    newX = 13;
                    isSafetyZone = true;
                    newY -= steps - (x - newX);
                }
            } else {
                newX = x - steps;
                if (newX < 0) {
                    newX = 0;
                    newY -= steps - (x - newX);
                }
            }
        }

        return moveToPosition(newX, newY, board);
    }
    /**
     * Handles logic for moving a pawn from its start position to the board.
     * This method checks if the pawn is in its start position based on its color and moves it accordingly.
     *
     * @param board The game board on which the pawns are placed.
     * @return true if the pawn successfully moves from the start to the board, false otherwise.
     */
    boolean startLogic(Board board) {
        if (color == Color.RED && x == startPosition(0)[0] && y == startPosition(0)[1]) {
            y = 0;
            x = 4;
            board.getSquare(y, x).setHasPawn(this);
            this.isStart = false;
            return true;
        } else if (color == Color.YELLOW && x == startPosition(1)[0] && y == startPosition(1)[1]) {
            y = 15;
            x = 11;
            board.getSquare(y, x).setHasPawn(this);
            this.isStart = false;
            return true;
        } else if (color == Color.GREEN && x == startPosition(2)[0] && y == startPosition(2)[1]) {
            x = 0;
            y = 11;
            board.getSquare(y, x).setHasPawn(this);
            this.isStart = false;
            return true;
        } else if (color == Color.BLUE && x == startPosition(3)[0] && y == startPosition(3)[1]) {
            x = 15;
            y = 4;
            board.getSquare(y, x).setHasPawn(this);
            this.isStart = false;
            return true;
        }

        return false;
    }
    /**
     * Handles logic for moving a pawn within the safety zone.
     * This method updates the pawn's position based on its color and the number of steps it can move.
     *
     * @param board  The game board on which the pawns are placed.
     * @param steps  The number of steps the pawn can move within the safety zone.
     * @return true if the pawn successfully moves within the safety zone, false otherwise.
     */
    boolean safetyZoneLogic(Board board, int steps) {

        board.getSquare(y, x).setHasPawn(null);

        if (color == Color.RED && isSafetyZone) {
            y += steps;
            if(y > 6) {
                y = 6;
                isHome = true;
            } else {
                return false;
            }

        } else if (color == Color.YELLOW && isSafetyZone) {
            y -= steps;
            if(y < 9) {
                y = 9;
                isHome = true;
            } else {
                return false;
            }
        } else if (color == Color.GREEN && isSafetyZone) {
            x += steps;
            if(x > 6) {
                x = 6;
                isHome = true;
            } else {
                return false;
            }

        } else if (color == Color.BLUE && isSafetyZone) {
            x -= steps;
            if(x < 9) {
                x = 9;
                isHome = true;
            } else {
                return false;
            }
        }

        board.getSquare(y, x).setHasPawn(this);
        return false;
    }

    /**
     * Moves the Pawn backward by a specified number of steps.
     *
     * @param steps The number of steps to move the Pawn backward.
     * precondition steps is a positive integer.
     */
    public boolean moveBackward(int steps, Board board) {
        if(isStart || isSafetyZone || isHome) {
            return false;//if is Home or Safety Zone or Start cannot run anywhere
        }

        int newX = x;
        int newY = y;

        if(x == 0) {
            newY = y + steps;
            if( newY > 15) {
                newY = 15;
                newX = Math.abs(newX - steps - (y - newY));
            }
        } else if(x == 15) {
            newY = y - steps;
            if( newY < 0) {
                newY = 0;
                newX -= steps - (y - newY);
            }
        } else if(y == 0) {
            newX = x - steps;
            if( newX < 0) {
                newX = 0;
                newY = Math.abs(newY - steps - (newX - x));
            }
        } else if(y == 15) {
            newX = x + steps;
            if( newX > 15) {
                newX = 15;
                newY -= steps - (newX - x);
            }
        }

        return moveToPosition(newX, newY, board);
    }

    /**
     * Resets the position of the Pawn to the starting position (0, 0).
     */
    public void resetPosition() {
        x = 0;
        y = 0;
    }

    /**
     * Checks for collisions with other pawns when moving to a new position on the board.
     *
     * @param board  The game board on which the pawns are placed.
     * @param newX   The new X-coordinate for the pawn's position.
     * @param newY   The new Y-coordinate for the pawn's position.
     */
    void checkOtherPawnCollision(Board board, int newX, int newY) {
        if (x == newX && y == newY) {
            Pawn pawn = board.getSquare(y, x).getHasPawn();
            if(pawn.getColor() != color) {
                checkXYCollision(board, x, "y");
            }
        } else if(x == newX) {
            if(newY <= y) {
                for(int i = y; i >= newY; i--) {
                    checkXYCollision(board, i, "x");
                }
            } else {
                for(int i = y; i <= newY; i++) {
                    checkXYCollision(board, i, "x");
                }
            }
        } else if(y == newY) {
            if(newX <= x) {
                for(int i = x; i >= newX; i--) {
                    checkXYCollision(board, i, "y");
                }
            } else {
                for(int i = x; i <= newX; i++) {
                    checkXYCollision(board, i, "y");
                }
            }
        }

    }

    /**
     * Checks for collisions with other pawns along the X or Y axis at a specific coordinate.
     *
     * @param board    The game board on which the pawns are placed.
     * @param i The coordinate (either X or Y) at which to check for collisions.
     * @param constant  A string indicating whether to check along the X or Y axis.
     */
    private void checkXYCollision(Board board, int i, String constant) {
        Pawn pawn;
        if(constant.equals("x")) {
            pawn = board.getSquare(i, x).getHasPawn();
        } else {
            pawn = board.getSquare(y, i).getHasPawn();
        }

        if(pawn != null) {//team player
            if(pawn.getPawnID() == 0) {
                switch (pawn.getColor()) {
                    case RED:
                        pawn.setPosition(pawn1StartRed1.x / 50, pawn1StartRed1.y / 50);
                        pawn.setStart(true);
                        break;
                    case YELLOW:
                        pawn.setPosition(pawn2StartYellow1.x / 50, pawn2StartYellow1.y / 50);
                        pawn.setStart(true);
                        break;
                    case GREEN:
                        pawn.setPosition(pawn3StartGreen1.x / 50, pawn3StartGreen1.y / 50);
                        pawn.setStart(true);
                        break;
                    case BLUE:
                        pawn.setPosition(pawn4StartBlue1.x / 50, pawn4StartBlue1.y / 50);
                        pawn.setStart(true);
                        break;
                }

            } else {
                switch (pawn.getColor()) {
                    case RED:
                        pawn.setPosition(pawn1StartRed2.x / 50, pawn1StartRed2.y / 50);
                        pawn.setStart(true);
                        break;
                    case YELLOW:
                        pawn.setPosition(pawn2StartYellow2.x / 50, pawn2StartYellow2.y / 50);
                        pawn.setStart(true);
                        break;
                    case GREEN:
                        pawn.setPosition(pawn3StartGreen2.x / 50, pawn3StartGreen2.y / 50);
                        pawn.setStart(true);
                        break;
                    case BLUE:
                        pawn.setPosition(pawn4StartBlue2.x / 50, pawn4StartBlue2.y / 50);
                        pawn.setStart(true);
                        break;
                }
            }
        }
    }

    /**
     * Returns a string representation of the Pawn including its color and current position.
     *
     * @return A string representation of the Pawn.
     * Postcondition: The returned string is in the format "<color> Pawn at position (x, y)".
     */
    @Override
    public String toString() {
        return color + " Pawn at position (" + x + ", " + y + ")";
    }

    /**
     * Checks if the provided coordinates are a valid position on the board.
     *
     * @param x The x-coordinate to check.
     * @param y The y-coordinate to check.
     * @return true if the position is valid, false otherwise.
     */
    private boolean isValidPosition(Board board, int x, int y) {
        return board.getSquare(y , x) != null;
    }

    public int[] startPosition(int color) {
        return new int[] {pawnsStartDim[color][pawnID].x / 50, pawnsStartDim[color][pawnID].y / 50};
    }

    public boolean isHome() {
        return isHome;
    }

    public boolean isSafetyZone() {
        return isSafetyZone;
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    public int getPawnID() {
        return pawnID;
    }

    public void setPawnID(int pawnID) {
        this.pawnID = pawnID;
    }
}
