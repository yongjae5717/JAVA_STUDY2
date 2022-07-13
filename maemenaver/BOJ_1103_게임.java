import java.io.*;
import java.util.*;

class BoardElement {
  int element;
  // int maxMove = 0;
  int maxMove = -1;
  BoardElement[] next = new BoardElement[4];
  
  BoardElement(int e) {
    this.element = e;
  }

  // int deep(int _move, ArrayList<BoardElement> checked) {  
  int deep(ArrayList<BoardElement> checked) {  
    checked.add(this);
    // boolean isNext = false;

    // int _max = _move;
    int _max = 0;
    if (this.maxMove != -1) {
      return maxMove;
    }
    for (int i = 0 ; i < 4 ; i++) {
      var nextBoard = this.next[i];
      if (nextBoard == null) {
        continue;
      }

      // 0인 경우
      if (nextBoard.element == 0) {
        continue;
      }

      // 다녀간 곳이면
      if (checked.contains(nextBoard)) {
        return 1000000000;
      }

      // 그 외의 경우
      int result = 0;

      result = nextBoard.deep((ArrayList<BoardElement>) checked.clone()) + 1;
      
      // if (nextBoard.maxMove == 0) {
      //   result = nextBoard.deep(_move+1, (ArrayList<BoardElement>) checked.clone());
      // } else {
      //   result = nextBoard.maxMove;
      // }

      // if (result == -1) {
      //   return -1;
      // }
      
      _max = Math.max(result, _max);
      // isNext = true;
    }

    // if (!isNext) {
    //   maxMove = Math.max(maxMove, _move+1);
    //   return maxMove;
    // }

    maxMove = Math.max(maxMove, _max);
    return maxMove;
  }
}

public class Main {  
  public static void main(String[] args) throws IOException {
    BoardElement[][] board;
    
    var br = new BufferedReader(new InputStreamReader(System.in));
    var line = new StringTokenizer(br.readLine());
    var N = Integer.parseInt(line.nextToken());
    var M = Integer.parseInt(line.nextToken());

    board = new BoardElement[N][M];

    for (int n = 0 ; n < N ; n++) {
      line = new StringTokenizer(br.readLine());
      var boardLine = line.nextToken().split("");
      for (int m = 0 ; m < M ; m++) {
        if (boardLine[m].compareTo("H") == 0) {
          boardLine[m] = "0";
        }
        board[n][m] = new BoardElement(Integer.parseInt(boardLine[m]));
      }
    }

    for (int n = 0 ; n < N ; n++) {
      for (int m = 0 ; m < M ; m++) {
        BoardElement b = board[n][m];
        try {
          board[n][m].next[0] = board[n-b.element][m];
        } catch (IndexOutOfBoundsException e) {}
        try {
          board[n][m].next[1] = board[n+b.element][m];
        } catch (IndexOutOfBoundsException e) {}
        try {
          board[n][m].next[2] = board[n][m-b.element];
        } catch (IndexOutOfBoundsException e) {}
        try {
          board[n][m].next[3] = board[n][m+b.element];
        } catch (IndexOutOfBoundsException e) {}
      }
    }

    if (board[0][0].element == 0) {
      System.out.println(0);
    } else {
      int s = board[0][0].deep(new ArrayList<BoardElement>());
      if (s >= 1000000000) {
        System.out.println(-1);
      } else {
        System.out.println(s+1);
      }
    }
  }
}