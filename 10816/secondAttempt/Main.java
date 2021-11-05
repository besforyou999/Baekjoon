import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N, M;

	public static void main (String [] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());		
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		String [] split = br.readLine().split(" ");	
		for ( int i = 0 ; i < N ; i++ ) {
			Integer num = Integer.parseInt(split[i]);
			if ( map.containsKey(num) ) {
				map.replace(num, map.get(num) + 1 );
			} else {
				map.put(num, 1);
			}
		}

		M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		split = br.readLine().split(" ");

		for ( int i = 0 ; i < M ; i++ ) {
			Integer num = Integer.parseInt(split[i]);
			if ( map.containsKey(num) ) {
				sb.append(map.get(num));
			} else {
				sb.append(0);
			}
			sb.append(" ");
		}

		System.out.print(sb);
	}
}
