import java.math.*;
import java.util.*;

class Solution {
    static HashSet<Integer> cand = new HashSet<Integer>();
      
    
    public int solution(String numbers) {
        int cnt =0;
        Perm(numbers,0,numbers.length());
        for(int i : cand){
            if(isPrime(i)) {cnt++; System.out.println(i);}
        }
        return cnt;
    }
    public static boolean isPrime(int k){
        double num = Math.sqrt(k);
        boolean flag = true;
        
        if(k<=1) return false;
        if(k==2) return true;
        for(int i=2; i<num+1;i++){
            if(k%i==0){flag = false; break;}
        }
        return flag;
    }
    
    public static void Perm(String num,int r, int n){
        if(r==n+1) return;
        
        for(int i=r; i<n; i++){
            String num1 = swap(num,r,i);
            cand.add(Integer.parseInt(num1.substring(0,r+1)));
            Perm(num1,r+1,n);
        }
    }
    public static String swap(String num,int r, int i){
        char[] nums = num.toCharArray();
        char tmp = nums[r];
        nums[r] = nums[i];
        nums[i] = tmp;
        return String.valueOf(nums);
    }
    

}