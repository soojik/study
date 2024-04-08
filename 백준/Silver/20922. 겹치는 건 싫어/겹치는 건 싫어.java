import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] cnt = new int[100001]; // cnt[idx] == idx가 몇번 나왔는지
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) nums[i] = Integer.parseInt(st.nextToken());
		
		if (N == 1) {
			System.out.println(1);
			return;
		}

		int p1 = 0, p2 = 0;
		++cnt[nums[p1]];
		
		int ans = 0;
		while (p1 <= p2 && p2 < N) {
			if (cnt[nums[p2]] <= K) {
				++p2;
				if (p2 == N) {
					ans = Math.max(ans, p2 - p1);
					break;
				}
				++cnt[nums[p2]];
			}
			else {
				ans = Math.max(ans, p2 - p1);
				while (K < cnt[nums[p2]]) {
					--cnt[nums[p1++]];
				}
			}
		}
		
		System.out.println(ans);
	}
	
}
