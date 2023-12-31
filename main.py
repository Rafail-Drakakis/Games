from hangman import hangman
from pong_game import pong_game
from rock_paper_scissors import rock_paper_scissors
from tic_tac_toe import tic_tac_toe
from labyrinth import labyrinth
from Town_of_Salem import game_flow as Salem
from guess_game import guess_number
from star_catcher_game import main as star_catcher_game

if __name__ == "__main__":
    choice = int(input("Press \n1.To play tic tac toe \n2.To play hangman \n3.To play rock paper scissors \n4.To play the pong game \n5.To generate a random labyrinth \n6.To play Town of Salem \n7.To play a guessing game \n8.To play the star catcher game: "))
    if choice == 1:
        tic_tac_toe()
    elif choice == 2:
        hangman()
    elif choice == 3:
        rock_paper_scissors()
    elif choice == 4:
        pong_game()
    elif choice == 5:
        labyrinth()
    elif choice == 6:
        Salem()
    elif choice == 7:
        guess_number()
    elif choice == 8:
        star_catcher_game()
    else:
     	print ("Invalid input! ")