import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;

    static char mat[][];
    static boolean visit[][];
    static int [] dr = {-1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        mat = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0 ; i < R ; i++) {
            String line = br.readLine();
            for (int j = 0 ; j < C ; j++)
                mat[i][j] = line.charAt(j);
        }

        int cnt = 0;
        for (int r = 0 ; r < R ; r++) {
            if (mat[r][0] == '.')
                if (rec(r, 0))
                    cnt += 1;
        }
        System.out.print(cnt);
    }

    static boolean rec(int r, int c) {
        if (c == C - 1) return true;

        for (int i = 0 ; i < dr.length ; i++) {
            int nr = r + dr[i];
            if (nr >= 0 && nr < R) {
                if (!visit[nr][c + 1] && mat[nr][c+1] == '.') {
                    visit[nr][c + 1] = true;
                    if(rec(nr , c + 1))
                        return true;
                }
            }
        }
        return false;
    }

}
