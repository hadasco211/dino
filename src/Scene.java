import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Scene extends JPanel{
    private Player player;
    private ArrayList<Cactus> cactuses;
//    private boolean[] keys = new boolean[256];
    private boolean isGameOver;
    private boolean isStartPressed;
    private int speed;


    public Scene(int x, int y, int width, int height){
        this.setBounds(x,y,width,height);
        this.setLayout(null);
        this.setBackground(Color.PINK);
        this.isStartPressed = false;
        JButton instructions = new JButton("Game Instructions");
        instructions.setBounds(x + Utils.X_START , y + Utils.Y_INSTRUCTION_BUTTON, Utils.START_WIDTH , Utils.START_HEIGHT );
        instructions.setFont(new Font("Game Instructions", Font.BOLD, 20));
        this.add(instructions);
        instructions.addActionListener(e -> {
            try {
                showMessage(this.GameInstructions());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        JButton start = new JButton("Start");
        start.setBounds(x + instructions.getX(), y + Utils.Y_START, Utils.START_WIDTH , Utils.START_HEIGHT);
        start.setFont(new Font("Start", Font.BOLD, 20));
        this.add(start);
        start.addActionListener(e -> {
            try {
                this.remove(start);
                this.remove(instructions);
                this.isStartPressed = true;
                this.player = new Player(this);
                this.player.start();
                this.cactuses = new ArrayList<>();
                this.speed = 20;

                new Thread(()->{
                while (true) {
                    Random random = new Random();
                    Cactus cactus = new Cactus(this,speed);
                    Utils.sleep(random.nextInt(2500,4500));
                    cactus.start();
                    this.speed += 2;
                    this.cactuses.add(cactus);
                }
                }).start();

//                this.isGameOver = false;
//                this.setVisible(true);
                new Thread(() -> {
                    while (true) {
                        this.repaint();
                        Utils.sleep(20);
                        //  this.checkCollision(cactus1,this.player);
                    }
                }).start();

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });


//        this.setFocusable(true);
//        this.requestFocus();
//        this.addKeyListener(new Movement(this.player, this));
//        System.exit(0);
    }


//    public void mainGameLoop(){
//        while (true){
//            this.update();
//            this.repaint();
//        }


    public void checkCollision(Cactus cactus, Player player) {
        if (player.getX() < cactus.getX() + cactus.getWidth() &&
                player.getX() + player.getWidth() > cactus.getX() &&
                player.getY() < cactus.getY() + cactus.getHeight() &&
                player.getY() + player.getHeight() > cactus.getY()) {
            System.out.println("Game over");
        }
    }
    public void showMessage(String message)
    {
        JOptionPane.showMessageDialog(this, message, "Game Instructions", JOptionPane.INFORMATION_MESSAGE);
    }

    public String GameInstructions()
    {
        String instructions ;
        instructions = "Welcome to the Dino game\n" +
                "All you have to do is press the start button and the player will start running. \n" +
                "Press the spacebar to jump over the obstacles (like cacti) in your way.\n " +
                "The longer you last, the faster the obstacles will enter the game,\n thus increasing the level of difficulty.\n" +
                "If you collide with one of the cacti, the game will end and you can go back to play again.\n" +
             //   "by pressing the enter key.\n" +
                "Successfully!!!" ;

        return instructions ;
    }




    public void paintBackground(Graphics graphics){
        ImageIcon imageIcon = new ImageIcon("src/picture/WhatsApp Image 2023-04-29 at 23.33.15.jpg");
        imageIcon.paintIcon(this,graphics,0,0);
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        if (isStartPressed){
            paintBackground(graphics);
            this.player.paint(graphics);

                    for (Cactus cactus : this.cactuses) {
                        cactus.paint(graphics);
                        this.repaint();
                    }

        }
    }
}