import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class shark {
	int y, x;
	int m, s, d;

	public shark(int y, int x, int m, int s, int d) {
		this.y = y;
		this.x = x;
		this.m = m;
		this.s = s;
		this.d = d;
	}
}

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, K;
	static Queue<shark>[][] map;
	static Queue<shark> qu;
	static int dx[] = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int dy[] = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dir[];
	static int answer;

	public static void move() {
		int nextx;
		int nexty;
		while (!qu.isEmpty()) {
			shark now = qu.poll();
			nexty = now.y + (now.s % N) * dy[now.d];
			nextx = now.x + (now.s % N) * dx[now.d];
			if (nexty < 0 && nextx < 0) {
				nextx = nextx + N;
				nexty = nexty + N;
			} else if (nexty > N - 1 && nextx > N - 1) {
				nextx = nextx % N;
				nexty = nexty % N;
			} else {
				if (nexty < 0) {
					nexty = nexty + N;
				}
				if (nexty > N - 1) {
					nexty = nexty % N;
				}
				if (nextx < 0) {
					nextx = nextx + N;
				}
				if (nextx > N - 1) {
					nextx = nextx % N;
				}
			}
			map[nexty][nextx].add(new shark(nexty, nextx, now.m, now.s, now.d));
		}
	}

	public static void dup(int y, int x) {
		int mSum = 0;
		int sSum = 0;
		int size = map[y][x].size();
		int flag = 0;
		dir = new int[4];
		while (!map[y][x].isEmpty()) {
			shark now = map[y][x].poll();
			mSum += now.m;
			sSum += now.s;
			if (now.d % 2 == 0) {
				flag--;
			} else {
				flag++;
			}
		}
		if (mSum / 5 == 0) {
			return;
		}
		int count = 1;
		if (flag == size || flag == -size) {
			count = 0;
		}
		for (int i = 0; i < 4; i++) { // dir 저장만해줌. separate에서 사용할거임.
			dir[i] = count;
			count += 2;
		}

		separate(new shark(y, x, mSum, sSum / size, -1));
	}

	public static void separate(shark now) {
		for (int i = 0; i < 4; i++) {
			answer += now.m / 5;
			qu.add(new shark(now.y, now.x, now.m / 5, now.s, dir[i]));
		}
	}

	public static void cal() {
		answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].size() > 1) {
					dup(i, j);
				} else if (map[i][j].size() == 1) {
					shark temp = map[i][j].poll();
					answer += temp.m;
					qu.add(temp);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new ArrayDeque[N][N];
		qu = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayDeque<>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			qu.add(new shark(y, x, m, s, d));
		}
		for (int i = 0; i < K; i++) {
			move();
			cal();
		}
		System.out.println(answer);
	}

}
