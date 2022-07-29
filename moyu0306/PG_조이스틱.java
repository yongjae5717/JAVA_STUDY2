import java.util.*;
import java.math.*;

class Solution {
    
    public int solution(String name) {
        return countChanges(name)+countMovement(name);
    }
    public int countChanges(String name){
        int count = 0;
        for(int i=0; i<name.length(); i++){
            int change = name.charAt(i)-'A';
            if(change>13) change = 26- change;
            count += change;
        }
        return count;
    }
    public int countMovement(String name){
        int len = name.length();
        int left = 0;
        int leftA = 0;
        boolean leftFlag = true;
        
        int right = 0;
        int rightA = 0;
        boolean rightFlag = true;
        for(int i= 1; i<=len/2; i++){
            if(name.charAt(i)!='A'){
                left = i;
                leftFlag =false;
            }else if (leftFlag){
                leftA++;
            }
            if(name.charAt(len - i)!='A'){
                right = i;
                rightFlag = false;
            }else if (rightFlag){
                rightA++;
            }   
        }
       int path1 = len - 1 - leftA;
       int path2 = len - 1 - rightA;
       int path3 = left *2 +right;
       int path4 = right*2 + left;
        
        
        return Integer.min(Integer.min(path1,path2),Integer.min(path3,path4));
    }
}