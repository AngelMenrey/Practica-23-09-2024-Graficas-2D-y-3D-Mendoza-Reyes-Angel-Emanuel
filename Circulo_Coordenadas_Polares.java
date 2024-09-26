import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Circulo_Coordenadas_Polares extends JFrame {
    private BufferedImage buffer;
    private Graphics graPixel; 
    private Color red = Color.RED; 
    public static void main(String[] args) {
        Circulo_Coordenadas_Polares ventana = new Circulo_Coordenadas_Polares();
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
        for (int i = 0; i < 360; i++) {
            double theta = Math.toRadians(i);
            int x = (int) (radius * Math.cos(theta));
            int y = (int) (radius * Math.sin(theta));
            putPixel(centerX + x, centerY + y, red);
        }
    }
}