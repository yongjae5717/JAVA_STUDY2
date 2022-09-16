import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            func();
        }
        System.out.print(sb.toString());
    }
    
    private static void func() throws IOException {
        int n = Integer.parseInt(br.readLine());
        HashSet<String> hashSet = new HashSet<>();
        boolean isYes = true;
        for (int i = 0; i < n; i++) {
            String phoneNumber = br.readLine();
            hashSet.add(phoneNumber); // 현재 전화번호를 hashSet에 추가
        }
        for (String phoneNumber : hashSet) {
            for (int index = 1; index < phoneNumber.length(); index++) { // 접두어인 경우 찾기
                if (hashSet.contains(phoneNumber.substring(0, index))) {
                    isYes = false;
                }
            }
        }
        
        if (isYes) {
            sb.append("YES\n");
        } else {
            sb.append("NO\n");
        }
    }
}