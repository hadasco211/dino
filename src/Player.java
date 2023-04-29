import javax.swing.*;
import java.awt.*;

public class Player extends Thread{


    private int x;
    private int y;
    private Scene scene;
    private boolean jump;

    public Player(Scene scene){
        this.x = Utils.X_PLAYER;
        this.y = Utils.Y_PLAYER;
        this.scene = scene;
        this.jump = false;
    }

      public void run(){
        while (true){
            if (this.jump) {
                this.jump();
                Utils.sleep(500);
                this.land();
                this.jump=false;
            }
        }
    }
    public void jump(){
            this.y = Utils.PLAYER_JUMP;

    }
    public void land(){
        this.y=Utils.Y_PLAYER;
    }
    public void setJump(boolean value){
        this.jump=value;
    }

    public void paint(Graphics graphics){
        ImageIcon imageIcon = new ImageIcon("src/picture/50.jpg");
        imageIcon.paintIcon(this.scene,graphics,this.x,this.y);
    }
}