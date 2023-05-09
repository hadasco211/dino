import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Scene extends JPanel {
    private Player player;
    private ArrayList<Cactus> cactuses;
    private boolean isGameOver;
    private int speed;
    private GameTimer gameTimer;



    public Scene(int x, int y, int width, int height, Window window) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        this.setBackground(Color.RED);
        this.player = new Player(this);
        this.player.start();
        this.addKeyListener(new Movement(this.player));
        this.setFocusable(true);
        this.requestFocus();
        this.gameTimer = new GameTimer();
        this.gameTimer.start();
        this.gameTimer.startTimer();
        this.isGameOver = false;
        this.cactuses = new ArrayList<>();
        this.speed = Utils.SPEED;
        new Thread(() ->
        {
            while (true)
            {
                Random random = new Random();
                Cactus cactus = new Cactus(this, speed);
                Utils.sleep(random.nextInt(2500, 4500));
                cactus.start();
                this.speed += 2;
                this.cactuses.add(cactus);
                if (isGameOver){
                    this.restGame();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                this.repaint();
                Utils.sleep(20);
                for (Cactus cactus : this.cactuses) {
                    if(Utils.collision(this.player.creatRect(),cactus.creatRect())){
                        this.isGameOver = true;
                        window.switchScreen("ButtonsScreen");
                    }
                }
            }
        }).start();
    }


    public void restGame(){
        this.isGameOver = false;
        for (Cactus cactus : this.cactuses){
            cactus.rest();
        }
    }

    public void paintBackground(Graphics graphics) {
        ImageIcon imageIcon = new ImageIcon("src/picture/170%.jpg");
        imageIcon.paintIcon(this, graphics, 0, 0);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        paintBackground(graphics);
        this.player.paint(graphics);
        for (Cactus cactus : this.cactuses) {
            cactus.paint(graphics);
            this.repaint();
        }
    }
}