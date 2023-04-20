import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, S, LEN = 1, ans = 0;
	public static int arr[];
	public static boolean visit[];
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (LEN = 1 ; LEN <= N ; LEN++) {
			dfs(0, 0);
		}
		System.out.println(ans);
	}
	
	public static void dfs(int at, int depth) {
		if (depth == LEN) {
			int sum = 0;
			for (int i = 0 ; i < N ; i++) {
				if (visit[i]) {
					sum += arr[i];
				}
			}
			if (sum == S) ans += 1;
			return;
		}
		
		for (int i = at ; i < N ; i++) {
			visit[i] = true;
			dfs(i + 1, depth + 1);
			visit[i] = false;
		}
	}
}