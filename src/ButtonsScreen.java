import javax.swing.*;
import java.awt.*;

public class ButtonsScreen extends JPanel {

    private boolean start;

    public ButtonsScreen(int x, int y, int width, int height, Window window) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);
        this.setBackground(Color.RED);
        this.start = false;
        JButton instructions = new JButton("Game Instructions");
        instructions.setBounds(x + Utils.X_START, y + Utils.Y_INSTRUCTION_BUTTON, Utils.START_WIDTH, Utils.START_HEIGHT);
        instructions.setFont(new Font("Game Instructions", Font.BOLD, 20));
        this.add(instructions);
        instructions.addActionListener(e -> {
            try {
                showMessage(this.GameInstructions());
                this.start = true;
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        JButton start = new JButton("Start");
        start.setBounds(x + instructions.getX(), y + Utils.Y_START, Utils.START_WIDTH, Utils.START_HEIGHT);
        start.setFont(new Font("Start", Font.BOLD, 20));
        this.add(start);
        start.addActionListener(e -> {
            try {
                window.switchScreen("scene");

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

    }

//    public boolean startGame(){
//        boolean isStartGame = false;
//        if (this.start){
//            isStartGame = true;
//        }
//        return isStartGame;
//    }


    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Game Instructions", JOptionPane.INFORMATION_MESSAGE);
    }

    public String GameInstructions() {
        String instructions;
        instructions = "Welcome to the Dino game\n" +
                "All you have to do is press the start button and the player will start running. \n" +
                "Press the spacebar to jump over the obstacles (like cacti) in your way.\n " +
                "The longer you last, the faster the obstacles will enter the game,\n thus increasing the level of difficulty.\n" +
                "If you collide with one of the cacti, the game will end and you can go back to play again.\n" +
                "Successfully!!!";

        return instructions;
    }
}
