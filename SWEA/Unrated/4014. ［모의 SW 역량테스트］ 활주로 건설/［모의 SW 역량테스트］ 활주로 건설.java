import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1 ; test_case <= T ; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            int mat [][] = new int[N + 1][N + 1];

            for (int i = 1 ; i <= N ; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1 ; j <= N ; j++) {
                    mat[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;

            // 행 탐색
            for (int row = 1 ; row <= N ; row++) {
                boolean goodLine = true;
                boolean [] used = new boolean[N + 1];
                int prevHeight = mat[row][1];

                for (int col = 1 ; col <= N ; col++) {
                    int curHeight = mat[row][col];

                    if (prevHeight - 1 == curHeight ) {

                        int countSmallHeight = 0;
                        for (int i = 0 ; i < X ; i++) {
                            if (col + i <= N && !used[col + i] && mat[row][col + i] == curHeight) {
                                used[col + i] = true;
                                countSmallHeight += 1;
                            }
                        }

                        if (countSmallHeight < X) {
                            goodLine = false;
                            break;
                        }
                        col += (X - 1);
                        prevHeight = curHeight;

                    } else if (prevHeight  + 1 == curHeight) {

                        int countLowHeight = 0;
                        for (int i = 0 ; i < X ; i++) {
                            if (col - i - 1 >= 1 && !used[col - i - 1] && mat[row][col - i - 1] == curHeight - 1) {
                                used[col - i - 1] = true;
                                countLowHeight += 1;
                            }
                        }

                        if (countLowHeight < X) {
                            goodLine = false;
                            break;
                        }

                        prevHeight = curHeight;

                    } else if (Math.abs(prevHeight - curHeight) > 1) {
                        goodLine = false;
                        break;
                    }
                }

                if(goodLine) {
                    //System.out.println("good row : " + row);
                    cnt++;
                }
            }

            // 열 탐색
            for (int col = 1 ; col <= N ; col++) {
                boolean goodLine = true;
                boolean [] used = new boolean[N + 1];
                int prevHeight = mat[1][col];

                for (int row = 1 ; row <= N ; row++) {
                    int curHeight = mat[row][col];

                    if (prevHeight - 1 == curHeight ) {

                        int countSmallHeight = 0;
                        for (int i = 0 ; i < X ; i++) {
                            if (row + i <= N && !used[row + i] && mat[row + i][col] == curHeight) {
                                used[row + i] = true;
                                countSmallHeight += 1;
                            }
                        }

                        if (countSmallHeight < X) {
                            goodLine = false;
                            break;
                        }

                        row += (X - 1);
                        prevHeight = curHeight;

                    } else if (prevHeight  + 1 == curHeight) {

                        int countLowHeight = 0;
                        for (int i = 0 ; i < X ; i++) {
                            if (row - i - 1 >= 1 && !used[row - i - 1] && mat[row - i - 1][col] == curHeight - 1) {
                                used[row - i - 1] = true;
                                countLowHeight += 1;
                            }
                        }

                        if (countLowHeight < X) {
                            goodLine = false;
                            break;
                        }

                        prevHeight = curHeight;
                    } else if (Math.abs(prevHeight - curHeight) > 1) {
                        goodLine = false;
                        break;
                    }
                }

                if(goodLine) {
                    //System.out.println("good col : " + col);
                    cnt++;
                }
            }
            sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}