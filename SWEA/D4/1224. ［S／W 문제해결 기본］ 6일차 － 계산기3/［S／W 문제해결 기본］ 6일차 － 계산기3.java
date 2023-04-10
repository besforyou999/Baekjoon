import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    static int priority(char tmp) {
        if (tmp == '(') return 0;
        else if (tmp == '+' || tmp == '-') return 1;
        else return 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        StringBuilder sb = new StringBuilder();

        for (int testcase = 1 ; testcase <= T ; testcase++) {
            int inputLength = Integer.parseInt(br.readLine());
            StringBuilder postfix = new StringBuilder();
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (int i = 0 ; i < inputLength ; i++) {
                char tmp = input.charAt(i);
                if (tmp >= '0' && tmp <= '9') {
                    postfix.append(tmp);
                } else if (tmp == '(') {
                    stack.add(tmp);
                } else if (tmp == ')') {
                    while (!stack.isEmpty()) {
                        if (stack.peek() == '(') {
                            stack.pop();
                            break;
                        }
                        postfix.append(stack.pop());
                    }
                } else {
                    while(!stack.isEmpty() && priority(stack.peek()) >= priority(tmp)) {
                        postfix.append(stack.pop());
                    }
                    stack.add(tmp);
                }
            }

            while(!stack.isEmpty()) {
                postfix.append(stack.pop());
            }

            sb.append("#").append(testcase).append(" ").append(calcPostfix(postfix.toString())).append("\n");
        }

        System.out.print(sb);
    }

    static int calcPostfix(String input) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0 ; i < input.length() ; i++) {

            char op = input.charAt(i);

            if (op >= '0' && op <= '9') {
                stack.push(op - '0');
            } else {
                int op2 = stack.pop();
                int op1 = stack.pop();
                switch(op) {
                    case '+' : {
                        stack.push(op1 + op2);
                        break;
                    }
                    case '-' : {
                        stack.push(op1 - op2);
                        break;
                    }
                    case '*' : {
                        stack.push(op1 * op2);
                        break;
                    }
                    case '/' : {
                        stack.push(op1 / op2);
                        break;
                    }
                }
            }
        }
        return stack.pop();
    }
}