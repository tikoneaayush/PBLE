package Backtracking;


public class NQueens2 {
    static int c = 0;
    public static boolean isSafe(char board[][], int row, int cal){
        // Vertically up
        for(int i=row; i>=0; i--){
            if(board[i][cal] == 'Q'){
                return false;
            }
        }

        // left up diagonal
        for(int i=row, j=cal; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // right up diagonal
        for(int i=row, j=cal; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void nQueens(char board[][], int row){

        if(row == board.length){
            printBoard(board);
            ++c;
            return; 
        }

        for(int j=0; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueens(board, row+1);
                board[row][j] = 'x';
            }
            
        }
    }

    public static void printBoard(char board[][]) {
        System.out.println();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n=20;

    char board[][] = new char[n][n];

    for(int i=0; i<board.length; i++){
        for(int j=0; j<board.length; j++){
            board[i][j]='x';
        }
    }

    nQueens(board, 0);
    System.out.println("Count ="+ c);
    }
    
}
