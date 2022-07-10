import java.io.*;
import java.util.*;

class Solution {
    
    Set<Integer> primeNums = new HashSet<>();
    boolean[] isVisited;
    int[] input;
    int[] arr;
    int answer = 0;
    
    public int solution(String numbers) {
        
        input = new int[numbers.length()];
        isVisited = new boolean[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            input[i] = numbers.charAt(i) - '0';
        }
        
        for (int i = 1; i <= input.length; i++) {
            arr = new int[i];
            func(i, 0);
        }
        
        answer = primeNums.size();
        return answer;
    }
    
    private void func(int n, int k) {
        
        if (n == k) {
            String strNum = "";
            for (int i = 0; i < n; i++) {
                strNum += arr[i];
            }
            
            int num = Integer.parseInt(strNum);
            if (isPrime(num)) {
                primeNums.add(num);
            }
            return;
        }
        
        for (int i = 0; i < input.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                arr[k] = input[i];
                func(n, k + 1);
                isVisited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int num) {
        
        if (num < 2) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}