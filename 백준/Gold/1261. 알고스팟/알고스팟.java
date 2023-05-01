import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N;
    static int mat[][];
    static boolean visit[][];

    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        mat = new int[N][M];
        visit = new boolean[N][M];

        for (int r = 0 ; r < N ; r++) {
            String tk[] = br.readLine().split("");
            for (int m = 0 ; m < M ; m++) {
                mat[r][m] = Integer.parseInt(tk[m]);
            }
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });
        queue.add(new int[] {0, 0, 0});



        visit[0][0] = true;
        int ans = 0;

        while(!queue.isEmpty()) {
            int [] coord = queue.poll();
            int r = coord[0];
            int c = coord[1];
            int cnt = coord[2];

            if (r == N - 1 && c == M - 1) {
                ans = cnt;
                break;
            }
            for (int i = 0 ; i < 4 ; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (isIn(nr, nc) && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    if (mat[nr][nc] == 0) {
                        queue.add(new int[] {nr, nc, cnt});
                    } else if (mat[nr][nc] == 1) {
                        queue.add(new int[]{nr, nc, cnt + 1});
                    }
                }
            }
        }

        System.out.println(ans);


    }

    static boolean isIn(int r, int c) {
        return (r >= 0 && r < N && c >= 0 && c < M);
    }
}