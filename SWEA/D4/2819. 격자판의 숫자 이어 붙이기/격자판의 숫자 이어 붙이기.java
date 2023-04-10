import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    static HashSet<String> hashSet;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1 ; test_case <= T ; test_case++) {
            hashSet = new HashSet<>();
            int mat[][] = new int[4][4];

            for (int r = 0 ; r < 4 ; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0 ; c < 4 ; c++) {
                    mat[r][c] = Integer.parseInt(st.nextToken());
                }
            }


            for (int r = 0 ; r < 4 ; r++)
                for (int c = 0 ; c < 4 ; c++)
                    dfs(mat, r, c, 0, "");

            sb.append("#").append(test_case).append(" ").append(hashSet.size()).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int mat[][], int r, int c, int depth, String output) {
        if (depth == 7) {
            hashSet.add(output);
            return;
        }

        for (int i = 0 ; i < 4 ; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (isIn(nr, nc)) {
                dfs(mat, nr, nc, depth + 1, output + mat[r][c]);
            }
        }
    }

    static boolean isIn(int r, int c) {
        return (r >= 0 && r < 4 && c >= 0 && c < 4);
    }
}