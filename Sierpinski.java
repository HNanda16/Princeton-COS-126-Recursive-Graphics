import java.awt.*;

/**This library can be used to recursively generate a Sierpinski triangle pattern of order n
 * The fractal pattern contains a large equilateral triangle which is split into
 * 4 smaller equilateral triangles, of which the centre one (facing downwards) is filled in
 */

public class Sierpinski {
    //  Height of an equilateral triangle whose sides are of the specified length.
    public static double height(double length){
        return Math.sqrt((3*(length*length))/4);
    }

    //  Draws a filled equilateral triangle whose bottom vertex is (x, y)
    //  of the specified side length.
    public static void filledTriangle(double x, double y, double length){
        double[] vx = {x, x+(length/2), x-(length/2)};
        double[] vy = {y, y+height(length), y+height(length)};

        if (Math.log(1/length)/Math.log(2) % 2 == 0) {
            StdDraw.setPenColor(Color.blue);
        }
        else {
            StdDraw.setPenColor(Color.magenta);
        }

        StdDraw.filledPolygon(vx, vy);
    }

    //  Draws a Sierpinski triangle of order n, such that the largest filled
    //  triangle has bottom vertex (x, y) and sides of the specified length.
    public static void sierpinski(int n, double x, double y, double length){
        filledTriangle(x, y, length);
        if(Math.log(1/length)/Math.log(2) < n){
            sierpinski(n, (x - (length/2)), y, length/2);
            sierpinski(n, (x + (length/2)), y, length/2);
            sierpinski(n, x, y + height(length), length/2);
        }

    }

    //  Takes an integer command-line argument n;
    //  draws the outline of an equilateral triangle (pointed upwards) of length 1;
    //  whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and
    //  draws a Sierpinski triangle of order n that fits snugly inside the outline.
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        double[] vx = {0, 0.5, 1};
        double[] vy = {0, Math.sqrt(0.75), 0};

        StdDraw.setPenColor(Color.blue);
        StdDraw.polygon(vx, vy);
        sierpinski(n, 0.5, 0, 0.5);
    }

}
