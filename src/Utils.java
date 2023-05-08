import java.awt.*;

public class Utils {
    public static final int X_WINDOW = 0;
    public static final int Y_WINDOW = 0;
    public static final int WIDTH = 1750;
    public static final int HEIGHT = 950;

    public static final int X_PLAYER = 5;
    public static final int Y_PLAYER = 350;
    public static final int PLAYER_JUMP = 150;

    public static final int X_CACTUS = 1300;
    public static final int Y_CACTUS = 570;
    public static final int SPEED = 5;
    public static final int X_START = 600 ;
    public static final int Y_INSTRUCTION_BUTTON = 300;

    public static final int Y_START = 500 ;
    public static final int START_WIDTH = 250 ;
    public static final int START_HEIGHT = 50 ;





    public static void sleep (int millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public static boolean collision (Rectangle rectangle1, Rectangle rectangle2) {
            return rectangle1.intersects(rectangle2);
        }
    }
