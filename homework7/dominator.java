import java.util.ArrayList;
import java.util.Arrays;

public class dominator {
  public static String solution(int[] A) {
    if (A.length == 0) {
      return "-1";
    }

    int count = 0;
    int domNum = A[0];

    for (int i:A) {
      if (i==domNum) {
        count ++;
      } else {
        if (count == 0) {
          count ++;
          domNum = i;
        } else {
          count--;
        }
      }
    }

    int recount = 0;
    ArrayList<Integer> result = new ArrayList<>();
    for (int k =0; k<A.length; k++) {
      if (A[k]==domNum) {
        recount++;
        result.add(k);
      }
    }
    if (recount >= A.length/2) {
      return result.toString();
    } else {
      return "-1";
    }
  }

  public static void main(String[] args) {
    int[] A={4,1,6,1,1,1,5,1,5,1,4};
    System.err.println(solution(A));
  }
}
