public class Main {
  public static void main(String[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].charAt(0) != '-') continue;
      args[i] = args[i].substring(1);

      boolean test = false;
      String testString = "";
      if (args[i].charAt(0) == 't') {
        test = true;
        testString = "Test";
        args[i] = args[i].substring(1);
      }

      switch (args[i]) {
        case "1":
          System.out.println("Day 1 " + testString);
          Day01.part1(test);
          Day01.part2(test);
          System.out.println();
          break;
        case "2":
          System.out.println("Day 2 " + testString);
          Day02.part1(test);
          Day02.part2(test);
          System.out.println();
          break;
        case "3":
          System.out.println("Day 3 " + testString);
          Day03.part1(test);
          Day03.part2(test);
          System.out.println();
          break;
      }
    }
  }
}
