import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });
        
        Queue<Process> general_queue = new LinkedList();
        for (int i=0;i<priorities.length;i++) {
            pq.add(priorities[i]);
            general_queue.add(new Process(i, priorities[i]));
        }
        
        while (!general_queue.isEmpty()) {
            /*
            pq에 가장 앞에 있는(우선순위가 가장 높은) 값이 현재 맨 앞에서 대기중인 프로세스의 우선순위와 같다면 빼기
            그리고 이 프로세스의 번호(idx)가 location과 같다면 바로 answer 리턴
            */
            while (pq.peek() != general_queue.peek().getPriority()) {
                general_queue.add(general_queue.poll());
            }
            Process process = general_queue.poll();
            pq.poll();
            ++answer;
            if (process.getIdx() == location) return answer;
        }
        
        
        return answer;
    }
}

class Process implements Comparable<Process> {
    private int idx;
    private int priority;
    
    public Process (int idx, int priority) {
        this.priority = priority;
        this.idx = idx;
    }
    
    public int getIdx() {return idx;}
    public int getPriority() {return priority;}
    
    @Override
    public int compareTo(Process p) {
        return p.priority - this.priority;
    }
    
    @Override
    public String toString() {
        return "{idx: " + idx + ", priority: " + priority + "}";
    }
}