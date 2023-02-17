import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1 ; test_case <= T ; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int [][] mat = new int[N + 1][N + 1];

            for (int i = 1 ; i <= N ; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1 ; j <= N ; j++) {
                    mat[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0 ; i < M ; i++) {
                st = new StringTokenizer(br.readLine());
                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                opertation(mat, r1, c1, r2, c2, v);
            }


            StringBuilder row = new StringBuilder();
            StringBuilder col = new StringBuilder();

            for (int i = 1 ; i <= N ; i++) {
                int rowSum = 0;
                int colSum = 0;
                for (int j = 1 ; j <= N ; j++) {
                    rowSum += mat[i][j];
                    colSum += mat[j][i];
                }
                row.append(rowSum).append(" ");
                col.append(colSum).append(" ");
            }

            System.out.println(row);
            System.out.println(col);
        }

    }

    static void opertation(int [][] mat, int r1, int c1, int r2, int c2, int v) {
        for (int r = r1 ; r <= r2 ; r++) {
            for (int c = c1; c <= c2; c++) {
                mat[r][c] += v;
            }
        }
    }
}