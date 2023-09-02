import java.util.HashSet;

class Solution {
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    HashSet<Path> visit = new HashSet();
    /*
    HashSet<Path> visit에는 점이 아닌 선(길)에 대한 방문여부를 나타내기 때문에 a->b, b->a 로의 두 방향에 대해 모두 더해준다.
    */
    public int solution(String dirs) {
        // 시작지점 설정
        int curr_r = 0, curr_c = 0;
        
        char[] c_arr = dirs.toCharArray();
        
        // 주어진 명령 순회
        int next_r, next_c;
        for (char c : c_arr) {
            // 다음 위치 업데이트하기 위한 next_r, next_c
            next_r = curr_r;
            next_c = curr_c;
            // 나온 명령에 따라 next_r, next_c를 이동해준다.
            if (c == 'U') {
                next_r -= 1;
            }
            else if (c == 'D') {
                next_r += 1;
            }
            else if (c == 'R') {
                next_c += 1;
            }
            else {
                next_c -= 1;
            }
            
            // 범위 안이라면
            if (-5 <= next_r && next_r <= 5 && -5 <= next_c && next_c <= 5) {
                // 현재지점과 방향 정보를 visit에 더해준다.
                visit.add(new Path(curr_r, curr_c, c));
                
                // 다음에 이동할 위치에서 현재지점으로의 방향 정보를 visit에 더해준다.
                char next_d = ' ';
                
                if (c == 'R') next_d = 'L';
                if (c == 'L') next_d = 'R';
                if (c == 'U') next_d = 'D';
                if (c == 'D') next_d = 'U';
                
                visit.add(new Path(next_r, next_c, next_d));
                
                // 다음 출발지를 지정해준다.
                curr_r = next_r;
                curr_c = next_c;
            }
        }
        
        return visit.size() / 2;
    }
}

/*
지점 r, c 의 정보와 이동 방향 direction 속성을 갖고있다.
*/
class Path {
    int r;
    int c;
    char direction;
    
    public Path (int r, int c, char direction) {
        this.r = r;
        this.c = c;
        this.direction = direction;
    }
    
    @Override
    public String toString() {
        return "r: " + r + ", c: " + c + ", direction: " + direction;
    }
    
    // r, c, direction 각 속성의 모양(값)이 같다면 같은 인스턴스로 보도록 한다.
    @Override
    public boolean equals(Object obj) {
        Path anotherPath = (Path) obj;
        return ((this.r == anotherPath.r)
                && (this.c == anotherPath.c)
                && (this.direction == anotherPath.direction));
    }
    
    // hashCode 산정 방식을 임의로 r 과 c, 그리고 direction 를 더한 값이 같다면 동일한 hashCode를 반환하도록 정의했다.
    // 이는 HashSet 에서 같은 값임을 알아채도록 하기 위함이며, HashSet에서는 equals 가 true 이며 hashCode 가 같은 인스턴스끼리는 같다고 판단하기 때문이다.
    @Override
    public int hashCode() {
        int hashcode = 0;
        
        hashcode = 31 * hashcode + r + c + (direction - 'A');
        
        return hashcode;
    }
}