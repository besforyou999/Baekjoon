import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Student {
    String name;
    int kor, eng, math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}

public class Main {
    static int N;
    static Student [] students;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        students = new Student[N];

        for (int n = 0 ; n < N ; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            students[n] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.kor == o2.kor) {
                    if (o1.eng == o2.eng) {
                        if (o1.math == o2.math) {
                            return o1.name.compareTo(o2.name);
                        }
                        return Integer.compare(o1.math, o2.math) * -1;
                    }
                    return Integer.compare(o1.eng, o2.eng);
                }
                return Integer.compare(o1.kor, o2.kor) * -1;
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int n = 0 ; n < N ; n++) {
            sb.append(students[n].name).append("\n");
        }

        System.out.println(sb);
    }
}