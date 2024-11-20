import java.util.Scanner;

class TicTacToe {
    private char board[][]; //note this is the wrong syntax for Java.
    private char player;
    private char winner;
    private boolean gameOver;

    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        player = 'X';
        winner = ' ';
        gameOver = false;
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean checkWin(char player) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }

    public boolean checkDraw() {
        // Check if all spaces are filled, indicating a draw
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public void makeMove(int row, int col) {
        if (gameOver) {
            System.out.println("Game is over. Please start a new game.");
            return;
        }
        if (board[row][col] == ' ') {
            board[row][col] = player;
            if (checkWin(player)) {
                winner = player;
                gameOver = true;
            } else if (checkDraw()) {
                winner = 'D';
                gameOver = true;
            } else {
                player = (player == 'X') ? 'O' : 'X';
            }
        } else {
            System.out.println("That position is already taken! Try again.");
        }
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        do {
            printBoard();
            if (player == 'X') {
                System.out.print("Player X, enter row (0-2): ");
                row = scanner.nextInt();
                System.out.print("Enter column (0-2): ");
                col = scanner.nextInt();
            } else {
                System.out.print("Player O, enter row (0-2): ");
                row = scanner.nextInt();
                System.out.print("Enter column (0-2): ");
                col = scanner.nextInt();
            }
            makeMove(row, col);
        } while (!gameOver);

        printBoard();
        if (winner == 'D') {
            System.out.println("It's a draw!");
        } else {
            System.out.println("Player " + winner + " wins!");
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.startGame();
    }
}
