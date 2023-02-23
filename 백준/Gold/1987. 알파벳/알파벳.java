import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C;
	static int ans = 0;
	static int [] dr = {0, 0, -1, 1};
	static int [] dc = {-1, 1, 0, 0};
	static Character map [][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new Character[R + 1][C + 1];
		
		for (int i = 1 ; i <= R ; i++) {
			String line = br.readLine();
			for (int j = 1 ; j <= C ; j++) {
				map[i][j] = line.charAt(j - 1);
			}
		}
		
		boolean [] used = new boolean[26]; // A ~ Z
		
		dfs(1, 1, 0, used);
		
		System.out.println(ans);
	}
	
	static void dfs(int r, int c, int cnt, boolean [] used) {
		if (used[map[r][c] - 'A']) {
			if (cnt > ans) 
				ans = cnt;
			return;
		}
		
		for (int i = 0 ; i < 4 ; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (isIn(nr, nc)) {
				used[map[r][c] - 'A'] = true;
				dfs(nr, nc, cnt + 1, used);
				used[map[r][c] - 'A'] = false;
			}
		}
	}
	
	static boolean isIn(int r, int c) {
		return (r >= 1 && r <= R && c >= 1 && c <= C);
	}
	
}