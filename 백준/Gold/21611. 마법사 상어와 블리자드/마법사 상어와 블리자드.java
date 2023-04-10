import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class marble {
	int y;
	int x;

	public marble(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, m, d, s;
	static int map[][];
	static int dx[] = new int[] { 0, 0, -1, 1 };
	static int dy[] = new int[] { -1, 1, 0, 0 };
	static int snaildy[] = new int[] { 1, 0, -1, 0 };
	static int snaildx[] = new int[] { 0, -1, 0, 1 };
	static int rsnaildx[] = new int[] { -1, 0, 1, 0 };
	static int rsnaildy[] = new int[] { 0, 1, 0, -1 };
	static int sx, sy, index, flag, sum;
	static Queue<marble> qu;
	static ArrayList<Integer> list;
	static ArrayList<Integer> mapMaker;

	public static void shot(int d, int s) {
		while (!qu.isEmpty()) {
			marble now = qu.poll();
			if (s-- <= 0) {
				break;
			}
			int nexty = now.y + dy[d];
			int nextx = now.x + dx[d];
			map[nexty][nextx] = 0;
			qu.add(new marble(nexty, nextx));
		}
	}

	public static void moveSnail(int dir, int count) {
		for (int i = 0; i < count; i++) {
			marble now = qu.poll();
			int nexty = now.y + snaildy[dir];
			int nextx = now.x + snaildx[dir];
			qu.add(new marble(nexty, nextx));
			if (map[nexty][nextx] != 0 && map[nexty][nextx] != -1) {
				list.add(map[nexty][nextx]);
			}
		}
	}

	public static void snail() {
		for (int i = 0; i < n; i++) {
			if (map[0][i] != 0) {
				list.add(map[0][i]);
			}
		}
		qu.add(new marble(0, n - 1));
		int dir = 0;
		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < 2; j++) {
				moveSnail(dir, i);
				dir++;
			}
			if (dir == 4) {
				dir = 0;
			}

		}
		list.add(0, 0); // 나중에 reverse snail을 위한 temp값
		list.add(list.size(), 0); // 나중에 duplicated를 위한 temp값, 나중에 제거해줄거임
	}

	public static int cal(int value) {
		if (value == 1) {
			return 1;
		} else if (value == 2) {
			return 2;
		} else if (value == 3) {
			return 3;
		}
		return 0;
	}

	public static void duplicated() {
		int count = 1;
		int keepI = 0;
		while (true) {
			int flag2 = 0;
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i) == list.get(i + 1)) {
					count++;
				} else {
					if (count > 3) {
						sum += cal(list.get(i)) * count;
						for (int j = count; j > 0; j--) {
							list.remove(i - count + 1);
						}
						i -= count; // 이러면 기본값으로 돌아감
						flag2 = 1;
					}
					count = 1;
				}
			}
			if (flag2 == 0) {
				break;
			}
		}
		list.remove(list.size() - 1); // 위에서 임의의 temp값 넣어준거 제거함
	}

	public static void map_maker() {
		int count = 1;
		for (int i = list.size() - 1; i > 0; i--) {
			if (list.get(i) == list.get(i - 1)) {
				count++;
			} else {
				mapMaker.add(count);
				mapMaker.add(list.get(i));
				count = 1;
			}
		}
	}

	public static void moveRsnail(int direction, int count) {
		for (int i = 0; i < count; i++) { // 여기에서 change구현해야함
			marble now = qu.poll();
			int nexty = now.y + rsnaildy[direction];
			int nextx = now.x + rsnaildx[direction];
//			map[nexty][nextx] = map[now.y][now.x] + 1; // 테스트용
			qu.add(new marble(nexty, nextx));
			if (index == mapMaker.size()) {
				flag = 1;
				return;
			}
			map[nexty][nextx] = mapMaker.get(index++);
		}
	}

	public static void rev_snail() {
		int direction = 0;
//		qu.add(new marble(n / 2, n / 2, map[n / 2][n / 2]));
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				if (flag == 1) {
					return;
				}
				moveRsnail(direction, i);
				direction++;
			}
			if (direction == 4) {
				direction = 0;
			}
			if (i == n - 1) {
				if (flag == 1) {
					return;
				}
				moveRsnail(direction, i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sy = n / 2;
		sx = n / 2;
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sum = 0;
		qu = new ArrayDeque<>();
		mapMaker = new ArrayList<>();
		list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			d = Integer.parseInt(st.nextToken()) - 1;
			s = Integer.parseInt(st.nextToken());
			qu.clear();
			mapMaker.clear();
			list.clear();
			index = 0;
			flag = 0;
			map[n / 2][n / 2] = -1;
			qu.add(new marble(n / 2, n / 2));
			shot(d, s);
			snail();
			duplicated();
			map_maker();
			map = new int[n][n];
			rev_snail();
		}
		System.out.println(sum);
	}

}
