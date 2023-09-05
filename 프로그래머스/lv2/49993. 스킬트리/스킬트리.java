import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // 스킬 순서 모두 ArrayList 에 넣어주기
        // contains 메서드를 사용하면서 배열 형식을 그대로 쓰기 위함
        List<Character> skills = new ArrayList();
        
        int len = skill.length();
        for (int i=0;i<len;i++) {
            skills.add(skill.charAt(i));
        }
        
        int p;
        
        // skill_trees 순회
        for (String sk : skill_trees) {
            // 배워야할 차례의 스킬(skills) 하나씩 가리키도록
            p = 0;
            len = sk.length();
            
            // 각 스킬트리 순회
            for (int i=0;i<len;i++) {
                char s = sk.charAt(i);
                
                // 스킬 순서가 정해져있으면서,
                if (skills.contains(s)) {
                    // 배워야할 차례가 맞다면
                    if (skills.get(p) == s) {
                        // 스킬 찍기 계속하고 다음 스킬 가리키기
                        ++p;
                        continue;
                    }
                    // 배워야할 차례가 아니면 불가능한 스킬트리 이므로 answer 1 증가하고 스킬 찍기 중단
                    ++answer;
                    break;
                }
            }
        }
        
        // 가능한 스킬트리 수를 출력하므로, 전체 스킬트리에서 answer 뺀 값
        return skill_trees.length - answer;
    }
}