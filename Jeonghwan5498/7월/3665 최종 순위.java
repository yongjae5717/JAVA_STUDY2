import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        // System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            N = Integer.parseInt(br.readLine());
            int[] inDegree = new int[N+1];
            int[] arr = new int[N+1];
            List<Integer>[] list = new ArrayList[N+1];

            // 작년순위정보 저장하기
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                list[i] = new ArrayList<>();
            }

            // 작년순위정보 이용, 연결리스트와 inDegree 만들기
            for(int i = 1; i <= N; i++){
                for(int j = i+1; j <= N; j++){
                    list[arr[i]].add(arr[j]);
                    inDegree[arr[j]]++;
                }
            }

            // 올해순위정보 이용, 연결리스트와 inDegree 수정하기.
            int M = Integer.parseInt(br.readLine());
            for(int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int front = Integer.parseInt(st.nextToken());
                int back = Integer.parseInt(st.nextToken());

                // 올해순위정보에서 우선순위가 end > front 일 경우
                if(list[front].contains(back)) {
                    list[front].remove(Integer.valueOf(back));
                    list[back].add(front);
                    inDegree[front]++;
                    inDegree[back]--;
                }
                // 올해순위정보에서 우선순위가 front > end 일 경우
                else{
                    list[back].remove(Integer.valueOf(front));
                    list[front].add(back);
                    inDegree[front]--;
                    inDegree[back]++;
                }
            }

            // DAG - BFS 시작지점 찾기
            visited = new boolean[N+1];
            visited[0] = true;
            ArrayList<Integer> zeroInDegreeList = FindZeroInDegree(inDegree);
            Queue<Integer> queue = new LinkedList<>();
            if(zeroInDegreeList.size() > 1){
                System.out.println("?");
                continue;
            }
            else if( zeroInDegreeList.size() == 0 ){
                System.out.println("IMPOSSIBLE");
                continue;
            }
            else{
                queue.offer(zeroInDegreeList.get(0));
            }

            // DAG - BFS 진행
            StringBuilder result = new StringBuilder();
            boolean isImpossible = false;
            for(int i = 1; i <= N; i++){
                if(queue.isEmpty()){
                    System.out.println("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
                int front = queue.poll();
                visited[front] = true;
                result.append(front).append(" ");

                for(Integer back : list[front]){
                    inDegree[back]--;
                    if(inDegree[back] == 0 && visited[back] == false){
                        queue.offer(back);
                    }
                }
            }
            if(!isImpossible) System.out.println(result);
        }
    }

    public static ArrayList<Integer> FindZeroInDegree(int[] inDegree){
        ArrayList<Integer> zeroInDegreeList = new ArrayList<>();
        for(int i = 1; i < inDegree.length; i++){
            if(inDegree[i] == 0 && visited[i] == false){
                zeroInDegreeList.add(i);
            }
        }
        return zeroInDegreeList;
    }
}