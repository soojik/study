public class 단어변환 {

  // 주어진 단어 갯수
  static int size;
  // 모든 단어는 len 만큼의 동일한 길이
  static int len;
  // 방문 배열
  static boolean[] visit;
  // 최솟값 저장할 answer 은 Math.min 으로 비교하기 위해 처음에 MAX_VALUE 로 정의
  static int answer = Integer.MAX_VALUE;

  public static void main(String[] args) {
    System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
  }

  static int solution(String begin, String target, String[] words) {

    size = words.length;
    len = begin.length();
    visit = new boolean[size];

    // words 배열 순회하며
    for (int i=0;i<size;i++) {
      // begin 과 비교할 단어
      String to = words[i];

      // begin 과 알파벳 하나만 다르며(isValid), 아직 방문하지 않은 단어라면
      if (isValid(begin, to) && !visit[i]) {
        // 방문 true 로 체크 후
        visit[i] = true;
        // target 과 words 배열을 같이 주며 다른 단어(words[i])와 비교하도록 하고, 몇번의 비교가 이루어졌는지(depth) 체크
        dfs(words, i, 1, target);
        // 탐색이 끝나면 해당 단어에 대한 방문 체크 원래대로 false
        visit[i] = false;
      }
    }

    // 처음 answer 값과 다르지 않다면 answer 출력
    return answer == Integer.MAX_VALUE ? 0 : answer;
  }

  // 주어진 from, to 단어가 알파벳 하나만 다른지 체크하는 메서드
  static boolean isValid(String from, String to) {
    int diff = 0;
    for (int i=0;i<len;i++) {
      if (from.charAt(i) != to.charAt(i)) ++diff;
    }

    return diff == 1;
  }

  /*
  from: 비교할 단어의 인덱스
  depth: 몇번째 비교인지 체크하며, target 단어를 찾게되면 answer 에 최솟값 업데이트
   */
  static void dfs(String[] words, int from, int depth, String target) {
    // target 에 다다르면 depth 와 비교해 answer 에 최솟값 업데이트 후 메서드 반환
    if (words[from].equals(target)) {
      answer = Math.min(answer, depth);
      return;
    }

    // words 배열 순회
    for (int to=0;to<size;to++) {
      // 자기자신을 제외하고 탐색
      if (from == to) continue;
      // 알파벳 하나 차이나며(isValid), 아직 방문하지 않은 단어라면
      if (isValid(words[from], words[to]) && !visit[to]) {
        // 방문 체크 후
        visit[to] = true;
        // words[to] 단어와 다른 단어를 비교하도록
        dfs(words, to, depth+1, target);
        visit[to] = false;
      }
    }
  }
}
