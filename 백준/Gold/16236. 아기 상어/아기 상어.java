import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [키워드]
 * N x N 크기 공간, 어디로 이동할지 결정 - 그래프 탐색, 시뮬레이션
 *
 * [풀이과정]
 * 1. 먹을 수 있는 물고리 탐색 ( 덩치가 작은 물고기들만 추리고 아기 상어가 해당 물고기 위치에 갈 수 있는지 판단해야함
 * 2. 해당 물고기로 가는데 걸리는 시간 다 기록
 * 3. 전부 -1 나오면 못 간다는 의미이므로 종료
 * 4. 최단 경로 물고기만 골라냄
 * 5. 1 마리면 해당 물고기 먹기
 * 6. 다수라면 가장 위, 가장 왼쪽의 물고기 선택
 * 7. 해당 물고기 먹고, 아기상어가 물고리를 자기 크기만큼 먹었다면 덩치 + 1
 * [입력]
 * 공간의 크기 N (2 <= N <= 20)
 * 둘째 줄부터 N개의 줄에 공간의 상태
 * 0, 1, 2, 3, 4, 5, 6, 9
 * 0 : 빈칸
 * 1 ~ 6 : 물고기 크기
 * 9 : 아기 상어 위치
 * 아기상어는 한 마리
 * [출력]
 * 아기 상어 혼자서 물고리를 잡아먹을 수 있는 시간 출력
 * @author besforyou
 * @see https://www.acmicpc.net/problem/16236
 * @performance 292,912 KB, 612ms
 * @category #그래프, #BFS, #시뮬레이션
 */

class Fish {
    int r, c, size;
    Fish(int r, int c, int size) {
        this.r = r;
        this.c = c;
        this.size = size;
    }
}

class Shark extends Fish {
    int fishEaten = 0;
    Shark(int r, int c, int size, int eaten) {
        super(r, c, size);
        this.fishEaten = eaten;
    }

    public void eatFish() {
        fishEaten += 1;
        if (fishEaten == size) {
            fishEaten = 0;
            size += 1;
        }
    }
}

public class Main {
    static int N;
    static int [][] mat;
    static boolean [][] visited; // bfs 용

    static Shark shark;

    static int seconds = 0;

    static int dr [] = {-1, 1, 0 ,0};
    static int dc [] = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        mat = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 9) {
                    shark = new Shark(i, j, 2, 0);
                }
                mat[i][j] = val;
            }
        }

        simulation();
        System.out.println(seconds);
    }

    static void simulation() {

        for (int loop = 0 ; loop < 500 ; loop++) {

            ArrayList<Fish> fishesToEat = getFishesToEat(); // 아기 상어보다 덩치 작은 물고기만 가져옴
            int numberOfFishesToEat = fishesToEat.size();
            if (numberOfFishesToEat == 0) break; // 아기 상어보다 덩치 작은 물고기가 없음

            int distance[] = new int[numberOfFishesToEat];
            int canReach = 0;
            int minimumDistance = Integer.MAX_VALUE;

            for (int i = 0 ; i < numberOfFishesToEat ; i++) {
                int dist = getMovementCnt(fishesToEat.get(i));
                distance[i] = dist;
                if (dist != -1) {
                    canReach++;
                    minimumDistance = Math.min(minimumDistance, dist);
                }
            }

            if (canReach == 0) break; // 먹을 수 있는 물고기는 있는데 해당 위치로 갈 수가 없음

            ArrayList<Fish> minDistanceFishes = new ArrayList<>();

            for (int i = 0 ; i < distance.length ; i++) {
                if (distance[i] == minimumDistance) minDistanceFishes.add(fishesToEat.get(i));
            }

            if (minDistanceFishes.size() == 1) { // 최단 경로 물고기가 한 마리면 그 물고기 먹음
                Fish fish = minDistanceFishes.get(0);
                eatFish(fish, minimumDistance); // 상어 덩치 키우고, 상어 위치 바꾸고, 공간 상태 변경
            } else { // 최단 경로 물고기가 다수라면 제일 가까운 물고기 고르기

                Collections.sort(minDistanceFishes, new Comparator<Fish>() { // 제일 위 먼저
                    @Override
                    public int compare(Fish o1, Fish o2) {
                        return o1.r - o2.r;
                    }
                });

                int topRow = minDistanceFishes.get(0).r;
                ArrayList<Fish> topRowFishes = new ArrayList<>();

                for (int i = 0 ; i < minDistanceFishes.size() ; i++) {
                    Fish fish = minDistanceFishes.get(i);
                    if (fish.r == topRow) {
                        topRowFishes.add(fish);
                    }
                }

                if (topRowFishes.size() == 1) { // 제일 위 물고기가 한 마리라면 그 물고기 먹기
                    Fish fish = topRowFishes.get(0);
                    eatFish(fish, minimumDistance);
                    continue;
                }

                Collections.sort(topRowFishes, new Comparator<Fish>() {
                    @Override
                    public int compare(Fish o1, Fish o2) {
                        return o1.c - o2.c;
                    }
                });

                Fish fish = topRowFishes.get(0);
                eatFish(fish, minimumDistance);
            }

        }


    }

    static void eatFish(Fish fish, int distance) {
        shark.eatFish();
        mat[shark.r][shark.c] = 0;
        mat[fish.r][fish.c] = 9;
        shark.r = fish.r;
        shark.c = fish.c;
        seconds += distance;
    }

    static ArrayList<Fish> getFishesToEat() {
        ArrayList<Fish> fishes = new ArrayList<>();
        for (int r = 0 ; r < N ; r++) {
            for (int c = 0 ; c < N ; c++) {
                int val = mat[r][c];
                if (val >= 1 && val <= 6 && shark.size > val)
                    fishes.add(new Fish(r, c, val));
            }
        }
        return fishes;
    }

    static void resetVisited() {
        for (int r = 0 ; r < N ; r++)
            for (int c = 0; c < N ; c++)
                visited[r][c] = false;
    }

    static int getMovementCnt(Fish target) {
        resetVisited();
        visited[shark.r][shark.c] = true;
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {shark.r, shark.c, 0});

        while(!queue.isEmpty()) {
            int coord [] = queue.poll();
            int r = coord[0];
            int c = coord[1];
            int movement = coord[2];

            if (r == target.r && c == target.c) return movement;

            for (int i = 0 ; i < 4 ; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (isIn(nr, nc) && !visited[nr][nc]) {
                    if (mat[nr][nc] <= shark.size) {
                        visited[nr][nc] = true;
                        queue.add(new int[] {nr, nc, movement + 1});
                    }
                }
            }
        }

        return -1;
    }

    static boolean isIn(int r, int c) {
        return (r >= 0 && r < N && c >= 0 && c < N);
    }

}