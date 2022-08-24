package DAY01.P1713;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();

        portrait[] nomi = new portrait[100];
        List<portrait> list = new ArrayList<>();

//        for (int i=0;i<C;i++) {
//            int num = sc.nextInt();
//            // 해당 후보 최초 호출 시
//            if (nomi[num] == null) {
//                nomi[num] = new portrait(0, num, 0, false);
//            }
//            // 해당 후보가 사진틀에 있을 경우
//            if (nomi[num].isIn == true) {
//                nomi[num].like++;
//            } else {
//                // 해당 후보가 사진틀에 없음
//                // 사진틀이 가득 찬 경우
//                if (list.size() == N) {
//                    Collections.sort(list);
//                    list.get(0).isIn = false;
//                    list.remove(0);
//                }
//                nomi[num].like = 1;
//                nomi[num].isIn = true;
//                nomi[num].when = i;
//                list.add(nomi[num]);
//            }
//            // 사진틀이 여유가 있는 경우
//        }

        for (int i=0;i<C;i++) {
            for (int j=0;j<list.size();j++) {
                list.get(j).when++;
            }
            int n = sc.nextInt();

            if (nomi[n] == null) {
                nomi[n] = new portrait(n, 0, 0, false);
            }
            if (nomi[n].isIn) {
                nomi[n].like++;
            } else {
                if (list.size() == N) {
                    Collections.sort(list);
                    list.get(0).isIn = false;
                    list.remove(0);
                }
                nomi[n].like = 1;
                nomi[n].when = 1;
                list.add(nomi[n]);
            }

            System.out.println(list);
        }

        Comparator<portrait> comp = new Comparator<portrait>() {
            @Override
            public int compare(portrait o1, portrait o2) {
                return o1.num - o2.num;
            }
        };

        Collections.sort(list, comp);
        System.out.println(list);
    }
}

class portrait implements Comparable<portrait> {
    public int like;
    public int num;
    public int when;
    public boolean isIn;

    public portrait (int num, int like, int when, boolean isIn) {
        this.num = num;
        this.like = like;
        this.when = when;
        this.isIn = isIn;
    }

    public portrait() {

    }

    @Override
    public int compareTo(portrait o) {
        if (like - o.like < 0) {
            return -1;
        } else if (like == o.like) {
            return o.when - when;
        } else {
            return 1;
        }
    }

    public String toString() {
        return Integer.toString(num);
    }
}