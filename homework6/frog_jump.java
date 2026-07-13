import java.util.ArrayList;
import java.util.LinkedList;


public static class Jump {
  int position;
  int move;
  public Jump(int position, int move) {
    this.position = position;
    this.move = move;
  }

}

public static int solution(int[] A) {
  ArrayList<Integer> fib = new ArrayList<>(); 

  fib.add(0); // Time O1
  fib.add(1); // Time O1

  int i=1;
  while (fib.get(i) <= A.length) { // O1 + O(logn-10)*logn; n=A.length
    fib.add(fib.get(i) + fib.get(i-1));
    i++;
  };


  LinkedList<Jump> queue = new LinkedList<Jump>();
  boolean[] visited = new boolean[A.length+1];

  for (int j=2; j<fib.size()-1; j++) { // time Ologn
    int pos = fib.get(j) - 1;
    if (A[pos] == 1) {
      queue.add(new Jump(pos, 1)); // time O1
      visited[pos] = true; // time O1
    }

    if (pos == A.length) {
      return 1;
    }
  };


  while (!queue.isEmpty()) { // O(n*logn); 
    Jump startPos = queue.remove(); //time O1
    for (int k=1; k<fib.size()-1; k++) { // Ologn
      int nextPos = startPos.position + fib.get(k);
      if (nextPos == A.length) {
        return startPos.move+1;
      } else if (nextPos < A.length && A[nextPos] == 1 && visited[nextPos] == false) {
        queue.add(new Jump(nextPos, startPos.move+1)); // O1
        visited[nextPos] = true; // O1
      } else if (nextPos > A.length) {
        continue;
      }

    }
  }

  return -1;

}
// time complexity: b=nlogn

public static void main(String[] args) {
  int[] A={1,1,1,1,1,0,1,1,1,0,0};
  System.out.println(solution(A));
}

// 0,1,0,0