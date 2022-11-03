import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int mat[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        mat = new int[N + 1][N + 1];

        for (int i = 1 ; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j < N + 1 ; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // k : 거쳐가는 노드
        for (int k = 1 ; k < N + 1 ; k++) {
            // i : 출발 노드
            for (int i = 1 ; i < N + 1 ; i++) {
                // j : 도착 노드
                for (int j = 1 ; j < N + 1 ; j++) {
                    if (mat[i][k] == 1 && mat[k][j] == 1) {
                        mat[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1 ; i < N + 1; i++) {
            for (int j = 1 ; j < N + 1 ; j++) {
                if (mat[i][j] == 0) {
                    sb.append(0).append(' ');
                } else if (mat[i][j] > 0) {
                    sb.append(1).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);

    }
}

