import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cs101.sosgame.SOS;

public class SOSGUIPanel extends JPanel {

    //Variables
    private SOSCanvas canvas;
    private SOS game;
    private String player1;
    private String player2;
    private JRadioButton sButton;
    private JRadioButton oButton;
    private boolean sButtonSelect;
    private boolean oButtonSelect;
    private JLabel labelP1;
    private JLabel labelP2;
    private JPanel panel;

    //Constructors
    public SOSGUIPanel(SOS game,String player1, String player2){

        this.game = game;

        this.player1 = player1;
        this.player2 = player2;

        canvas = new SOSCanvas(game);

        sButton = new JRadioButton("S");
        oButton = new JRadioButton("O");
        oButton.addActionListener ( new RadioButtonListener());
        sButton.addActionListener ( new RadioButtonListener());
        oButtonSelect = false;
        sButtonSelect = true;

        labelP1 = new JLabel(player1 + " = " + game.getPlayerScore1());
        labelP1.setForeground(Color.GREEN);
        labelP2 = new JLabel(player2 + " = " + game.getPlayerScore2());
        labelP2.setForeground(Color.RED);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(100,100));
        panel.setLayout (new FlowLayout());

        panel.add(labelP1);
        panel.add(sButton);
        panel.add(oButton);
        panel.add(labelP2);


        setLayout (new BorderLayout());
        setPreferredSize(new Dimension(600,600));
        add (canvas, BorderLayout.NORTH);
        add (panel, BorderLayout.SOUTH);
        canvas.addMouseListener (new MyMouseAdapter());
    }

    //button listener inner class
    class RadioButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == oButton){
                oButtonSelect = true;
                sButtonSelect = false;
                sButton.setSelected(false);
            }
            else{
                sButtonSelect = true;
                oButtonSelect = false;
                oButton.setSelected(false);
            }
        }
    }

    //mouse adapter inner class
    class MyMouseAdapter extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            Point point;

            if (e.getX() >= canvas.BORDER_SPACE && e.getY() >= canvas.BORDER_SPACE && e.getY() <= canvas.BORDER_SPACE + game.getDimension() * canvas.getSpace() && e.getX() <= canvas.BORDER_SPACE + game.getDimension() * canvas.getSpace())
            {
                point = e.getPoint();

                if (oButtonSelect)
                {
                    game.play ('o', ((int) ((point.getY() - (canvas.BORDER_SPACE)) / canvas.getSpace())) + 1, ((int) ((point.getX() - (canvas.BORDER_SPACE)) / canvas.getSpace())) + 1);
                }
                else if (sButtonSelect)
                {
                    game.play ('s', ((int) ((point.getY() - (canvas.BORDER_SPACE)) / canvas.getSpace())) + 1, ((int) ((point.getX() - (canvas.BORDER_SPACE)) / canvas.getSpace())) + 1);
                }
            }

            if (game.getTurn() == 1)
            {
                labelP1.setForeground (Color.GREEN);
                labelP2.setForeground(Color.RED);

            }
            else if (game.getTurn() == 2)
            {
                labelP2.setForeground (Color.GREEN);
                labelP1.setForeground (Color.RED);
            }

            labelP1.setText (player1 + ": " + game.getPlayerScore1());
            labelP2.setText (player2 + ": " + game.getPlayerScore2());

            String winner;

            if (game.getPlayerScore1() > game.getPlayerScore2()) {
                winner = player1;
            }
            else if (game.getPlayerScore1() < game.getPlayerScore2()) {
                winner = player2;
            }
            else {
                winner = "draw";
            }

            canvas.repaint();

            if (game.isGameOver() && (!(winner.equals("draw"))))
            {
                JOptionPane.showMessageDialog (null, "Winner is " + winner + "!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (game.isGameOver() && (winner.equals("draw")))
            {
                JOptionPane.showMessageDialog (null, "It's a " + winner + "!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }



}
