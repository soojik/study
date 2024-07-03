import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input_str = br.readLine();
		String[] arr = input_str.split(" ");
		
		int ans = 0;
		for (String s : arr) {
			if (s.equals("")) continue;
			++ans;
		}
		
		System.out.println(ans);
	}
}