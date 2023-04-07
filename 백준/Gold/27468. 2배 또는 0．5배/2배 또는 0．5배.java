import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer tokens;

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(input.readLine());
        int cnt = 0;
        int cycle = 0;
        int idx = 0;
        sb.append("YES\n");
        int [] arr;
        if(N%4>2) arr = new int[]{1,3,2,4};
        else arr = new int[]{1,2,4,3};
        while(cnt<N) {
            sb.append(arr[idx++]+cycle*4).append(" ");
            cnt++;
            if(cnt%4==0) {
                cycle++;
                idx=0;
            }
        }
        output.write(sb.toString());
        output.flush();
        output.close();
    }
}