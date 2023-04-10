import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int map[][];
	static int count, min;
	static int c5, c4, c3, c2, c1;

	public static void main(String[] args) throws Exception {
		input();
		dfs(0, 0);
		if (min == 2147483647) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	static boolean flag = false;

	public static void dfs(int subcount, int ans) {
		if (count == subcount) {
			min = Math.min(min, ans);
			return;
		}
		if (c1 < 0 || c2 < 0 || c3 < 0 || c4 < 0 || c5 < 0) {
			return;
		}
		if (min <= ans) {
			return;
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1) {
					if (c5 > 0 && check(i, j, 5)) {
						c5--;
						visit(i, j, 5, 2);
						dfs(subcount + 25, ans + 1);
						visit(i, j, 5, 1);
						c5++;
					}
					if (c4 > 0 && check(i, j, 4)) {
						c4--;
						visit(i, j, 4, 2);
						dfs(subcount + 16, ans + 1);
						visit(i, j, 4, 1);
						c4++;
					}
					if (c3 > 0 && check(i, j, 3)) {
						c3--;
						visit(i, j, 3, 2);
						dfs(subcount + 9, ans + 1);
						visit(i, j, 3, 1);
						c3++;
					}
					if (c2 > 0 && check(i, j, 2)) {
						c2--;
						visit(i, j, 2, 2);
						dfs(subcount + 4, ans + 1);
						visit(i, j, 2, 1);
						c2++;
					}
					if (c1 > 0 && check(i, j, 1)) {
						c1--;
						visit(i, j, 1, 2);
						dfs(subcount + 1, ans + 1);
						visit(i, j, 1, 1);
						c1++;
					}
					return;
				}
			}
		}
	}

	public static boolean check(int y, int x, int c) {
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < c; j++) {
				if (y + i == 10 || x + j == 10) {
					return false;
				}
				if (map[y + i][x + j] == 0 || map[y + i][x + j] == 2) {
					return false;
				}
			}
		}
		return true;
	}

	public static void visit(int y, int x, int c, int recover) {
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < c; j++) {
				map[y + i][x + j] = recover;
			}
		}
	}

	public static void input() throws IOException {
		count = 0;
		map = new int[10][10];
		c5 = 5;
		c4 = 5;
		c3 = 5;
		c2 = 5;
		c1 = 5;
		min = 2147483647;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					count++;
				}
			}
		}
	}
}