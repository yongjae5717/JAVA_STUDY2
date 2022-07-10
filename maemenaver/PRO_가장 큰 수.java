import java.util.*;

// 코드를 다시 짜보자
class Num implements Comparable<Num> {
    String str = "";
    int len = 0;
    
    Num(int num) {
        if (num == 0) {
            this.str = "0000";
            this.len = 1;
        } else if (num <= 9) {
            this.str = Integer.toString(num * 1000);
            this.len = 1;
        } else if (num <= 99) {
            this.str = Integer.toString(num * 100);
            this.len = 2;
        } else if (num <= 999) {
            this.str = Integer.toString(num * 10);
            this.len = 3;
        } else {
            this.str = Integer.toString(num);
            this.len = 4;
        }
    }
    
    String print() {
        String res = this.str.substring(0, this.len);
        return res;
    }
    
    @Override
    public int compareTo(Num t) {
        if (t.str.compareTo(this.str) != 0) {
            return t.str.compareTo(this.str);
        } else {
            return this.len - t.len;
        }
    }
}

class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<Num> queue = new PriorityQueue<Num>();
        
        for (int i = 0 ; i < numbers.length ; i++) {
            queue.add(new Num(numbers[i]));
        }
        
        String answer = "";
        
        while (!queue.isEmpty()) {
            answer = answer + queue.poll().print();
        }
        
        String valid0 = "";
        for (int i = 0 ; i < answer.length() ; i++) {
            valid0 = valid0 + "0";            
        }
        if (valid0.compareTo(answer) == 0) {
            return "0";
        }
        
        return answer;
    }
}

/*
테스트 1 〉	실패 (6017.85ms, 390MB)
테스트 2 〉	실패 (1928.79ms, 396MB)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (20.20ms, 94.1MB)
테스트 5 〉	실패 (4708.79ms, 397MB)
테스트 6 〉	실패 (3782.00ms, 380MB)
테스트 7 〉	통과 (2.45ms, 79.8MB)
테스트 8 〉	통과 (2.40ms, 69.4MB)
테스트 9 〉	통과 (2.82ms, 73.6MB)
테스트 10 〉	실패 (2.40ms, 74.3MB)
테스트 11 〉	통과 (2.65ms, 73.3MB)
테스트 12 〉	통과 (2.61ms, 76.7MB)
테스트 13 〉	실패 (2.29ms, 77.2MB)
테스트 14 〉	실패 (2.36ms, 75.8MB)
테스트 15 〉	통과 (2.56ms, 72.4MB)
*/