import java.io.*;
import java.util.*;

public class Main {

    public static class TreeNode{
        int idx;
        ArrayList<Integer> childsIdx = new ArrayList<>();

        public TreeNode(int idx) {
            this.idx = idx;
        }
        public ArrayList<Integer> getChildsIdx() {
            return childsIdx;
        }
    }

    static TreeNode[] treeNodes;
    static int N;
    static int[] time;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        treeNodes = new TreeNode[N];
        for(int i = 0; i < N; i++){
            treeNodes[i] = new TreeNode(i);
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for(int i = 1; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            treeNodes[num].getChildsIdx().add(i);
        }

        time = new int[N];
        for(int i = 0; i < N; i++){
            time[i] = -1;
        }
        System.out.println(doSearchTime(0));
    }

    public static int doSearchTime(int idx) {

        if (time[idx] != -1)
            return time[idx];

        ArrayList<Integer> childsIdx = treeNodes[idx].getChildsIdx();

        if (childsIdx.size() == 0) {
            time[idx] = 0;
        } else {
            int[] childsTimeArray = new int[childsIdx.size()];
            for (int i = 0; i < childsIdx.size(); i++){
                childsTimeArray[i] = doSearchTime(childsIdx.get(i));
            }
            Arrays.sort(childsTimeArray);

            int maxTime = 0;
            for (int i = 0; i < childsIdx.size(); i++){
                maxTime = Math.max(maxTime, childsTimeArray[i] + childsIdx.size() - i);
            }
            time[idx] = maxTime;
        }
        return time[idx];
    }
}
