# Game Collection

This repository contains a set of small games written in Python and Java. Each directory is a standalone project. You can run the Python games directly with `python3` and the Java project with the JDK.

## Requirements

* **Python 3** – required for all Python based games.
* **pygame** – needed for `pong_game`, `star_catcher` and `tic_tac_toe`.
* **PyQt5** and **numpy** – required for `sudoku`.
* **Java** – needed for the `Sorry_game` implementation.

You can install the Python dependencies with `pip`:

```bash
pip install pygame PyQt5 numpy
```

## Games

### Hangman (`hangman/hangman.py`)
A console hangman implementation. The script randomly chooses a word and you guess letters until you either reveal it or run out of lives.

Run with:
```bash
python3 hangman/hangman.py
```

### Rock Paper Scissors (`rock_paper_scissors/rock_paper_scissors.py`)
Simple command line version of the classic game where you play against the computer.

Run with:
```bash
python3 rock_paper_scissors/rock_paper_scissors.py
```

### Pong (`pong_game/pong_game.py`)
A basic two–player Pong clone that uses pygame for graphics.

Run with:
```bash
python3 pong_game/pong_game.py
```

### Star Catcher (`star_catcher/star_catcher_game.py`)
Full–screen pygame game where you dodge falling stars. Move left or right with the arrow keys. Uses the `BACKROUND.jpeg` image in the same folder.

Run with:
```bash
python3 star_catcher/star_catcher_game.py
```

### Tic Tac Toe (`tic_tac_toe/tic_tac_toe.py`)
Two player tic–tac–toe, also written with pygame.

Run with:
```bash
python3 tic_tac_toe/tic_tac_toe.py
```

### Sudoku (`sudoku/sudoku.py`)
Graphical Sudoku puzzle creator and solver using PyQt5. The interface lets you generate puzzles, enter numbers and validate boards.

Run with:
```bash
python3 sudoku/sudoku.py
```

### Town of Salem (`town_of_Salem/Town_of_Salem.py`)
Text based game inspired by the party game Mafia. Starting roles are loaded from `town_of_Salem/Players.txt`.

Run with:
```bash
python3 town_of_Salem/Town_of_Salem.py
```

### Sorry! (`Sorry_game`)
A Java Swing version of the board game *Sorry!*. Compiled `.class` files are in `Sorry_game/out/production/MVC`.

Run with:
```bash
java -cp Sorry_game/out/production/MVC view.View
```

Alternatively you can recompile using the source in `Sorry_game/src`.

## Repository Layout
```
Sorry_game/            # Java implementation of Sorry!
hangman/               # Command line Hangman game
pong_game/             # Pong written with pygame
rock_paper_scissors/   # Command line Rock–Paper–Scissors
tic_tac_toe/           # Pygame Tic Tac Toe
star_catcher/          # Pygame arcade game
sudoku/                # PyQt5 Sudoku puzzle
town_of_Salem/         # Text based Town of Salem clone
```
