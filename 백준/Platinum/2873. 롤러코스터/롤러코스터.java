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

	static int n, m;
	static int map[][];
	static int visited[][];
	static int count = 0;
	static boolean flag = false;

	static int dy[] = new int[] { 1, 0, -1, 0 };
	static int dx[] = new int[] { 0, 1, 0, -1 };
	static int lx[] = new int[] { 1, 0, -1 };
	static int ly[] = new int[] { 0, 1, 0 };
	static int ox[] = new int[] { 0, 1, 0 };
	static int oy[] = new int[] { 1, 0, -1 };

	static String drul[] = new String[] { "D", "R", "U", "L" };
	static String rdl[] = new String[] { "R", "D", "L" };
	static String dru[] = new String[] { "D", "R", "U" };
	static PriorityQueue<int[]> pq;
	static ArrayDeque<String> dq;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dq = new ArrayDeque<>();
		pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if ((i + j) % 2 == 1) {
					pq.add(new int[] { i, j, map[i][j] });
				}
			}
		}
		if (n % 2 == 0 && m % 2 == 0) { // 짝짝
			visited = new int[n][m];
			int now[] = pq.poll();
			visited[now[0]][now[1]] = -1;
			visited[0][0] = 1;
			betterthanxy(now[0], now[1]);
			dfs(starty, startx, 1);
			while (!startdq.isEmpty()) {
				sb.append(startdq.poll());
			}
			while (!startxdq.isEmpty()) {
				sb.append(startxdq.poll());
			}
			while (!dq.isEmpty()) {
				sb.append(dq.poll());
			}
			while (!endxdq.isEmpty()) {
				sb.append(endxdq.poll());
			}
			while (!enddq.isEmpty()) {
				sb.append(enddq.poll());
			}
			System.out.println(sb);
		} else {
			easy();
			while (!dq.isEmpty()) {
				sb.append(dq.poll());
			}
			System.out.println(sb);
		}
	}

//	1 2 3 4 5 6 7 8
//	7 8 9 1 2 3 4 5
//	s 5 6 7 8 9 1 2
//	1 2 3 4 5 6 7 8
//	7 8 9 00 2 3 4 5
//	4 5 6 7 8 9 1 e
//	3 4 5 6 7 8 9 1
//	2 3 4 5 6 7 8 9

	static int starty, startx, endy, endx;

	public static void betterthanxy(int aimy, int aimx) {
		startx = 0;
		starty = 0;
		endy = n - 1;
		endx = m - 1;
		startdq = new ArrayDeque<>();
		enddq = new ArrayDeque<>();
		startxdq = new ArrayDeque<>();
		endxdq = new ArrayDeque<>();
		while (true) {
			if (aimy - 2 > starty) {
				betterthanstart();
				starty += 2;
			} else {
				break;
			}
		}
		while (true) {
			if (aimy + 2 < endy) {
				betterthanend();
				endy -= 2;
			} else {
				break;
			}
		}
		while (true) {
			if (aimx - 2 > startx) {
				betterthanstartx();
				startx += 2;
			} else {
				break;
			}
		}
		while (true) {
			if (aimx + 2 < endx) {
				betterthanendx();
				endx -= 2;
			} else {
				break;
			}
		}
	}
	
	static ArrayDeque<String> startxdq;
	static ArrayDeque<String> endxdq;
	
	public static void betterthanstartx() {
		for (int i = starty + 1; i < endy + 1; i++) {
			startxdq.add("D");
			visited[i][startx] = 1;
		}
		startxdq.add("R");
		visited[endy][startx + 1] = 1;
		for (int i = starty; i < endy; i++) {
			startxdq.add("U");
			visited[i][startx + 1] = 1;
		}
		startxdq.add("R");
		visited[starty][startx + 2] = 1;
	}
	public static void betterthanendx() {
		visited[endy][endx] = 1;
		for (int i = starty; i < endy; i++) {
			endxdq.addFirst("D");
			visited[i][endx] = 1;
		}
		endxdq.addFirst("R");
		visited[starty][endx - 1] = 1;
		for (int i = starty + 1; i < endy + 1; i++) {
			endxdq.addFirst("U");
			visited[i][endx - 1] = 1;
		} 
		endxdq.addFirst("R");
	}

	static ArrayDeque<String> startdq;
	static ArrayDeque<String> enddq;

	public static void betterthanstart() {
		for (int i = 0; i < m - 1; i++) {
			startdq.add("R");
			visited[starty][i] = 1;
		}
		startdq.add("D");
		visited[starty][m - 1] = 1;
		visited[starty + 1][m - 1] = 1;
		for (int i = 0; i < m - 1; i++) {
			startdq.add("L");
			visited[starty + 1][i] = 1;
		}
		startdq.add("D");
		visited[starty + 2][0] = 1;
	}

	public static void betterthanend() {
		for (int i = 0; i < m - 1; i++) {
			enddq.addFirst("R");
			visited[endy][i] = 1;
		}
		enddq.addFirst("D");
		visited[endy][m - 1] = 1;
		visited[endy - 1][0] = 1;
		for (int i = 0; i < m - 1; i++) {
			enddq.addFirst("L");
			visited[endy - 1][i] = 1;
		}
		enddq.addFirst("D");
		visited[endy - 1][m - 1] = 1;
	}

	public static void easy() {
		if (n % 2 == 1 && m % 2 == 1) {
			right();
		} else if (n % 2 == 1 && m % 2 == 0) {
			right();
		} else {
			down();
		}
//		if (dq.size() == n * m - 1) {
//			return;
//		}
//		down();
	}
	
	public static void right() {
		int count = 0;
		while (true) {
			for (int i = 0; i < m - 1; i++) {
				dq.add("R");
				count++;
			}
			if (count == n * m - 1) {
				break;
			}
			dq.add("D");
			count++;
			if (count == n * m - 1) {
				break;
			}
			for (int i = 0; i < m - 1; i++) {
				dq.add("L");
				count++;
			}
			if (count == n * m - 1) {
				break;
			}
			dq.add("D");
			count++;
			if (count == n * m - 1) {
				break;
			}
		}
	}

	public static void down() {
		int count = 0;
		while (true) {
			for (int i = 0; i < n - 1; i++) {
				dq.add("D");
				count++;
			}
			if (count == n * m - 1) {
				break;
			}
			dq.add("R");
			count++;
			if (count == n * m - 1) {
				break;
			}
			for (int i = 0; i < n - 1; i++) {
				dq.add("U");
				count++;
			}
			if (count == n * m - 1) {
				break;
			}
			dq.add("R");
			count++;
			if (count == n * m - 1) {
				break;
			}
		}
	}

	public static void dfs(int y, int x, int count) {
		if (count == (endx - startx + 1) * (endy - starty + 1) - 1) {
			flag = true;
		}
		if (flag) {
			return;
		}
		if (y == endy && x == endx) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nexty = y + dy[i];
			int nextx = x + dx[i];
			if (nexty < 0 || nexty > n - 1 || nextx < 0 || nextx > m - 1) {
				continue;
			}
			if (visited[nexty][nextx] == 1 || visited[nexty][nextx] == -1) {
				continue;
			}
			visited[nexty][nextx] = 1;
			dq.add(drul[i]);
			dfs(nexty, nextx, count + 1);
			if (flag) {
				return;
			}
			dq.pollLast();
			visited[nexty][nextx] = 0;
		}
	}

}