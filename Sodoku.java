public class Sodoku {

    public static void printBoard(int[][] board) {
        for(int i = 0; i <= 8; i++) {
            if (i % 3 == 0 && i != 0){
                System.out.println("-".repeat(60));
            }
            for(int j = 0; j <= 8; j++) {
                if (j % 3 == 0 && j != 0){
                    System.out.print("|");
                }
                System.out.printf("%5d ", board[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isValid(int[][] board, int n, int row, int col){
        for(int i = 0; i <= 8; i++){
            if (board[row][i] == n){
                return false;
            }
        }

        for(int i = 0; i <= 8; i++){
            if (board[i][col] == n){
                return false;
            }
        }

        int cornerRow = row - row % 3;
        int cornerCol = col - col % 3;

        for (int i = cornerRow; i < cornerRow + 3; i++){
            for (int j = cornerCol; j < cornerCol + 3; j++){
                if (board[i][j] == n){
                    return false;
                }
            }
        }

        return true;
    }


    private static boolean solveSodoku(int[][] board){
        for (int i= 0; i <= 8; i++){
            for (int j = 0; j <= 8; j++){
                if (board[i][j] == 0){
                    for (int n = 1; n <= 9; n++){
                        if (isValid(board, n, i, j)){
                            board[i][j] = n;
                            if (solveSodoku(board)){
                                return true;
                            }
                            else{
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }


    public static void main(String[] args) {

        int[][] board = {
                {0,0,0,0,0,0,0,0,2},
                {0,0,0,0,0,0,9,4,0},
                {0,0,3,0,0,0,0,0,5},
                {0,9,2,3,0,5,0,7,4},
                {8,4,0,0,0,0,0,0,0},
                {0,6,7,0,9,8,0,0,0},
                {0,0,0,7,0,6,0,0,0},
                {0,0,0,9,0,0,0,2,0},
                {4,0,8,5,0,0,3,6,0}
        };
        

        System.out.println("Here is the original sodoku:");
        printBoard(board);
        System.out.print("");

        if (solveSodoku(board)){
            System.out.println("Solved! Here is a valid solution:");
            printBoard(board);
        }
        else{
            System.out.println("Sodoku has no valid solution!");
        }

    }







}