import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int rec[];
	public static int src[];
	public static boolean visit[];
	public static LinkedHashSet<String> ans;
	public static void main (String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		src = new int[N];
		visit = new boolean[N];
		rec = new int[M];
		ans = new LinkedHashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < N ; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(src);
		dfs(0);
		
		ans.forEach(str -> System.out.println(str));
	}
	
	public static void dfs(int depth) {
		if (depth == M ) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0 ; i < M ; i++) {
				sb.append(rec[i]).append(" ");
			}
			ans.add(sb.toString());
			return;
		}
		
		for (int i = 0 ; i < N ; i++) {
			if (!visit[i]) {
				visit[i] = true;
				rec[depth] = src[i];
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}
	
}
