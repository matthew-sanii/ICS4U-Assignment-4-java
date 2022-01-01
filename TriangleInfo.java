public class TriangleInfo {

    private double lengthA;

    private double lengthB;

    private double lengthC;

    public boolean checkTriangle(final double sideA, final double sideB,
      final double sideC) {
        if ((sideA + sideB) >= sideC && (sideB + sideC) >= sideA
            && (sideA + sideC) >= sideB) {
          lengthA = sideA;
          lengthB = sideB;
          lengthC = sideC;
          return true;
        }
        else {
          return false;
        }
      }

    public void getArea() {
      final double semiPerm = (lengthA + lengthB + lengthC) / 2;
      double area = semiPerm * (semiPerm - lengthA)
        * (semiPerm - lengthB) * (semiPerm - lengthC);
      area = Math.pow(area, 0.5);
        System.out.println(area);
    }

    public void getPerimeter() {
      final double perimeter = lengthA + lengthB + lengthC;
      System.out.println(perimeter);
    }

    public void getAngles() {
      final double lengthASquared = Math.pow(lengthA, 2);
      final double lengthBSquared = Math.pow(lengthB, 2);
      final double lengthCSquared = Math.pow(lengthC, 2);
      double angleA = ((lengthBSquared + lengthCSquared - lengthASquared)
        / (2 * lengthB * lengthC));
      double angleB = ((lengthASquared + lengthCSquared - lengthBSquared)
        / (2 * lengthA * lengthC));
      angleA = (Math.acos(angleA)) * (180 / 3.14);
      angleA = Math.round(angleA * 10.0) / 10.0;
      angleB = (Math.acos(angleB)) * (180 / 3.14);
      angleB = Math.round(angleB * 10.0) / 10.0;
      double angleC = 180 - angleA - angleB;
      angleC = Math.round(angleC * 10.0) / 10.0;
      System.out.println(angleA);
      System.out.println(angleB);
      System.out.println(angleC);
    }

    public String getType() {
      double smallerLengths;
      final double lengthASquared = Math.pow(lengthA, 2);
      final double lengthBSquared = Math.pow(lengthB, 2);
      final double lengthCSquared = Math.pow(lengthC, 2);
      if (lengthA < lengthB && lengthC < lengthB) {
        smallerLengths = lengthASquared + lengthCSquared;
      }
      else if (lengthB < lengthA && lengthC < lengthA) {
        smallerLengths = lengthBSquared + lengthCSquared;
      }
      else if (lengthA < lengthC && lengthB < lengthC) {
        smallerLengths = lengthASquared + lengthBSquared;
      }
      else {

      }
    }

    public String giveType(final double combinedLength,
      final double largeLength) {
        String type;
        if (combinedLength > largeLength) {
          type = "Obtuse";
        }
        else if (combinedLength < largeLength) {
          type = "Acute";
        }
        else if (combinedLength == largeLength) {
          type = "Right";
        }
        return type;
      }
}
