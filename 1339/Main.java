import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int [] arr = new int[26];

    static int number = 9;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            char [] letters = br.readLine().toCharArray();

            for (int j = 0 ; j < letters.length ; j++) {
                char ch = letters[letters.length - j - 1];
                arr[ch - 'A'] += Math.pow(10, j);
            }
        }

        Arrays.sort(arr);
        
        int ans = 0;
        for (int i = 25 ; i >= 0 ; i--) {
            if(arr[i] != 0) {
                int val = arr[i];
                ans += val * number--;
            }
        }
        System.out.println(ans);
    }
}
