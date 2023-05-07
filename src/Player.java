import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

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
//    public void jump()  {
//        this.y -= (250);//TODO
//        Utils.sleep(1000);
//        this.y = Utils.Y_PLAYER;
//
//    }

    public int getY() {
        return y;
    }

    public void setJump(boolean value){
        this.jump=value;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void paint(Graphics graphics){
        ImageIcon imageIcon = new ImageIcon("src/picture/dog-min (1).gif");
        imageIcon.paintIcon(this.scene,graphics,this.x,this.y);
//        graphics.fillRect(this.x,this.y,60,120);
//        graphics.setColor(Color.red);
    }

    public int[] getFrontLocation () {
        int[] location = new int[2];
        location[0] = this.x;
        location[1] = this.y;
        return location;
    }

}