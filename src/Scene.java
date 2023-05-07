import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Scene extends JPanel{
    private Player player;
    private ArrayList<Cactus> cactuses;
    private boolean[] keys = new boolean[256];
    private boolean isGameOver;


    public Scene(int x, int y, int width, int height){
        this.setBounds(x,y,width,height);
        this.setLayout(null);
        this.setBackground(Color.DARK_GRAY);
        this.player = new Player(this);
        this.player.start();
        this.cactuses = new ArrayList<>();
        Cactus cactus1 = new Cactus(this);
        Cactus cactus2 = new Cactus(this);
        Cactus cactus3 = new Cactus(this);
        Cactus cactus4 = new Cactus(this);
        Cactus cactus5 = new Cactus(this);
        cactus1.start();
        cactus2.start();
        cactus3.start();
        cactus4.start();
        cactus5.start();
        cactuses.add(cactus1);
        cactuses.add(cactus2);
        cactuses.add(cactus3);
        cactuses.add(cactus4);
        cactuses.add(cactus5);
        this.isGameOver = false;
        this.setVisible(true);
        new Thread(()->{
            while (true){
                this.repaint();
                Utils.sleep(20);
            }
        }).start();
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new Movement(this.player, this));


//                this.update();
//                this.repaint();
//                }





//            try {
//                this.player.setY(Utils.PLAYER_JUMP);
//                this.player.setY(Utils.Y_PLAYER);
//
//            }catch (IOException ){
//                throw new RuntimeException();
//            }
 //       });
    }

//    private void update(){
//        new Thread(()->{
//        while (true) {
//            if (keys[KeyEvent.VK_LEFT]) {
//                this.player.setY(Utils.Y_CACTUS);
//                Utils.sleep(1000);
//                this.repaint();
//                this.player.setY(Utils.Y_PLAYER);
//            }
//        }
//        }).start();
//    }

//    public void mainGameLoop(){
//        while (true){
//            this.update();
//            this.repaint();
//        }
//    }


    public void paintBackground(Graphics graphics){
        ImageIcon imageIcon = new ImageIcon("src/picture/WhatsApp Image 2023-04-29 at 23.33.15.jpg");
        imageIcon.paintIcon(this,graphics,0,0);
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        this.paintBackground(graphics);
        this.player.paint(graphics);
        for (Cactus cactus:this.cactuses){
            cactus.paint(graphics);
            this.repaint();
        }


    }
}