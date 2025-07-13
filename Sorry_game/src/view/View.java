package view;

import controller.Controller;
import model.Card.Card;
import model.Pawn.Pawn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static GameDimensions.GameDim.*;

public class View extends JFrame {
    private JLayeredPane boardPanel;
    private final JLabel backgroundLabel;
    private JMenu fileMenu;
    public JButton foldButton;
    private JTextArea infoBox;
    private JButton CardsDeckButtons;
    private JLabel currentCardLabel;
    String[] colors = {"red", "yellow", "green", "blue"};
    public void setNoOfPlayers(int n) {
        this.NoOfPlayers = n;
    }
    public int getNoOfPlayers() {
        return NoOfPlayers;
    }
    public JButton getCardsDeckButtons() {
        return CardsDeckButtons;
    }
    public void setCardsDeckButtons(JButton cardsDeckButtons) {
        CardsDeckButtons = cardsDeckButtons;
    }
    public JButton getPlayerPawnButtons(int i, int j) {
        return playerPawnButtons[i][j];
    }
    public JButton[][] getAllPlayerPawnButtons() {
        return playerPawnButtons;
    }
    public void setPlayerPawnButtons(JButton[][] playerPawnButtons) {
        this.playerPawnButtons = playerPawnButtons;
    }
    public JLabel getCurrentCardLabel() {
        return currentCardLabel;
    }
    public void setCurrentCardLabel(JLabel currentCardLabel) {
        this.currentCardLabel = currentCardLabel;
    }
    private int NoOfPlayers;
    private JButton[][] playerPawnButtons;

    /**
     * Constructs a new GraphicUI frame for the "Sorry!" game. Initializes various components of the graphical user interface,
     * including the background image, buttons, info box, game board, pawns, cards deck, current card label, and menu.
     * Also prompts the user to enter the number of players and configures the frame accordingly.
     *
     */
    public View() {
        // Set the frame title and default close operation
        setTitle("Sorry Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the background image and add it to a label
        ImageIcon backgroundImage = new ImageIcon("images/background.png");
        backgroundLabel = new JLabel(backgroundImage);

        // Set the layout manager to null for absolute positioning
        backgroundLabel.setLayout(null);

        NoOfPlayers = Integer.parseInt(JOptionPane.showInputDialog("Enter valid number of players to play (2,3,4)"));
        while (NoOfPlayers < 2 || NoOfPlayers > 4) {
            NoOfPlayers = Integer.parseInt(JOptionPane.showInputDialog("You entered an invalid number. Enter valid number of players to play (2,3,4)"));
        }
        createFoldButton();
        createInfoBox();
        createBoardPanel();
        createPawns();
        createSorryImage();//attach with board
        createCardsDeck();
        createCurrentCardLabel();

        // Set the size of the background label to match the window size
        backgroundLabel.setSize(1050, 850);

        // Set the content pane to the background label
        setContentPane(backgroundLabel);

        // Pack the frame and center it on the screen
        pack();
        setLocationRelativeTo(null);

        setResizable(false);
        createMenu();
        setVisible(true);
    }
    /**
     * Constructs a new GraphicUI frame for the "Sorry!" game. Initializes various components of the graphical user interface,
     * including the background image, buttons, info box, game board, pawns, cards deck, current card label, and menu.
     * Also prompts the user to enter the number of players and configures the frame accordingly.
     *
     * @param temp A temporary parameter that allows creating different instances of the GraphicUI frame.
     *             Typically used for initializing the main game frame with user input for the number of players.
     */
    public View(int temp) {
        // Set the frame title and default close operation
        setTitle("Sorry Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the background image and add it to a label
        ImageIcon backgroundImage = new ImageIcon("images/background.png");
        backgroundLabel = new JLabel(backgroundImage);

        // Set the layout manager to null for absolute positioning
        backgroundLabel.setLayout(null);

        // Set the size of the background label to match the window size
        backgroundLabel.setSize(1050, 850);

        // Set the content pane to the background label
        setContentPane(backgroundLabel);

        // Pack the frame and center it on the screen
        pack();
        setLocationRelativeTo(null);

        setResizable(false);
        createMenu();
        setVisible(true);
    }

    /**
     * Resets various components of the graphical user interface to their initial state. This method recreates the fold button,
     * info box, game board, pawns, sorry image, cards deck, and current card label. It is typically used to reset the GUI
     * components when starting a new game or resetting the current game state.
     */
    public void reset() {
        createFoldButton();
        createInfoBox();
        createBoardPanel();
        createPawns();
        createSorryImage();//attach with board
        createCardsDeck();
        createCurrentCardLabel();
    }

    /**
     * Creates and configures a menu bar with a "File" menu containing items for starting a new game, opening a saved game,
     * saving the current game, and exiting the application. This method sets up the menu and associated action listeners.
     */
    void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New Game");
        JMenuItem openItem = new JMenuItem("Open Saved Game");
        JMenuItem saveItem = new JMenuItem("Save Game");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Controller();
                dispose();
            }
        });

        exitItem.addActionListener(e -> System.exit(0));

        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    /**
     * Opens a file chooser dialog for selecting a file to open. Returns the absolute path of the selected file.
     * If no file is selected or the dialog is canceled, an empty string is returned.
     *
     * @return The absolute path of the selected file, or an empty string if no file is selected.
     */
    public String selectedOpenAbsPath() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            fileChooser.setVisible(false);
            return selectedFile.getAbsolutePath();
        }

        fileChooser.setVisible(false);
        return "";
    }

    /**
     * Opens a file chooser dialog for selecting a file to save. Returns the absolute path of the selected file.
     * If no file is selected or the dialog is canceled, an empty string is returned.
     *
     * @return The absolute path of the selected file, or an empty string if no file is selected.
     */
    public String selectedSaveAbsPath() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            fileChooser.setVisible(false);
            return selectedFile.getAbsolutePath();
        }

        fileChooser.setVisible(false);
        return "";
    }

    /**
     * Gets the fold button component from the user interface.
     *
     * @return The fold button component, typically used for player actions.
     */
    public JButton getFoldButton() {
        return foldButton;
    }

    /**
     * Create the game board panel
     * Postcondition Creates the game board panel
     */
    private void createBoardPanel() {
        boardPanel = new JLayeredPane();
        boardPanel.setOpaque(true);

        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (isEdgeSquare(row, col)) {
                    String path = "";
                    if(SquaresDim.get(row).get(col) != null) {
                        path = SquaresDim.get(row).get(col).getValue();
                    }

                    JLabel jLabel = new JLabel(scaleImage("images/slides/" + path + ".png"));
                    jLabel.setBorder(BorderFactory.createLineBorder(Color.black));
                    //jLabel.setOpaque(true);
                    jLabel.setBounds(col*50, row*50, 50, 50);
                    boardPanel.add(jLabel, JLayeredPane.DEFAULT_LAYER);
                } else {
                    if(SquaresDim.get(row).get(col) == null)
                        continue;

                    JLabel jLabel;
                    switch (SquaresDim.get(row).get(col)) {
                        case RED_SAFETY_ZONE:
                            jLabel = createJLabel(row, col, Color.RED);
                            boardPanel.add(jLabel, JLayeredPane.DEFAULT_LAYER);
                            break;

                        case RED_HOME:
                            jLabel = createJLabel(row, col, Color.RED);
                            updateJLabelHOME(jLabel, col * 38, row * 50);
                            boardPanel.add(jLabel, JLayeredPane.DEFAULT_LAYER);
                            break;

                        case YELLOW_SAFETY_ZONE:
                            jLabel = createJLabel(row, col, Color.YELLOW);
                            boardPanel.add(jLabel, JLayeredPane.DEFAULT_LAYER);
                            break;

                        case YELLOW_HOME:
                            jLabel = createJLabel(row, col, Color.YELLOW);
                            updateJLabelHOME(jLabel, col * 48, 400);
                            boardPanel.add(jLabel, JLayeredPane.DEFAULT_LAYER);
                            break;

                        case GREEN_SAFETY_ZONE:
                            if (NoOfPlayers > 2) {
                                jLabel = createJLabel(row, col, Color.GREEN);
                                boardPanel.add(jLabel,
                                        JLayeredPane.DEFAULT_LAYER);
                                break;
                            }

                        case GREEN_HOME:
                            if (NoOfPlayers > 2) {
                                jLabel = createJLabel(row, col, Color.GREEN);
                                updateJLabelHOME(jLabel, col * 50, row * 48);
                                boardPanel.add(jLabel, JLayeredPane.DEFAULT_LAYER);
                                break;
                            }

                        case BLUE_SAFETY_ZONE:
                            if (NoOfPlayers > 3) {
                                jLabel = createJLabel(row, col, Color.BLUE);
                                boardPanel.add(jLabel,
                                        JLayeredPane.DEFAULT_LAYER);
                                break;
                            }

                        case BLUE_HOME:
                            if (NoOfPlayers > 3) {
                                jLabel = createJLabel(row, col, Color.BLUE);
                                updateJLabelHOME(jLabel, 400, row * 38);
                                boardPanel.add(jLabel, JLayeredPane.DEFAULT_LAYER);
                                break;
                            }
                    }
                }
            }
        }

        // Add the board panel to the background label
        boardPanel.setBounds(25, 25, 800, 800);
        backgroundLabel.add(boardPanel);
    }

    /**
     * Create and position the Sorry Image
     * Postcondition Creates the Sorry Image.
     */
    private void createSorryImage() {
        JLabel jLabel = new JLabel(scaleImage("images/sorryImage.png", 250, 100));
        jLabel.setBounds(sorryImageDim);
        boardPanel.add(jLabel, JLayeredPane.PALETTE_LAYER);
    }

    /**
     * Create and position the fold button
     * Postcondition Creates the fold button.
     */
    private void createFoldButton() {
        foldButton = new JButton("Fold");
        foldButton.setBounds(850, 500, 100, 30);
        backgroundLabel.add(foldButton);
    }

    /**
     * Create and position the info box
     * Postcondition Creates the info box
     */
    private void createInfoBox() {
        infoBox = new JTextArea("Turn: Player 1 (Red)\nCards Left: 44");
        infoBox.setBounds(850, 550, 200, 100);
        backgroundLabel.add(infoBox);
    }

    /**
     * Updates what the info box shows.
     * Postcondition Updates what the info box shows.
     * @param info The message we want to be shown at the info box.
     */
    public void updateInfoBox(String info) {
        infoBox.setText(info);
        backgroundLabel.repaint();
    }

    /**
     * Creates and configures a JLabel with specific properties, such as border, background color, and location.
     * This method is used to generate JLabels for the graphical user interface (GUI).
     *
     * @param row   The row index to position the JLabel.
     * @param col   The column index to position the JLabel.
     * @param color The background color of the JLabel.
     * @return A configured JLabel object.
     */
    JLabel createJLabel(int row, int col, Color color) {
        JLabel jLabel = new JLabel();
        jLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        jLabel.setBackground(color);
        jLabel.setOpaque(true);
        jLabel.setBounds(col * 50, row * 50, 50, 50);
        return jLabel;
    }

    /**
     * Updates the appearance and content of a JLabel to indicate that it represents a "HOME" square on the game board.
     * This method sets the font, horizontal alignment, and text content of the JLabel for HOME squares.
     *
     * @param jLabel The JLabel to be updated as a "HOME" square representation.
     * @param x      The x-coordinate position of the JLabel.
     * @param y      The y-coordinate position of the JLabel.
     */
    void updateJLabelHOME(JLabel jLabel, int x, int y) {
        jLabel.setFont(new Font(Font.SERIF, Font.BOLD, 18)); // Change 18 to your desired font size
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setBounds(x, y, 100, 100);
        jLabel.setText("HOME");
    }

    /**
     * Creates the packOfCards button.
     * Postcondition Creates the packOfCards button.
     */
    public void createCardsDeck() {
        CardsDeckButtons = new JButton("Cards Deck");
        CardsDeckButtons.setBounds(835, 320, 100, 150);
        CardsDeckButtons.setHorizontalAlignment(JButton.CENTER);
        CardsDeckButtons.setIcon(scaleImage("images/cards/backCard.png", 100, 150));
        backgroundLabel.add(CardsDeckButtons);
    }

    /**
     * Creates the currentCard button.
     * Postcondition Creates the currentCard button.
     */
    public void createCurrentCardLabel() {
        currentCardLabel = new JLabel();
        currentCardLabel.setBounds(945, 320, 100, 150);
        currentCardLabel.setBackground(Color.WHITE);
        backgroundLabel.add(currentCardLabel);
    }

    /**
     * Creates the pawns buttons.
     * Postcondition Creates the pawns buttons.
     */
    public void createPawns() {
        playerPawnButtons = new JButton[NoOfPlayers][2];

        for(int i = 0; i < NoOfPlayers; i++) {

            playerPawnButtons[i][0] = new JButton(scaleImage("images/pawns/"+ colors[i] +"Pawn1.png"));
            playerPawnButtons[i][1] = new JButton(scaleImage("images/pawns/"+ colors[i] +"Pawn2.png"));
            playerPawnButtons[i][0].setBounds(pawnsStartDim[i][0]); // player 1 start position
            playerPawnButtons[i][1].setBounds(pawnsStartDim[i][1]);

            boardPanel.add(playerPawnButtons[i][0], JLayeredPane.DRAG_LAYER);
            boardPanel.add(playerPawnButtons[i][1], JLayeredPane.DRAG_LAYER);
        }
    }


    /**
     * Scales an image located at the specified 'path' to a new size of 50x50 pixels while maintaining its aspect ratio.
     * This method is used to resize images for GUI components.
     *
     * @param path The file path to the image to be scaled.
     * @return An ImageIcon containing the scaled image.
     */
    private ImageIcon scaleImage(String path) {
        ImageIcon originalIcon = new ImageIcon(path);
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        // Create a new ImageIcon with the resized image
        return new ImageIcon(resizedImage);
    }

    /**
     * Scales an image located at the specified 'path' to the specified 'width' and 'height' while maintaining its aspect ratio.
     * This method is used to resize images for GUI components.
     *
     * @param path   The file path to the image to be scaled.
     * @param width  The new width for the scaled image.
     * @param height The new height for the scaled image.
     * @return An ImageIcon containing the scaled image.
     */
    private ImageIcon scaleImage(String path, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(path);
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // Create a new ImageIcon with the resized image
        return new ImageIcon(resizedImage);
    }

    /**
     * Checks if a square at the specified 'row' and 'col' coordinates is an edge square on the game board.
     * Edge squares are located at the outer border of the board.
     *
     * @param row The row index of the square.
     * @param col The column index of the square.
     * @return True if the square is an edge square, false otherwise.
     */
    private boolean isEdgeSquare(int row, int col) {
        return row == 0 || row == ROW - 1 || col == 0 || col == COL - 1;
    }


    /**
     * Sends the pawn to its start square.
     * Precondition Valid pawn is given.
     * Postcondition Sends the pawn to its start square.
     * @param i,j the pawn we move.
     */

    public void startAgain(int i, int j) {
        playerPawnButtons[i][j].setBounds(pawnsStartDim[i][j]); // player start position
    }

    /**
     * Updates the position of a pawn on the graphical user interface (GUI). This method moves the pawn's associated
     * GUI component to the specified location based on its current position.
     *
     * @param pawn The pawn to be updated on the GUI.
     * @param i    The row index of the player's pawn array.
     * @param j    The column index of the player's pawn array.
     */
    public void updatePawn(Pawn pawn, int i, int j) {
        playerPawnButtons[i][j].setLocation(pawn.getPosition()[0] * 50, pawn.getPosition()[1] * 50);
    }

    /**
     * Updates the current card displayed on the GUI. This method changes the image/icon of the current card label
     * based on the provided 'currentCard' object.
     *
     * @param currentCard The current card object to display on the GUI.
     */
    public void updateCurrentCard(Card currentCard) {
        currentCardLabel.setIcon(scaleImage("images/cards/" + currentCard.getImage() + ".png", 100, 150));
    }


    /**
     * Display a message dialog indicating the winner.
     *
     * @param message The message to be displayed.
     */
    public void showWinMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Game Info", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Returns the file menu component from the user interface.
     *
     * @return The file menu component, typically used to access file-related actions.
     */
    public JMenu getFileMenu() {
        return fileMenu;
    }

    /**
     * Closes the current graphical user interface (GUI) window.
     * This method hides the GUI and disposes of its resources.
     * It is typically used when closing or switching between different GUI windows.
     */
    private void closeCurrentGUI() {
        setVisible(false);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Controller c = new Controller();
        });
    }
}
