import javax.swing.*;
import java.awt.*;
import cs101.sosgame.SOS;

public class SOSCanvas extends JPanel {

    final int WIDTH = 500;
    final int HEIGHT = 500;
    private final double STRING_POSX = 2.5;
    private final double STRING_POSY = 1.5;
    public static final int BORDER_SPACE = 50;
    private final ImageIcon background = new ImageIcon(getClass().getResource("images/background.png"));

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

        space = (HEIGHT - 2* BORDER_SPACE)/ dimensions;
    }

    @Override
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 0, null);
        int xPoint;
        int yPoint;
        xPoint = BORDER_SPACE;
        yPoint = BORDER_SPACE;

        //drawing lines
        for(int i = 0; i <= dimensions; i++){
            g.drawLine(xPoint,yPoint,xPoint + (space * dimensions) ,yPoint);
            yPoint += space;
        }

        yPoint = BORDER_SPACE;

        for(int i = 0; i <= dimensions; i++){
            g.drawLine(xPoint,yPoint,xPoint,yPoint + (space * dimensions));
            xPoint += space;
        }
        xPoint = BORDER_SPACE + ((int) ((space / STRING_POSX)));
        yPoint = BORDER_SPACE + ((int) ((space / STRING_POSY)));
        g.setFont (new Font ("Verdana", Font.PLAIN, space / 2));
        for (int i = 0; i < dimensions; i++)
        {
            for (int j = 0; j < dimensions; j++)
            {
                String s = "" + game.getCellContents (i, j);

                if (s.equals("s")) {
                    g.setColor (Color.RED);
                }
                else {
                    g.setColor (Color.GREEN);
                }

                if (!(s.equals("."))) {
                    g.drawString (s, xPoint, yPoint);
                }
                xPoint += space;

                if (j == dimensions - 1)
                {
                    xPoint = BORDER_SPACE + ((int) ((space / STRING_POSX)));
                    yPoint += space;
                }
            }
        }

    }
    public int getSpace()
    {
        return space;
    }



}
