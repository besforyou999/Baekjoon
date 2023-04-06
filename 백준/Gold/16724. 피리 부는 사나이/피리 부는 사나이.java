import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m, flag, count;
	static char map[][];

	static int visited[][];
	static char c[] = new char[] { 'D', 'L', 'U', 'R' };
	static int dy[] = new int[] { 1, 0, -1, 0 };
	static int dx[] = new int[] { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		input();
		count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == 0) {
					flag = 0;
					dfs(i, j);
					if (flag == 1) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}

	public static void dfs(int y, int x) {
		if (visited[y][x] == 1) { // 새로운 사이클
			flag = 1;
			return;
		}
		if (visited[y][x] == -1) { // 기존에 있는 사이클 합류
			flag = -1;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (c[i] == map[y][x]) {
				visited[y][x] = 1;
				dfs(y + dy[i], x + dx[i]);
				visited[y][x] = -1;
			}
		}
	}

	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new int[n][m];
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
	}

}