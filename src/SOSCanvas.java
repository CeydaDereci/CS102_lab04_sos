import javax.swing.*;
import java.awt.*;
import cs101.sosgame.SOS;

public class SOSCanvas extends JPanel {

    final int WIDTH = 500;
    final int HEIGHT = 500;

    //Variables
    private SOS game;
    private int space;
    private int dimensions;

    //Constructors
    public SOSCanvas(SOS game){
        this.game = game;
        dimensions = game.getDimension();
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        space = (HEIGHT - 2* WIDTH)/ dimensions;
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        //drawing lines
        for(int i = 0; i <= dimensions; i++){
            //g.drawLine();

        }





    }



}
