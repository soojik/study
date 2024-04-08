import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 전체 초밥 수
		int d = Integer.parseInt(st.nextToken()); // 초밥 가짓 수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		int[] dishes = new int[N];
		for (int i=0;i<N;i++) {
			dishes[i] = Integer.parseInt(br.readLine());
		}

		int max = 0;
		for (int i=0;i<N;i++) {
			HashSet<Integer> set = new HashSet();
			
			for (int p1=i;p1<Math.min(N, i+k);p1++) {
				set.add(dishes[p1]);
			}
			for (int p2=0;p2<i+k - N;p2++) {
				set.add(dishes[p2]);
			}
			
			set.add(c);
			max = Math.max(max, set.size());
		}
		
		System.out.println(max);
	}
}
