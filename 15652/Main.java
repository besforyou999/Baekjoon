import java.io.*;
import java.util.*;

public class Main
{
	public static int N, M;
	public static int arr[];
	public static StringBuilder sb;
	public static void main(String [] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		sb = new StringBuilder();
		
		dfs(0);
			
		System.out.print(sb);
	}
	
	public static void dfs(int depth) {
		if (depth == M) {
			for (int n : arr) {
				sb.append(n).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i = 0 ; i < N ; i++) {
			if (depth == 0) {
				arr[depth] = i + 1;
				dfs(depth + 1);
			} else if (depth > 0 && arr[depth - 1] <= i + 1){
				arr[depth] = i + 1;
				dfs(depth + 1);
			}
		}
	}
}