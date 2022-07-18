package studyGroup.july.july17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*

https://firework-ham.tistory.com/10

 */

public class 백준1644소수의연속합 {

    static int n;
    static ArrayList<Integer> primeArr;
    static ArrayList<Integer> sumArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        primeArr = new ArrayList<>();

        for(int i = 1; i <= n; i++)
        {
            if(prime(i))
            {
                primeArr.add(i);
            }
        }

        int size = primeArr.size();

        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        while(true)
        {
            if(sum >= n) sum -= primeArr.get(start++);
            else if(end == size) break;
            else sum += primeArr.get(end++);
            if(n == sum) count++;
        }

        System.out.println(count);


    }


    // 소수 구하는 함수
    public static boolean prime(int number)
    {
       if(number == 1)
       {
           return false;
       }

       if(number == 2)
       {
           return true;
       }

       for(int i = 2; i*i <= number; i++)
       {
           if(number % i == 0)
           {
               return false;
           }
       }

       return true;




    }

}
