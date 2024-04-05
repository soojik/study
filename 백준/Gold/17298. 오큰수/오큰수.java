import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		if (N == 1) {
			System.out.println(-1);
			return;
		}
		
		int[] arr = new int[N];
		int[] ans = new int[N];
		int idx_ans = N-1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i=N-1;i>=0;i--) arr[i] = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack();

		StringBuilder sb = new StringBuilder();

		for (int i=0;i<N;i++) {
			int curr = arr[i];
			if (stack.isEmpty()) {
				ans[idx_ans--] = -1;
				stack.push(curr);
				continue;
			}
			
			while (!stack.isEmpty() && stack.peek() <= curr) {
				stack.pop();
			}
			
			ans[idx_ans--] = stack.isEmpty() ? -1 : stack.peek();
			
			stack.push(curr);
		}
		
		for (int i=0;i<N;i++) sb.append(ans[i]).append(" ");
		
		System.out.println(sb);
	}

}
