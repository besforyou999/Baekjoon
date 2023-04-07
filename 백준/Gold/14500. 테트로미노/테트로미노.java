import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int mat[][];

    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mat = new int[N][M];

        for (int n = 0 ; n < N ; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0 ; m < M ; m++) {
                mat[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        searchSquare();
        searchStick();
        searchPurpleStick();
        searchGreenStick();
        searchLStick();

        System.out.print(ans);
    }

    static void searchSquare() {
        for (int r = 0 ; r <= N - 2 ; r++) {
            for (int c = 0 ; c <= M - 2 ; c++) {
                int tmp = mat[r][c] + mat[r+1][c] + mat[r][c+1] + mat[r+1][c+1];
                ans = Math.max(ans, tmp);
            }
        }
    }

    static void searchStick() {
        // 세로 막대기
        for (int r = 0 ; r <= N - 4 ; r++) {
            for (int c = 0 ; c <= M - 1 ; c++) {
                int tmp = mat[r][c] + mat[r+1][c] + mat[r+2][c] + mat[r+3][c];
                ans = Math.max(ans, tmp);
            }
        }

        // 가로 막대기
        for (int r = 0 ; r <= N - 1 ; r++) {
            for (int c = 0 ; c <= M - 4 ; c++) {
                int tmp = mat[r][c] + mat[r][c + 1] + mat[r][c + 2] + mat[r][c + 3];
                ans = Math.max(ans, tmp);
            }
        }

    }

    static void searchLStick() {

        for (int r = 0 ; r <= N - 3 ; r++) {
            for (int c = 0 ; c <= M - 2 ; c++) {
                int tmp = mat[r][c] + mat[r+1][c] + mat[r+2][c] + mat[r+2][c + 1];
                ans = Math.max(ans, tmp);
                tmp = mat[r][c+1] + mat[r+1][c+1] + mat[r+2][c+1] + mat[r+2][c];
                ans = Math.max(ans, tmp);
                tmp = mat[r][c] + mat[r][c + 1] + mat[r + 1][c + 1] + mat[r + 2][c + 1];
                ans = Math.max(ans, tmp);
                tmp = mat[r][c] + mat[r][c+1] + mat[r+1][c] + mat[r+2][c];
                ans = Math.max(ans, tmp);
            }
        }

        for (int r = 0 ; r <= N - 2 ; r++) {
            for (int c = 0 ; c <= M - 3 ; c++) {
                int tmp = mat[r][c] + mat[r+1][c] + mat[r][c + 1] + mat[r][c + 2];
                ans = Math.max(ans, tmp);
                tmp = mat[r][c] + mat[r][c+1] + mat[r][c+2] + mat[r+1][c+2];
                ans = Math.max(ans, tmp);
                tmp = mat[r + 1][c] + mat[r + 1][c + 1] + mat[r + 1][c + 2] + mat[r][c + 2];
                ans = Math.max(ans, tmp);
                tmp = mat[r][c] + mat[r+1][c] + mat[r+1][c+1] + mat[r+1][c+2];
                ans = Math.max(ans, tmp);
            }
        }

    }

    static void searchGreenStick() {
        // 세로
        for (int r = 0 ; r <= N - 3 ; r++) {
            for (int c = 0 ; c <= M - 2 ; c++) {
                int tmp = mat[r][c] + mat[r+1][c] + mat[r+1][c+1] + mat[r+2][c+1];
                ans = Math.max(ans, tmp);
                tmp = mat[r][c+1] + mat[r+1][c+1] + mat[r+1][c] + mat[r+2][c];
                ans = Math.max(ans, tmp);
            }
        }
        // 가로
        for (int r = 0 ; r <= N - 2 ; r++) {
            for (int c = 0 ; c <= M - 3 ; c++) {
                int tmp = mat[r][c] + mat[r][c+1] + mat[r+1][c+1] + mat[r+1][c+2];
                ans = Math.max(ans, tmp);
                tmp = mat[r+1][c] + mat[r+1][c+1] + mat[r][c+1] + mat[r][c+2];
                ans = Math.max(ans, tmp);
            }
        }
    }

    static void searchPurpleStick() {
        // 옆으로 눕힌 상태
        for (int r = 0 ; r <= N - 2 ; r++) {
            for (int c = 0 ; c <= M - 3 ; c++) {
                int tmp = mat[r][c] + mat[r][c+1] + mat[r][c+2] + mat[r+1][c+1];
                ans = Math.max(ans, tmp);
                tmp = mat[r+1][c] + mat[r+1][c+1] + mat[r+1][c+2] + mat[r][c+1];
                ans = Math.max(ans, tmp);
            }
        }

        // 세로3칸, 가로 2칸
        for (int r = 0 ; r <= N - 3 ; r++) {
            for (int c = 0 ; c <= M - 2 ; c++) {
                int tmp = mat[r][c] + mat[r+1][c] + mat[r+2][c] + mat[r+1][c+1];
                ans = Math.max(ans, tmp);
                tmp = mat[r][c+1] + mat[r+1][c] + mat[r+1][c+1] + mat[r+2][c+1];
                ans = Math.max(ans, tmp);
            }
        }
    }



}