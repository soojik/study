package Day2.P3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int num;
    static int find_num;
    static StringBuilder sb;
    static List<Student> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/Day2/P3/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        find_num = Integer.parseInt(st.nextToken());

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            Double height = Double.parseDouble(st.nextToken());
            list.add(new Student(name, height));
        }

        list.sort(Comparator.comparing(Student::getName).thenComparingDouble(Student::getHeight));

        for (Student s : list) {
            System.out.println(s);
        }

        System.out.println(list.get(find_num - 1));
    }
}

class Student {
    String name;
    Double height;

    public Student(String name, Double height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public Double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return name + " " + String.format("%.2f", height);
    }
}