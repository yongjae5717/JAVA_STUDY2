import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {
  public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer> p = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			p.add(Integer.parseInt(st.nextToken()));
		}

    Collections.sort(p);

    int start = 0;
    int end = N-1;
    int prevMin = Integer.MAX_VALUE;
    int min = Integer.MAX_VALUE;

    int diffStart = 0;
    int diffEnd = N-1;
    int diff = Integer.MAX_VALUE;

    while (true) {
    // bw.write(Integer.toString(p.get(start)));
    // bw.write(" ");
    // bw.write(Integer.toString(p.get(end)));
    // bw.write(" ");
      
      int startValue = p.get(start);
      int endValue = p.get(end);

      min = endValue + startValue;

      if (start == end) {
        break;
      }
      
      if (Math.abs(min) < Math.abs(diff)) {
        diffStart = start;
        diffEnd = end;
        diff = min;
      }

      if (min == 0) {
        break;
      }
      
      if (min < 0) {
        start++;
      } else {
        end--;
      }



      prevMin = min;
    }
    
    bw.write(Integer.toString(p.get(diffStart)));
    bw.write(" ");
    bw.write(Integer.toString(p.get(diffEnd)));
    
		bw.flush();
		br.close();
		bw.close();
  }
}