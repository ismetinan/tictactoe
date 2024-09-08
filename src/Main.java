import java.util.Scanner;

/**
 * Main
 */
public class Main {
    private static char[][] hamleler = new char[3][3];


    private static char currentPlayer = 'O';
    public static void main(String[] args) {
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                hamleler[i][j] = ' ';
            }
        }
        Scanner scanner = new Scanner(System.in);

        printBoard();
        while (!gameOver() && hasMoreMoves()) {
            
            changePlayer();
            System.out.println(currentPlayer + " turn: ");
            System.out.print("Enter moves (1 - 3 for each row and column in order)  ");
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            playMove(x, y);
            hasMoreMoves();
            printBoard();
            
            
        }
        if (gameOver()) {
            System.out.println(currentPlayer + " won!");
        }
        else if (!hasMoreMoves()) {
            System.out.println("Draw!");
        }
        

        scanner.close();
    }
    public static boolean gameOver(char[][] hamleler) {
        for (int i = 0; i < 3; i++) {
            if (hamleler[i][0] == hamleler[i][1] && hamleler[i][1] == hamleler[i][2] && hamleler[i][0] != '\0') {
                return true;
            }

            if (hamleler[0][i] == hamleler[1][i] && hamleler[1][i] == hamleler[2][i] && hamleler[0][i] != '\0') {
                return true;
            }
        }
    
 
        if (hamleler[0][0] == hamleler[1][1] && hamleler[1][1] == hamleler[2][2] && hamleler[0][0] != '\0') {
            return true;
        }
        if (hamleler[0][2] == hamleler[1][1] && hamleler[1][1] == hamleler[2][0] && hamleler[0][2] != '\0') {
            return true;
        }
    

        return false;
    }
    public static boolean hasMoreMoves() {
        boolean hasMoreMoves = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (hamleler[i][j] == ' ') {
                    hasMoreMoves = true;
                }
            }
        }
        return hasMoreMoves;
    }
    
    public static void playMove(int x, int y) {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            System.out.println("This position is not available!");
            changePlayer();
        } 
        else {
            if (hamleler[x][y] != ' ') {
                System.out.println("This position is already taken!");
                changePlayer();
            }
            else {
                hamleler[x][y] = currentPlayer;
            }
        }
    }
    public static void printBoard() {
        System.out.print(" ---+---+---\n");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + hamleler[i][j] + " |");
            }
            System.out.print("\n ---+---+---\n");
        }
    }
    public static void changePlayer () {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        }
        else {
            currentPlayer = 'X';
        }
    }
}