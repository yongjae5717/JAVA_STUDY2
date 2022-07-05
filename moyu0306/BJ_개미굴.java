import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N;
    public static void main(String[] args) throws IOException {
        // write your code here
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        ArrayList<Node> antHole = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            String[] str = br.readLine().split(" ");
            int size = Integer.parseInt(str[0]);
            makeMap(1,antHole,str);
        }
        antHole.sort((a,b)->{return a.name.compareTo(b.name);});
        for(Node node : antHole){
            printMap(sb,node,0);
        }
        System.out.println(sb.toString());
    }

    public static void makeMap(int idx, ArrayList<Node> list, String[] info){

        if(idx == info.length) return;

        String food = info[idx];
        boolean flag = false;
        for(Node node : list){
            if(node.name.equals(food)){
                makeMap(idx+1,node.children,info);
                flag = true;
                break;
            }
        }

        if(!flag){
            Node childNode = new Node(food);
            list.add(childNode);
            makeMap(idx+1,childNode.children,info);
        }

    }

    public static void printMap(StringBuilder sb, Node node,int stage){

        for(int i=0; i<stage; i++) sb.append("--");
        sb.append(node.name+"\n");

        node.children.sort((a,b)->{return a.name.compareTo(b.name);});
        for(Node childNode: node.children){
            printMap(sb,childNode,stage+1);
        }
    }


}

class Node{
    String name;
    ArrayList<Node> children;

    public Node(String n){
        name = n;
        children = new ArrayList<>();
    }
}