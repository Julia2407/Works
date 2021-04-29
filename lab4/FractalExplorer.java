package lab4;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
public class FractalExplorer {
   
    private int displaySize;
    private JImageDisplay display;
    private FractalGenerator fractalGenerator;
    private Rectangle2D.Double range;

    /**
     * A constructor that takes a display-size, stores it, and
     * initializes the range and fractal-generator objects.
     */
    public FractalExplorer(int size) {
        /** Stores display-size **/
        displaySize = size;

        /** Initializes the fractal-generator and range objects. **/
        fractalGenerator = new Mandelbrot();
        range = new Rectangle2D.Double();
        fractalGenerator.getInitialRange(range);
        display = new JImageDisplay(size, size);

    }
    /**
     * This method intializes the Swing GUI with a JFrame holding the 
     * JImageDisplay object and a button to reset the display.
     */
    public void createAndShowGUI()
    {
        display.setLayout(new BorderLayout());
        JFrame frame = new JFrame("Fractal Explorer");

        /** 
         * Add the image-display object in the BorderLayout.CENTER 
         * position. 
         */
        frame.add(display, BorderLayout.CENTER);
         

        /** Create a reset button. */
        JButton resetButton = new JButton("Reset Display");
        
       ResetButton reset = new ResetButton();
        resetButton.addActionListener(reset);

        /** Add the reset button in the BorderLayout.SOUTH position. */
        frame.add(resetButton, BorderLayout.NORTH);

        MouseClickZoom click = new MouseClickZoom();
        display.addMouseListener(click);
       

        /** Set the frame's default close operation to "exit". */
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    
    private void drawFractal()
    {
        float h;
        int CountIter;
        double xCoord, yCoord;
        for (int x = 0; x < displaySize; x++) {
            for (int y = 0; y < displaySize; y++) {
                xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize,x);
                yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize,y);
                CountIter = fractalGenerator.numIterations(xCoord, yCoord);
                if (CountIter == -1) {
                    display.drawPixel(x,y,0);

                }
                else {
                    h = 0.7f + (float) CountIter / 200f;
                    display.drawPixel(x, y, Color.HSBtoRGB(h, 1f, 1f));
                }
            }
        }

        display.repaint();
    }
   
    private class ResetButton implements ActionListener
    {
        public void actionPerformed(ActionEvent event) {
            fractalGenerator.getInitialRange(range);
            drawFractal();
        }


    }

    private class MouseClickZoom extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent event) {
            int x = event.getX();
            int y = event.getY();
            double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize,x);
            double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize,y);
            fractalGenerator.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }
    } 



        private class ResetHandler implements ActionListener
        {
            /**
             * The handler resets the range to the intial range given by the 
             * generator, and then draws the fractal.
             */
            public void actionPerformed(ActionEvent e)
            {
                fractalGenerator.getInitialRange(range);
                drawFractal();
            }
        }
        /**
         * An inner class to handle MouseListener events from the display.
         */
       
    
    public static void main(String[] args)
    {
        FractalExplorer displayExplorer = new FractalExplorer(800);
        displayExplorer.createAndShowGUI();
        displayExplorer.drawFractal();
    }
}
    

    

