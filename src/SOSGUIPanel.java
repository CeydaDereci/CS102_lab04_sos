import javax.swing.*;
import java.awt.*;

import cs101.sosgame.SOS;

public class SOSGUIPanel extends JPanel {

    //Variables
    private SOSCanvas canvas;
    private SOS game;
    private String player1;
    private String player2;
    private JButton sButton;
    private JButton oButton;
    private JLabel labelP1;
    private JLabel labelP2;
    private JPanel panel;

    //Constructors
    public SOSGUIPanel(SOS game,String player1, String player2){

        this.game = game;

        this.player1 = player1;
        this.player2 = player2;

        canvas = new SOSCanvas(game);

        sButton = new JButton("S");
        oButton = new JButton("O");

        labelP1 = new JLabel(player1 + " = " + game.getPlayerScore1());
        labelP2 = new JLabel(player2 + " = " + game.getPlayerScore2());

        panel = new JPanel();

        panel.add(sButton);
        panel.add(oButton);
        panel.add(labelP1);
        panel.add(labelP2);


        setLayout (new BorderLayout());
        add (canvas, BorderLayout.CENTER);
        add (panel, BorderLayout.SOUTH);
    }

    //mouse adapter
    //button listener



}
