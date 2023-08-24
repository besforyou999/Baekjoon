import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int [][] mat;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        mat = new int[101][101];

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int y = r ; y < r + 10 ; y++) {
                for (int x = c ; x < c + 10 ; x++) {
                    mat[y][x] = 1;
                }
            }
        }
        int cnt = 0;
        for (int i = 0 ; i < 101 ; i++) {
            for (int j = 0 ; j < 101 ; j++) {
                if (mat[i][j] == 1) cnt++;
            }
        }

        System.out.println(cnt);
    }
}