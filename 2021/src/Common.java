public class Common {
  public static void expect(int expected, int output) {
    if (expected != output) {
      System.err.println("Unexpected result, " + output + ". Expected " + expected);
      System.exit(1);
    }
  }
}
