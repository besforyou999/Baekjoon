import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int mat[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mat = new int[9][9];

        int cnt = 0;

        for (int i = 0 ; i < 9 ; i++) {
            String line = br.readLine();
            for (int j = 0 ; j < 9 ; j++) {
                mat[i][j] = line.charAt(j) - '0';
                if (mat[i][j] != 0) cnt++;
            }
        }

        back(cnt, 0, 0);

    }

    public static void back(int cnt, int r, int c) {
        if (cnt == 81) {
            printMat();
            System.exit(0);
        }

        while(mat[r][c] != 0 && r < 9) {
            c++;
            if (c == 9) {
                r++;
                c = 0;
            }
        }

        for (int i = 1 ; i <= 9 ; i++) {
            if (valid(r, c, i)) {
                mat[r][c] = i;
                back(cnt + 1, r, c);
                mat[r][c] = 0;
            }
        }

    }

    public static boolean valid(int r, int c, int number) {

        for (int i = 0 ; i < 9 ; i++) {
            if (mat[r][i] == number || mat[i][c] == number) return false;
        }

        int R = (r / 3) * 3;
        int C = (c / 3) * 3;

        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                if (mat[R + i][C + j] == number) return false;
            }
        }

        return true;
    }

    public static void printMat() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                sb.append(mat[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}