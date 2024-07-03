import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int min = N;
		int p1 = 0;
		int p2 = 0;
		
		while (p1 <= p2 && p2 < N) {
			if (D < arr[p2] - arr[p1]) {
				++p1;
			}
			else {
				min = Math.min(min, (N - p2 - 1) + (p1));
				++p2;
			}
		}
		System.out.println(min);
	}
}