import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Circulo_Punto_Medio extends JFrame {
    private BufferedImage buffer;
    private Graphics graPixel; 
    private Color red = Color.RED; 
    public static void main(String[] args) {
        Circulo_Punto_Medio ventana = new Circulo_Punto_Medio();
        ventana.MiVentana();
    }

    public void MiVentana() {
        setTitle("Círculo"); 
        setSize(500, 500); 
        setLayout(null); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB); 
        graPixel = buffer.getGraphics(); 
        graPixel.setColor(Color.WHITE); 
        graPixel.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());
        setVisible(true); 
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(x, y, c.getRGB());
        this.getGraphics().drawImage(buffer, 0, 0, this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int centerX = 250, centerY = 250, radius = 100;
        circulo(centerX, centerY, radius);
    }

    public void circulo(int centerX, int centerY, int radius) {
        int x = 0;
        int y = radius;
        int d = 1 - radius; 

        while (x <= y) {
            putPixel(centerX + x, centerY + y, red);
            putPixel(centerX - x, centerY + y, red);
            putPixel(centerX + x, centerY - y, red);
            putPixel(centerX - x, centerY - y, red);
            putPixel(centerX + y, centerY + x, red);
            putPixel(centerX - y, centerY + x, red);
            putPixel(centerX + y, centerY - x, red);
            putPixel(centerX - y, centerY - x, red);
            x++;

            if (d < 0) {
                d = d + 2 * x + 1; 
            } else {
                y--;
                d = d + 2 * x - 2 * y + 1; 
            }
        }
    }
}
