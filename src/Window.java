import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(){
        this.setSize(Utils.WIDTH,Utils.HEIGHT);
        this.setLayout(null);
        this.add(new Scene(Utils.X_WINDOW,Utils.Y_WINDOW,Utils.WIDTH,Utils.HEIGHT));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
//        JLabel label = new JLabel("dino game",SwingConstants.CENTER);
//        label.setPreferredSize(new Dimension(width,high));
//        this.getContentPane().add(label,BorderLayout.CENTER);
//        this.setResizable(false);
//        this.add(new Scene(0,0,500,500));
//        //      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLocationRelativeTo(null);
//        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//    //    this.pack();
//        this.setVisible(true);

    }


}