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

	static int c, n, m;
	static int map[][];
	static boolean visited[][][];
	
	static int dx[] = new int[] {1, 0, -1, 0};
	static int dy[] = new int[] {0, 1, 0, -1};
	static int hx[] = new int[] {2, 1, -1, -2, -2, -1, 1, 2};
	static int hy[] = new int[] {1, 2, 2, 1, -1, -2, -2, -1};
	
	static boolean flag = true;
	
	
	public static void main(String[] args) throws IOException {
		input();
		bfs();
		if (flag) {
			System.out.println("-1");
		}
	}
	
	public static void bfs() {
		Queue<Node> qu = new ArrayDeque<>();
		qu.add(new Node(0, 0, 0, 0));
		while(!qu.isEmpty()) {
			Node now = qu.poll();
			int nextx, nexty;
			if (now.limit == c + 1) {
				continue;
			}
			if (now.y == n - 1 && now.x == m - 1) {
				System.out.println(now.count);
				flag = false;
				return;
			}
			for (int i = 0; i < 4; i++) {
				nexty = dy[i] + now.y;
				nextx = dx[i] + now.x;
				if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) {
					continue;
				}
				if (map[nexty][nextx] == 1) {
					continue;
				}
				if (visited[nexty][nextx][now.limit]) {
					continue;
				}
				visited[nexty][nextx][now.limit] = true;
				qu.add(new Node(nexty, nextx, now.limit, now.count + 1));
			}
			
			for (int i = 0; i < 8; i++) {
				nexty = hy[i] + now.y;
				nextx = hx[i] + now.x;
				if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1 || now.limit == c) {
					continue;
				}
				if (map[nexty][nextx] == 1) {
					continue;
				}
				if (visited[nexty][nextx][now.limit + 1]) {
					continue;
				}
				visited[nexty][nextx][now.limit + 1] = true;
				qu.add(new Node(nexty, nextx, now.limit + 1, now.count + 1));
			}
		}
	}
	
	public static void input() throws IOException {
		c = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m][c + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}

class Node {
	int y;
	int x;
	int limit;
	int count;
	
	public Node(int y, int x, int limit, int count) {
		super();
		this.y = y;
		this.x = x;
		this.limit = limit;
		this.count = count;
	}
	
}
