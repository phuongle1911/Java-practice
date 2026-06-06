package homework4;

import java.util.HashSet;

public class coverPrefix {
  public static int solution(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    HashSet<Integer> appeared = new HashSet<Integer>();
    int prefix = 0;

    for (int i=0; i<A.length; i++) {
      
      if (!appeared.contains(A[i])) {
        appeared.add(A[i]);
        prefix = i;
      }
    }

    return prefix;
  }


  public static void main(String[] args) {
    int[] A = {1,2,2,1,0,2,5,4,2,1,0};
    System.out.println(solution(A));
  }
}
