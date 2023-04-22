import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int MAX = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int [][] mat = new int[N][N];

        for (int r = 0 ; r < N ; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0 ; c < N ; c++)
                mat[r][c] = Integer.parseInt(st.nextToken());
        }

        rec(0, mat);


        System.out.println(MAX);

    }

    static void printMat(int [][]mat) {
        System.out.println("Matrix");
        for (int r = 0 ; r < N ; r++) {
            for (int c = 0 ; c < N ; c++) {
                System.out.print(mat[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    static void rec(int depth, int mat[][]) {
        if (depth == 5) {
            int result = searchBiggest(mat);
            MAX = Math.max(MAX, result);
            return;
        }

        // 0 : 위, 1 : 오른쪽, 2 : 아래, 3 : 왼쪽
        for (int i = 0 ; i < 4 ; i++) {
            int newMat[][] = copyMat(mat);

            switch(i) {
                case 0: {
                    pushUp(newMat);
                    break;
                }
                case 1: {
                    pushRight(newMat);
                    break;
                }
                case 2: {
                    pushDown(newMat);
                    break;
                }
                case 3: {
                    pushLeft(newMat);
                    break;
                }
            }

            rec(depth + 1, newMat);
        }
    }
    static void pushDown(int mat[][]) {
        boolean [][] merged = new boolean[N][N];

        for (int c = 0 ; c < N ; c++) {
            for (int r = N - 2 ; r >= 0 ; r--) {
                if (mat[r][c] == 0) continue;

                int value = mat[r][c];
                int row = r + 1;

                while (row < N) {
                    if (mat[row][c] > 0) {
                        if (merged[row][c]) {
                            mat[r][c] = 0;
                            mat[row - 1][c] = value;
                            break;
                        }
                        if (mat[row][c] == value) {
                            mat[row][c] += value;
                            merged[row][c] = true;
                            mat[r][c] = 0;
                            break;
                        } else {
                            mat[r][c] = 0;
                            mat[row - 1][c] = value;
                            break;
                        }
                    }

                    row += 1;
                    if (row >= N) {
                        mat[r][c] = 0;
                        mat[row - 1][c] = value;
                    }
                }
            }
        }

    }

    static void pushLeft(int mat[][]) {
        boolean [][] merged = new boolean[N][N];

        for (int r = 0 ; r < N ; r++) {
            for (int c = 1 ; c < N ; c++) {
                if (mat[r][c] == 0) continue;

                int value = mat[r][c];
                int col = c - 1;

                while (col >= 0) {
                    if (mat[r][col] > 0) {
                        if (merged[r][col]) {
                            mat[r][c] = 0;
                            mat[r][col + 1] = value;
                            break;
                        }
                        if (mat[r][col] == value) {
                            mat[r][col] += value;
                            merged[r][col] = true;
                            mat[r][c] = 0;
                            break;
                        } else {
                            mat[r][c] = 0;
                            mat[r][col + 1] = value;
                            break;
                        }
                    }

                    col -= 1;
                    if (col < 0 ) {
                        mat[r][c] = 0;
                        mat[r][col + 1] = value;
                    }
                }
            }
        }

    }

    static void pushRight(int mat[][]) {
        boolean [][] merged = new boolean[N][N];

        for (int r = 0 ; r < N ; r++) {
            for (int c = N - 2 ; c >= 0 ; c--) {
                if (mat[r][c] == 0) continue;

                int value = mat[r][c];
                int col = c + 1;

                while (col < N) {
                    if (mat[r][col] > 0) {
                        if (merged[r][col]) {
                            mat[r][c] = 0;
                            mat[r][col - 1] = value;
                            break;
                        }
                        if (mat[r][col] == value) {
                            mat[r][col] += value;
                            merged[r][col] = true;
                            mat[r][c] = 0;
                            break;
                        } else {
                            mat[r][c] = 0;
                            mat[r][col - 1] = value;
                            break;
                        }
                    }

                    col += 1;
                    if (col >= N ) {
                        mat[r][c] = 0;
                        mat[r][col - 1] = value;
                    }
                }
            }
        }

    }

    static void pushUp(int mat[][]) {

        boolean [][] merged = new boolean[N][N];

        for (int c = 0 ; c < N ; c++) {
            for (int r = 1 ; r < N ; r++) {
                if (mat[r][c] == 0) continue;

                int value = mat[r][c];
                int row = r - 1;

                while (row >= 0) {
                    if (mat[row][c] > 0) {
                        if (merged[row][c]) {
                            mat[r][c] = 0;
                            mat[row + 1][c] = value;
                            break;
                        }
                        if (mat[row][c] == value) {
                            mat[row][c] += value;
                            merged[row][c] = true;
                            mat[r][c] = 0;
                            break;
                        } else {
                            mat[r][c] = 0;
                            mat[row + 1][c] = value;
                            break;
                        }
                    }

                    row -= 1;
                    if (row < 0) {
                        mat[r][c] = 0;
                        mat[row + 1][c] = value;
                    }
                }
            }
        }
    }

    static int searchBiggest(int mat[][]) {
        int max = -1;
        for (int c = 0 ; c < N ; c++)
            for (int r = 0 ; r < N ; r++)
                max = Math.max(mat[r][c], max);
        return max;
    }

    static int [][] copyMat(int mat[][]) {
        int n = mat.length;
        int tmp[][] = new int[n][n];
        for (int c = 0 ; c < N ; c++) {
            for (int r = 0; r < N; r++) {
                int val = mat[c][r];
                tmp[c][r] = val;
            }
        }
        return tmp;
    }
}