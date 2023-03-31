import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m;
	static int lis[];

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		lis = new int [n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			lis[i] = 2147483647;
		}
		lis[0] = arr[0];
		int index = 1;
		for (int i = 1; i < n; i++) {
			if (lis[index - 1] < arr[i]) {
				lis[index++] = arr[i];
			} else {
				int value = Arrays.binarySearch(lis, arr[i]);
				if (value < 0) {
					value = (value + 1) * -1; 
				}
				lis[value] = arr[i];
			}
		}
		System.out.println(index);
	}

}