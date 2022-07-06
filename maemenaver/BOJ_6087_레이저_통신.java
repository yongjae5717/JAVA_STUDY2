import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

class Node {
  HashMap<String, Node> prev = new HashMap<>();
  HashMap<String, Node> next = new HashMap<>();
  Set<Node> checked = new HashSet<Node>(Arrays.asList(this));
  String text = "";
  int mirror = 0;
}


// 문제 해결 능력 부족으로 인한 실패
public class Main {
  public static void main(String[] args) throws IOException {
    var br = new BufferedReader(new InputStreamReader(System.in));
    var bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Node[][] node = new Node[100][100];

    // 1줄
    var line = new StringTokenizer(br.readLine());
    var W = Integer.parseInt(line.nextToken());
    var H = Integer.parseInt(line.nextToken());

    Node C1 = null;
    Node C2 = null;
    
    for (int h = 0 ; h < H ; h++) {
      for (int w = 0 ; w < W ; w++) {
        // 2줄
        line = new StringTokenizer(br.readLine());        
        var text = line.nextToken();

        if (text.equals("C")) {
          if (C1 == null) {
            C1 = node[h][w];
          } else {
            C2 = node[h][w];
          }
        }
        
        node[h][w].text = text;
      }
    }

    for (int h = 0 ; h < H ; h++) {
      for (int w = 0 ; w < W ; w++) {
        // 상
        if (h-1 >= 0) {
          if (node[h-1][w].text != "*" 
              && node[h-1][w].text != ""
              && node[h][w].checked.contains(node[h-1][w])) {
            
            node[h][w].next.putIfAbsent("up", node[h-1][w]);
            node[h-1][w].prev.putIfAbsent("down", node[h][w]);
            node[h-1][w].checked.add(node[h][w]);
          }
        }
        // 하
        if (h+1 < H) {
          if (node[h+1][w].text != "*" 
              && node[h+1][w].text != ""
              && node[h][w].checked.contains(node[h+1][w])) {
            
            node[h][w].next.putIfAbsent("down", node[h+1][w]);
            node[h+1][w].prev.putIfAbsent("up", node[h][w]);
            node[h+1][w].checked.add(node[h][w]);
          }
        }
        // 좌
        if (w-1 >= 0) {
          if (node[h][w-1].text != "*" 
              && node[h][w-1].text != ""
              && node[h][w].checked.contains(node[h][w-1])) {
            
            node[h][w].next.putIfAbsent("left", node[h][w-1]);
            node[h][w-1].prev.putIfAbsent("right", node[h][w]);
            node[h][w-1].checked.add(node[h][w]);
          }
        }
        // 우
        if (w+1 < W) {
          if (node[h][w+1].text != "*" 
              && node[h][w+1].text != ""
              && node[h][w].checked.contains(node[h][w+1])) {
            
            node[h][w].next.putIfAbsent("right", node[h][w+1]);
            node[h][w+1].prev.putIfAbsent("left", node[h][w]);
            node[h][w+1].checked.add(node[h][w]);
          }
        }
      }
    }

    br.close();
    bw.close();
  }
}