package DAY01.SORT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Item item1 = new Item(1, 3, 1);
        Item item2 = new Item(1, 2, 3);
        Item item3 = new Item(1, 1, 2);

        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

        Comparator<Item> comp = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.c - o2.c;
            }
        };

        Collections.sort(list, comp);
        System.out.println(list);

        Collections.sort(list, Comparator.comparingInt(Item::getB));
        // Comparator.comparingInt(Item::get?).reversed (역순)
        // Comparator.comparingInt(Item::get?).thenComparingInt ... 이어서 다른 기준으로 정렬 가능
        // Item :: getB 는 객체의 함수를 바로 갖다쓸 수 있도록
        System.out.println(list);
    }
}

class Item implements Comparable<Item>{
    int a;
    int b;
    int c;

    public Item(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "{a= " + a + ", b= " + b + ", c= " + c + "}";
    }

    @Override
    public int compareTo(Item o) {
        // 음수 -> 원래 순서
        // 0
        // 양수 -> SWAP

        // b 기준으로 정렬 (오름차순)
        if (b < o.b) {
            return -1;
        } else if (b == o.b) {
            // return o.c - c; 로 c 기준으로 정렬할 수 있다
            return 0;
        } else {
            return 1;
        }
        // == return b - o.b;
        // return Integer.compare(b, o.b);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}
