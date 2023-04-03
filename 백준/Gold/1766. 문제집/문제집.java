import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m;
	static int adj[];

	static ArrayList<Integer> list[];
	static ArrayList<Integer> ans;

	public static void main(String[] args) throws IOException {
		input();
		tsort();
		for (int i = 0; i < ans.size(); i++) {
			sb.append(ans.get(i)).append(" ");
		}
		System.out.println(sb);
	}

	public static void tsort() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) {
			if (adj[i] == 0) {
				pq.add(i);
			}
		}
		while (!pq.isEmpty()) {
			int size = pq.size();
			while (size-- > 0) {
				int now = pq.poll();
				ans.add(now);
				if (list[now] == null) {
					continue;
				}
				for (int i = 0; i < list[now].size(); i++) {
					int next = list[now].get(i);
					if (--adj[next] == 0) {
						pq.add(next);
					}
				}
			}
		}
	}

	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		adj = new int[n + 1];
		ans = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (list[a] == null) {
				list[a] = new ArrayList<>();
			}
			list[a].add(b);
			adj[b]++;
		}
	}
}