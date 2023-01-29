import java.io.*;
import java.util.*;

class TwoBall {
    int rx;
    int ry;
    int bx;
    int by;
    int count;

    public TwoBall(int rx,int ry, int bx, int by, int count) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.count = count;
    }
}

public class Main{

    static int N,M;
    static char[][] map;
    static boolean[][][][] visited;
    static int result = -1;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs(TwoBall twoBall) {
        Queue<TwoBall> q = new LinkedList<>();
        q.offer(twoBall);

        // 빨간 구슬과 파란구슬의 위치 방문 처리
        visited[twoBall.rx][twoBall.ry][twoBall.bx][twoBall.by]= true;

        while (!q.isEmpty()) {
            TwoBall now = q.poll();

            if(now.count > 10) {
                result = -1;
                return;
            }

            if(map[now.bx][now.by] == 'O') {
                continue;
            }

            if(map[now.rx][now.ry] == 'O') {
                result = now.count;
                return;
            }

            for(int i = 0; i < 4; i++) {

                int bx = now.bx;
                int by = now.by;
                while(true) {
                    bx += dx[i];
                    by += dy[i];

                    if(map[bx][by] == 'O') break;

                    else if(map[bx][by] == '#'){
                        bx -= dx[i];
                        by -= dy[i];
                        break;
                    }
                }

                int rx = now.rx;
                int ry = now.ry;
                while(true) {
                    rx += dx[i];
                    ry += dy[i];

                    if(map[rx][ry] == 'O') break;

                    else if(map[rx][ry] == '#'){
                        rx -= dx[i];
                        ry -= dy[i];
                        break;
                    }
                }

                if(bx == rx && by == ry && map[rx][ry] != 'O') {

                    int r_dis = Math.abs(now.rx - rx) + Math.abs(now.ry - ry);
                    int b_dis = Math.abs(now.bx - bx) + Math.abs(now.by - by);

                    if(r_dis > b_dis) {
                        rx -= dx[i];
                        ry -= dy[i];
                    }
                    else {
                        bx -= dx[i];
                        by -= dy[i];
                    }
                }

                if(!visited[rx][ry][bx][by]) {
                    visited[rx][ry][bx][by] = true;
                    q.offer(new TwoBall(rx, ry, bx, by, now.count + 1));
                }
            }

        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map= new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for(int i = 0; i < N; i++) {
            String row = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j);
                if(map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
                else if(map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }
        bfs(new TwoBall(rx, ry, bx, by,0));
        System.out.println(result);
    }
}
