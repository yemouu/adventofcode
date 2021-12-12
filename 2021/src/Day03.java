import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day03 {
  public static void part1(boolean test) {
    File input;
    if (test) input = new File("data/sample03.txt");
    else input = new File("data/input03.txt");

    ArrayList<String> inputArray = new ArrayList<String>();

    try {
      Scanner scan = new Scanner(input);
      while (scan.hasNextLine()) {
        String line = scan.nextLine();
        if (line.equals("")) continue;

        inputArray.add(line);
      }
    } catch (FileNotFoundException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }

    String gammaBinary = "";
    String epsilonBinary = "";
    int zero, one;
    for (int i = 0; i < inputArray.get(0).length(); i++) {
      zero = one = 0;
      for (int j = 0; j < inputArray.size(); j++) {
        switch (inputArray.get(j).substring(i, i + 1)) {
          case "0":
            zero++;
            break;
          case "1":
            one++;
            break;
        }
      }

      if (zero > one) {
        gammaBinary += "0";
        epsilonBinary += "1";
      } else {
        gammaBinary += "1";
        epsilonBinary += "0";
      }
    }

    int ans = Integer.parseInt(gammaBinary, 2) * Integer.parseInt(epsilonBinary, 2);

    if (test) Common.expect(198, ans);
    System.out.println("Answer: " + ans);
  }

  public static void part2(boolean test) {
    File input;
    if (test) input = new File("data/sample03.txt");
    else input = new File("data/input03.txt");

    ArrayList<String> inputArray = new ArrayList<String>();

    try {
      Scanner scan = new Scanner(input);
      while (scan.hasNextLine()) {
        String line = scan.nextLine();
        if (line.equals("")) continue;

        inputArray.add(line);
      }
    } catch (FileNotFoundException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }

    ArrayList<String> gammaArray = new ArrayList<String>(inputArray);
    ArrayList<String> epsilonArray = new ArrayList<String>(inputArray);

    boolean inverse = false;
    ArrayList<String> array = gammaArray;
    for (int l = 0; l < 2; l++) {
      if (l == 1) {
        array = epsilonArray;
        inverse = true;
      }

      int zero, one;
      for (int i = 0; i < array.get(0).length(); i++) {
        zero = one = 0;
        for (int j = 0; j < array.size(); j++) {
          switch (array.get(j).substring(i, i + 1)) {
            case "0":
              zero++;
              break;
            case "1":
              one++;
              break;
          }
        }

        for (int k = array.size() - 1; k >= 0; k--) {
          if (inverse) {
            if (one < zero) {
              if (array.get(k).substring(i, i + 1).equals("0")) array.remove(k);
            } else {
              if (array.get(k).substring(i, i + 1).equals("1")) array.remove(k);
            }
          } else {
            if (zero > one) {
              if (array.get(k).substring(i, i + 1).equals("1")) array.remove(k);
            } else {
              if (array.get(k).substring(i, i + 1).equals("0")) array.remove(k);
            }
          }
        }
        if (array.size() <= 1) break;
      }
    }

    int ans = Integer.parseInt(gammaArray.get(0), 2) * Integer.parseInt(epsilonArray.get(0), 2);

    if (test) Common.expect(230, ans);
    System.out.println("Answer: " + ans);
  }
}
