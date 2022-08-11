import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < number.length(); i++){
            char c = number.charAt(i);
            while(!stack.isEmpty() && k > 0 && stack.peek() < c){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        for(int i = 0; i < k; i++){
            stack.pop();
        }
        
        String result = "";
        while(!stack.isEmpty()){
            result = stack.pop() + result;
        }
        return result;
    }
}