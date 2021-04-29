package laba5;


import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.Rectangle2D;


public class burningShip extends FractalGenerator {


    public static final int MAX_ITERATIONS = 2000;

    /**
     * This method allows the fractal generator to specify which part
     * of the complex plane is the most interesting for a fractal.  
     * It is passed a rectangle object and the method modifies the
     * rectangle's fields to show the correct initial range for the fractal.
     * This implementation sets the initial range to (-2 - 1.5i) - (1 + 1.5i)
     * or x=-2, y=-1.5, width=height=3.  
     */
    public void getInitialRange(Rectangle2D.Double range)
    {
        range.x = -2;
        range.y = -2.5;
        range.width = 4;
        range.height = 4;
    }

    
    public int numIterations(double x, double y)
    {
        /** Start with iterations at 0. */
        int iteration = 0;
        /** Initialize zreal and zimaginary. */
        double zreal = 0;
        double zimaginary = 0;

        
        while (iteration < MAX_ITERATIONS &&
               zreal * zreal + zimaginary * zimaginary < 4)
        {
            double zrealUpdated = zreal * zreal - zimaginary * zimaginary + x;
            double zimaginaryUpdated = 2 * Math.abs(zreal) * Math.abs(zimaginary) + y;
            zreal = zrealUpdated;
            zimaginary = zimaginaryUpdated;
            iteration += 1;
        }

        
        if (iteration == MAX_ITERATIONS)
        {
            return -1;
        }

        return iteration;
    }

    
    public String toString() {
        return "BurningShip";
    }
}
