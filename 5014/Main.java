package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/*
 * @author jsm
 * @since 2023.02.10
 * @see https://www.acmicpc.net/problem/5014
 * @performance 36404 KB, 140 ms
 * @category #bfs
 * @note 
 */

public class Main {
	/*
	 * F : 건물 총 층수
	 * S : 현재 위치
	 * G : 스타트링크 위치
	 * U : 위로 U층 가는 버튼
	 * D : 아래로 D층 가는 버튼
	 * 만약 U층 위, D층 아래에 해당하는 층이 없을땐 엘베는 움직이지 않는다
	 */
	static int F, S, G, U, D;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		boolean [] visit = new boolean[F + 1];
		int start = S;
		int target = G;
		
		int result = bfs(start, target, visit);
		
		if (result != -1) {
			System.out.println(result);
		} else {
			System.out.println("use the stairs");
		}
		
	}
	
	public static int bfs(int start, int target, boolean [] visit) {
		ArrayDeque<int []> deque = new ArrayDeque<>(); // 현재 층수, 이동 횟수
		visit[start] = true;
		deque.add(new int[] {start, 0});
		
		while (!deque.isEmpty()) {
			int coord [] = deque.poll();
			int floor = coord[0];
			int move_cnt = coord[1];
			
			if (floor == target) {
				return move_cnt;
			}
			
			if (floor + U <= F && !visit[floor + U]) {
				visit[floor + U] = true;
				deque.add(new int[] {floor + U, move_cnt + 1});
			}
			if (floor - D >= 1 && !visit[floor - D]) {
				visit[floor - D] = true;
				deque.add(new int[] {floor - D, move_cnt + 1});
			}
		}
		
		return -1;
	}
}




