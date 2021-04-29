package lab4;

import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
public class JImageDisplay extends JComponent {
    

    private BufferedImage displayImage; // задает картинку
    
    /**
      * The constructor takes an integer width and height and initializes 
      * its BufferedImage object to be a new image with that width an height 
      * of image-type TYPE_INT_RGB.
      */
    public JImageDisplay(int width, int height) {
        displayImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Dimension imageDimension = new Dimension(width, height);
        super.setPreferredSize(imageDimension);
        /** 
         * Call the parent class' setPreferredSize() method
         * with given width and height.
         */
       /* Dimension imageDimension = new Dimension(width, height);
        super.setPreferredSize(imageDimension); */

    }
   
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(displayImage, 0, 0, displayImage.getWidth(), displayImage.getHeight(), null);
    }
    /**
     * Sets all pixels in the image data to black.
     */
    public void clearImage() 
    {
       for (int x =0; x < displayImage.getHeight(); x++) {
           for (int y = 0; y < displayImage.getWidth(); y++) {
               displayImage.setRGB(x, y, 0);
           }
       }
    }
    /**
     * Sets a pixel to a specific color.
     */
    public void drawPixel(int x, int y, int rgbColor)
    {
        displayImage.setRGB(x, y, rgbColor);
    }
}
