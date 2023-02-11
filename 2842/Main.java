package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int start_r, start_c;
	static int N, houses = 0;
	static char [][] map;
	static int [][] alt;
	static int dr [] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dc [] = {0, 1, 1, 1 ,0, -1, -1, -1};
	static int heights[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		alt = new int[N][N];
		
		for (int i = 0 ; i < N ; i++) {
			String line = br.readLine();
			for (int j = 0 ; j < N ; j++) {
				char c = line.charAt(j);
				map[i][j] = c;
				if (c == 'P') {
					start_r = i;
					start_c = j;
				} else if (c == 'K') {
					houses += 1;
				}
			}
		}
		
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < N ; j++) {
				int val = Integer.parseInt(st.nextToken());
				alt[i][j] = val;
				set.add(val);
			}
		}
		
		heights = new int[set.size()];
		int idx = 0;
		Iterator<Integer> iter = set.iterator();
		while (iter.hasNext()) {
			heights[idx++] = iter.next();
		}
			
		Arrays.sort(heights);
		
		int lp = 0;
		int rp = 0;
		int ans = 2000000;
		
		while (lp < heights.length && rp < heights.length) {
			int result = bfs(heights[lp], heights[rp]);
			if (result == 1) {
				ans = Math.min(ans, heights[rp] - heights[lp]);
				lp += 1;
			} else {
				if (rp < heights.length - 1) rp++;
				else 
					break;
			}
		}
		
		System.out.println(ans);
	}
	
	static int bfs(int low, int high) {
		Queue<int[]> queue = new LinkedList<>();
		
		int start_h = alt[start_r][start_c];
		
		if (start_h >= low && start_h <= high) {
			queue.add(new int[] {start_r, start_c});
		} else {
			return 0;
		}
		
		int visit = 0;
		
		boolean visited[][] = new boolean[N][N];
		visited[start_r][start_c] = true;
		
		while (!queue.isEmpty()) {
			int cod[] = queue.poll();
			int r = cod[0];
			int c = cod[1];
			for (int i = 0 ; i < 8; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (isIn(nr, nc) && !visited[nr][nc]) {
					int nh = alt[nr][nc];
					if (nh >= low && nh <= high) {
						if (map[nr][nc] == 'K') visit += 1;
						visited[nr][nc] = true;
						queue.add(new int[] {nr, nc});
					}
				}
			}
		}
		
		if (visit == houses) return 1;
		return 0;
	}
	
	
	
	static boolean isIn(int r, int c) {
		return (r >= 0 && r < N && c >= 0 && c < N);
	}
	
	
}