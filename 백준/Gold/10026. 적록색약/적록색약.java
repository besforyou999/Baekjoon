import java.io.*;
import java.util.StringTokenizer;

/**
 * [키워드]
 * 그래프 탐색 - bfs
 * 같은 색상이 상하좌우로 인접해 있는 경우 같은 구역  
 * 
 * [풀이과정]
 * 1. 각 위치 방문했는지 안했는지 판별 가능하도록 N * M 2차원 boolean 배열 선언
 * 2. 모든 좌표를 한번씩 참조하여 아직 방문되지 않은 경우 bfs 탐색
 * 3. 처음 방문한 좌표 상하좌우를 참조하여 같은 색상인지 확인 -> 같은 색상인 경우 bfs 탐색
 * 4. bfs 탐색 횟수 = 구역의 개수
 * 5. 적록색약인 사람의 경우, 원본 그림에서 R를 G로만 바꾸어 2,3,4 과정 실행
 * 6. 정답 출력
 *
 * <p>
 * [입력]
 * N x N (1 ≤ N ≤ 100)
 * <p>
 * [출력]
 * 적록색약이 아닌 사람이 봤을 때의 구역 수 , 적록색약인 사람이 봤을 떄의 구역 수
 *
 * @author 주상민
 * @performance 12,860kb, 88ms
 * @category #그래프#bfs
 * @see https://www.acmicpc.net/problem/10026
 */

public class Main {
    static int N;
    static char mat[][];
    static boolean visited[][];
    static int dx [] = {0, 0, -1, 1};
    static int dy [] = {-1, 1, 0 ,0};

    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        mat = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0 ; i < N ; i++) {
            String line = br.readLine();
            for (int j = 0 ; j < N ; j++) {
                mat[i][j] = line.charAt(j);
            }
        }

        Integer red_group = 0;
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (visited[i][j] == false) {
                    DFS(new int[]{i, j});
                    red_group += 1;
                }
            }
        }

        reset_visited();
        flip_color();

        Integer group = 0;
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (visited[i][j] == true) continue;
                DFS(new int[] {i, j});
                group += 1;
            }
        }
        System.out.print(red_group + " " + group);
    }

    public static void reset_visited() {
        visited = new boolean[N][N];
    }

    public static void flip_color() {
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                if (mat[i][j] == 'R') mat[i][j] = 'G';
            }
        }
    }

    public static void DFS(int [] point) {
        int y = point[0];
        int x = point[1];

        visited[y][x] = true;

        for (int i = 0 ; i < 4 ; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || mat[ny][nx] != mat[y][x]) continue;
            DFS(new int[] {ny, nx});
        }
    }

}