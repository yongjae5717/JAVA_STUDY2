import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {


    public static void main(String[] args) throws IOException {
        // write your code here
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        boolean reversed = false;

        char[] S = br.readLine().toCharArray();
        char[] T = br.readLine().toCharArray();

        int targetLength = S.length;
        int start = 0;
        int end = T.length-1;

        int idx = end;

        while(S.length !=(end - start +1)){
            if(reversed) start++;
            else end--;

            if(T[idx] == 'B'){
                    if(reversed){
                        idx =end;
                        reversed = false;
                    }else{
                        idx = start;
                        reversed = true;
                    }
            }else{
                if(reversed) idx = start;
                else idx = end;
            }
        }

        System.out.println(compare(S,T,start,reversed) ? 1 : 0);

    }

    public static boolean compare(char[] S, char[] T, int start, boolean reversed){
        boolean flag = true;
        for(int i=0; i<S.length; i++){
            int num = i;
            if(reversed) num = S.length - 1 -i;

            if(S[i]!= T[start+num]){
                flag = false;
                break;
            }

        }

        return flag;
    }
}