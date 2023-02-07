import java.util.Scanner;

public class Main4 {
	
	static int [][] delta = {	// 아래로 내려가는 방향 존재
			{-1, 1},
			{-1, -1},
			{1, 0}
	};
	
	static int [][] alpha = { // 위로 올라가는 방향 존재
			{1, 1,},
			{1, -1},
			{-1, 0},
	};
	public static int N, answer = 0 ;
	public static int mat[][] = new int[100][100];
	public static boolean visit[][] = new boolean[100][100];
	public static int stop_rec[] = new int[23];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for (int r = 0 ; r < 100 ; r += 4) {
			for (int c = 0 ; c < 100; c += 2) {
				mat[r][c + 1] = 1;
				mat[r + 1][c] = 1;
				mat[r + 2][c] = 1;
				mat[r + 3][c + 1] = 1;
			}
		}
		
		visit[50][50] = true;
		dfs(49, 50, 0, -1, 0, 1);
		System.out.println(answer);
	}
	
	public static void dfs(int r, int c, int cnt, int pr, int pc, int type) {
		if (visit[r][c]) {
			if (cnt == N) 
				answer += 1;
			return;
		}
		
		if (cnt == N) return;
		visit[r][c] = true;
		if (type == 1) {
			for (int i = 0 ; i < 3 ; i++) {
				int dr = delta[i][0];
				int dc = delta[i][1];
				if (pr * -1 == dr && pc * -1 == dc) continue;
				dfs(r + dr, c + dc, cnt + 1, dr, dc, 0);
			}
		} else {
			for (int i = 0 ; i < 3 ; i++) {
				int dr = alpha[i][0];
				int dc = alpha[i][1];
				if (pr * -1 == dr && pc * -1 == dc) continue;
				dfs(r + dr, c + dc, cnt + 1, dr, dc, 1);
			}
		}
		visit[r][c] = false;
	}

}
