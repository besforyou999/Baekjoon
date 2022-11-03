import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int mat[][];
    static final int INF = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        mat = new int[n + 1][n + 1];
        for (int i = 0 ; i < n + 1 ; i++) {
            for (int j = 0 ; j < n + 1 ; j++) {
                mat[i][j] = INF;
                if (i == j) {
                    mat[i][j] = 0;
                }
            }
        }

        for (int i = 0 ; i < m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (c < mat[a][b])
                mat[a][b] = c;
        }

        // K : 경유
        for (int k = 1 ; k <= n ; k++) {
            // i : 시작
            for (int i = 1 ; i <= n ; i++) {
                // j : 도착
                for (int j = 1 ; j <= n ; j++) {
                    if (mat[i][k] + mat[k][j] < mat[i][j]) {
                        mat[i][j] = mat[i][k] + mat[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                if (mat[i][j] == INF) {
                    sb.append(0).append(' ');
                } else {
                    sb.append(mat[i][j]).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}

