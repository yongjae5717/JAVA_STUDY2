import static java.lang.Math.*;

import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static String a, b;
    static int[][] d;
    
    public static void main(String[] args) throws IOException {
        
        a = br.readLine();
        b = br.readLine();
        d = new int[a.length() + 1][b.length() + 1];
        
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    d[i][j] = d[i - 1][j - 1] + 1;
                } else {
                    d[i][j] = max(d[i - 1][j], d[i][j - 1]);
                }
            }
        }
        
        System.out.print(d[a.length()][b.length()]);
    }
}