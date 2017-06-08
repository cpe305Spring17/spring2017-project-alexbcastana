[![Build Status](https://travis-ci.org/cpe305Spring17/spring2017-project-alexbcastana.svg?branch=master)](https://travis-ci.org/cpe305Spring17/spring2017-project-alexbcastana)


# Command Checkers
A classic game in the retro command line style

Command Checkers is played on an 8x8 board. Before the board is loaded, the user selects the gamestyle or mode (strategy pattern inspired). The user must input "standard", "Standard", "score", or "Score". Based on the input the game will adhere to the standard rules of draughts or based on a scoring system devised by the developer.

Once the gamestyle is selected, the board is drawn and populated with red pawns and yellow pawns. Game will begin on red's turn. 

# Standard Rules
*The user chose "standard" or "Standard" as their gamestyle of choice.*

In this mode, the path to victory lies in the elimination of all opposing pieces. Each color starts with 12 pawns. The game concludes when a player reaches 0 pieces remaining.

Each piece can only move diagonally upward for yellow pieces(diagonally downward for red pieces). A piece can only move one tile forward (with respect to the color and nature of the piece) or they can "leap" over an opposing piece and capture that piece if there is an opening in the same direction behind the piece to be taken. If a piece is leapt over, it is removed from play. Multiple pieces may be captured in one turn if they are captured in the same pathway as the original piece was.

When a pawn reaches the opposite edge (downward or upward) on the board, the pawn becomes a king. The king is then granted the ability to move in any direction in one tile increments. (with exception of the piece capture mechanic). 

Once a move has been made, the turn changes. 

## Score Rules
*The user chose "Score" or "score" as their gamestyle of choice.*

In this mode, the path to victory lies with the player who most stylishly battled. 
Points are awarded as follows:

Capture Pawn = 10
Capture King = 20
Promote Pawn = 30

If a combo is used, the points retrieved are collectively summed up and doubled.

The player with the most points when a player runs out of pieces wins.

Otherwise the rules obey the Standard Rules.
