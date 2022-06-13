import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
        int absA = Math.abs(a);
        int absB = Math.abs(b);
        return (absA == absB) ? a - b : absA - absB;
    });

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(pq.isEmpty()){
                    sb.append("0");
                }else{
                    sb.append(pq.poll());
                }
                sb.append("\n");
            }else{
                pq.offer(num);
            }
        }
        System.out.println(sb.toString());
    }
}