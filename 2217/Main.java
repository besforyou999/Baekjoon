import java.io.*;
import java.util.*;

public class Main {
	public static void main ( String [] args ) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int arr[] = new int[N];

		for (int i = 0; i < N ; i++) arr[i] = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		int max = -1;
		int ropeNum = 0;
		for (int i = N - 1 ; i >= 0 ; i--) {
			ropeNum += 1;
			int currentWeight = arr[i];
			int maxCandidate = currentWeight * ropeNum;
			max = MAX(max, maxCandidate);
		}	
		System.out.print(max);	
	}

	public static int MAX(int a , int b) {
		if ( a >= b ) return a;
		else		  return b;
	}
}
