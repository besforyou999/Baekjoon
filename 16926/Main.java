import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int N, M, R;
    static int [][] mat;

    static int [] dr = {0 , 1, 0, -1};
    static int [] dc = {1 , 0 , -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        mat = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++)
                mat[i][j] = Integer.parseInt(st.nextToken());
        }

        int min = Math.min(N, M);
        int squares = min / 2;

        for (int spin = 0; spin < R ; spin++) {
            int row = N;
            int col = M;
            for (int i = 0; i < squares; i++) {
                int r = i;
                int c = i;

                int tmp = mat[r][c];
                int idx = 0;

                while (idx < 4) {
                    int nr = r + dr[idx];
                    int nc = c + dc[idx];

                    if (nr >= i && nc >= i && nr < N - i && nc < M - i) {
                        mat[r][c] = mat[nr][nc];
                        r = nr;
                        c = nc;
                    } else
                        idx++;
                }
                mat[i + 1][i] = tmp;
            }
        }
        printMat();
    }

    static void printMat() {
        StringBuilder sb = new StringBuilder();

        for (int r = 0 ; r < N ; r++) {
            for (int c = 0 ; c < M ; c++)
                sb.append(mat[r][c]).append(" ");
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
