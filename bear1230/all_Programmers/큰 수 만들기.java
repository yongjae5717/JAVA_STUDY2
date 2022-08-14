
class Solution {
    public static String solution(String number, int k ) {
        StringBuilder sb = new StringBuilder();
        sb.append(number);
        String answer = "";
        int point = 0;
        while(k-->0) {
            for(int i = 0; i < sb.length()-1; i++) {
                if(sb.charAt(i)-'0' < sb.charAt(i+1)-'0') {
                    sb.deleteCharAt(i);
                    break;
                }
                if(i == sb.length()-2) {
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        answer = sb.toString();
        return answer;
    }
}
