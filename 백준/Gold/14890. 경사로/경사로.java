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

	static int n, x;
	static int map[][];
	static int count;

	public static void main(String[] args) throws IOException {
		input();
		left_right();
		up_down();
		System.out.println(count);
	}

	public static void left_right() {
		boolean visited[][] = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			boolean c = true;
			loop: for (int j = 0; j < n - 1; j++) {
				int value = map[i][j] - map[i][j + 1];
				if (value == 0 || visited[i][j + 1]) {
					continue;
				} else if (value == 1) { // 내려감
					for (int d = 1; d < x; d++) {
						if (j + 1 + d > n - 1) {
							c = false;
							break loop;
						}
						if (visited[i][j + 1 + d]) {
							c = false;
							break loop;
						}
						if (map[i][j + 1] != map[i][j + 1 + d]) {
							c = false;
							break loop;
						}
					}
					if (visited[i][j + 1] == true) {
						c = false;
						break;
					}
					visited[i][j + 1] = true;
					for (int d = 1; d < x; d++) {
						visited[i][j + 1 + d] = true;
					}
					c = true;
				} else if (value == -1) { // 올라감
					for (int d = 1; d < x; d++) {
						if (j - d < 0) {
							c = false;
							break loop;
						}
						if (visited[i][j - d]) {
							c = false;
							break loop;
						}
						if (map[i][j] != map[i][j - d]) {
							c = false;
							break loop;
						}
					}
					if (visited[i][j] == true) {
						c = false;
						break;
					}
					visited[i][j] = true;
					for (int d = 1; d < x; d++) {
						visited[i][j - d] = true;
					}
					c = true;
				} else {
					c = false;
					break;
				}
			}
			if (c) {
				count++;
			}
		}
	}

	public static void up_down() {
		boolean visited[][] = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			boolean c = true;
			loop: for (int j = 0; j < n - 1; j++) {
				int value = map[j][i] - map[j + 1][i];
				if (value == 0 || visited[j + 1][i]) {
					continue;
				} else if (value == 1) {
					for (int d = 1; d < x; d++) {
						if (j + 1 + d > n - 1) {
							c = false;
							break loop;
						}
						if (visited[j + 1 + d][i]) {
							c = false;
							break loop;
						}
						if (map[j + 1][i] != map[j + 1 + d][i]) {
							c = false;
							break loop;
						}
					}
					if (visited[j + 1][i] == true) {
						c = false;
						break;
					}
					visited[j + 1][i] = true;
					for (int d = 1; d < x; d++) {
						visited[j + 1 + d][i] = true;
					}
					c = true;
				} else if (value == -1) {
					for (int d = 1; d < x; d++) {
						if (j - d < 0) {
							c = false;
							break loop;
						}
						if (visited[j - d][i]) {
							c = false;
							break loop;
						}
						if (map[j][i] != map[j - d][i]) {
							c = false;
							break loop;
						}
					}
					if (visited[j][i] == true) {
						c = false;
						break;
					}
					visited[j][i] = true;
					for (int d = 1; d < x; d++) {
						visited[j - d][i] = true;
					}
					c = true;
				} else {
					c = false;
					break;
				}
			}
			if (c) {
				count++;
			}
		}
	}

	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		count = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}