import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel{
    private int blockHeight = 24;
    private int blockWidth = 24;

    //How many blocks vertically and horizontally
    private int columnAmount = 30;
    private int rowAmount = 30;

    //Window Size
    private int windowHeight = blockHeight * columnAmount;
    private int windowWidth = blockWidth * rowAmount;

    Panel(){
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setBackground(Color.BLACK);
    }


    public int getWindowHeight(){
        return windowHeight;
    }

    public int getWindowWidth(){
        return windowWidth;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g.setColor(Color.white);
        g.fillRect(0, 0, blockWidth, blockHeight);
    }

    public void update(){

    }
}
