import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Collections;

// BufferedWrite와 sort에 대해서는 공부했지만
// 이분탐색에 대해서는 더 공부할 필요성이 있어보인다. ㅠㅠㅠ
public class Main {
  public static int stk(int start, int end) {
    return 1;
  }
  
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
    
    for (int i = 0; i < N; i++) {
      bw.write(Integer.toString(p.get(i)));
      bw.write(" ");
    }
    
		bw.flush();
		br.close();
		bw.close();
  }
}