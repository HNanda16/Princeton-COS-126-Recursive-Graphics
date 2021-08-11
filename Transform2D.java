/** This library can be used to perform geometric transformations on polygons
 * The transformations include scaling, translating, and rotating
 */

public class Transform2D {
        // Returns a new array object that is an exact copy of the given array.
        public static double[] copy(double[] array){
            return array;
        }

        // Scales the polygon by the factor alpha.
        public static void scale(double[] x, double[] y, double alpha){
            for (int i = 0; i < x.length ;i++ ) {
                x[i] = alpha*x[i];
                y[i] = alpha*y[i];
            }
        }

        // Translates the polygon by (dx, dy).
        public static void translate(double[] x, double[] y, double dx, double dy){
            for (int i = 0; i < x.length ;i++ ) {
                x[i] = x[i] + dx;
                y[i] = y[i] + dy;
            }
        }

        // Rotates the polygon theta degrees counterclockwise, about the origin.
        public static void rotate(double[] x, double[] y, double theta){
            double angle = Math.toRadians(theta);
            double cosAngle = Math.cos(angle);
            double sinAngle = Math.sin(angle);
            for (int i = 0;i<x.length;i++) {
                double dx = (x[i]);
                double dy = (y[i]);

                x[i] = (dx*cosAngle-dy*sinAngle);
                y[i] = (dx*sinAngle+dy*cosAngle);
            }

            }


        // Tests each of the API methods by directly calling them.
        public static void main(String[] args){
            StdDraw.setScale(-5.0, +5.0);
            double[] x = { 0, 1, 1, 0 };
            double[] y = { 0, 0, 2, 1 };
            double theta = 45.0;
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.polygon(x, y);
            rotate(x, y, theta);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.polygon(x, y);
        }
}

