import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String input = br.readLine();
        int result = 0;
        for (int i = 0 ; i < input.length() ; i++) {
            if (input.charAt(i) == '(') {
                stack.push('(');
                continue;
            } else if (input.charAt(i) == ')') {
                stack.pop();
                if (input.charAt(i-1) == '(') {
                    result += stack.size();
                } else
                    result += 1;
            }
        }
        System.out.print(result);
    }
}
