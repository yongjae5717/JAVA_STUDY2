import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] str_numbers = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++ ){
            str_numbers[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(str_numbers, new Comparator<String>() {
            
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
        
        // 00000... 인 경우를 예외 처리
        if(str_numbers[0].equals("0")) return "0";
        
        String answer = "";
        for(int i = 0; i < numbers.length; i++ ){
            answer += str_numbers[i];
        }
        
        return answer;
    }
}