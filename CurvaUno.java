import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CurvaUno extends JFrame {
    private BufferedImage buffer;
    private Graphics graPixel; 
    private Color red = Color.RED; 
    public static void main(String[] args) {
        CurvaUno ventana = new CurvaUno();
        ventana.MiVentana();
    }

    public void MiVentana() {
        setTitle("Curva"); 
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
        if (x >= 0 && x < buffer.getWidth() && y >= 0 && y < buffer.getHeight()) {
            buffer.setRGB(x, y, c.getRGB());
            this.getGraphics().drawImage(buffer, 0, 0, this);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        dibujarCurva();
    }

    public void dibujarCurva() {
        int vertexX = 250;
        int vertexY = 400; 
        int width = 200;

        for (int x = -width; x <= width; x++) {
            int y = (x * x) / (width / 2); 
            putPixel(vertexX + x, vertexY - y, red);
        }
    }
}
