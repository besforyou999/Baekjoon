import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Student implements Comparable<Student> {
    int number;
    int [] like;

    public Student(int number, int[] like) {
        this.number = number;
        this.like = like;
    }

    public boolean hasLike(int num) {
        for (int i : like)
            if (i == num) return true;
        return false;
    }

    @Override
    public int compareTo(Student s1) {
        return Integer.compare(this.number, s1.number);
    }
}

public class Main {

    static int N;
    static int [][] mat;
    static Student [] students;
    static int [] dr = {-1, 1, 0, 0};
    static int [] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        mat = new int[N+1][N+1];

        students = new Student[N * N];

        for (int i = 0 ; i < N * N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());
            int four = Integer.parseInt(st.nextToken());
            Student student = new Student(number, new int[] {one, two, three, four});
            students[i] = student;
            int [] coord = findClosest(student);
            mat[coord[0]][coord[1]] = number;
        }

        Arrays.sort(students);

        int score = 0;

        for (int r = 1 ; r <= N ; r++) {
            for (int c = 1 ; c <= N ; c++) {
                int number = mat[r][c];

                Student student = students[number - 1];

                int like = 0;

                for (int i = 0 ; i < 4 ; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (isIn(nr, nc) && student.hasLike(mat[nr][nc])) like++;
                }

                if (like <= 1) score += like;
                else if (like == 2) score += 10;
                else if (like == 3) score += 100;
                else                score += 1000;
            }
        }

        System.out.println(score);
    }

    public static int [] findClosest(Student student) {

        ArrayList<int[]> result1 = condition1(student);

        if (result1.size() == 1) return result1.get(0);

        ArrayList<int[]> result2 = condition2(result1);

        if (result2.size() == 1) return result2.get(0);

        Collections.sort(result2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        return result2.get(0);
    }

    public static ArrayList<int[]> condition2(ArrayList<int[]> input) {

        ArrayList<int[]> result = new ArrayList<>();
        int maxEmpty = -1;

        for (int [] coord : input) {

            int emptyCnt = 0;

            for (int i = 0 ; i < 4 ; i++) {
                int nr = coord[0] + dr[i];
                int nc = coord[1] + dc[i];
                if (isIn(nr, nc) && mat[nr][nc] == 0) emptyCnt++;
            }

            if (emptyCnt > maxEmpty) {
                maxEmpty = emptyCnt;
                result = new ArrayList<>();
                result.add(new int[] {coord[0], coord[1]});
            } else if (emptyCnt == maxEmpty) {
                result.add(new int[] {coord[0], coord[1]});
            }
        }

        return result;
    }

    public static ArrayList<int[]> condition1(Student student) {

        ArrayList<int[]> result = new ArrayList<>();
        int maxLike = -1;

        for (int r = 1 ; r <= N ; r++) {
            for (int c = 1 ; c <= N ; c++) {
                if (mat[r][c] == 0) {

                    int cnt = 0;

                    for (int i = 0 ; i < 4 ; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        if (isIn(nr, nc) && mat[nr][nc] != 0) {
                            if (student.hasLike(mat[nr][nc])) cnt++;
                        }
                    }

                    if (cnt > maxLike) {
                        maxLike = cnt;
                        result = new ArrayList<>();
                        result.add(new int[] {r, c});
                    } else if (cnt == maxLike) {
                        result.add(new int[] {r, c});
                    }
                }
            }
        }

        return result;
    }


    public static boolean isIn(int r, int c) {
        return (r >= 1 && r <= N && c >= 1 && c <= N);
    }

    public static boolean close(int r1, int c1, int r2, int c2) {
        return (Math.abs(r1 - r2) + Math.abs(c1 - c2)) == 1;
    }
}