package homework2;

public class homework2_3 {
  public static boolean isPrimeNumber(int number) {
    for (int i=2; i<number; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  };

  public static void main(String[] args) {
    int n = 17;
    System.out.println(isPrimeNumber(n));
  };
}
