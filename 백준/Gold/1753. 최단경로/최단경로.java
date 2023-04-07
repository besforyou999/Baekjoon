import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int v, e, start;
	static ArrayList<int[]>[] list;
	static int answer[];
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		list = new ArrayList[v + 1];
		answer = new int[v + 1];
		visited = new boolean[v + 1];
		for (int i = 0; i < v + 1; i++) {
			answer[i] = 2147483647;
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if (list[u] == null) {
				list[u] = new ArrayList<>();
			}
			list[u].add(new int[] { v, w });
		}
		dij();
		for (int i = 1; i <= v; i++) {
			if (answer[i] != 2147483647) {
				sb.append(answer[i]).append("\n");
			} else {
				sb.append("INF").append("\n");
			}
		}
		System.out.println(sb);
	}

	public static void dij() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.add(new int[] { start, 0 });
		answer[start] = 0;
		while (!pq.isEmpty()) {
			int now[] = pq.poll(); // now[0] == start, now[1] == w
			if (list[now[0]] == null) {
				continue;
			}
			for (int t[] : list[now[0]]) {
				if (answer[t[0]] > now[1] + t[1]) {
					answer[t[0]] = now[1] + t[1];
					pq.add(new int[] { t[0], answer[t[0]] });
				}
			}
		}
	}

}
