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

	static int n, m;
	static int coins[];
	
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		input();
		bfs();
		if (!flag) {
			System.out.println("-1");
		}
	}
	
	public static void bfs() {
		Queue<int []> qu = new ArrayDeque<>();
		boolean visited[] = new boolean [m + 1];
		qu.add(new int [] {0,1});
		visited[0] = true;
		while (!qu.isEmpty()) {
			int now[] = qu.poll();
			for (int i = 0; i < n; i++) {
				int coin = coins[i] + now[0];
				if (coin > m || visited[coin]) {
					continue;
				}
				if (coin == m) {
					System.out.println(now[1]);
					flag = true;
					return;
				}
				visited[coin] = true;
				qu.add(new int[] {coin, now[1] + 1});
			}
		}
	}
	
	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		coins = new int [n];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
	}
}