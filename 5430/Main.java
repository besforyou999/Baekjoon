import java.io.*;
import java.util.*;

public class Main {

	static String p;
	static int n;
	static String numArrStr;
	static BufferedReader br;
	static BufferedWriter bw;
	
	public static void main(String [] args) throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0 ; i < T ; i++) {
			p = br.readLine();
			n = Integer.parseInt(br.readLine());
			numArrStr = br.readLine();			
			execute();
		}
		bw.flush();
		bw.close();
	}

	public static void execute() throws IOException {
		String line = numArrStr.substring(1, numArrStr.length() - 1);
		String splitLine[]  = line.split(",");
		ArrayList<Integer> numArr = new ArrayList<Integer>(n);
		for (int i = 0 ; i < n ; i++) numArr[i] = Integer.parseInt(splitLine[i]);		
		
		String orders [] = p.split("");			

	}	
	
	public static void command(String command, ArrayList numArr ) {

		switch(command) {
			case "R" : {
				
				break;
			}
			case "D" : {
					
				break;
			}

		}	
	}
}
