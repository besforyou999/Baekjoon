import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char [][] mat;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        mat = new char[N + 1][N + 1];

        for (int r = 1 ; r < N + 1 ; r++) {
            String line = br.readLine();
            for (int c = 1 ; c < N + 1 ; c++) {
                mat[r][c] = line.charAt(c - 1);
            }
        }

        System.out.println(rec(1, 1, N));
    }

    public static String rec(int r, int c, int len) {
        if (len == 1) {
            return Character.toString(mat[r][c]);
        }

        int check = checkAll(r, c, len);

        if (check == 1) {
            return "1";
        } else if (check == 0) {
            return "0";
        } else {
            int half = len / 2;
            return "(" + rec(r, c, half) + rec(r, c + half, half) + rec(r + half, c, half) + rec(r + half, c + half, half) + ")";
        }
    }

    public static int checkAll(int r, int c, int len) {

        char ch = mat[r][c];

        for (int i = 0 ; i < len ; i++) {
            for (int j = 0 ; j < len ; j++) {
                if (ch != mat[r + i][c + j])
                    return -1;
            }
        }

        return ch - '0';
    }
}