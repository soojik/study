import java.util.TreeSet;

class Solution {
    // 나올 수 있는 문자는 총 6개(빈칸까지 포함)
    String[] alpha = {"", "A", "E", "I", "O", "U"};
    
    // 정렬을 도와주는 TreeSet을 사전의 데이터형으로 정했다.
    TreeSet<String> dict = new TreeSet();
    public int solution(String word) {
        makingDict(5, "");
    
        /* TreeSet에서 주어진 매개변수 값(여기서는 word)을 찾아,
        0부터 해당 인덱스 앞까지의 일부 set을 가져오는 Set<Object> headSet(Object o) 메서드를 이용해
        주어진 word 의 사전번호를 구해주었다.
        */
        return dict.headSet(word).size();
    }
    
    // 5부터 시작해 n이 0이 될때까지 재귀
    public void makingDict(int n, String word) {
        if (n == 0) {
            // n이 0이 되면 만들었던 단어를 dict에 넣어준다.
            dict.add(word);
            return;
        }
        
        // 그 외의 경우는 미리 지정해놓은 alpha 배열을 순회하며 새로운 단어를 만들어나간다.
        for (int i=0;i<6;i++) {
            makingDict(n-1, word + alpha[i]);
        }
    }
}