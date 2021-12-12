import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Day01 {
  public static void part1(boolean test) {
    File input;
    if (test) input = new File("data/sample01.txt");
    else input = new File("data/input01.txt");

    try {
      Scanner scan = new Scanner(input);

      int prev = Integer.MAX_VALUE;
      int ans = 0;
      while (scan.hasNextLine()) {
        String line = scan.nextLine();
        if (line.equals("")) continue;

        int curr = Integer.parseInt(line);
        if (curr > prev) ans++;

        prev = curr;
      }

      if (test) Common.expect(7, ans);
      System.out.println("Answer: " + ans);
    } catch (FileNotFoundException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }
  }

  public static void part2(boolean test) {
    File input;
    if (test) input = new File("data/sample01.txt");
    else input = new File("data/input01.txt");

    ArrayList<Integer> inputArray = new ArrayList<Integer>();

    try {
      Scanner scan = new Scanner(input);
      while (scan.hasNextLine()) {
        String line = scan.nextLine();
        if (line.equals("")) continue;

        inputArray.add(Integer.parseInt(line));
      }
    } catch (FileNotFoundException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }

    int ans = 0;
    for (int i = 0; i < inputArray.size(); i++) {
      if (i + 3 >= inputArray.size()) break;
      if ((inputArray.get(i + 3) - inputArray.get(i)) > 0) ans++;
    }

    if (test) Common.expect(5, ans);
    System.out.println("Answer: " + ans);
  }
}
