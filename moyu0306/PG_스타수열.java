import java.util.*;

class Solution {
    HashSet<Integer> num = new HashSet<>();
    public int solution(int[] a) {
        Integer[] countNum = new Integer[a.length+1];
        for(int i : a){
            countNum[i]++;
            num.add(i);
        }
        Arrays.sort(countNum,Collections.reverseOrder());
        int types = num.size();
        int len = a.length;
        for(int i=0; i<countNum.length; i++){
            int maxCount = countNum[i];
            int count = (maxCount>len/2) ? len/2 : maxCount;

            if(types-1>count) return count;
            else if(types>count-1) return count -1;
        }

        return -1;

    }
}