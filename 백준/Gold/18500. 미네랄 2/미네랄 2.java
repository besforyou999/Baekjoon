import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m, c, xcount, findxcount;
	static char map[][];
	static boolean visited[][];
	
	static int dx[] = new int[] {1, 0, -1, 0};
	static int dy[] = new int[] {0, 1, 0, -1};
	
	static PriorityQueue<int[]> keepqu;
	static PriorityQueue<int[]> mapupdate;

	public static void main(String[] args) throws IOException {
		input();
		c = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= c; i++) {
			if (i % 2 == 1) {
				destroy(true);
			} else {
				destroy(false);
			}
			gravity();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void destroy(boolean flag) {
		int floor = n - Integer.parseInt(st.nextToken());
		if (flag) {
			for (int i = 0; i < m; i++) {
				if (map[floor][i] == 'x') {
					map[floor][i] = '.';
					xcount--;
					return;
				}
			}
		} else {
			for (int i = m - 1; i >= 0; i--) {
				if (map[floor][i] == 'x') {
					map[floor][i] = '.';
					xcount--;
					return;
				}
			}
		}
	}
	
	public static void gravity() {
		if (!find_xcount()) {
			go_gravity();
		}
	}
	
	public static boolean find_xcount() {
		visited = new boolean[n][m];
		findxcount = 0;
		for (int i = 0; i < m; i++) {
			if (map[n - 1][i] == 'x' && !visited[n - 1][i]) {
				bfs(n - 1, i);
				if (findxcount == xcount) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void bfs(int y, int x) {
		Queue<int[]> qu = new ArrayDeque<>();
		qu.add(new int [] {y, x});
		visited[y][x] = true;
		findxcount++;
		while (!qu.isEmpty()) {
			int now[] = qu.poll();
			int nexty,nextx;
			for (int i = 0; i < 4; i++) {
				nexty = now[0] + dy[i];
				nextx = now[1] + dx[i];
				if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) {
					continue;
				}
				if (visited[nexty][nextx] || map[nexty][nextx] == '.') {
					continue;
				}
				visited[nexty][nextx] = true;
				qu.add(new int [] {nexty, nextx});
				findxcount++;
			}
		}
	}

	public static void go_gravity() {
		keepqu = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
		mapupdate = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] == 'x') {
					bfsdown(i, j);
				}
			}
		}
		char tempmap[][] = new char [n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tempmap[i][j] = map[i][j];
			}
		}
		
		loop : while (!keepqu.isEmpty()) {
			PriorityQueue<int[]> keep2 = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
			int size = keepqu.size();
			while (size-- > 0) {
				int now[] = keepqu.poll();
				if (now[0] == n - 1 || tempmap[now[0] + 1][now[1]] == 'x') {
					break loop;
				}
				tempmap[now[0]][now[1]] = '.';
				tempmap[now[0] + 1][now[1]] = 'x';
				keep2.add(new int [] {now[0] + 1, now[1]});
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = tempmap[i][j];
				}
			}
			keepqu = keep2;
		}
	}

	public static void bfsdown(int y, int x) {
		visited[y][x] = true;
		Queue<int[]> qu = new ArrayDeque<>();
		keepqu.add(new int[] {y,x});
		qu.add(new int[] {y, x});
		while (!qu.isEmpty()) {
			int now[] = qu.poll();
			int nexty,nextx;
			for (int i = 0; i < 4; i++) {
				nexty = now[0] + dy[i];
				nextx = now[1] + dx[i];
				if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) {
					continue;
				}
				if (visited[nexty][nextx] || map[nexty][nextx] == '.') {
					continue;
				}
				visited[nexty][nextx] = true;
				qu.add(new int [] {nexty, nextx});
				keepqu.add(new int[] {nexty, nextx});
			}
		}
	}
	
	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		xcount = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (str.charAt(j) == 'x') {
					xcount++;
				}
			}
		}
	}

}