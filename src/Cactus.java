import javax.swing.*;
import java.awt.*;

public class Cactus extends Thread {
    private int x;
    private int y;
    private int speed;
    private Scene scene;
    private int width;
    private int height;

    public Cactus(Scene scene, int speed){
        this.x= Utils.X_CACTUS;
        this.y= Utils.Y_CACTUS;
        this.speed = speed;
        this.scene = scene;
        this.width = Utils.CACTUS_WIDTH;
        this.height = Utils.CACTUS_HEIGHT;

    }
    public void run () {
        while (true) {
            this.x -= this.speed;
            Utils.sleep(100);


        }
    }

//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public int getHeight(){
//        return this.height;
//    }
//
//    public int getWidth() {
//        return width;
//    }

    public void paint (Graphics graphics) {
        ImageIcon imageIcon = new ImageIcon("src/picture/200.png");
        imageIcon.paintIcon(this.scene, graphics, this.x, this.y);
        this.width = imageIcon.getIconWidth();
    }

    public Rectangle creatRect(){
        Rectangle rectangle = new Rectangle(this.x,this.y,this.width,this.height);
        return rectangle;
    }
//    public int[] getFrontLocation () {
//        int[] location = new int[2];
//        location[0] = this.x;
//        location[1] = this.y;
//        return location;
//    }
}
