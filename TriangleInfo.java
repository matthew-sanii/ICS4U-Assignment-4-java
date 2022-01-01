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
}
