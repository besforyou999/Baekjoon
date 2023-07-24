import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, INF = 1_000_000;

    static char [][] map;
    static int [][] mat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N + 1][N + 1];
        mat = new int[N + 1][N + 1];

        for (int r = 1 ; r < N + 1 ; r++) {
            String line = br.readLine();
            for (int c = 1 ; c < N + 1 ; c++) {
                map[r][c] = line.charAt(c - 1);
                if (map[r][c] == 'Y') {
                    mat[r][c] = 1;
                } else if (r != c) {
                    mat[r][c] = INF;
                }
            }
        }

        for (int k = 1 ; k < N + 1 ; k++) {
            for (int i = 1 ; i < N + 1 ; i++) {
                for (int j = 1 ; j < N + 1 ; j++) {
                    if (mat[i][j] > mat[i][k] + mat[k][j]) {
                        mat[i][j] = mat[i][k] + mat[k][j];
                    }
                }
            }
        }

        int ans = -1;

        for (int r = 1  ; r < N + 1 ; r++) {
            int tmp = 0;
            for (int c = 1 ; c < N + 1 ; c++) {
                if (r == c) continue;
                else if (mat[r][c] <= 2) {
                    tmp++;
                }
            }

            ans = Math.max(ans, tmp);
        }

        System.out.println(ans);
    }
}