import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Student implements Comparable<Student>{
    int skill;
    int group;
    Student(int s, int g) {
        this.skill = s;
        this.group = g;
    }

    @Override
    public int compareTo(Student o) {
        return this.skill - o.skill;
    }
}

public class Main {
    static int N, M;
    static int [] group_rec;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Student [] students = new Student[N * M];
        group_rec = new int[N + 1];
        int cnt = 0;
        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < M ; j++) {
                int skill = Integer.parseInt(st.nextToken());
                students[cnt++] = new Student(skill, i);
            }
        }

        Arrays.sort(students);
        /*
        for (Student s : students) {
            System.out.println(s.skill + " " + s.group);
        }
           */
        int min = 1000000001;
        int lp = 0, rp = 1;

        int MAX = students[1].skill;
        int MIN = students[0].skill;
        group_rec[students[0].group]++;
        group_rec[students[1].group]++;

        while (rp < students.length) {
            boolean hasAllGroup = hasAllGroups();
            if (!hasAllGroup) {
                rp++;
                if(rp == students.length) continue;
                Student student = students[rp];
                MAX = student.skill;
                group_rec[student.group]++;
            } else {
                //printStatus(lp, rp);
                int diff = Math.abs(MAX - MIN);
                min = Math.min(min, diff);
                group_rec[students[lp].group]--;
                lp++;
                MIN = students[lp].skill;
            }
        }

        System.out.println(min);

    }

    static void printStatus(int l, int r) {
        System.out.println("lp : " + l + " " + "rp : " + r);
        for (int i = 1 ; i <= N ; i++)
            System.out.print(group_rec[i] + " ");
        System.out.println();
        System.out.println();
    }

    static boolean hasAllGroups() {
        for (int i = 1 ; i <= N ; i++)
            if (group_rec[i] == 0) return false;
        return true;
    }
}
