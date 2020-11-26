import javax.swing.*;
import cs101.sosgame.SOS;

public class SOSTester {
    public static void main(String[] args) {
        JFrame frame = new JFrame("SOS GAME");


        int dimension = 3;
        Object[] dimensions = {"3","4","5","6","7"};
        String dimensionString = (String)JOptionPane.showInputDialog(frame, "Board Size:", "Create your board", JOptionPane.PLAIN_MESSAGE, null, dimensions, "3");
        if (dimensionString != null) {
            dimension = Integer.parseInt(dimensionString);
        }

        String player1 = (String) JOptionPane.showInputDialog (frame, "Please enter first player's name:", "Create your board", JOptionPane.INFORMATION_MESSAGE, null, null, "PLAYER 1");
        String player2 = (String) JOptionPane.showInputDialog (frame, "Please enter second player's name:", "Create your board", JOptionPane.INFORMATION_MESSAGE, null, null, "PLAYER 2");

        SOS game = new SOS(dimension);
        SOSGUIPanel sosPanel = new SOSGUIPanel(game,player1,player2);

        frame.add(sosPanel);
        frame.pack();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible(true);

    }
}
