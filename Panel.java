import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class Panel extends JPanel{
    private final int blockHeight = 20;
    private final int blockWidth = 20;

    //How many blocks vertically and horizontally
    private final int columnAmount = 30;
    private final int rowAmount = 30;

    //Window Size
    private final int windowHeight = blockHeight * columnAmount;
    private final int windowWidth = blockWidth * rowAmount;

    //Player Coordinates and details
    private int playerX = 0;
    private int playerY = 0;
    private int playerSpeed = 5;

    //KeyListener Instance
    KeyChecker keyChecker = new KeyChecker();

    //Timer for events
    Timer timer;

    Panel(){
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setBackground(Color.BLACK);
        this.addKeyListener(keyChecker);
        this.setFocusable(true);

        timer = new Timer(17, (e -> {
            update();
            repaint();
        }));

        timer.start();

    }


    public int getWindowHeight(){
        return windowHeight;
    }

    public int getWindowWidth(){
        return windowWidth;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g.setColor(Color.blue);
        g.fillRect(playerX, playerY, blockWidth, blockHeight);
    }

    public void update(){

        if (keyChecker.wPressed){
            playerY -= playerSpeed;
        }
        if (keyChecker.aPressed){
            playerX -= playerSpeed;
        }
        if (keyChecker.sPressed){
            playerY += playerSpeed;
        }
        if (keyChecker.dPressed){
            playerX += playerSpeed;
        }

        //Keep player from going off screen
        if (playerX < 0){
            playerX = 0;
        }
        if (playerY < 0){
            playerY = 0;
        }
        if (playerX > getWidth() - blockWidth){
            playerX = getWidth() - blockWidth;
        }
        if (playerY > getHeight() - blockHeight){
            playerY = getHeight() - blockHeight;
        }


    }
}
