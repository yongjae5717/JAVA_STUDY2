class Solution {
    public long[] solution(long[] numbers) {
        long[] answers = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            
            long num1 = numbers[i];
            
            if(num1 % 2 == 0){
                answers[i] = num1 + 1;
            }
            else{
                for(int j = 1; j <= 63; j++){
                    if((num1 & (1L << j)) == 0L){
                        answers[i] = num1 + (1L << (j-1));
                        break;
                    }
                }
            }
        }
        return answers;
    }
}