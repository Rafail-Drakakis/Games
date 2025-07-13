package controller;

import model.Board.Board;
import model.CardsDeck.CardsDeck;
import model.Card.Card;
import model.Player.Player;
import view.View;

import javax.swing.SwingUtilities;

import java.io.*;

import static GameDimensions.GameDim.*;

/**
 * The Controller class is responsible for managing the game and controlling its operations.
 */
public class Controller implements Serializable {
    private CardsDeck cardsDeck;
    private Card currentCard;
    private Board board;
    private transient View view;
    int currentPlayerID = 0;

    Player[] players;

    /**
     * Constructor: Initializes a new game and sets it as eligible to start.
     * Postcondition: Constructs a new Controller with 4 players, new instances of Turn Class,
     * Round Class, and CardsDeck Class, and initializes some int or boolean variables.
     * Responsible for creating a new game and initializing it.
     */
    public Controller() {
        view = new View();
        initPlayer();
        init_table();
        initUI();
    }

    /**
     * Initializes the user interface, setting up button listeners and handling actions for various UI elements.
     * This method is responsible for configuring the UI components and defining their action behaviors.
     *
     * Precondition: The necessary game components, such as 'cardsDeck', 'currentCard', 'board', 'players', 'currentPlayerID',
     * and 'graphicUI' must be properly initialized before calling this method.
     *
     * Postcondition: The user interface is set up with event listeners for buttons, and the UI components are configured
     * based on the current game state. Actions are defined for UI elements like the fold button, player pawn buttons,
     * and file menu items. The UI reflects the current game state, and actions are handled as specified.
     */
    void initUI() {
        currentCard = cardsDeck.getCards().get(0);
        view.updateCurrentCard(currentCard);

        view.getFoldButton().addActionListener(e -> {

            if (checkIfGameFinished()) {
                view.showWinMessage("The winner is " + players[currentPlayerID].toString() + "\n");
                return;
            }

            fold();
        });

        for(int i = 0; i < players.length; i++) {
            int finalI = i;
            view.getPlayerPawnButtons(i, 0).addActionListener(e -> {
                if (checkIfGameFinished()) {
                    view.showWinMessage("The winner is " + players[currentPlayerID].toString() + "\n");
                    return;
                }

                nextTurn(finalI, 0);
            });

            view.getPlayerPawnButtons(i, 1).addActionListener(e -> {
                if (checkIfGameFinished()) {
                    view.showWinMessage("The winner is " + players[currentPlayerID].toString() + "\n");
                    return;
                }

                nextTurn(finalI, 1);
            });
        }

        view.getFileMenu().getItem(1).addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                Controller c = openGame(view.selectedOpenAbsPath());
                if(c != null) {
                    this.cardsDeck = c.cardsDeck;
                    this.currentCard = c.currentCard;
                    this.board = c.board;
                    this.players = c.players;
                    this.currentPlayerID = c.currentPlayerID;
                    this.view.dispose();
                    this.view = new View(0);
                    this.view.setNoOfPlayers(c.players.length);
                    this.view.reset();
                    this.updateAllPawnsView();
                    this.view.updateCurrentCard(this.currentCard);
                    this.view.updateInfoBox("Turn: Player " + (currentPlayerID + 1) + " (" + COLORS[currentPlayerID]+ ")" + "\nCards Left: " + cardsDeck.getCards().size());
                    initUI();
                }
            });
        });

        view.getFileMenu().getItem(2).addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                saveGame(view.selectedSaveAbsPath());
            });
        });
    }
    /**
     * Initializes the game board and the deck of cards. This method should be called at the beginning of the game
     * to set up the initial game state.
     *
     * Postcondition: The 'board' and 'cardsDeck' objects are created and ready for use in the game.
     */
    public void init_table() {
        board = new Board(ROW, COL);
        cardsDeck = new CardsDeck();
    }

    /**
     * Initializes the player objects based on the number of players configured in the user interface.
     * Each player is given a name and player-specific data is initialized.
     *
     * Precondition: The 'graphicUI' object must be properly initialized with the desired number of players.
     *
     * Postcondition: Player objects are created and initialized, and the 'players' array is populated with them.
     * The 'updateAllPawnsView()' method is called to update the UI to reflect the initial game state.
     */
    void initPlayer() {
        currentPlayerID = 0;
        players = new Player[view.getNoOfPlayers()];

        for (int i = 0; i < players.length; i++) {
            players[i] = new Player("Player " + i, i);
            players[i].init_player();
        }

        updateAllPawnsView();
    }

    /**
     * Handles the fold action when the fold button is clicked. This method advances the game to the next player's turn.
     *
     * Postcondition: The game state is updated by changing the current player to the next player in a circular manner.
     * The 'currentCard' is updated, and if the 'cardsDeck' is empty, it is reinitialized. UI components are updated
     * to reflect the current game state.
     */
    void fold() {
        if (cardsDeck.isEmpty()) // If cards are empty, then initialize cards again.
            cardsDeck.init_cards();

        updateAllPawnsView();
        currentPlayerID++;
        currentPlayerID %= players.length;
        view.updateInfoBox("Turn: Player " + (currentPlayerID + 1) + " (" + COLORS[currentPlayerID] + ")" + "\nCards Left: " + cardsDeck.getCards().size());
        currentCard = cardsDeck.getCards().get(0);
        view.updateCurrentCard(currentCard);
    }

    /**
     * Handles the next turn action for a specific player and pawn. Moves the player's pawn on the board based on the current card.
     * If a move is not possible with one pawn, it attempts to move the other pawn.
     *
     * Precondition: 'playerID' and 'pawnID' should correspond to a valid player and pawn in the game. The 'currentPlayerID'
     * should match the provided 'playerID'.
     *
     * Postcondition: The player's pawn is moved on the board based on the current card. The 'cardsDeck' is updated by removing
     * the top card. If the 'cardsDeck' is empty, it is reinitialized. UI components are updated to reflect the current game state.
     */
    void nextTurn(int playerID, int pawnID) {
        if (currentPlayerID != playerID) {
            return; // Ignore the action if it's not the current player's turn.
        }

        if (pawnID == 0) {
            if (!currentCard.movePawn(players[currentPlayerID].getPawn1(), board)) {
                // If the move doesn't work with the first pawn, try the second pawn.
                currentCard.movePawn(players[currentPlayerID].getPawn2(), board);
            }
        } else {
            if (!currentCard.movePawn(players[currentPlayerID].getPawn2(), board)) {
                // If the move doesn't work with the second pawn, try the first pawn.
                currentCard.movePawn(players[currentPlayerID].getPawn1(), board);
            }
        }

        cardsDeck.removeCardIndex(0);
        if (cardsDeck.isEmpty()) // If cards are empty, then initialize cards again.
            cardsDeck.init_cards();

        updateAllPawnsView();
        currentPlayerID++;
        currentPlayerID %= players.length;
        view.updateInfoBox("Turn: Player " + (currentPlayerID + 1) + " (" + COLORS[currentPlayerID] + ")" + "\nCards Left: " + cardsDeck.getCards().size());

        currentCard = cardsDeck.getCards().get(0);
        view.updateCurrentCard(currentCard);
    }

    /**
     * Updates the visual representation of all player pawns on the user interface.
     * This method iterates through all players and their pawns, updating their positions and visuals on the UI.
     * It ensures that the UI reflects the current positions of all pawns in the game.
     */
    void updateAllPawnsView() {
        SwingUtilities.invokeLater(() -> {
            for (int i = 0; i < players.length; i++) {
                view.updatePawn(players[i].getPawn1(), i, 0);
                view.updatePawn(players[i].getPawn2(), i, 1);
            }
        });
    }

    /**
     * Checks if someone won and the game finished.
     * Postcondition Returns true if one of the players won,else false.
     * @return True if one of the players won,else false.
     */
    public boolean checkIfGameFinished() {
        return players[currentPlayerID].isFinished();
    }

    /**
     * Save the current game state to a file.
     *
     * @param fileName The name of the file to save the game state to.
     */
    public void saveGame(String fileName) {
        if(fileName!= null && !fileName.isEmpty()) {
            try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName))) {
                os.writeObject(this);
                System.out.println("Game saved successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Open and load a saved game state from a file.
     *
     * @param fileName The name of the file to load the game state from.
     */
    public static Controller openGame(String fileName) {
        if(fileName!= null && !fileName.isEmpty()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                Controller loadedGame = (Controller) ois.readObject();
                System.out.println("Game loaded successfully.");
                return loadedGame;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
