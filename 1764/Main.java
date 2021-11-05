import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;

public class Main {
	static int N, M;
	public static void main(String [] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		Map<String, Integer> map = new HashMap<String , Integer>(N);
		ArrayList<String> ans = new ArrayList<String>();

		for ( int i = 0 ; i < N ; i++ ) {
			String name = br.readLine();
			map.put(name, 1);
		}

		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < M ; i++ ) {
			String name = br.readLine();
			if (map.containsKey(name)) {
				ans.add(name);
			}	
		}	
		Collections.sort(ans);	
		for ( int i = 0 ; i < ans.size() ; i++ ) {
			sb.append(ans.get(i) + "\n");
		}


		System.out.println(ans.size());
		System.out.print(sb);	
		
	}
}
