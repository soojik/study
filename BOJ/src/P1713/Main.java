package P1713;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static List<Portrait> list;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1713/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new Portrait(0, 0, 0));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            Collections.sort(list, Comparator.comparingInt(Portrait::getLike).thenComparing(Portrait::getTimeStamp, Comparator.reverseOrder()));
            for (int j = 0; j < list.size(); j++) {
                list.get(j).timeStamp++;
            }
            int liked_num = Integer.parseInt(st.nextToken());

            // 이미 게시되어 있으면 추천수+1
            boolean FindPortrait = false;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).num == liked_num) {
                    list.get(j).like++;
                    FindPortrait = true;
                    break;
                }
            }

            if (!FindPortrait) {
                list.get(0).num = liked_num;
                list.get(0).like = 1;
                list.get(0).timeStamp = 0;
            }
            // 아니라면 추천수 제일 작은 맨 앞 뽑아서 사진 게시

        }

        Collections.sort(list, Comparator.comparingInt(Portrait::getNum));

        for (Portrait p : list) {
            if (p.num != 0) {
                System.out.println(p.num);
            }
        }
    }
}

class Portrait {
    public int num;
    public int like;
    public int timeStamp;

    public Portrait(int num, int like, int timeStamp) {
        this.num = num;
        this.like = like;
        this.timeStamp = timeStamp;
    }

    public int getLike() {
        return like;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public int getNum() {
        return num;
    }
}