import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        for (int t = 0; t < T; t++) {
            String[] str_split = br.readLine().split(" ");

            while (true) {
                String line = br.readLine();
                if (line.equals("what does the fox say?")) {
                    break;
                }
                String cry = line.split(" ")[2];
                for (int i=0;i<str_split.length;i++) {
                    if (str_split[i].equals(cry)) {
                        str_split[i] = "";
                    }
                }
            }

            for (String str : str_split) if (!str.equals("")) sb.append(str).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
