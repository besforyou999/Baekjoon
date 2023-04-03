import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static char map[][];
	static boolean visited[][];

	static int dx[] = new int[] { 1, 0, -1, 0 };
	static int dy[] = new int[] { 0, 1, 0, -1 };

	static int n, m;
	static int answer = 0;
	static boolean flag = true;
	static boolean flag2 = true;

	static Queue<int[]> water;
	static Queue<int[]> dochi;

	public static void main(String[] args) throws IOException {
		input();
		while (flag) {
			waterbfs();
			dochibfs();
			if (flag2 == false) {
				System.out.println("KAKTUS");
				return;
			}
		}
		System.out.println(answer);
	}

	public static void waterbfs() {
		int size = water.size();
		while (size-- > 0) {
			int now[] = water.poll();
			for (int i = 0; i < 4; i++) {
				int nexty = now[0] + dy[i];
				int nextx = now[1] + dx[i];
				if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) {
					continue;
				}
				if (visited[nexty][nextx] || map[nexty][nextx] == '*' || map[nexty][nextx] == 'X' || map[nexty][nextx] == 'D') {
					continue;
				}
				visited[nexty][nextx] = true;
				map[nexty][nextx] = '*';
				water.add(new int [] {nexty, nextx});
			}
		}
	}
	
	public static void dochibfs() {
		int size = dochi.size();
		if (size == 0) {
			flag2 = false;
			return;
		}
		while (size-- > 0) {
			int now[] = dochi.poll();
			for (int i = 0; i < 4; i++) {
				int nexty = now[0] + dy[i];
				int nextx = now[1] + dx[i];
				if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) {
					continue;
				}
				if (visited[nexty][nextx] || map[nexty][nextx] == '*' || map[nexty][nextx] == 'X') {
					continue;
				}
				if (map[nexty][nextx] == 'D') {
					flag = false;
					answer = now[2];
					return;
				}
				visited[nexty][nextx] = true;
				dochi.add(new int [] {nexty, nextx, now[2] + 1});
			}
		}
	}

	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		visited = new boolean[n][m];
		
		water = new ArrayDeque<>();
		dochi = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (str.charAt(j) == '*') {
					water.add(new int[] { i, j });
					visited[i][j] = true;
				}
				if (str.charAt(j) == 'S') {
					dochi.add(new int[] { i, j, 1 });
					visited[i][j] = true;
				}
			}
		}

	}

}