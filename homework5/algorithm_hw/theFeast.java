package algorithm_hw;

public class theFeast {
  public static int theFeast(int n, int c, int m) {

    int bars;
    int spareWrap = 0;
    int extraBar;
    bars = n/c;
    extraBar = bars;
    while (extraBar > 0) {
      extraBar = (extraBar + spareWrap) / m;
      spareWrap = (extraBar + spareWrap) % m;
      bars += extraBar;
    }

    return bars;
  }

  public static void main(String[] args) {
    System.out.println(theFeast(6, 2, 2));
  }
}
