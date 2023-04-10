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
	static char map2[][];
	static int n, m, k;
	static Queue<int[]> qu;

	static int dy[] = new int[] { 0, 1, 0, -1 };
	static int dx[] = new int[] { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		input();
		if (k == 1) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		} else if (k % 4 == 1) {
			find();
			find2();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					sb.append(map3[i][j]);
				}
				sb.append("\n");
			}
			// 2 4 6 8 ... 꽉참 // 1 5 9 13 ... 입력그대로 // 3 7 11 15 ... 터짐
		} else if (k % 4 == 3) {
			find();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					sb.append(map2[i][j]);
				}
				sb.append("\n");
			}
		} else if (k % 2 == 0) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					sb.append("O");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	public static void find() {
		while (!qu.isEmpty()) {
			int now[] = qu.poll();
			map2[now[0]][now[1]] = '.';
			for (int i = 0; i < 4; i++) {
				int nexty = now[0] + dy[i];
				int nextx = now[1] + dx[i];
				if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) {
					continue;
				}
				map2[nexty][nextx] = '.';
			}
		}
	}

	static char map3[][];

	public static void find2() {
		map3 = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map2[i][j] == 'O') {
					qu.add(new int[] { i, j });
				}
				map3[i][j] = 'O';
			}
		}
		while (!qu.isEmpty()) {
			int now[] = qu.poll();
			map3[now[0]][now[1]] = '.';
			for (int i = 0; i < 4; i++) {
				int nexty = now[0] + dy[i];
				int nextx = now[1] + dx[i];
				if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) {
					continue;
				}
				map3[nexty][nextx] = '.';
			}
		}
	}

	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		map2 = new char[n][m];
		qu = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				map2[i][j] = 'O';
				if (str.charAt(j) == 'O') {
					qu.add(new int[] { i, j });
				}
			}
		}

	}
}