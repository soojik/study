import java.io.*;
import java.util.*;
class Main {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int X, Y, N;
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		for (int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			sb.append(isReachable(X, Y, N) ? "YES" : "NO").append("\n");
		}
		
		System.out.println(sb);
	}
	
	static boolean bfs(int x, int y, int n) {
		Queue<int[]> q = new LinkedList();
		q.add(new int[]{0, 0, 0});
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			
			if (curr[0] == x && curr[1] == y && n == curr[2]) {
				return true;
			}
			
			if (n < curr[2]) break;
			
			int nx, ny;
			for (int i=0;i<4;i++) {
				nx = curr[0] + dr[i];
				ny = curr[1] + dc[i];
				
				q.add(new int[]{nx, ny, curr[2]+1});
			}
		}
		
		return false;
	}
	
	static boolean isReachable(int x, int y, int n) {
		long shortest_way = Math.abs(x) + Math.abs(y);
		return shortest_way <= n ? (shortest_way - n) % 2 == 0 : false;
	}
}