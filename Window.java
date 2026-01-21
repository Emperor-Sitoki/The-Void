import javax.swing.*;

public class Window {

    Panel panel = new Panel();




    Window(){

        JFrame frame = new JFrame("The Void");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(panel.getWindowWidth(), panel.getWindowHeight());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(panel);



        frame.setVisible(true);

    }
}
