import java.util.Arrays;

class deep_pit {
  public static int solution(int[] A) {
    int deepest;
    int bottom = 0;
    int peak = 0;
    boolean findPeak = true;
    int pitDepth = 0;
    int[] depthArr = new int[A.length/2];


    if (A.length < 3) {
      return -1;
    }

    int j = 0;
    for (int i=0; i<A.length-1; i++) {
      if (findPeak) {
        if (A[i] > A[i+1] || i == A.length -2) {
          peak = Math.max(A[i], A[i+1]);
          pitDepth = Math.min(pitDepth,peak-bottom);
          depthArr[j] = pitDepth;
          j++;
          findPeak = false;
        }
       } else {
        if (A[i] < A[i+1]) {
          bottom = A[i];
          pitDepth = peak - bottom;
          findPeak = true;
        }
        }
      }

    if (depthArr[1] != 0) {
      deepest = depthArr[1];
      for (int k=2; k< depthArr.length-1; k++) {
        deepest = Math.max(deepest, depthArr[k]);
        if (depthArr[k] == 0) {
          break;
        }
      }
      return deepest;
    }

  return -1;

  }

  public static void main(String[] args) {
    int[] A = {0,5,4,-1,0,2,7,-3,2,3};
    System.out.println(solution(A));
  }
}