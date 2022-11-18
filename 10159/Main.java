import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean [][] check = new boolean[N + 1][N + 1];

        for (int i = 0 ; i < M ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            check[one][two] = true;
        }

        for (int k = 1 ; k < N + 1 ; k++) {
            for (int i = 1 ; i < N + 1 ; i++) {
                for (int j = 1 ; j < N + 1 ; j++) {
                    if (check[i][k] && check[k][j])
                        check[i][j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1 ; i <= N ; i++) {
            int cnt = 0;
            for (int j = 1 ; j <= N ; j++) {
                if (i == j) continue;
                if (!check[i][j] && !check[j][i]) cnt += 1;
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}


