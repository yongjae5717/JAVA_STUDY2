import java.util.*;
import java.io.*;

public class Main {

    static boolean[] isVisited;
    static int[] cyclicNumber;
    static boolean cyclicFound;
    static ArrayList<Integer>[] station;
    static int N;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 노선도 정보 입력받기
        N = Integer.parseInt(br.readLine());
        station = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            station[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            station[a].add(b);
            station[b].add(a);
        }


        cyclicNumber = new int[N+1];
        for(int i = 1; i <= N; i++){
            cyclicNumber[i] = 3002;
        }

        // 순환선 역 찾기
        isVisited = new boolean[N+1];
        for(int i = 1; i <= N; i++){
            if(!cyclicFound){
                DoCyclicFind(i, i, 0);
            }
        }

        // 지선 역 찾기
        isVisited = new boolean[N+1];
        for(int i = 1; i <= N; i++){
            if(cyclicNumber[i] != 0 ){
                DoAcyclicFind(i, i, 0);
            }
        }

        for(int i = 1; i <= N; i++){
            System.out.print(cyclicNumber[i] + " ");
        }
    }

    public static void DoCyclicFind(int current, int start, int depth){

        if(depth >= 3 && current == start){
            cyclicFound = true;
            for(int i = 1; i <= N; i++){
                if(isVisited[i]){
                    cyclicNumber[i] = 0;
                }
            }
            return;
        }

        for(Integer next : station[current]){
            if(!isVisited[next]){
                isVisited[next] = true;
                DoCyclicFind(next, start, depth+1);
                isVisited[next] = false;
            }
        }
    }

    public static void DoAcyclicFind(int current, int start, int depth){

        if(cyclicNumber[current] == 0){
            cyclicNumber[start] = Math.min(cyclicNumber[start], depth);
        }

        for(Integer next : station[current]){
            if(!isVisited[next]){
                isVisited[next] = true;
                DoAcyclicFind(next, start, depth+1);
                isVisited[next] = false;
            }
        }
    }
}