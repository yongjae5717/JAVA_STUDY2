import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static ArrayList<Long> decreasingNumbers = new ArrayList<>();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        if (n > 1022) {
            System.out.print(-1);
            return;
        }
        for (int i = 1; i <= 10; i++) {
            arr = new int[i];
            func(0, i, 10);
        }
        Collections.sort(decreasingNumbers);
        System.out.print(decreasingNumbers.get(n));
    }
    
    private static void func(int k, int cnt, int lastIdx) {
        
        if (k == cnt) {
            long number = 0;
            for (int i = 0; i < arr.length; i++) {
                number *= 10;
                number += arr[i];
            }
            decreasingNumbers.add(number);
            return;
        }
        
        for (int i = lastIdx - 1; i >= 0; i--) {
            arr[k] = i;
            func(k + 1, cnt, i);
        }
        
    }
}