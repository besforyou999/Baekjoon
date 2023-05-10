import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] mat;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        mat = new int[N + 1][N + 1];

        for (int r = 0 ; r < N ; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0 ; c < N ; c++) {
                mat[r + 1][c + 1] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 1 ; k <= N ; k++) {
            for (int i = 1 ; i <= N ; i++) {
                for (int j = 1 ; j <= N ; j++) {
                    if (mat[i][k] == 1 && mat[k][j] == 1) {
                        mat[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                sb.append(mat[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}