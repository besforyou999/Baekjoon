import java.util.*;
import java.io.*;

class Main {
    public static int N, M;
    public static int mat[][];
    public static int INF = 1000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        mat = new int[N + 1][N + 1];

        for (int i = 0 ; i < N + 1 ; i++) {
            for (int j = 0 ; j < N + 1 ; j++) {
                mat[i][j] = INF;
                if (i == j) {
                    mat[i][j] = 0;
                }
            }
        }

        M = Integer.parseInt(st.nextToken());

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            mat[a][b] = mat[b][a] = 1;
        }

        for (int k = 1 ; k <= N ; k++) {
            for (int i = 1 ; i <= N ; i++) {
                for (int j = 1 ; j <= N ; j++) {
                    if (mat[i][k] + mat[k][j] < mat[i][j])
                        mat[i][j] = mat[i][k] + mat[k][j];
                }
            }
        }

        int ans = INF, idx = -1;
        for (int i = 1 ; i < N + 1 ; i++) {
            int sum = 0;
            for (int j = 1 ; j < N + 1 ; j++) {
                if (i == j) continue;
                sum += mat[i][j];
            }
            if (ans > sum) {
                ans = sum;
                idx = i;
            }
        }
        System.out.print(idx);
    }
}


