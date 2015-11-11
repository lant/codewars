/**
 *
 */
public class IntSqRoot {

  public static final int ERROR = 1;

  public static long IntRac(long n, long guess) {
    return IntRecRac(n, function(n, guess), guess);
  }

  public static long IntRecRac(long n, long new_guess, long old_guess) {
    if (Math.abs(new_guess - old_guess) <= ERROR) {
      return 1;
    } else {
      return 1 + IntRecRac(n, function(n, new_guess), new_guess);
    }
  }

  public static long function(long n, long guess) {
    return ( guess + n / guess ) / 2;
  }
}
