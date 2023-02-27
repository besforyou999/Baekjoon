import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K, M;

    // 대표자 배열
    static int [] repres;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1 ; test_case <= T ; test_case++) {

            sb.append("Scenario ").append(test_case).append(":\n");

            N = Integer.parseInt(br.readLine());
            K = Integer.parseInt(br.readLine());

            makeSet();

            for (int k = 0 ; k < K ; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b); // 친구들 결합
            }

            M = Integer.parseInt(br.readLine());

            for (int m = 0 ; m < M ; m++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                sb.append(findSet(a) == findSet(b) ? 1 : 0).append("\n");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    // 각 그룹의 대표자를 자기로 하는 집합을 만든다.
    static void makeSet() {
        repres = new int[N];
        for (int n = 0 ; n < N ; n++) {
            repres[n] = n;
        }
    }

    // findSet : 각 요소가 속한 그룹의 대표자를 반환한다.
    static int findSet(int a) {
        if (repres[a] == a) {
            return a;
        } else {
            // path compression : a가 속한 그룹의 대표
            return repres[a] = findSet(repres[a]);
        }
    }

    // union: 두 조직의 대표자를 합하기
    // 반환 : 합하기 동작이 성공했나?
    static boolean union(int a, int b) {
        // a, b가 속한 그룹의 대표자를 데려오기
        a = findSet(a);
        b = findSet(b);

        // 대표자가 이미 같다!
        if (a == b) {
            return false;
        } else {
            repres[a] = b;
            return true;
        }
    }

}