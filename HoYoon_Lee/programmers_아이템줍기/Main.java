package HoYoon_Lee.programmers_아이템줍기;

class Solution {
    private boolean[][] rectangles;
    private final int[] upDown = {-1, 1, 0, 0};
    private final int[] leftRight = {0, 0, -1, 1};
    private final int limit = 101;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        rectangles = new boolean[limit][limit];

        for (int[] rect : rectangle)
            for (int x = rect[0] * 2; x <= rect[2] * 2; x++)
                for (int y = rect[1] * 2; y <= rect[3] * 2; y++)
                    rectangles[y][x] = true;

        for (int[] rect : rectangle)
            for (int x = rect[0] * 2 + 1; x <= rect[2] * 2 - 1; x++)
                for (int y = rect[1] * 2 + 1; y <= rect[3] * 2 - 1; y++)
                    rectangles[y][x] = false;
        rectangles[characterY * 2][characterX * 2] = false;
        int answer = getShortestRoute(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return (answer - 1) / 2;
    }

    private int getShortestRoute(int currentX, int currentY, int itemX, int itemY){
        if(currentX == itemX && currentY == itemY) return 1;

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            int nextX = currentX + leftRight[i];
            int nextY = currentY + upDown[i];
            if(0 <= nextX && nextX < limit && 0 < nextY && nextY < limit && rectangles[nextY][nextX]){
                rectangles[nextY][nextX] = false;
                min = Math.min(min, getShortestRoute(nextX, nextY, itemX, itemY));
                rectangles[nextY][nextX] = true;
            }
        }
        return min + 1;
    }
}

public class Main {
    public static void main(String[] args) {
//        int[][] rectangle = {{1,1,7,4}, {3,2,5,5}, {4,3,6,9}, {2,6,8,8}};
//        new Solution().solution(rectangle, 1, 3, 7, 8);
        int[][] rectangle = {{1, 1, 4, 4}, {2, 2, 5, 5}, {3, 3, 7, 8}};
        new Solution().solution(rectangle, 1, 1, 5, 3);
    }
}
