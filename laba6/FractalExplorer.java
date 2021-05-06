
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;
import javax.swing.JFileChooser.*;
import javax.swing.filechooser.*;
import javax.imageio.ImageIO;
import javax.imageio.ImageIO.*;
import java.awt.image.*;
public class FractalExplorer {
   
    private int displaySize;
    private JImageDisplay display;
    private FractalGenerator fractalGenerator;
    private Rectangle2D.Double range;
    private int rowsRemaining;
    private JButton resetButton = new JButton("Reset");
    private JButton saveButton = new JButton ("Save");
    private JComboBox comboBox = new JComboBox();

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
       ButtonHandler reset = new ButtonHandler();
        resetButton.addActionListener(reset);

        JButton saveButton = new JButton("Save");
        ButtonHandler save = new ButtonHandler();
         saveButton.addActionListener(save);

         JPanel buttonsPanel = new JPanel();
         buttonsPanel.add(resetButton);
         buttonsPanel.add(saveButton);
        frame.add(buttonsPanel, BorderLayout.SOUTH);

        JComboBox comboBox = new JComboBox();
        comboBox.addItem(new Mandelbrot());
        comboBox.addItem(new Tricorn());
        comboBox.addItem(new burningShip());
        ButtonHandler fractalChooser = new ButtonHandler();
        comboBox.addActionListener(fractalChooser);

       
        JPanel Panel = new JPanel();
        JLabel label = new JLabel("Fractal:");
        Panel.add(label);
        Panel.add(comboBox);
        frame.add(Panel, BorderLayout.NORTH);

        MouseClickZoom click = new MouseClickZoom();
        frame.addMouseListener(click);
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    
    private void drawFractal()
    {
        enableUI(false); // откл пооьзовательский интнрфейс
        rowsRemaining = displaySize;
        for (int y = 0; y < displaySize; y ++) {
            FractalWorker fractalWorker = new FractalWorker(y);
            fractalWorker.execute();
        }
        display.repaint();
        /*float h;
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
        }*/

        display.repaint();
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() instanceof JComboBox) {
                JComboBox source = ( JComboBox)event.getSource();
                fractalGenerator = (FractalGenerator)source.getSelectedItem();
                fractalGenerator.getInitialRange(range);
                drawFractal();
            }
           if (event.getActionCommand().equals("Reset Display")) {
               fractalGenerator.getInitialRange(range);
               drawFractal();
           }
           if (event.getActionCommand().equals("Save")) {
               JFileChooser chooser = new JFileChooser();
               javax.swing.filechooser.FileFilter filter = new  javax.swing.filechooser.FileNameExtensionFilter("PNG Images", "png");
                chooser.setFileFilter(filter);
                chooser.setAcceptAllFileFilterUsed(false);
                if (chooser.showSaveDialog(display) == JFileChooser.APPROVE_OPTION)
                {
                    java.io.File file = chooser.getSelectedFile();
                    try {
                        BufferedImage displayI = display.getImage();
                        ImageIO.write(displayI, "png", file);
                    }

                    catch (Exception exeption) {
                        JOptionPane.showMessageDialog(display, "Error", "Cannot save image", JOptionPane.ERROR_MESSAGE);
                    }
                } 
           }

    }
        
    }
   
    

    private  class MouseClickZoom extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent event) {
            if (rowsRemaining == 0) {
            int x = event.getX();
            int y = event.getY();
            double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize,x);
            double yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize,y);
            fractalGenerator.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
            }
        }

    
       
    }

    private class FractalWorker extends SwingWorker<Object, Object> 
    {
        private int yC;
        private int xColor[];
        private FractalWorker(int y) {
            yC = y;
        }

        public Object doInBackground () { // вычисляет пиксели для строки 
            float h;
        int CountIter;
        double xCoord, yCoord;
        xColor  = new int[ displaySize]; // каждое значение цвета будет сохраняться в массиве целых чисел
        for (int x = 0; x < displaySize; x++) {
                xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize,x);
                yCoord = FractalGenerator.getCoord(range.y, range.y + range.height, displaySize,yC);
                CountIter = fractalGenerator.numIterations(xCoord, yCoord);
                if (CountIter == -1) {
                   xColor[x] = 0;

                }
                else {
                    h = 0.7f + (float) CountIter / 200f;
                    xColor[x] = Color.HSBtoRGB(h, 1f,1f);
                }
        
            }
            return null;
        }

        public void done () { // рисует пиксели
            for (int x = 0; x < xColor.length; x++) {
                display.drawPixel(x,yC,xColor[x]);
            }
            display.repaint(0,0,yC, displaySize, 1);
            rowsRemaining--;
            if (rowsRemaining == 0) 
            {
                enableUI(true);
            }
        }

    }

    public void enableUI(boolean enable) {
        resetButton.setEnabled(enable);
        saveButton.setEnabled(enable);
        comboBox.setEnabled(enable);
    }
    
    public static void main(String[] args)
    {
        FractalExplorer displayExplorer = new FractalExplorer(600);
        displayExplorer.createAndShowGUI();
        displayExplorer.drawFractal();
    }


}
        

    

    

    

