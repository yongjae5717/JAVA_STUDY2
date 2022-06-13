class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;
        for(int i=len-1;i>=1;i--){
            int[] target= triangle[i];
            int[] dest = triangle[i-1];
            int len1 = target.length;
            for(int j=0;j<len1-1;j++){
                if(target[j]>target[j+1]) dest[j] +=target[j];
                else dest[j]+= target[j+1];
            }
        }
        int answer = triangle[0][0];
        return answer;
    }
}