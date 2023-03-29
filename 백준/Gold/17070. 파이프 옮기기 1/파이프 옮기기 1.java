import java.io.*;
import java.util.*;

public class Main {
    static int mat[][];
    static Integer N;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        mat = new int[N+1][N+1];
        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                mat[i+1][j+1] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(1, 2, 0);
        System.out.print(ans);
    }
    /*
        0 : horizontal
        1 : vertical
        2 : diag
    */
    public static void DFS (int y, int x, int direction) {
        if (y == N && x == N) {
            ans += 1;
            return;
        }

        switch (direction) {
            case 0: {
                if (x + 1 <= N && mat[y][x + 1] == 0) {
                    DFS(y, x + 1, 0);
                }
                break;
            }
            case 1: {
                if (y + 1 <= N && mat[y + 1][x] == 0) {
                    DFS(y + 1, x, 1);
                }
                break;
            }
            case 2: {
                if (x + 1 <= N && mat[y][x + 1] == 0) {
                    DFS(y, x + 1, 0);
                }
                if (y + 1 <= N && mat[y + 1][x] == 0) {
                    DFS(y + 1, x, 1);
                }
                break;
            }
        }

        if (x + 1 <= N && y + 1 <= N && mat[y][x+1] == 0 && mat[y+1][x+1] == 0 && mat[y+1][x] == 0) {
            DFS(y + 1, x + 1, 2);
        }
    }
}