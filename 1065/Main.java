import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int count = 0 ;

		for (int i = 1 ; i <= N ; i++) count += hansu(i);

		System.out.print(count);
	}

	public static int hansu(Integer num) {
		if (num >= 1 && num <= 99) return 1;
		
		String str = num.toString();

		char [] chars = str.toCharArray();	

		int len = chars.length;

		int [] arr = new int[len];

		for (int i = 0 ; i < len; i++) {
			arr[i] = chars[i] - '0';
		}

		int diff  = arr[0] - arr[1];
		int diff2 = arr[1] - arr[2];

		if (len == 3 && diff == diff2) {
			return 1;
		}

		return 0;
	}
}
