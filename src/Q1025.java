import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q1025 {
    public static void main(String[] args)  throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern p = Pattern.compile("([0-9]+) ([0-9]+)");

        int i = 0;

        while (true) {
            String line = reader.readLine();
            Matcher m = p.matcher(line);

            if (! m.find() || m.groupCount() != 2) {
                throw new RuntimeException("Invalid pattern found in the input!");
            }

            int n = Integer.parseInt(m.group(1)),
                q = Integer.parseInt(m.group(2));

            if (n == 0 && q == 0) {
                break;
            }

            ArrayList<Integer> list = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(reader.readLine()));
            }

            Collections.sort(list);
            System.out.println(String.format("CASE# %d:", ++i));

            for (int j = 0; j < q; j++) {
                int c = Integer.parseInt(reader.readLine());

                if (list.contains(c)) {
                    System.out.println(String.format("%d found at %d", c, list.indexOf(c) + 1));
                } else {
                    System.out.println(String.format("%d not found", c));
                }
            }
        }
    }
}
