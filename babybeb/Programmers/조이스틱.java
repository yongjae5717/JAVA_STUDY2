import static java.lang.Math.*;

class Solution {
    
    public int solution(String name) {
        
        int TopBottom = 0;
        int rightLeft = name.length() - 1;
        
        for (int i = 0; i < name.length(); i++) {
            
            TopBottom += min(abs('Z' - name.charAt(i) + 1),
                             abs('A' - name.charAt(i)));
            
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int sequence = i + 1;
                for (int k = sequence; k < name.length(); k++) {
                    if (name.charAt(k) == 'A') {
                        sequence++;
                    } else {
                        break;
                    }
                }
                rightLeft = min(rightLeft, min(i * 2 + (name.length() - sequence),
                                               i + (name.length() - sequence) * 2));
            }
        }
        
        return TopBottom + rightLeft;
    }
}