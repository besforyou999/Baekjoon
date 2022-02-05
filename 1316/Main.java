import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0 ; i < N ; i++) {
            String word = br.readLine();
            ans += checkIfGroupWord(word);
        }
        System.out.println(ans);
    }

    public static int checkIfGroupWord(String word) {
        boolean arr[] = new boolean[26];
        for (int i = 0 ; i < 26 ; i++) arr[i] = false;
        char pastChar = word.charAt(0);
        int idx = (int)pastChar - 97;
        arr[idx] = true;
        for (int i = 1 ; i < word.length() ; i++) {
            char currentChar = word.charAt(i);
            if (currentChar != pastChar) {
                idx = (int)currentChar - 97;
                if (arr[idx] == true) return 0;
                else
                    arr[idx] = true;
            }
            pastChar = currentChar;
        }
        return 1;
    }
}