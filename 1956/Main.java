import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int INF = 10000000;
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int mat [][] = new int[V + 1][V + 1];
        for (int i = 1 ; i <= V ; i++) {
            for (int j = 1 ; j <= V ; j++) {
                if (i != j)
                    mat[i][j] = INF;
            }
        }

        for (int i = 0 ; i < E ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            mat[a][b] = c;
        }

        for (int k = 1 ; k <= V ; k++) {
            for (int i = 1 ; i <= V ; i++) {
                for (int j = 1 ; j <= V ; j++) {
                    if (i == j)
                        continue;
                    if (mat[i][k] + mat[k][j] < mat[i][j])
                        mat[i][j] = mat[i][k] + mat[k][j];
                }
            }
        }

        int ans = INF;
        for (int i = 1 ; i <= V ; i++) {
            for (int j = 1 ; j <= V ; j++) {
                if (i == j) continue;
                if (mat[i][j] != INF && mat[j][i] != INF) {
                    if (ans > mat[i][j] + mat[j][i])
                        ans = mat[i][j] + mat[j][i];
                }
            }
        }

        if (ans == INF) ans = -1;
        System.out.print(ans);
    }
}


