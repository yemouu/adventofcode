import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day02 {
  public static void part1(boolean test) {
    File input;
    if (test) input = new File("data/sample02.txt");
    else input = new File("data/input02.txt");

    int depth, horiz;
    depth = horiz = 0;
    try {

      Scanner scan = new Scanner(input);
      while (scan.hasNextLine()) {
        String line = scan.nextLine();
        if (line.equals("")) continue;

        String[] move = line.split(" ");

        switch (move[0]) {
          case "down":
            depth += Integer.parseInt(move[1]);
            break;
          case "forward":
            horiz += Integer.parseInt(move[1]);
            break;
          case "up":
            depth -= Integer.parseInt(move[1]);
            break;
        }
      }
    } catch (FileNotFoundException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }

    int ans = horiz * depth;

    if (test) Common.expect(150, ans);
    System.out.println("Answer: " + ans);
  }

  public static void part2(boolean test) {
    File input;
    if (test) input = new File("data/sample02.txt");
    else input = new File("data/input02.txt");

    int aim, depth, horiz;
    aim = depth = horiz = 0;
    try {

      Scanner scan = new Scanner(input);
      while (scan.hasNextLine()) {
        String line = scan.nextLine();
        if (line.equals("")) continue;

        String[] move = line.split(" ");

        switch (move[0]) {
          case "down":
            aim += Integer.parseInt(move[1]);
            break;
          case "forward":
            horiz += Integer.parseInt(move[1]);
            depth += aim * Integer.parseInt(move[1]);
            break;
          case "up":
            aim -= Integer.parseInt(move[1]);
            break;
        }
      }
    } catch (FileNotFoundException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }

    int ans = horiz * depth;

    if (test) Common.expect(900, ans);
    System.out.println("Answer: " + ans);
  }
}

