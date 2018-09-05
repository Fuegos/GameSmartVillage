package Totality;
//Метод для pictureBox
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class pictureBox extends JPanel {
    private Image img; 
    
    public pictureBox(String img) {
        this(new ImageIcon(img).getImage());
    }
    public pictureBox(Image img) {
        this.img = img;
        Dimension size = new Dimension(
                img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }
    @Override
    public void paintComponent(Graphics g) {
       g.drawImage(img, 0, 0, null);
    }
}