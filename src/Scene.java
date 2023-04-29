import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Scene extends JPanel {
    private ImageIcon ii;
    private Player player;
    private ArrayList<Cactus> cactuses;


    public Scene(int x, int y, int width, int height){
        this.setBounds(x,y,width,height);
        this.setLayout(null);
        this.setBackground(Color.DARK_GRAY);
        this.player = new Player(this);
        this.cactuses = new ArrayList<>();
        Cactus cactus1 = new Cactus(this,10);
        cactus1.start();
        cactuses.add(cactus1);
        this.setVisible(true);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new Movement(this.player, this));
    }


    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        this.player.paint(graphics);
        for (Cactus cactus:this.cactuses){
            cactus.paint(graphics);
        }

    }
}