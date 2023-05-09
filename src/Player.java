import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Player extends Thread {


    private int x;
    private int y;
    private Scene scene;
    private boolean jump;
    private int width;
    private int height;

    public Player(Scene scene) {
        this.x = Utils.X_PLAYER;
        this.y = Utils.Y_PLAYER;
        this.scene = scene;
        this.jump = false;
        this.width = Utils.PLAYER_WIDTH;
        this.height = Utils.PLAYER_HEIGHT;
    }


    public void run() {
        while (true) {
            if (this.jump) {
                this.y = Utils.PLAYER_JUMP;
                Utils.sleep(500);
                this.y = Utils.Y_PLAYER;
                this.jump = false;
            }

            Utils.sleep(10);
        }
    }

    public void setJump(boolean value) {
        this.jump = value;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rectangle creatRect() {
        Rectangle rectangle = new Rectangle(this.x, this.y, this.width, this.height);
        return rectangle;
    }


    public void paint(Graphics graphics) {
        ImageIcon imageIcon = new ImageIcon("src/picture/IMG_6988 (1).GIF");
        imageIcon.paintIcon(this.scene, graphics, this.x, this.y);

    }

}