import java.util.*;

class sort-vowels-in-a-string {
  public String sortVowels(String s) {
    StringBuilder sb =new StringBuilder();
    String vowels = "AEIOUaeiou";

    PriorityQueue<String> pq = new PriorityQueue();
    HashMap<Integer, Character> answer = new HashMap();

    int len = s.length();

    for (int i=0;i<len;i++) {
      if (vowels.contains(s.charAt(i)+"")) pq.add(s.charAt(i)+"");
      else answer.put(i, s.charAt(i));
    }

    for (int i=0;i<len;i++) {
      if (answer.containsKey(i)) sb.append(answer.get(i));
      else sb.append(pq.poll());
    }

    return sb.toString();
  }
}