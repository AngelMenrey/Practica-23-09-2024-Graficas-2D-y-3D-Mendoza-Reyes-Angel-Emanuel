import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Rectangulo_2_Puntos extends JFrame {
    private BufferedImage buffer;
    private Graphics graPixel; 
    private Color red = Color.RED; 

    public static void main(String[] args) {
        Rectangulo_2_Puntos ventana = new Rectangulo_2_Puntos();
        ventana.MiVentana();
    }

    public void MiVentana() {
        setTitle("Rectángulo"); 
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
        int x1 = 100, y1 = 100, x2 = 300, y2 = 200;
        rectangulo(x1, x2, y1, y2);
    }

    public void rectangulo(int x1, int x2, int y1, int y2) {
        for (int aux = x1; aux <= x2; aux++) {
            putPixel(aux, y1, red); 
            putPixel(aux, y2, red); 
        }
        for (int aux = y1; aux <= y2; aux++) {
            putPixel(x1, aux, red); 
            putPixel(x2, aux, red); 
        }
    }
}
