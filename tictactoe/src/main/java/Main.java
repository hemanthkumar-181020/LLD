public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        char[][] board = new char[3][3];
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[i].length ; j++){
                board[i][j] = '.';
            }
        }
    }
}
