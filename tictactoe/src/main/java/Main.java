import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char[][] board = new char[3][3];

        // Initialize the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '.';
            }
        }

        char player = 'X';
        boolean gameOver = false;

        try (Scanner sc = new Scanner(System.in)) {

            while (!gameOver) {
                printBoard(board);

                System.out.println("Player " + player + "'s turn.");
                System.out.print("Enter row and column (0-2): ");

                int row = sc.nextInt();
                int col = sc.nextInt();

                // Validate coordinates
                if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                    System.out.println("Invalid position! Try again.");
                    continue;
                }

                // Validate cell availability
                if (board[row][col] != '.') {
                    System.out.println("Cell already occupied! Try again.");
                    continue;
                }

                // Place the player's symbol
                board[row][col] = player;

                // Check winner
                if (haveWon(board, player)) {
                    printBoard(board);
                    System.out.println("Congratulations! Player " + player + " wins!");
                    gameOver = true;
                } else if (isDraw(board)) {
                    printBoard(board);
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    // Switch players
                    player = (player == 'X') ? 'O' : 'X';
                }
            }
        }
    }

    public static boolean haveWon(char[][] board, char player) {

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player &&
                    board[i][1] == player &&
                    board[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player &&
                    board[1][j] == player &&
                    board[2][j] == player) {
                return true;
            }
        }

        // Check main diagonal
        if (board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player) {
            return true;
        }

        // Check opposite diagonal
        if (board[0][2] == player &&
                board[1][1] == player &&
                board[2][0] == player) {
            return true;
        }

        return false;
    }

    public static boolean isDraw(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printBoard(char[][] board) {
        System.out.println();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);

                if (j < 2) {
                    System.out.print(" | ");
                }
            }

            System.out.println();

            if (i < 2) {
                System.out.println("---------");
            }
        }

        System.out.println();
    }
}