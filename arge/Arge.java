public class Arge {
  public static int nbYear(int p0, double percent, int aug, int p) {
    int currentP = p0 + ((int) (p0 * percent / 100)) + aug;
    if (currentP >= p) {
      return 1;
    } else {
      return 1 + nbYear(currentP, percent, aug, p);
    }
  }
}
