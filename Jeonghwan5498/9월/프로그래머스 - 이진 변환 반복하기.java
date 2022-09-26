class Solution {
    public int[] solution(String s) {
        
        int cnt = 0;
        int t = 0;
        while(true){
            t++;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0'){
                    cnt++;
                }
            }    
            s = s.replace("0","");
            s = Integer.toBinaryString(s.length());
            
            if(s.equals("1")){
                break;
            }
        }
        return new int[] {t, cnt};
        
    }
}