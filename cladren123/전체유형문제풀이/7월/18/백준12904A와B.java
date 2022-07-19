package studyGroup.july.july18;


import java.util.*;
import java.io.*;

public class 백준12904A와B {

    static String start;
    static String target;

    static int answer;




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        start = br.readLine();
        target = br.readLine();

        answer = 0;



        solution();

        System.out.println(answer);

    }

    public static void solution()
    {

        while(target.length() > 0)
        {

            int n = target.length();

            String ntarget = "";

            if(target.charAt(n-1) == 'A')
            {
                ntarget = target.substring(0, n-1);
            }
            else if(target.charAt(n-1) == 'B')
            {
                ntarget = target.substring(0,n-1);
                ntarget = reverse(ntarget);
            }

            if(ntarget.equals(start))
            {
                answer = 1;
                return;
            }

            target = ntarget;

        }

        return;


    }





    public static String reverse(String one)
    {
        String result = "";

        char[] arr = one.toCharArray();

        for(int i = arr.length-1; i >= 0; i--)
        {
            result += arr[i];
        }

        return result;

    }

}
