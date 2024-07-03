import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int total = Integer.parseInt(st.nextToken());
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			total -= Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
		}
		
		System.out.println(0 <= total ? total : "No");
	}
}