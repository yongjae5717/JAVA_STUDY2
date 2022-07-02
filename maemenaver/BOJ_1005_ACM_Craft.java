import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.HashMap;

// class Node implements Comparable<Node> {
class Node {
  HashMap<Integer, Node> prevNode = new HashMap<>();
  HashMap<Integer, Node> nextNode = new HashMap<>();

  int id = 0;
  int currentCost = 0; // 이 곳의 건설 시간
  int minPathCost = -1; // 여기까지 오는데 최소 시간 비용 (currentCost 포함)

  void calcPathCost() {
    if (this.prevNode.size() == 0) {
      this.minPathCost = this.currentCost;
    }
    
    this.prevNode.forEach((id, node) -> {
        if (node.minPathCost == -1) {
          node.calcPathCost();
        }  

      this.minPathCost = Math.max(node.minPathCost + this.currentCost, this.minPathCost);
    });
  }

  void addNext(Node node) {
    this.nextNode.put(node.id, node);
    node.prevNode.put(this.id, this);
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 1줄
    StringTokenizer line = new StringTokenizer(br.readLine());

    int T = Integer.parseInt(line.nextToken());

    for (int t = 0 ; t < T ; t++) {
      if (t != 0) {
        bw.write("\n");
      }
      
      // 2줄
      line = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(line.nextToken()); // 건물 개수
      int K = Integer.parseInt(line.nextToken()); // 건설순서 개수

      // 3줄
      line = new StringTokenizer(br.readLine());
      
      HashMap<Integer, Node> nodes = new HashMap<>();
      
      for (int n = 1 ; n <= N ; n++) {
        int cost = Integer.parseInt(line.nextToken());
        Node node = new Node();
        node.id = n;
        node.currentCost = cost;
        nodes.put(n, node);
      }

      // 4줄
      for (int k = 0 ; k < K ; k++) {
        line = new StringTokenizer(br.readLine());
        Node node1 = nodes.get(Integer.parseInt(line.nextToken()));
        Node node2 = nodes.get(Integer.parseInt(line.nextToken()));

        node1.addNext(node2);
      }

      // 5줄
      line = new StringTokenizer(br.readLine());
      int W = Integer.parseInt(line.nextToken()); // 건물 번호
      Node node = nodes.get(W);

      node.calcPathCost();
      bw.write(Integer.toString(node.minPathCost));
    }
    
    ////////////////////////////////////////////////////////
    // bw.write(Long.toString(p.get("")));
    // bw.write(" ");

    bw.flush();
		br.close();
		bw.close();
  }
}