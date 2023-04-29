import javax.swing.*;
import java.awt.*;

public class Cactus extends Thread {
    private int x;
    private int y;
    private int speed;
    private Scene scene;
    private int width;

    public Cactus(Scene scene, int speed){
        this.x= Utils.X_CACTUS;
        this.y= Utils.Y_CACTUS;
        this.speed = speed;
        this.scene = scene;


    }
    public void run () {
        while (true) {
            this.x -= this.speed;
            Utils.sleep(100);
        }
    }
    public void paint (Graphics graphics) {
        ImageIcon imageIcon = new ImageIcon("src/picture/Imagem-de-Cacto-PNG.png");
        imageIcon.paintIcon(this.scene, graphics, this.x, this.y);
        this.width = imageIcon.getIconWidth();
    }
    public int getFrontLocation () {
        return this.x + this.width;
    }
}
