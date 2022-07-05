import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map.Entry;

class Node {
  TreeMap<String, Node> next = new TreeMap<>();

  Node add(String id) {
    Node node = new Node();
    next.putIfAbsent(id, node);
    return next.get(id);
  }

  void print(String dash, String id) {
    String _dash = "";
    if (id != "") {
      System.out.println(dash + id);
      _dash = new String("--" + dash);
    }

    for (String key : next.keySet()) {
      Node value = next.get(key);
      value.print(_dash, key);
    }
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    var br = new BufferedReader(new InputStreamReader(System.in));
    var bw = new BufferedWriter(new OutputStreamWriter(System.out));

    var root = new Node();
    
    // 1줄
    var line = new StringTokenizer(br.readLine());
    var N = Integer.parseInt(line.nextToken());
    for (int n = 0 ; n < N ; n++) {
      // 2줄
      line = new StringTokenizer(br.readLine());
       var processNode = root;
      var K = Integer.parseInt(line.nextToken());
      for (int k = 0 ; k < K ; k++) {
        var key = line.nextToken();
         processNode = processNode.add(key);
      }
    }

    root.print("", "");

    br.close();
    bw.close();
  }
}