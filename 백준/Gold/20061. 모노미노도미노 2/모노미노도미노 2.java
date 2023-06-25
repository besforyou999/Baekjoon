import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

y값은 greenboard에서 column과 동일
3 - x값은 blueboard에서 column과 동일


 */

public class Main {

    static int N;
    static StringTokenizer st;
    static boolean [][] blueBoard, greenBoard;
    static final int HEIGHT = 6, WIDTH = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        blueBoard = new boolean[HEIGHT][WIDTH];
        greenBoard = new boolean[HEIGHT][WIDTH];

        N = Integer.parseInt(br.readLine());

        int score = 0;

        for (int n = 0 ; n < N ; n++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 새로운 블록
            if (t == 1) {
                drop1(greenBoard, y);
                drop1(blueBoard, 3 - x);
            } else if (t == 2) {
                drop2(greenBoard, y, y + 1);
                drop3(blueBoard, 3 - x);
            } else if (t == 3) {
                drop3(greenBoard, y);
                drop2(blueBoard, 3 - x, 3 - x - 1);
            }

            // 가득 찬 행 지우고, 지운만큼 내리기
            int [] result = deleteFilledRow(greenBoard);
            if (result[0] != 0) {
                score += result[0];
                dropRow(greenBoard, result[0], result[1]);
            }

            result = deleteFilledRow(blueBoard);
            if (result[0] != 0) {
                score += result[0];
                dropRow(blueBoard, result[0], result[1]);
            }

            // 회색 부분 내리기
            int grayRows = grayRow(greenBoard);
            if (grayRows > 0) {
                deleteRowFromBottom(greenBoard, grayRows);
                dropGrayRow(greenBoard, grayRows);
            }

            grayRows = grayRow(blueBoard);
            if (grayRows > 0) {
                deleteRowFromBottom(blueBoard, grayRows);
                dropGrayRow(blueBoard, grayRows);
            }
        }

        int tile = countTile(greenBoard);
        tile += countTile(blueBoard);

        System.out.println(score);
        System.out.println(tile);
    }

    public static int countTile(boolean [][] board) {
        int cnt = 0;
        for (int row = 2; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                if (board[row][col]) cnt += 1;
            }
        }
        return cnt;
    }

    public static int grayRow(boolean [][] board) {
        int row = 0;

        for (int r = 0 ; r < 2 ; r++) {
            for (int c = 0 ; c < WIDTH ; c++) {
                if (board[r][c]) {
                    row += 1;
                    break;
                }
            }
        }

        return row;
    }

    public static void deleteRowFromBottom(boolean[][] board, int deleteRow) {
        for (int cnt = 0 ; cnt < deleteRow ; cnt++) {
            for (int col = 0 ; col < WIDTH ; col++) {
                board[HEIGHT - 1 - cnt][col] = false;
            }
        }
    }

    public static int[] deleteFilledRow(boolean [][] board) {
        int cnt = 0;
        int highestDeletedRow = -1;
        for (int row = HEIGHT - 1; row >= 2 ; row--) {
            boolean rowFilled = true;
            for (int col = 0; col < WIDTH ; col++) {
                if (!board[row][col]) {
                    rowFilled = false;
                    break;
                }
            }
            if (rowFilled) {
                for (int col = 0; col < WIDTH ; col++) {
                    board[row][col] = false;
                }
                cnt += 1;
                highestDeletedRow = row;
            }
        }

        return new int[] {cnt, highestDeletedRow};
    }

    public static void dropGrayRow(boolean [][] board, int cnt) {
        for (int row = HEIGHT - 2; row >= 0 ; row--) {
            for (int col = 0 ; col < WIDTH ; col++) {
                if (board[row][col]) {
                    board[row][col] = false;
                    board[row + cnt][col] = true;
                }
            }
        }
    }

    public static void dropRow(boolean [][] board, int cnt, int highestDeletedRow) {
        for (int row = highestDeletedRow - 1; row > 0 ; row--) {
            for (int col = 0 ; col < WIDTH ; col++) {
                if (board[row][col]) {
                    board[row][col] = false;
                    board[row + cnt][col] = true;
                }
            }
        }
    }

    public static void drop1(boolean [][] board, int col) {
        int row = 1;

        board[0][col] = true;

        while (row < HEIGHT && !board[row][col]) {
            board[row - 1][col] = false;
            board[row][col] = true;
            row++;
        }
    }

    public static void drop2(boolean [][] board, int col1, int col2) {
        int row = 0;

        board[row][col1] = board[row][col2] = true;

        row++;

        while (row < HEIGHT && (!board[row][col1] && !board[row][col2]) ) {
            board[row - 1][col1] = board[row - 1][col2] = false;
            board[row][col1] = board[row][col2] = true;
            row++;
        }
    }

    public static void drop3(boolean [][] board, int col) {
        int row = 0;

        board[row][col] = true;
        board[row + 1][col] = true;

        row = 2;

        while (row < HEIGHT && !board[row][col]) {
            board[row - 2][col] = false;
            board[row][col] = true;
            row++;
        }
    }

}