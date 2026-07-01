import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class frog_jump {
  public static int solution(int[] A) {
    List<Integer> fibList = new ArrayList<>();

    fibList.add(0);
    fibList.add(1);

    int num=1;
    int i = 2;
    int jumpCount = 0;
    int start;
    while (num < A.length) {
      num = fibList.get(i-1) + fibList.get(i-2);
      fibList.add(num);
      i++;
    }

    for (int x=A.length; x>=0; x--) {
      step = x - start;
      if (A[x] == 1 && Collections.binarySearch(fibList, x) >= 0) {
        jumpCount += 1;
        start = x;
      }
    }

  }

  public static void main(String[] args) {
    int[] A={0,0,0,1,1,0,1,0,0,0,0};
    System.out.println(solution(A));
  }
}
