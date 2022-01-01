public class TriangleInfo {

    private double lengthA;

    private double lengthB;

    private double lengthC;

    private double triangleArea;

    private double semiPerimeter;

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
      semiPerimeter = (lengthA + lengthB + lengthC) / 2;
      double area = semiPerimeter * (semiPerimeter - lengthA)
        * (semiPerimeter - lengthB) * (semiPerimeter - lengthC);
      area = Math.pow(area, 0.5);
      triangleArea = Math.round(area * 100.0) / 100.0;
      System.out.println(triangleArea);
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
      String triangleType;
      final double lengthASquared = Math.pow(lengthA, 2);
      final double lengthBSquared = Math.pow(lengthB, 2);
      final double lengthCSquared = Math.pow(lengthC, 2);
      if (lengthA < lengthB && lengthC < lengthB) {
        smallerLengths = lengthASquared + lengthCSquared;
        triangleType = giveType(smallerLengths, lengthBSquared);
      }
      else if (lengthB < lengthA && lengthC < lengthA) {
        smallerLengths = lengthBSquared + lengthCSquared;
        triangleType = giveType(smallerLengths, lengthASquared);
      }
      else if (lengthA < lengthC && lengthB < lengthC) {
        smallerLengths = lengthASquared + lengthBSquared;
        triangleType = giveType(smallerLengths, lengthCSquared);
      }
      else {
        triangleType = "Equallateral";
      }
      return triangleType;
    }

    public String giveType(final double combinedLength,
      final double largeLength) {
        String type = "Equallateral";
        if (combinedLength > largeLength) {
          type = "Acute";
        }
        else if (combinedLength < largeLength) {
          type = "Obtuse";
        }
        else if (combinedLength == largeLength) {
          type = "Right";
        }
        return type;
      }

    public void getHeights() {
      final double heightA = Math.round((2 * (triangleArea / lengthA))
        * 100.0) / 100.0;
      final double heightB = Math.round((2 * (triangleArea / lengthB))
        * 100.0) / 100.0;
      final double heightC = Math.round((2 * (triangleArea / lengthC))
        * 100.0) / 100.0;
      System.out.println(heightA);
      System.out.println(heightB);
      System.out.println(heightC);
    }

    public void getInscribed() {
      final double inscribedCircleRadius = Math.round((triangleArea
        / semiPerimeter) * 1000.0) / 1000.0;
      System.out.println(inscribedCircleRadius);
    }

    public void getCircumcircle() {
      double circumcircleRadius = (lengthA * lengthB * lengthC)
        / (4 * triangleArea);
      double circumcircleArea = 3.14 * Math.pow(circumcircleRadius, 2);
      System.out.println(Math.round(circumcircleArea * 100.0) / 100.0);
    }
}
