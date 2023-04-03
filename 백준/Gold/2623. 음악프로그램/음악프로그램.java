import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, m, count;
	static int dist[];
	static ArrayList<Integer> list[];
	static ArrayList<Integer> answer;

	public static void main(String[] args) throws IOException {
		input();
		fsort();
		if (count != n) {
			System.out.println(0);
		} else {
			System.out.println(sb);
		}
	}

	public static void fsort() {
		Queue<Integer> qu = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (dist[i] == 0) {
				qu.add(i);
			}
		}
		while(!qu.isEmpty()) {
			int size = qu.size();
			while (size-- > 0) {
				int now = qu.poll();
				count++;
				sb.append(now + "\n");
				if (list[now] == null) {
					continue;
				}
				for (int i = 0; i < list[now].size(); i++) {
					int next = list[now].get(i);
					if (--dist[next] == 0) {
						qu.add(next);
					}
				}
			}
		}
	}
	
	public static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		count = 0;
		
		dist = new int[n + 1];
		list = new ArrayList[n + 1];
		answer = new ArrayList<>();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int keep[] = new int [c];
			for (int j = 0; j < c; j++) {
				keep[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < c - 1; j++) {
				if (list[keep[j]] == null) {
					list[keep[j]] = new ArrayList<>();
				}
				list[keep[j]].add(keep[j + 1]);
				dist[keep[j + 1]]++;
			}
		}
	}
}