import java.util.*;

/*
스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범
*/
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int len = genres.length;
        
        // 장르 총 재생 횟수 기준 정렬
        HashMap<String, Integer> map = new HashMap();
        for (int i=0;i<len;i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<Integer> answer_list = new ArrayList();
        
        List<Genre> genre_list = new ArrayList();
        for (String g : map.keySet()) {
            genre_list.add(new Genre(g, map.get(g)));
        }
        
        // 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        genre_list.sort((g1, g2) -> g2.cnt - g1.cnt);
        // for (Genre g : genre_list) System.out.println(g.name);
        
        // 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        HashMap<String, List<Music>> musics = new HashMap();
        for (int i=0;i<len;i++) {
            String g = genres[i];
            int p = plays[i];
            List<Music> list = null;
            if (musics.containsKey(g)) {
                list = musics.get(g);
            }
            else {
                list = new ArrayList();
            }
            list.add(new Music(i, p));
            musics.put(g, list);
        }
        
        for (String g : musics.keySet()) {
            musics.get(g).sort((m1, m2) -> m2.cnt == m1.cnt ? m1.idx - m2.idx : m2.cnt - m1.cnt);
        }
        
        for (Genre g : genre_list) {
            List<Music> list = musics.get(g.name);
            int music_size = list.size();
            for (int i=0;i<2 && i<music_size;i++) {
                answer_list.add(list.get(i).idx);
            }
        }
        
        int[] answer = new int[answer_list.size()];
        int idx = 0;
        for (int a : answer_list) answer[idx++] = a;
        
        return answer;
    }
}

class Genre {
    String name;
    int cnt;
    
    public Genre(String name, int cnt) {
        this.name = name;
        this.cnt = cnt;
    }
}

class Music {
    int idx;
    int cnt;
    
    public Music(int idx, int cnt) {
        this.idx = idx;
        this.cnt = cnt;
    }
    
    @Override
    public String toString() {
        return "idx: " + idx + ", cnt: " + cnt;
    }
}