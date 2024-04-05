import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, M;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		
		int p1 = 0;
		int p2 = 1;
		int diff;
		int ans = Integer.MAX_VALUE;
		
		while (p1 < p2 && p2 < N) {
			diff = arr[p2] - arr[p1];
			
			if (diff < M) {
				++p2;
			}
			else {
				ans = Math.min(ans, diff);
				++p1;
			}
			
			if (p1 == p2) {
				++p2;
			}
		}
		
		System.out.println(ans);
	}
}
