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
      triangleInfo.getArea();
      triangleInfo.getPerimeter();
      triangleInfo.getAngles();
      System.out.println(triangleInfo.getType());
      triangleInfo.getHeights();
      triangleInfo.getInscribed();
      triangleInfo.getCircumcircle();
    } else {
      System.out.println(".");
    }
  }
}
