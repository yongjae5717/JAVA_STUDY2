class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = numbers[i] + findSumNumber(numbers[i]);
        }
        
        return answer;
    }
    
    private long findSumNumber(long n) {
        if (n % 2 == 0) {
            return 1;    
        }
        
        long i = 2;
        long dividedNum = n;
        for (; ; ) {
            if (dividedNum % 2 == 0) {
                break;
            }
            dividedNum /= 2;
            i *= 2;            
        }
        
        return i / 2 - i / 4;
    }
}