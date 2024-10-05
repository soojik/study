import java.util.*;

class Solution {
    int len;
    int port_len;
    List<String> order = new ArrayList();
    public String[] solution(String[][] tickets) {
        
        Arrays.sort(tickets, (t1, t2) -> {
            if (t1[0].equals(t2[0])) {
                return t1[1].compareTo(t2[1]);
            } else {
                return t1[0].compareTo(t2[0]);
            }
        });
        
        len = tickets.length;
        
        boolean[] visited = new boolean[len];
        dfs("ICN", 0, visited, tickets);
        
        String[] answer = new String[order.size()];
        int idx = 0;
        for (String o : order) answer[idx++] = o;
        
        return answer;
    }

    
    boolean dfs(String prev_port, int depth, boolean[] visited, String[][] tickets) {
        order.add(prev_port);
        if (depth == len) {
            return true;
        }
        
        for (int i=0;i<len;i++) {
            if (visited[i] || !prev_port.equals(tickets[i][0])) continue;
            visited[i] = true;
            if (dfs(tickets[i][1], depth + 1, visited, tickets)) {
                return true;
            }
            visited[i] = false;
        }
        order.remove(order.size() - 1);
        return false;
    }
}
