public class TriangleInfo {

    /**
    * The empty double for the first triangle side length.
    */
    private double lengthA;

    /**
    * The empty double for the second triangle side length.
    */
    private double lengthB;

    /**
    * The empty double for the third triangle side length.
    */
    private double lengthC;

    /**
    * The empty double for the triangle area.
    */
    private double triangleArea;

    /**
    * The empty double for the triangle's semiperimeter.
    */
    private double semiPerimeter;

    /**
    * The rounding used for the angles of the triangle.
    */
    private double angleRounding = 10.0;

    /**
    * The rounding used for the calculations (area, perimeter, circumcircle
    * area).
    */
    private double unitRounding = 100.0;

    /**
    * The pi value.
    */
    private double pi = 3.14;

    /**
    * The value used to turn radians into degrees (acos gives radians as answer).
    */
    private double angles = 180;

    /**
    * Value used for rounding radius for inscribed circle.
    */
    private double radiusRounding = 1000.0;

    /**
    *
    */
    protected boolean checkTriangle(final double sideA, final double sideB,
      final double sideC) {
        if ((sideA + sideB) >= sideC && (sideB + sideC) >= sideA
            && (sideA + sideC) >= sideB) {
            lengthA = sideA;
            lengthB = sideB;
            lengthC = sideC;
            return true;
        } else {
            return false;
        }
    }

    /**
    *
    */
    public void getArea() {
        semiPerimeter = (lengthA + lengthB + lengthC) / 2;
        double area = semiPerimeter * (semiPerimeter - lengthA)
            * (semiPerimeter - lengthB) * (semiPerimeter - lengthC);
        area = Math.pow(area, 0.5);
        triangleArea = Math.round(area * unitRounding) / unitRounding;
        System.out.println(triangleArea);
    }

    /**
    *
    */
    public void getPerimeter() {
        final double perimeter = lengthA + lengthB + lengthC;
        System.out.println(perimeter);
    }

    /**
    *
    */
    public void getAngles() {
        final double lengthASquared = Math.pow(lengthA, 2);
        final double lengthBSquared = Math.pow(lengthB, 2);
        final double lengthCSquared = Math.pow(lengthC, 2);
        double angleA = ((lengthBSquared + lengthCSquared - lengthASquared)
          / (2 * lengthB * lengthC));
        double angleB = ((lengthASquared + lengthCSquared - lengthBSquared)
          / (2 * lengthA * lengthC));
        angleA = (Math.acos(angleA)) * (angles / pi);
        angleA = Math.round(angleA * angleRounding) / angleRounding;
        angleB = (Math.acos(angleB)) * (angles / pi);
        angleB = Math.round(angleB * angleRounding) / angleRounding;
        double angleC = angles - angleA - angleB;
        angleC = Math.round(angleC * angleRounding) / angleRounding;
        System.out.println(angleA);
        System.out.println(angleB);
        System.out.println(angleC);
    }

    /**
    *
    */
    public String getType() {
        double smallerLengths;
        String triangleType;
        final double lengthASquared = Math.pow(lengthA, 2);
        final double lengthBSquared = Math.pow(lengthB, 2);
        final double lengthCSquared = Math.pow(lengthC, 2);
        if (lengthA < lengthB && lengthC < lengthB) {
          smallerLengths = lengthASquared + lengthCSquared;
          triangleType = giveType(smallerLengths, lengthBSquared);
        } else if (lengthB < lengthA && lengthC < lengthA) {
            smallerLengths = lengthBSquared + lengthCSquared;
            triangleType = giveType(smallerLengths, lengthASquared);
        } else if (lengthA < lengthC && lengthB < lengthC) {
            smallerLengths = lengthASquared + lengthBSquared;
            triangleType = giveType(smallerLengths, lengthCSquared);
        } else {
            triangleType = "Equallateral";
        }
        return triangleType;
    }

    /**
    *
    */
    public String giveType(final double combinedLength,
        final double largeLength) {
          String type = "Equallateral";
          if (combinedLength > largeLength) {
              type = "Acute";
          } else if (combinedLength < largeLength) {
              type = "Obtuse";
          } else if (combinedLength == largeLength) {
              type = "Right";
          }
          return type;
    }

    /**
    * The method to get the three heights of the triangle.
    */
    public void getHeights() {
      final double heightA = Math.round((2 * (triangleArea / lengthA))
        * unitRounding) / unitRounding;
      final double heightB = Math.round((2 * (triangleArea / lengthB))
        * unitRounding) / unitRounding;
      final double heightC = Math.round((2 * (triangleArea / lengthC))
        * unitRounding) / unitRounding;
      System.out.println(heightA);
      System.out.println(heightB);
      System.out.println(heightC);
    }

    /**
    * The method to get the inscribed circle's radius.
    */
    public void getInscribed() {
      final double inscribedCircleRadius = Math.round((triangleArea
        / semiPerimeter) * radiusRounding) / radiusRounding;
      System.out.println(inscribedCircleRadius);
    }

    /**
    * The method to get the area of the circumcircle.
    */
    public void getCircumcircle() {
      double circumcircleRadius = (lengthA * lengthB * lengthC)
        / (4 * triangleArea);
      double circumcircleArea = pi * Math.pow(circumcircleRadius, 2);
      System.out.println(Math.round(circumcircleArea *
        unitRounding) / unitRounding);
    }
}
