import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] town = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) town[i] = Integer.parseInt(st.nextToken());
		
		boolean[] rained = new boolean[N + 1];
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			for (int j=s;j<=e;j++) {
				rained[j] = true;
				++town[j];
			}
			
			if (i % 3 == 2) {
				// 배수도
				for (int j=1;j<=N;j++) if (rained[j]) --town[j];
				rained = new boolean[N + 1];
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i=1;i<=N;i++) sb.append(town[i]).append(" ");
		
		System.out.println(sb);
	}
}