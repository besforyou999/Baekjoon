import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int map[][];
	static boolean visited[][][];
	static int n, m;
	static int sx, sy, ex, ey;
	static int dy[] = new int[] { 1, 0, -1, 0 };
	static int dx[] = new int[] { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws IOException {
		input();
		bfs();
		if (!flag) {
			System.out.println(-1);
		}
//		if (map[ey][ex] == 1 || map[ey][ex] == 0) {
//			System.out.println(-1);
//		} else {
//			System.out.println(map[ey][ex] * - 1 - 1);
//		}
	}
	static boolean flag = false;
	
	public static void bfs() {
		Queue<int[]> qu = new ArrayDeque<>();
		if (map[sy][sx] == 1) {
			qu.add(new int[] {sy,sx, 1, 0});
		} else {
			qu.add(new int[] {sy,sx, 0, 0});
		}
		visited[sy][sx][0] = true;
		while (!qu.isEmpty()) {
			int size = qu.size();
			while (size-- > 0) {
				int now[] = qu.poll();
				if (now[0] == ey && now[1] == ex) {
					System.out.println(now[3]);
					flag = true;
					return;
				}
				for (int i = 0; i < 4; i++) {
					int nexty = now[0] + dy[i];
					int nextx = now[1] + dx[i];
					if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) {
						continue;
					}
					if (map[nexty][nextx] == 1) {
						if (now[2] == 1) {
							continue;
						} else {
							if (visited[nexty][nextx][now[2] + 1]) {
								continue;
							}
							visited[nexty][nextx][now[2] + 1] = true;
							qu.add(new int [] {nexty, nextx, now[2] + 1, now[3] + 1});
						}
					} else if (map[nexty][nextx] == 0) {
						if (visited[nexty][nextx][now[2]]) {
							continue;
						}
						visited[nexty][nextx][now[2]] = true;
						qu.add(new int [] {nexty, nextx, now[2], now[3] + 1});
					}
				}
			}
		}
	}
	
	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		sy = Integer.parseInt(st.nextToken()) - 1;
		sx = Integer.parseInt(st.nextToken()) - 1;
		st = new StringTokenizer(br.readLine());
		ey = Integer.parseInt(st.nextToken()) - 1;
		ex = Integer.parseInt(st.nextToken()) - 1;
		visited = new boolean [n][m][2];
		map = new int [n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}