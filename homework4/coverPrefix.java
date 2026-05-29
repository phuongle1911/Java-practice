package homework4;

public class coverPrefix {
  public static int solution(int[] A) {
    if (A.length == 1) {
      return 1;
    };

    int x = A.length - 1;
    while (x > 0) {
      for (int i=0; i < x; i++) {
        if (A[i] == A[x]) {
          x--;
          // end for loop
        } else {
          continue;
        }
      }
      break;
    }
    return (x+1);
  }


  public static void main(String[] args) {
    int[] A = {1,2,2,1,0,2,5,4,2,1,0};
    System.out.println(solution(A));
  }
}
