import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener {
    private Player player;
    private Scene scene;

    public Movement(Player player, Scene scene){
        this.player= player;
        this.scene = scene;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.player.setJump(true);
            this.scene.repaint();
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
