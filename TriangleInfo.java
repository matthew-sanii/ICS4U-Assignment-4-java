public class TriangleInfo {

    /**
    * The empty double for side length A.
    */
    private double lengthA;

    /**
    * The empty double for side length B.
    */
    private double lengthB;

    /**
    * The empty double for side length C.
    */
    private double lengthC;

    /**
    * The empty double for Semiperimeter
    */
    private double semiPerimeter;

    /**
    * The empty double for the triangle area.
    */
    private double triangleArea;

    /**
    * The rounding used for the angles of the triangle.
    */
    private final double angleRounding = 10.0;

    /**
    * The rounding used for the calculations (area, perimeter, circumcircle
    * area).
    */
    private final double unitRounding = 100.0;

    /**
    * The pi value.
    */
    private final double pi = 3.14;

    /**
    * The value used to turn radians into degrees (acos gives radians as
    * answer).
    */
    private final double angles = 180;

    /**
    * Value used in finding square root.
    */
    private final double half = 0.5;

    /**
    * Value used in finding circumcircle area.
    */
    private final double quad = 4;

    /**
    * The starting constructor
    *
    * @param sideA the first side length.
    * @param sideB the second side length.
    * @param sideC the third side length.
    */
    public TriangleInfo(final double sideA, final double sideB, final double sideC) {
      lengthA = sideA;
      lengthB = sideB;
      lengthC = sideC;
      semiPerimeter = (lengthA + lengthB + lengthC) / 2;
    }

    /**
    * The method used to check if the triangle lengths given are valid.
    *
    * @return if triangle is valid.
    */
    protected boolean checkTriangle() {
        if ((lengthA + lengthB) >= lengthC && (lengthB + lengthC) >= lengthA
            && (lengthA + lengthC) >= lengthB && semiPerimeter != lengthA
            && semiPerimeter != lengthB && semiPerimeter != lengthC) {
            return true;
        } else {
            return false;
        }
    }

    /**
    * The method used to get the area of the triangle.
    */
    public void getArea() {
        double area = semiPerimeter * (semiPerimeter - lengthA)
            * (semiPerimeter - lengthB) * (semiPerimeter - lengthC);
        area = Math.pow(area, half);
        triangleArea = Math.round(area * unitRounding) / unitRounding;
        System.out.println(triangleArea);
    }

    /**
    * Method used to get perimeter of triangle.
    */
    public void getPerimeter() {
        final double perimeter = lengthA + lengthB + lengthC;
        System.out.println(perimeter);
    }

    /**
    * Method used to get the angles of the triangle.
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
    * Method used to return the type of the triangle.
    *
    * @return type of triangle.
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
    * Method used to figure out the type of triangle.
    *
    * @param combinedLength the combined length of 2 sides.
    * @param largeLength the length of the larger side.
    *
    * @return the type of triangle.
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
        / semiPerimeter) * unitRounding) / unitRounding;
      System.out.println(inscribedCircleRadius);
    }

    /**
    * The method to get the area of the circumcircle.
    */
    public void getCircumcircle() {
      double circumcircleRadius = (lengthA * lengthB * lengthC)
        / (quad * triangleArea);
      double circumcircleArea = pi * Math.pow(circumcircleRadius, 2);
      System.out.println(Math.round(circumcircleArea
      * unitRounding) / unitRounding);
    }
}
