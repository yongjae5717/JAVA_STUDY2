package studyGroup.july.july12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*

부분합
모든 경우의 수 계산

누적합으로 모든 부분배열의 합 구함
투포인터로 부분배열들의 합을 구함

 */


public class 백준2143두배열의합 {

    static int t, n, m;
    static int[] map1;
    static int[] map2;

    static long answer;

    static ArrayList<Integer> arr1;
    static ArrayList<Integer> arr2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        map1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
        {
            map1[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        map2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++)
        {
            map2[i] = Integer.parseInt(st.nextToken());
        }


        arr1 = new ArrayList<>();
        arr2 = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            int sum = 0;
            for(int j = i; j < n; j++)
            {
                sum += map1[j];
                arr1.add(sum);
            }
        }

        for(int i = 0; i < m; i++)
        {
            int sum = 0;
            for(int j = i; j < m; j++)
            {
                sum += map2[j];
                arr2.add(sum);
            }
        }

        Collections.sort(arr1);
        Collections.sort(arr2);

        answer = 0;
        answer = getcount();

        System.out.println(answer);

    }

    public static long getcount()
    {
        int pa = 0;
        int pb = arr2.size() - 1;
        long count = 0;

        while(pa < arr1.size() && pb >= 0)
        {
            long sum = arr1.get(pa) + arr2.get(pb);

            if(sum == t)
            {
                int a = arr1.get(pa);
                int b = arr2.get(pb);

                long acount = 0;
                long bcount = 0;

                while(pa < arr1.size() && arr1.get(pa) == a)
                {
                    acount++;
                    pa++;
                }
                while(pb >= 0 && arr2.get(pb) == b)
                {
                    bcount++;
                    pb--;
                }

                count += acount * bcount;

            }

            else if(sum < t)
                pa++;

            else if(sum > t)
                pb--;

        }

        return count;

    }
}
