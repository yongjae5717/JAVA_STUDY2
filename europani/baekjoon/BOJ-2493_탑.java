import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] arr, result;

    static class Top {
        int idx;
        int h;

        Top(int idx, int h) {
            this.idx=idx;
            this.h=h;          
        }

        public String toString() {
            return idx + "," + h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");

        arr = new int[N];
        result = new int[N];
        for (int i=0; i < N; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        Stack<Top> stack = new Stack<>();
        for (int i=0; i < N; i++) {
            while(!stack.isEmpty()) {
                Top point = stack.peek();
                if (point.h > arr[i]) {
                    result[i] = point.idx;
                    break;
                } else {
                    stack.pop();
                }
            }

            stack.push(new Top(i+1, arr[i]));
        }

        for (int n : result) {
            System.out.print(n + " ");
        }
    }
}