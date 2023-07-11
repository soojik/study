import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 베스트앨범 {

  public static void main(String[] args) {
    System.out.println(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}));
  }

  static List<Integer> solution(String[] genres, int[] plays) {
    List<Integer> answer = new ArrayList<>();

    HashMap<String, Integer> playSum = new HashMap<>();
    HashMap<Integer, Integer> playTimeMap = new HashMap<>();

    int song_len = genres.length;
    for (int i=0;i<song_len;i++) {
      playSum.put(genres[i], playSum.getOrDefault(genres[i], 0) + plays[i]);
    }

    for (int i=0;i<song_len;i++) {
      playTimeMap.put(i, plays[i]);
    }

    List<String> sumKeySet = new ArrayList(playSum.keySet());
    sumKeySet.sort((o1, o2) -> playSum.get(o2).compareTo(playSum.get(o1)));

    List<Integer> playTimeKeySet = new ArrayList(playTimeMap.keySet());
    playTimeKeySet.sort((o1, o2) -> playTimeMap.get(o2).compareTo(playTimeMap.get(o1)));

    System.out.println(playTimeKeySet);

    for (String genre : sumKeySet) {

      int song_cnt = 0;

      for (int i : playTimeKeySet) {
        if (song_cnt == 2) break;

        if (genre.equals(genres[i])) {
          ++song_cnt;
          answer.add(i);
        }
      }
    }

    return answer;
  }
}
