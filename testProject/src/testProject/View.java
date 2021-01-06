package testProject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame{
	
	DrawComponent			comp;
	JFrame   				frame;
	JButton 				playButton;
	JButton 				stopButton;
	JButton 				addButton;
	JButton 				deleteButton;
	JPanel					panel;
	

	public View() {
		frame = new JFrame();
		comp = new DrawComponent();
		
	}
	public void draw() {
		frame.repaint();
	}

	public void setBallManager(BallManager ballManager) {
		// TODO Auto-generated method stub
		
	}


	public void registButtonListener(TestA testA) {
		
		
	}

}
