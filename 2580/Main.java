import java.io.*;
import java.util.*;

class Main {
    public static int mat[][] = new int[9][9];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0 ; i < 9 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < 9 ; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);
    }

    public static void sudoku(int row, int col){
        if (col == 9) {
            sudoku(row + 1 , 0);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0 ; i < 9 ; i++) {
                for (int j = 0; j < 9 ; j++)
                    sb.append(mat[i][j]).append(' ');
                sb.append('\n');
            }
            System.out.print(sb);
            System.exit(0);
        }

        if (mat[row][col] == 0) {
            for (int i = 1 ; i <= 9 ; i++) {
                if (isValid(row, col, i)) {
                    mat[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            mat[row][col] = 0;
            return;
        }

        sudoku(row, col + 1);
    }

    public static boolean isValid(int r, int c, int value) {
        boolean check;

        check = rowCheck(r, c, value);
        if(!check) return false;

        check = colCheck(r, c, value);
        if(!check) return false;

        check = three_by_three_check(r, c, value);
        if(!check) return false;

        return true;
    }

    public static boolean rowCheck(int row, int col, int value) {
        for (int i = 0 ; i < 9 ; i++) {
            if (mat[row][i] == value)
                return false;
        }
        return true;
    }

    public static boolean colCheck(int row, int col, int value) {
        for (int i = 0 ; i < 9 ; i++) {
            if (mat[i][col] == value)
                return false;
        }
        return true;
    }

    public static boolean three_by_three_check(int row, int col, int value) {
        row = (row / 3) * 3;
        col = (col / 3) * 3;

        for (int i = row ; i < row + 3 ; i++) {
            for (int j = col ; j < col + 3 ; j++) {
                if (mat[i][j] == value)
                    return false;
            }
        }
        return true;
    }
}


