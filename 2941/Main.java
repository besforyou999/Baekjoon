import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static boolean checkIfCandidate(char l) {
        if (l == 'c' || l == 'd' || l == 'l' || l == 'n' || l =='s' || l == 'z') {
            return true;
        } else
            return false;
    }

    // return value 0 : just another letter
    //              1 : croatia letter
    //              2 : need to check third letter
    public static int classify(char l1, char l2) {
        switch(l1) {
            case 'c' : {
                if (l2 == '=' || l2 == '-') return 1;
                else    return 0;
            }
            case 'd' : {
                if (l2 =='-')       return 1;
                else if (l2 == 'z') return 2;
                else                return 0;
            }
            case 'l' : {
                if (l2 == 'j')      return 1;
                else                return 0;
            }
            case 'n' : {
                if (l2 == 'j')      return 1;
                else                return 0;
            }
            case 's' : {
                if (l2 == '=')      return 1;
                else                return 0;
            }
            case 'z' : {
                if (l2 == '=')      return 1;
                else                return 0;
            }
        }
        return 3;
    }

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int ans = 0;

        for (int i = 0; i < str.length() ; i++) {
            char l = str.charAt(i);
            if (!checkIfCandidate(l)) {
                ans += 1;
                continue;
            }
            if (i + 1 == str.length()) {
                ans += 1;
                break;
            }
            char l2 = str.charAt(i+1);
            int result = classify(l, l2);

            switch(result) {
                case 1 : {
                    i += 1;
                    break;
                }
                case 2 : {
                    if ( i + 2 == str.length()) break;
                    char l3 = str.charAt(i+2);
                    if (l3 =='=') {
                        i += 2;
                        break;
                    }
                }
            }
            ans += 1;
        }
        System.out.print(ans);
    }
}

