import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] board = new int[101][101];
        for(int[] rec : rectangle) {
            makeBorder(rec, board);
        }
        return bfs(board, new Node(characterX * 2, characterY * 2), new Node(itemX * 2, itemY * 2)) / 2;

    }

    public void makeBorder(int[] rec, int[][] board) {
        int x1 = rec[0] * 2;
        int x2 = rec[2] * 2; 
        int y1 = rec[1] * 2;
        int y2 = rec[3] * 2;
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                if(board[i][j] == 2) continue;
                board[i][j] = 2;
                if(i == x1 || i == x2 || j == y1 || j == y2) board[i][j] = 1;
            }
        }
    }

    public int bfs(int[][] board, Node cx, Node cy) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Node> q = new LinkedList<>();
        int[][] map = new int[101][101];
        map[cx.x][cx.y] = 1;
        q.add(cx);
        while(!q.isEmpty()) {
            Node now = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx > 100 || ny < 0 || ny > 100) continue;
                if(board[nx][ny] != 1 || map[nx][ny] != 0) continue;
                q.add(new Node(nx, ny));
                map[nx][ny] = map[now.x][now.y] + 1;
            }    
        }
        return map[cy.x][cy.y] - 1;
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
