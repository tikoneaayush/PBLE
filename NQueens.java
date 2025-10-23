package Backtracking;
import java.util.Scanner;

public class NQueens {
    static int c = 0;

    public static void nQueens(char board[][], int row) {
        // Base Condition
        if (row == board.length) {
            printBoard(board);
            c++;
            return;
        }

        // Column Loop
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1); // Recursive call
                board[row][j] = 'x'; // Backtracking Step
            }
        }
    }

    public static void printBoard(char board[][]) {
        System.out.println("\n---- Chess Board ----");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char board[][], int row, int cal) {
        // Vertically Up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][cal] == 'Q') {
                return false;
            }
        }
        // Left Up Diagonal
        for (int i = row - 1, j = cal - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Right Up Diagonal
        for (int i = row - 1, j = cal + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        
        // Keep asking until valid integer is entered
        while (true) {
            System.out.print("Enter the size of N (>= 1): ");
            try {
                n = sc.nextInt();
                if (n < 1) {
                    System.out.println("Please enter a positive integer greater than 0.\n");
                    continue;
                }
                break; // valid input
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid integer.\n");
                sc.nextLine(); // clear invalid input
            }
        }

        // Initialize board
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }

        // Solve N-Queens
        nQueens(board, 0);
        System.out.println("\nAll Possible Safe Arrangements: " + c);
    }
}
