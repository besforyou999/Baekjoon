
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main3 {
	public static int N;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		rec("");
	}
	
	public static void rec(String str) {
		if (str.length() == N) {
			System.out.println(str);
			System.exit(0);
		}
		
		for (int i = 1 ; i <= 3 ; i++) {
			if (valid(str + i)) {
				rec(str + i);
			}
		}
	}
	
	
	public static boolean valid(String str) {
		for (int i = 1 ; i <= str.length() / 2 ; i++) {
			int len = str.length();
			String front = str.substring(len - i * 2, len - i);
			String back = str.substring(len - i, len);
			if (front.equals(back)) return false;
		}
		return true;
	}
	
}