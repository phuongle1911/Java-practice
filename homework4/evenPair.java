package homework4;

public class evenPair {
  public static int solution(int[] A) {
    int countPair = 0;
    int x = 0;
    while (x < A.length - 1) {
      for (int i=x+1; i<A.length; i++) {
        if ((A[x]+A[i])%2 == 0) {
          countPair += 1;
        }
      }
      x++;
    }

    if (countPair > 1000000000) {
      return -1;
    }
    return countPair;
  }


  public static void main(String[] args) {
    int[] A = {2};
    System.out.println(solution(A));
  }
}
