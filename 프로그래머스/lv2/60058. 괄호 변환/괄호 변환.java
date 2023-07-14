import java.util.*;

class Solution {
    public String solution(String p) {
        return buildString(p);
    }

    public String buildString(String input) {
        if (input.length() == 0) return input;

        String [] UV = splitToUV(input);

        if (validString(UV[0])) {
            return UV[0] + buildString(UV[1]);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(buildString(UV[1]));
            sb.append(')');
            sb.append(four_four(UV[0]));
            return sb.toString();
        }
    }

    public String four_four(String input) {
        if (input.length() == 2) return "";

        String trimStr = input.substring(1, input.length() - 1);

        char [] tmp = new char[trimStr.length()];

        for (int i = 0 ; i < tmp.length ; i++) {
            if (trimStr.charAt(i) == '(') {
                tmp[i] = ')';
            } else {
                tmp[i] = '(';
            }
        }

        return new String(tmp);
    }


    public String [] splitToUV(String input) {
        char [] chars = input.toCharArray();

        int left = 0, right = 0, idx = 0;

        for (idx = 0 ; idx < chars.length ; idx++) {
            if (chars[idx] == '(') left += 1;
            else if (chars[idx] == ')') right += 1;

            if (left == right) break;
        }

        String U = input.substring(0, idx + 1);
        String V = input.substring(idx + 1);
        return new String[]{U, V};
    }

    public boolean balanedString(char [] chars) {
        int leftCnt = 0 , rightCnt = 0;

        for (int i = 0 ; i < chars.length ; i++) {
            if (chars[i] == '(') {
                leftCnt += 1;
            } else {
                rightCnt += 1;
            }
        }

        return (leftCnt == rightCnt);
    }

    public boolean balancedString(String input) {
        int leftCnt = 0 , rightCnt = 0;

        for (int i = 0 ; i < input.length() ; i++) {
            if (input.charAt(i) == '(') {
                leftCnt += 1;
            } else {
                rightCnt += 1;
            }
        }

        return (leftCnt == rightCnt);
    }

    public boolean validString(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0 ; i < input.length() ; i++) {
            char ch = input.charAt(i);
            if (ch == '(') {
                stack.add(ch);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}