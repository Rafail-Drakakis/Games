import sys
import numpy as np
import random
import time
from PyQt5.QtWidgets import (
    QApplication, QWidget, QGridLayout, QLineEdit, QPushButton, QLabel, QVBoxLayout, QMessageBox, QHBoxLayout, QSpinBox
)
from PyQt5.QtCore import Qt

BOARD_SIZE = 9
SUBSECTION_SIZE = 3
NO_VALUE = 0
MIN_VALUE = 1
MAX_VALUE = 9

# Sudoku logic functions (reused from your original code)
def solve(board):
    for row in range(BOARD_SIZE):
        for col in range(BOARD_SIZE):
            if board[row][col] == NO_VALUE:
                for num in range(MIN_VALUE, MAX_VALUE + 1):
                    board[row][col] = num
                    if isValidSudoku(board, row, col) and solve(board):
                        return True
                    board[row][col] = NO_VALUE
                return False
    return True

def isValidSudoku(board, row, col):
    return isValidBoard(board) and isValidRow(board, row) and isValidColumn(board, col)

def isValidBoard(board):
    for i in range(BOARD_SIZE):
        if not (isValidRow(board, i) and isValidColumn(board, i) and isValidSubgrid(board, i)):
            return False
    return True

def isValidRow(board, row):
    seen = [False] * (BOARD_SIZE + 1)
    for val in board[row]:
        if val != 0 and seen[val]:
            return False
        seen[val] = True
    return True

def isValidColumn(board, col):
    seen = [False] * (BOARD_SIZE + 1)
    for i in range(BOARD_SIZE):
        val = board[i][col]
        if val != 0 and seen[val]:
            return False
        seen[val] = True
    return True

def isValidSubgrid(board, index):
    seen = [False] * (BOARD_SIZE + 1)
    row = (index // SUBSECTION_SIZE) * SUBSECTION_SIZE
    col = (index % SUBSECTION_SIZE) * SUBSECTION_SIZE
    for i in range(SUBSECTION_SIZE):
        for j in range(SUBSECTION_SIZE):
            val = board[row + i][col + j]
            if val != 0 and seen[val]:
                return False
            seen[val] = True
    return True

def isValidMove(board, row, col, num):
    for i in range(BOARD_SIZE):
        if board[row][i] == num or board[i][col] == num:
            return False
    start_row, start_col = row // 3 * 3, col // 3 * 3
    for i in range(start_row, start_row + 3):
        for j in range(start_col, start_col + 3):
            if board[i][j] == num:
                return False
    return True

def generateRandomCells(board, numFilled):
    attempts = 0
    max_attempts = 500
    filled = 0
    while filled < numFilled and attempts < max_attempts:
        x, y = random.randint(0, 8), random.randint(0, 8)
        val = random.randint(1, 9)
        if board[x][y] == 0 and isValidMove(board, x, y, val):
            board[x][y] = val
            filled += 1
        attempts += 1
    return board

def findInvalidities(board):
    issues = []

    # Check rows
    for i in range(BOARD_SIZE):
        seen = set()
        for j in range(BOARD_SIZE):
            val = board[i][j]
            if val != 0:
                if val in seen:
                    issues.append(f"Duplicate '{val}' in row {i+1}")
                    break
                seen.add(val)

    # Check columns
    for j in range(BOARD_SIZE):
        seen = set()
        for i in range(BOARD_SIZE):
            val = board[i][j]
            if val != 0:
                if val in seen:
                    issues.append(f"Duplicate '{val}' in column {j+1}")
                    break
                seen.add(val)

    # Check 3x3 subgrids
    for box_row in range(0, 9, 3):
        for box_col in range(0, 9, 3):
            seen = set()
            for i in range(3):
                for j in range(3):
                    val = board[box_row + i][box_col + j]
                    if val != 0:
                        if val in seen:
                            issues.append(f"Duplicate '{val}' in subgrid starting at ({box_row+1},{box_col+1})")
                            break
                        seen.add(val)
    return issues


class SudokuApp(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Sudoku Solver & Generator")
        self.board_inputs = [[QLineEdit() for _ in range(9)] for _ in range(9)]
        self.initUI()

    def initUI(self):
        main_layout = QVBoxLayout()

        grid_layout = QGridLayout()
        for i in range(9):
            for j in range(9):
                cell = self.board_inputs[i][j]
                cell.setFixedSize(40, 40)
                cell.setAlignment(Qt.AlignCenter)
                cell.setMaxLength(1)
                grid_layout.addWidget(cell, i, j)

        control_layout = QHBoxLayout()
        self.generate_button = QPushButton("Generate")
        self.solve_button = QPushButton("Solve")
        self.check_button = QPushButton("Check")
        self.empty_cells_input = QSpinBox()
        self.empty_cells_input.setRange(1, 80)
        self.empty_cells_input.setValue(40)

        control_layout.addWidget(QLabel("Empty Cells:"))
        control_layout.addWidget(self.empty_cells_input)
        control_layout.addWidget(self.generate_button)
        control_layout.addWidget(self.solve_button)
        control_layout.addWidget(self.check_button)

        self.generate_button.clicked.connect(self.generate_board)
        self.solve_button.clicked.connect(self.solve_board)
        self.check_button.clicked.connect(self.check_board)

        main_layout.addLayout(grid_layout)
        main_layout.addLayout(control_layout)
        self.setLayout(main_layout)

    def get_board(self):
        board = []
        for row in self.board_inputs:
            board_row = []
            for cell in row:
                try:
                    val = int(cell.text())
                except ValueError:
                    val = 0
                board_row.append(val)
            board.append(board_row)
        return board

    def set_board(self, board):
        for i in range(9):
            for j in range(9):
                val = board[i][j]
                self.board_inputs[i][j].setText(str(val) if val != 0 else "")

    def generate_board(self):
        max_attempts = 10
        success = False
        num_filled = 81 - self.empty_cells_input.value()

        for attempt in range(max_attempts):
            board = [[0] * 9 for _ in range(9)]
            board = generateRandomCells(board, num_filled)
            solved = [row[:] for row in board]
            if solve(solved):
                self.set_board(board)
                success = True
                break

        if not success:
            QMessageBox.warning(
                self,
                "Generation Failed",
                f"Couldn't generate a solvable board with {81 - num_filled} empty cells.\n"
                "Try a smaller number of empty cells."
            )

    def solve_board(self):
        board = self.get_board()
        if solve(board):
            self.set_board(board)
        else:
            QMessageBox.warning(self, "No Solution", "This Sudoku has no solution.")

    def check_board(self):
        board = self.get_board()
        issues = findInvalidities(board)
        if not issues:
            QMessageBox.information(self, "Valid", "This board is valid.")
        else:
            error_message = "Invalid board:\n" + "\n".join(issues)
            QMessageBox.warning(self, "Invalid", error_message)

# Entry point
def main():
    app = QApplication(sys.argv)
    window = SudokuApp()
    window.show()
    sys.exit(app.exec_())

if __name__ == "__main__":
    main()

