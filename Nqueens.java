public class Nqueens {   
    public static boolean issafe(char board[][],int row,int col) {
        //vertical up
        for (int i = row-1; i >= 0; i--) {
            if (board[i][col]=='Q') {
                return false;
            }
        }
        //diagonal left
        for (int i = row-1, j=col-1; i >= 0 && j >= 0; i--,j--) {
            if (board[i][j]=='Q') {
                return false;
            }
        }
        //diagonal right
        for (int i = row-1,j=col+1; i >= 0 && j<board.length; i--,j++) {
            if (board[i][j]=='Q') {
                return false;
            }
        }
        return true;
    }


    public static void queens(char board[][],int rows) {
         //base case
        if (board.length==rows) {           
            printBoard(board);
            return;
        }
           
            //recursion
            for (int j = 0; j < board.length; j++) {//column wise put queens
                if (issafe(board, rows, j)) {
                    board[rows][j]='Q';
                    queens(board, rows+1);// recursion steps
                    board[rows][j]='x';// backtracking steps
                }
            }            
    }
    public static void printBoard(char board[][]) {
        System.out.println("---------chess board------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n=4;
        char board[][]=new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j]='x';
            }
        }
        queens(board, 0);
    }
}
