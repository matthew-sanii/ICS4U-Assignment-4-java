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
    final double sideA = userInput.nextDouble();
    System.out.println("Input the second triangle side length: ");
    final double sideB = userInput.nextDouble();
    System.out.println("Input the third triangle side length: ");
    final double sideC = userInput.nextDouble();
    TriangleInfo triangleInfo = new TriangleInfo(sideA, sideB, sideC);
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
        + "length values input are invalid.");
    }
    System.out.println("\nDone");
  }
}
