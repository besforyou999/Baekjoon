import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int X, N;
    static int [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int n = 0 ; n < N ; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        int maxVisit = 0;
        int termCnt = 0;
        int visitCnt = 0;

        for (int i = 0 ; i < X ; i++) {
            visitCnt += arr[i];
        }

        maxVisit = visitCnt;
        termCnt = 1;

        int lp = 0;
        int rp = X;

        while (rp < N) {
            visitCnt -= arr[lp++];
            visitCnt += arr[rp++];

            if (maxVisit == visitCnt) {
                termCnt++;
            } else if (maxVisit < visitCnt){
                maxVisit = visitCnt;
                termCnt = 1;
            }
        }

        if (maxVisit == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVisit);
            System.out.println(termCnt);
        }
    }
}