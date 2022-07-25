import java.io.*;
import java.util.*;

public class Main {
  static final int MAX = 14;
  static int n, m, c;
  static int[] arr;
  static int[][][] dp;

  // 비트마스크에 대한 공부가 필요함
  // 참고 : https://coder-in-war.tistory.com/entry/BOJ-JAVA1480-%EB%B3%B4%EC%84%9D%EB%AA%A8%EC%9C%BC%EA%B8%B0
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer line = new StringTokenizer(br.readLine());

    n = Integer.parseInt(line.nextToken());
    m = Integer.parseInt(line.nextToken());
    c = Integer.parseInt(line.nextToken());

    arr = new int[n];
    dp = new int[1 << MAX][11][21]; // ???
  }
}