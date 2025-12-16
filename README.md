# 🎮TicTacToe-in-Java
This is a simple desktop based Java game of Tic Tac Toe developed using Java Swing that allows users to play the classic 3×3 board game in both Player vs Player and Player vs Computer modes. The game features an interactive graphical user interface, win and draw detection, and a computer opponent powered by a random move algorithm.

---

## Features

- Interactive 3×3 Tic Tac Toe board
- Player vs Player mode
- Player vs Computer mode (Random mode)
- Start screen with full background image
- Play again option
- Automatic win detection (rows, columns, diagonals)
- Tie detection
- Visual highlighting of winning tiles
- Modular and easy-to-understand code structure

---

## Technologies Used

- Java
- Java Swing
- Java AWT
- Object-Oriented Programming (OOP)
- Event Handling
- Random Library (for Computer moves)

---

## Game Modes

1. Player vs Player
- Two players take turns on the same system.
- Player X starts first. After game resets, the next player goes first.
- The game announces the winner or a tie automatically.

2. Player vs Computer
- Player competes against the computer.
- Player always plays as X.
- The computer plays as O and selects moves randomly from available cells.
- Implemented using Java’s Random class.
- Designed for simplicity and beginner-level understanding.


---

## 🔁 Play Again / Reset Game Feature

After every game result (win or tie), the application prompts the user with a **Play Again dialog**.

### How it works:
- A confirmation dialog appears asking:
  > *“Do you want to play again?”*
- **YES** → The game board resets instantly:
  - All tiles are cleared
  - Colors are restored
  - Turn counter resets
- **NO** → The current game window closes and returns to the start screen

This feature improves user experience by allowing continuous gameplay without restarting the application.


## ▶️ How to Run the Game

1. Make sure Java (JDK 8 or later) is installed.
2. Clone or download the repository.
3. Open the project in any Java-supported IDE (IntelliJ, Eclipse, VS Code).
4. Run the following file:
   ```bash
   MainApp.java

