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

# Score Rules
*The user chose "Score" or "score" as their gamestyle of choice.*

In this mode, the path to victory lies with the player who most stylishly battled. 
Points are awarded as follows:

Capture Pawn = 10
Capture King = 20
Promote Pawn = 30

If a combo is used, the points retrieved are collectively summed up and doubled.

The player with the most points when a player runs out of pieces wins.

Otherwise the rules obey the Standard Rules.

# The Original Idea

![http://i.imgur.com/huHVEff.png](http://i.imgur.com/huHVEff.png)

# The Final Product

![http://i.imgur.com/PHFGOjt.png](http://i.imgur.com/PHFGOjt.png)

# Software Architecture:

The system adheres to a layered architecture:

## 3-tiers

* Driver and UserCommands

* GameStyle, MoveHandler and TurnMachine

* Board, Square, and Piece


# Design Patterns:

## Strategy Pattern
This is exemplified in the GameStyle, ScoreMode, and StandardMode classes. The GameStyle is the strategy super class and users have to choose whether to play the game as either Score or Standard mode at the beginning of the game. 

## Template Method Pattern
This is exemplified in the GameStyle, ScoreMode, and StandardMode classes as well. GameStyle has a template method of getPieces() to scan the board for any piece changes. Then Score and Standard have submethods of completeGetPieces() that complete the operation based on what strategy the user selected.

## State Pattern
This is seen in the GameStyle, TurnMachine, YellowTurn, and RedTurn Classes. The GameStyle has a state to determine whether it is Yellow's turn to move or Red's turn to move. After a valid move is made, the GameStyle uses the TurnMachine to change states and process turns.

# SonarQube Status

[![Quality Status](http://i.imgur.com/xjbHEbT.png)](http://i.imgur.com/xjbHEbT.png)


# Key Learnings:

* Utilizing Design Patterns

* Properly following a planned Software Architecture

* Travis CI and CheckStyle tools

* SonarQube analysis

# Highlights: 

* Theory crafting the score mode

* Writing test cases

* Using Design Patterns unconciously

# Game Preview:

## Starting the game

### Choose a game mode
![http://i.imgur.com/wR3265y.png](http://i.imgur.com/wR3265y.png)

### Draw the board
![http://i.imgur.com/eS2XAkn.png](http://i.imgur.com/eS2XAkn.png)


## Move Command

### Make a move using following command
![http://i.imgur.com/uDlXHQH.png](http://i.imgur.com/uDlXHQH.png)

### That command moves red pawn at location B2 to C3
![http://i.imgur.com/8IAjk0M.png](http://i.imgur.com/8IAjk0M.png)


## Combo Command

### If multiple pieces can be taken in one turn use the following command
![http://i.imgur.com/RrfxwCI.png](http://i.imgur.com/RrfxwCI.png)

### That particular command will capture two red pawns with a red pawn at location A4.
![http://i.imgur.com/Z0Hzujr.png](http://i.imgur.com/Z0Hzujr.png)

![http://i.imgur.com/UE4g4Qm.png](http://i.imgur.com/UE4g4Qm.png)


## King Movement

### A King can move in any direction

![http://i.imgur.com/uy9Pf3D.png](http://i.imgur.com/uy9Pf3D.png)

![http://i.imgur.com/GuQxrYI.png](http://i.imgur.com/GuQxrYI.png)
