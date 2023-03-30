import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int map[][];
	static ArrayList<int[]> list;

	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		input();
		dfs(0);
		System.out.println(sb);
	}

	public static void dfs(int depth) {
		if (depth == list.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			flag = true;
			return;
		}
		if (flag) {
			return;
		}
		boolean visited[] = new boolean[9 + 1];
		int cur[] = list.get(depth);

		for (int i = 0; i < 9; i++) { // 가로
			visited[map[cur[0]][i]] = true;
		}

		for (int i = 0; i < 9; i++) { // 세로
			visited[map[i][cur[1]]] = true;
		}

		int y = cur[0] / 3 * 3;
		int x = cur[1] / 3 * 3;

		for (int i = y; i < y + 3; i++) { // 네모 0 3 6
			for (int j = x; j < x + 3; j++) {
				visited[map[i][j]] = true;
			}
		}

		for (int i = 1; i <= 9; i++) { // 방문안된거 후보 ㄱ
			if (!visited[i]) {
				map[cur[0]][cur[1]] = i;
				dfs(depth + 1);
				map[cur[0]][cur[1]] = 0;
			}
		}
	}

	public static void input() throws IOException {
		map = new int[9][9];
		list = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				int temp = str.charAt(j) - 48;
				map[i][j] = temp;
				if (temp == 0) {
					list.add(new int[] { i, j });
				}
			}
		}
	}
}
