import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static int R,C;
	static Character [][] map;
	static int ans = 0;
	static int [] dr = {0, 0, -1, 1};
	static int [] dc = {-1, 1, 0, 0};
	
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
		
		dfs(1, 1, 0, new HashSet<>());
		
		System.out.println(ans);
	}
	
	static void dfs(int r, int c, int cnt, HashSet<Character> set) {
		if (set.contains(map[r][c])) {
			if (cnt > ans) 
				ans = cnt;
			return;
		}
		
		for (int i = 0 ; i < 4 ; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (isIn(nr, nc)) {
				set.add(map[r][c]);
				dfs(nr, nc, cnt + 1, set);
				set.remove(map[r][c]);
			}
		}
	}
	
	static boolean isIn(int r, int c) {
		return (r >= 1 && r <= R && c >= 1 && c <= C);
	}
	
}