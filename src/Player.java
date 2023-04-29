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
                this.y = Utils.PLAYER_JUMP;
                Utils.sleep(500);
                this.y = Utils.Y_PLAYER;
                this.jump = false;
            }

        }
    }

    public void setJump(boolean value){
        this.jump=value;
    }

    public void paint(Graphics graphics){
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\USER001\\Downloads\\dog.gif");
        imageIcon.paintIcon(this.scene,graphics,this.x,this.y);
    }
}