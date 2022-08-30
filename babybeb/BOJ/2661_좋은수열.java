import java.io.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int n;
    static boolean isFound;
    static String ans;
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        func("");
        System.out.print(ans);
    }
    
    private static void func(String sequence) {
        if (isFound) {
            return;
        }
        
        int size = sequence.length();
        int halfSize = size / 2;
        for (int i = 1; i <= halfSize; i++) {
            if (sequence.substring(size - i * 2, size - i).equals(sequence.substring(size - i))) {
                return;
            }
        }
        
        if (size == n) {
            ans = sequence;
            isFound = true;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 3; j++) {
                func(sequence + j);
            }
        }
    }
}