import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.HashMap;

// 하루종일 고민해도 문제 이해와 해답이 생각나지 않아 우선 보류... ㅜ
public class Main {
  public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 1줄
    StringTokenizer line = new StringTokenizer(br.readLine());

    int s = Integer.parseInt(line.nextToken()); // 시간
    int N = Integer.parseInt(line.nextToken());
    int K = Integer.parseInt(line.nextToken());
    int R1 = Integer.parseInt(line.nextToken());
    int R2 = Integer.parseInt(line.nextToken());
    int C1 = Integer.parseInt(line.nextToken());
    int C2 = Integer.parseInt(line.nextToken());

    if (s == 0) {
      bw.write(Integer.toString(0));
    } else {
      
    }
    
    bw.flush();
		br.close();
		bw.close();
  }
}