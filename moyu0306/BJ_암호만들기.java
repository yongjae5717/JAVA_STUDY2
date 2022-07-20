import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

       static int L;
       static int C;
       static String[] letters;
     static StringBuilder answer;
    public static void main(String[] args) throws IOException {
        // write your code here
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);
        String[] input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        answer = new StringBuilder();
        letters = br.readLine().split(" ");
        Arrays.sort(letters);
        makeLetter(new StringBuilder(),0, 0,0,0,L);

        System.out.println(answer);


    }

    public static void makeLetter(StringBuilder preWord, int idx, int stage,int vowelCnt,int consonantCount, int len){

        if(stage == len){
            if(vowelCnt>=1 && consonantCount>=2) answer.append(preWord).append("\n");
            return;
        }

        for(int i = idx; i< C; i++){
            preWord.append(letters[i]);

            if(isVowel(letters[i])){
                makeLetter(preWord,i+1,stage+1,vowelCnt+1,consonantCount,len);
            }else{
                makeLetter(preWord,i+1,stage+1,vowelCnt,consonantCount+1,len);
            }

            preWord.deleteCharAt(preWord.length()-1);
        }

    }
    public static boolean isVowel(String s){
         char c = s.charAt(0);
        if(c=='a'||c=='e'||c=='i'||c=='u'||c=='o') return true;
        else return false;
    }
}