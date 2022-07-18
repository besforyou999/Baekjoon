import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = "";
        while ((input = br.readLine()) != null) {
            Integer lower = 0 , upper = 0, number = 0, space = 0;
            for (int i = 0 ; i < input.length() ; i++) {
                Character ch = input.charAt(i);
                if (65 <= ch && ch <= 90) {
                    upper += 1;
                } else if (97 <= ch && ch <= 122) {
                    lower += 1;
                } else if (48 <= ch && ch <= 57) {
                    number += 1;
                } else if (ch == 32) {
                    space += 1;
                }
            }
            bw.write(lower + " " + upper + " " + number + " " + space + "\n");
            bw.flush();
        }
        bw.close();
    }
}

