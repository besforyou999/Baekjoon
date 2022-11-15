import java.io.*;
import java.util.*;

public class Main {
    public static int L, C;
    public static char [] letters;
    public static boolean [] visit;
    public static StringBuilder sb = new StringBuilder();
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        letters = new char[C];
        visit = new boolean[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < C ; i++) {
            letters[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(letters);

        dfs(0, 0);

        System.out.println(sb);
    }

    public static void dfs(int idx, int depth) {
        if (depth == L) {
            char tmp[] = new char[L];
            int index = 0;
            for (int i = 0 ; i < C ; i++) {
                if (visit[i]) {
                    tmp[index++] = letters[i];
                }
            }
            if (isValid(tmp))
                sb.append(tmp).append('\n');

            return;
        }

        for (int i = idx ; i < C ; i++) {
            visit[i] = true;
            dfs(i + 1, depth + 1);
            visit[i] = false;
        }
    }


    public static boolean isValid(char [] array) {
        int vowel = 0 , constant = 0;
        for (char x : array) {
            if (isVowel(x)) vowel += 1;
            else constant += 1;
        }
        if (vowel >= 1 && constant >= 2) return true;
        return false;
    }

    public static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
