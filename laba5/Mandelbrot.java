package laba5;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
public class Mandelbrot extends FractalGenerator {
 
    public static final int MAX_ITERATIONS = 2000; // выполняется пока точка находится во множестве М

    
    public void getInitialRange(Rectangle2D.Double range)
    {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

   
    public int numIterations(double x, double y)
    {
        /** Start with iterations at 0. */
        int iteration = 0;
        /** Initialize zreal and zimaginary. */
        double zreal = 0;
        double zimaginary = 0;
        double zRealUp, zImaginaryUp;
        while (iteration < MAX_ITERATIONS &&
               zreal * zreal + zimaginary * zimaginary < 4)
        {
            zRealUp = zreal * zreal - zimaginary * zimaginary + x;
            zImaginaryUp = 2 * zreal * zimaginary + y;
            zreal = zRealUp;
            zimaginary = zImaginaryUp;
            iteration += 1;
        }

        
        if (iteration == MAX_ITERATIONS)
        {
            return -1;
        }

        return iteration;
    }

    public String toString() {
        return "Mandelbrot";
    }
    

    
}
