package difficulty;

import models.ComputerPlayer;

public class ExtremeLevel extends ComputerPlayer {

    public ExtremeLevel() {
    }

    private static int minimax(char[][] charBoard, boolean isMaximizing, int depth) {
        String result = checkWinner(charBoard);
        if (result != null) {
            if (result.equals("O")) {
                return 10 - depth;
            }
            if (result.equals("X")) {
                return depth - 10;
            }
            return 0;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    if (charBoard[r][c] == '-') {
                        charBoard[r][c] = 'O';
                        int score = minimax(charBoard, false, depth + 1);
                        charBoard[r][c] = '-';
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    if (charBoard[r][c] == '-') {
                        charBoard[r][c] = 'X';
                        int score = minimax(charBoard, true, depth + 1);
                        charBoard[r][c] = '-';
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

    public static int[] getBestMove(Integer[][] board) {
        char[][] charBoard = convertBoardToChar(board);

        int bestScore = Integer.MIN_VALUE;
        int bestRow = -1, bestCol = -1;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (charBoard[r][c] == '-') {
                    charBoard[r][c] = 'O';
                    int score = minimax(charBoard, false, 0);
                    charBoard[r][c] = '-';

                    if (score > bestScore) {
                        bestScore = score;
                        bestRow = r;
                        bestCol = c;
                    }
                }
            }
        }

        System.out.println("Best move is at (" + bestRow + ", " + bestCol + ") with score: " + bestScore);
        return new int[]{bestRow, bestCol};
    }

    public static String checkWinner(char[][] charBoard) {
        for (int i = 0; i < 3; i++) {
            // rows
            if (charBoard[i][0] != '-' && charBoard[i][0] == charBoard[i][1] && charBoard[i][1] == charBoard[i][2]) {
                return String.valueOf(charBoard[i][0]);
            }
            // column
            if (charBoard[0][i] != '-' && charBoard[0][i] == charBoard[1][i] && charBoard[1][i] == charBoard[2][i]) {
                return String.valueOf(charBoard[0][i]);
            }
        }
        // diagonal
        if (charBoard[0][0] != '-' && charBoard[0][0] == charBoard[1][1] && charBoard[1][1] == charBoard[2][2]) {
            return String.valueOf(charBoard[0][0]);
        }
        if (charBoard[0][2] != '-' && charBoard[0][2] == charBoard[1][1] && charBoard[1][1] == charBoard[2][0]) {
            return String.valueOf(charBoard[0][2]);
        }
        // draw
        return null;
    }

    public static char[][] convertBoardToChar(Integer[][] board) {
        char[][] charBoard = new char[3][3]; // Assuming a 3x3 board

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == null) {
                    charBoard[i][j] = '-'; // Empty cell
                } else if (board[i][j] % 2 == 0) {
                    charBoard[i][j] = 'O'; // Even number
                } else {
                    charBoard[i][j] = 'X'; // Odd number
                }
            }
        }
        return charBoard;
    }

}
