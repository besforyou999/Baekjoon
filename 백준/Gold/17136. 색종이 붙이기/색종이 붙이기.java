import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 17136
class Point {
    int r, c;
    Point (int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static boolean found = false;
    static int MAX = 1000000;
    static int ANS = MAX, SIZE = 10, oneCnt = 0;
    static int mat[][];
    static int [] papers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        mat = new int[SIZE][SIZE];
        for (int i = 0 ; i < SIZE ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < SIZE ; j++) {
                int val = Integer.parseInt(st.nextToken());
                mat[i][j] = val;
                if (val == 1) oneCnt++;
            }
        }

        papers = new int[6];
        for (int i = 1 ; i <= 5 ; i++) papers[i] = 5;

        back(0, 0, 0);

        if (ANS == MAX) ANS = -1;
        System.out.println(ANS);
    }

    static void back(int r, int c , int cnt) {
        if (c == SIZE) {
            back(r + 1, 0, cnt);
            return;
        }

        if (r == SIZE) {
            ANS = Math.min(ANS, cnt);
            return;
        }

        if (mat[r][c] == 0) {
            back(r, c + 1, cnt);
            return;
        }

        for (int len = 5 ; len >= 1 ; len--) {
            if (papers[len] == 0 || r + len > SIZE || c + len > SIZE) continue;

            // len 길이의 색종이 붙일 공간이 있는지 확인
            boolean available = true;
            for (int i = 0 ; i < len ; i++) {
                for (int j = 0 ; j < len ; j++) {
                    if (mat[r + i][c + j] == 0) {
                        available = false;
                        break;
                    }
                }
                if (!available) break;
            }

            if (!available) continue;

            for (int i = 0 ; i < len ; i++) {
                for (int j = 0 ; j < len ; j++) {
                    mat[r + i][c + j] = 0;
                }
            }

            papers[len]--;
            back(r, c + len, cnt + 1);

            papers[len]++;

            for (int i = 0 ; i < len ; i++) {
                for (int j = 0 ; j < len ; j++) {
                    mat[r + i][c + j] = 1;
                }
            }

        }
    }

}