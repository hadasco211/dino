import javax.swing.*;
import java.awt.*;

public class Cactus extends Thread {
    private int x;
    private int y;
    private int speed=5;
    private Scene scene;
    private int width;
    private int locationCactus;

    public Cactus(Scene scene){
        this.x= Utils.X_CACTUS;
        this.y= Utils.Y_CACTUS;
        this.speed = Utils.SPEED;
        this.scene = scene;
        this.locationCactus= this.x+this.width;


    }
    public void run () {
        while (true) {
            this.x -= this.speed;
            Utils.sleep(100);

        }
    }
    public void paint (Graphics graphics) {
        ImageIcon imageIcon = new ImageIcon("src/picture/Imagem-de-Cacto250-PNG.png");
        imageIcon.paintIcon(this.scene, graphics, this.x, this.y);
        this.width = imageIcon.getIconWidth();
    }
    public int getFrontLocation () {
        return this.x + this.width;
    }
}
