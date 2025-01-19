package difficulty;

import models.ComputerPlayer;

public class ExtremeLevel extends ComputerPlayer {

    public ExtremeLevel() {
    }

    public static Integer moveComputerMove(Integer[][] board) {
        int bestScore = Integer.MIN_VALUE;
        int bestRow = -1, bestCol = -1;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == null) {
                    board[r][c] = 1; 
                    int score = minimax(board, false); 
                    board[r][c] = null;  
                    if (score > bestScore) {
                        bestScore = score;
                        bestRow = r;
                        bestCol = c;
                    }
                }
            }
        }
        if (bestRow != -1 && bestCol != -1) {
            board[bestRow][bestCol] = 1;  
        }

        return (bestRow * 10) + bestCol;
    }

    private static int minimax(Integer[][] board, boolean isMaximizing) {
        String result = checkWinner(board);
        if (result != null) {
            if (result.equals("O")) {
                return -10; 
            }
            if (result.equals("X")) {
                return 10; 
            }
            return 0; 
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    if (board[r][c] == null) {
                        board[r][c] = 2; 
                        int score = minimax(board,true);
                        board[r][c] = null; 
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    if (board[r][c] == null) {
                        board[r][c] = 1; 
                        int score = minimax(board, true);
                        board[r][c] = null;
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }
 

    public static String getWinnerCharacter(Integer value) {
        if (value == null) {
            return null;
        }
        return (value % 2 == 0) ? "O" : "X";
    }

    public static boolean checkLine(Integer a, Integer b, Integer c) {
        if (a == null || b == null || c == null) {
            return false;
        }
          boolean state = ((a % 2 == b % 2) && (b % 2 == c % 2));
        return state;
    }

    public static String checkWinner(Integer[][] board) {
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (checkLine(board[i][0], board[i][1], board[i][2])) {
                return getWinnerCharacter(board[i][0]);
            }
            // Check columns
            if (checkLine(board[0][i], board[1][i], board[2][i])) {
                return getWinnerCharacter(board[0][i]);
            }
        }
        // Check diagonals
        if (checkLine(board[0][0], board[1][1], board[2][2])) {
            return getWinnerCharacter(board[0][0]);
        }
        if (checkLine(board[0][2], board[1][1], board[2][0])) {
            return getWinnerCharacter(board[0][2]);
        }
        return null;
    }
}