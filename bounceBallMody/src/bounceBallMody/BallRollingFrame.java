package bounceBallMody;
 
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class BallRollingFrame extends JFrame{
	
    private JFrame frame;
    private DrawComponent comp;
    private JPanel panel;
    private JButton  button;
    
    public BallRollingFrame() {
    frame = new JFrame("°ø±¼¸®±â");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    comp = new DrawComponent();
    panel = new JPanel();
    button = new JButton();
    
    BorderLayout fl = new BorderLayout();
    panel.setLayout(fl);
    
    panel.add(comp,BorderLayout.CENTER);
    panel.add(button,BorderLayout.SOUTH);
    frame.add(panel);
    frame.pack();
    frame.setVisible(true);
    }
 
    public void repaint() {
        frame.repaint();
    }
    
    public void setBall(Ball ball) {
        comp.setBall(ball);
        
    }
    
}