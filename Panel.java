import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Time;

public class Panel extends JPanel{
    private int blockHeight = 24;
    private int blockWidth = 24;

    //How many blocks vertically and horizontally
    private int columnAmount = 30;
    private int rowAmount = 30;

    //Window Size
    private int windowHeight = blockHeight * columnAmount;
    private int windowWidth = blockWidth * rowAmount;

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

    }
}
