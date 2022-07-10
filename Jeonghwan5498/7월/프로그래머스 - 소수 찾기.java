import java.util.*;

class Solution {
    
    static int N;
    static boolean[] IsNotPrime;
    static boolean[] Visited;
    static int count;
    static HashSet<Integer> PrimeSet;
    
    public int solution(String numbers) {
    
        N = numbers.length();
        int max = (int)Math.pow(10,N);
        IsNotPrime = new boolean[max];
        Visited = new boolean[N];
        PrimeSet = new HashSet<>();
        
        make_primelist(max-1);
        backtracking(0, "", numbers);
        return PrimeSet.size();
    }
    
    public void backtracking (int depth, String str_combination, String numbers){
        
        if(!str_combination.equals("")){
            int combination = Integer.parseInt(str_combination);
            if(!IsNotPrime[combination]){
                PrimeSet.add(combination);
            }
        }
        
        if(depth == N){
            return;
        }
        
        for(int i = 0; i < N; i++ ){
            if(!Visited[i]){
                Visited[i] = true;
                backtracking(depth + 1, str_combination + numbers.charAt(i), numbers);
                Visited[i] = false;
            }
        }
    }
     
    public void make_primelist(int n){
        IsNotPrime[0] = true;
        IsNotPrime[1] = true;
        for(int i = 2; i < IsNotPrime.length; i++){
            if(!IsNotPrime[i]){       
                for(int j = 2; j * i < IsNotPrime.length; j++){
                    IsNotPrime[j * i] = true;
                }
            }
        }
    }
    
}