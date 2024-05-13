import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();

        List<Word> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {

            String word = br.readLine();

            if (word.length() < M) continue;

            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String key : map.keySet()) {
            list.add(new Word(key, map.get(key)));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Word w : list) {
            sb.append(w.word).append("\n");
        }

        System.out.println(sb);
    }
}

class Word implements Comparable<Word> {
    String word;
    int cnt;

    public Word(String word, int cnt) {
        this.word = word;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Word o) {
        return (this.cnt == o.cnt) ? (this.word.length() == o.word.length()) ? this.word.compareTo(o.word) : o.word.length() - this.word.length() : o.cnt - this.cnt;
    }
}