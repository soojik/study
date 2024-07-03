import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer>[] problems = new List[5];
		for (int i=0;i<5;i++) {
			problems[i] = new ArrayList();
		}
		
		int N = Integer.parseInt(br.readLine());
		
		int[] target = new int[5];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<5;i++) target[i] = Integer.parseInt(st.nextToken());
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			problems[Integer.parseInt(st.nextToken()) - 1].add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i=0;i<5;i++) Collections.sort(problems[i]);
		
		int sum = 0;
		for (int i=0;i<5;i++) {
			sum += problems[i].get(0);
			for (int j=1;j<target[i];j++) {
				sum += problems[i].get(j) * 2 - problems[i].get(j-1);
			}
			sum += 60;
		}
		
		System.out.println(sum - 60);
	}
}