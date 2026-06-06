package homework3;


class arrayDeletion {
  public static int solution(int[] A) {

    if (A == null || A.length == 0) {
      return 0;
    }

    long S = 0;
    boolean peak = true;

    for (int i = 0; i< A.length; i++) {
      if (peak) {
        if (A[i] > A[i+1] || i == A.length - 1) {
          S = S + A[i];
          peak = false;
        }
      } else {
        if (A[i] < A[i+1] || i < A.length -1) {
          S = S - A[i];
          peak = true;
        }
      }
    }

    return (int) S % 1000000000;
  }

  public static void main(String[] args) {
    int[] A = {1,2,3,3,2,1,5};
    System.out.println(solution(A));
  }

}
