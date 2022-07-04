import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Comparator;

public class Main {
  static public List<List<Integer>> memo = new ArrayList<>();
  
  static boolean find(int[] _target) {
    int[] target = Arrays.copyOf(_target, 3);
    if (target[0] > target[1]) {
      int tmp = target[0];
      target[0] = target[1];
      target[1] = tmp;
    }

    if (target[0] > target[2]) {
      int tmp = target[0];
      target[0] = target[2];
      target[2] = tmp;
    }

    if (target[1] > target[2]) {
      int tmp = target[1];
      target[1] = target[2];
      target[2] = tmp;
    }

    boolean finded = false;
    boolean add = false;
    
    for (List<Integer> v : memo) {
      if (v.get(0) == target[0] && v.get(1) == target[1] && v.get(2) == target[2]) {
        finded = true;
        break;
      } else {
        add = true;
      }
    }

    if (add || memo.size() == 0) {
      memo.add(Arrays.asList(target[0], target[1], target[2]));
    }

    return finded;
  }
  
  public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 1줄
    StringTokenizer line = new StringTokenizer(br.readLine());
    int[] stones = new int[3];
    var result = 0;
    
    stones[0] = Integer.parseInt(line.nextToken());
    stones[1] = Integer.parseInt(line.nextToken());
    stones[2] = Integer.parseInt(line.nextToken());

    int k = 0;
    boolean pass = false;

    while (true) {
      int s1 = stones[0];
      int s2 = stones[1];
      int s3 = stones[2];
      
      if (s1 == s2 && s1 == s3 && s2 == s3) {
        result = 1;
        break;
      }
      
      else if (!pass && find(stones)) {
        result = 0;
        break;
      }
      
      switch(k) {

        case 0:
          k++;
          if (s1 == s2) {
            pass = true;
            continue;
          }

          if (s1 < s2) {
            stones[1] = s2 - s1;
            stones[0] = s1 + s1;
          } else {
            stones[0] = s1 - s2;
            stones[1] = s2 + s2;
          }

          pass = false;
          break;
        case 1:
          k++;
          if (s1 == s3) {
            pass = true;
            continue;
          }

          if (s1 < s3) {
            stones[2] = s3 - s1;
            stones[0] = s1 + s1;
          } else {
            stones[0] = s1 - s3;
            stones[2] = s3 + s3;
          }
          pass = false;
          break;
        case 2:
          k=0;
          if (s2 == s3) {
            pass = true;
            continue;
          }

          if (s2 < s3) {
            stones[2] = s3 - s2;
            stones[1] = s2 + s2;
          } else {
            stones[1] = s2 - s3;
            stones[2] = s3 + s3;
          }
          pass = false;
          break;
        default:
          break;
      }
    }

    bw.write(Integer.toString(result));
    bw.flush();
		br.close();
		bw.close();
  }
}