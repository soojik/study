import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        HashSet<String> dancing = new HashSet<>();
        dancing.add("ChongChong");
        for (int i = 0; i < N; i++) {
            String[] met = br.readLine().split(" ");

            if (dancing.contains(met[0]) || dancing.contains(met[1])) {
                dancing.add(met[0]);
                dancing.add(met[1]);
            }
        }

        System.out.println(dancing.size());
        
    }
}
