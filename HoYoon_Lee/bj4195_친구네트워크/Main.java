package HoYoon_Lee.bj4195_친구네트워크;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, String> friends = new HashMap<>();
    private static final Map<String, Integer> memberNumber = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0){
            int f = Integer.parseInt(br.readLine());
            friends.clear();
            memberNumber.clear();
            while (f-- > 0){
                String[] newFriend = br.readLine().split(" ");
                for(int i = 0; i < 2; i++){
                    if(!friends.containsKey(newFriend[i])) {
                        friends.put(newFriend[i], newFriend[i]);
                        memberNumber.put(newFriend[i], 1);
                    }
                }
                String g1 = findGroup(newFriend[0]), g2 = findGroup(newFriend[1]);
                int res = memberNumber.get(g1);
                if(!g1.equals(g2)){
                    if(memberNumber.get(g1) < memberNumber.get(g2)){
                        friends.replace(g1, g2);
                        memberNumber.replace(g2, memberNumber.get(g1) + memberNumber.get(g2));
                        res = memberNumber.get(g2);
                    }
                    else{
                        friends.replace(g2, g1);
                        memberNumber.replace(g1, memberNumber.get(g1) + memberNumber.get(g2));
                        res = memberNumber.get(g1);
                    }
                }
                bw.write(res + "\n");
            }
        }
        br.close();
        bw.close();
    }

    private static String findGroup(String name){
        if(!friends.get(name).equals(name))
            friends.replace(name, findGroup(friends.get(name)));
        return friends.get(name);
    }
}