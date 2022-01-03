import java.util.Scanner;

final class Triangle {

  /**
  * Prevent instantiation
  * Throw an exception IllegalStateException.
  * if this ever is called
  *
  * @throws IllegalStateException
  *
  */
  private Triangle() {
    throw new IllegalStateException("Cannot be initiated.");
  }

  /**
  * The starting main() function.
  *
  * @param args Name of file containing a
  string of numbers.
  */
  public static void main(final String[] args) {
    final Scanner userInput = new Scanner(System.in);
    System.out.println("Input the first triangle side length: ");
    final String sideA = userInput.nextLine();
    System.out.println("Input the second triangle side length: ");
    final String sideB = userInput.nextLine();
    System.out.println("Input the third triangle side length: ");
    final String sideC = userInput.nextLine();
    try {
      final double lengthA = Double.parseDouble(sideA);
      final double lengthB = Double.parseDouble(sideB);
      final double lengthC = Double.parseDouble(sideC);
      TriangleInfo triangleInfo = new TriangleInfo(lengthA, lengthB, lengthC);
      if (triangleInfo.checkTriangle()) {
        System.out.println("The area is " + triangleInfo.getArea()
        + " units" + "\u00B2.");
        System.out.println("The perimeter is "
          + triangleInfo.getPerimeter() + " units.");
        System.out.println("The angles of the triangle"
          + " (in order of side lengths given) are:");
        triangleInfo.getAngles();
        System.out.println("The triangle is a(n) "
          + triangleInfo.getType() + " triangle.");
        System.out.println("The heights of the triangle "
          + "(in order of side lengths given) are:");
        triangleInfo.getHeights();
        System.out.println("The radius of the inscribed circle is "
          + triangleInfo.getInscribed() + " units.");
        System.out.println("The area of the circumcircle is "
          + triangleInfo.getCircumcircle() + " units\u00B2.");
      } else {
        System.out.println("Error, one or more of side "
          + "length values input are invalid"
          + " (no value can equal semiperimeter.");
      }
    } catch (NumberFormatException errorCode) {
      System.out.println("Error, one or more of side "
        + "length values input are invalid (must be numbers).");
    }
    System.out.println("\nDone.");
  }
}
