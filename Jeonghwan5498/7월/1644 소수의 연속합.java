import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 에라토스테네스의 체로 소수 찾기.
        int N = Integer.parseInt(br.readLine());
        boolean[] isNotPrime = new boolean[N+1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for(int i = 2; i <= Math.sqrt(N); i++){
            for(int j = 2; j * i <= N; j++){
                isNotPrime[j*i] = true;
            }
        }

        // 찾은 소수를 리스트에 저장.
        ArrayList<Integer> primeList = new ArrayList<>();
        for(int i = 2; i <= N; i++){
            if(!isNotPrime[i]){
                primeList.add(i);
            }
        }

        // 소수의 연속합의 경우의 수 구하기.
        int left = 0, right = 0, count = 0, sum = 0;
        if(N != 1) {
            sum = primeList.get(0);
        }
        while(right < primeList.size() && left < primeList.size()){
            if(sum < N){
                if(++right == primeList.size()) break;
                sum += primeList.get(right);
            }
            else if(sum > N){
                sum -= primeList.get(left++);
            }
            else{
                count++;
                if(++right == primeList.size()) break;
                sum += primeList.get(right);

            }
        }
        System.out.println(count);
    }
}