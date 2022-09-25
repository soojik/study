package P1931;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static List<Meeting> timetable = new ArrayList<>();
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1931/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            timetable.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        timetable.sort(Comparator.comparingInt(Meeting::getEnd).thenComparingInt(Meeting::getStart));

        int last = 0;
        for (int i = 0; i < N; i++) {
            if (last <= timetable.get(i).getStart()) {
                last = timetable.get(i).getEnd();
                cnt++;
            }
        }

        System.out.println(cnt);
    }

}

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

}