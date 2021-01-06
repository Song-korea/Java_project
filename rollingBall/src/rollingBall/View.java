package rollingBall;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame{
	
	private JFrame				frame;
	private DrawComponent 		comp;
	private JButton				playButton;
	private JButton 			stopButton;
	private JButton				addButton;
	private JButton				deleteButton;
	private JPanel 				panel;
	private FlowLayout			flowLayout;
	private JComboBox<String>  	ballColorComboBox;
	
	
	public View() {
		frame = new JFrame("�� ������");
		comp = new DrawComponent();
		panel = new JPanel();
		flowLayout = new FlowLayout();
		ballColorComboBox = new JComboBox<String>();
	    addComboBoxItems();
	    initButton();
	    initPanel();
	    initFrame();    
	}
	
	private void addComboBoxItems() {
		BallGroupManager ballGroupManager = new BallGroupManager();
		
		for(int i=0; i<ballGroupManager.getBallGroupList().size();i++) {
			Color color = ballGroupManager.getBallGroupList().get(i).getColor();
			String colorName = convertTypeColorToString(color);
			ballColorComboBox.addItem(colorName);
		}
		
	}
	
	private void initButton() {
		playButton = new JButton("play");
		stopButton = new JButton("stop");
		addButton = new JButton("add");
		deleteButton = new JButton("delete");
		
		playButton.setVerticalTextPosition(AbstractButton.CENTER);
		playButton.setHorizontalTextPosition(AbstractButton.LEADING);
		stopButton.setVerticalTextPosition(AbstractButton.CENTER);
		stopButton.setHorizontalTextPosition(AbstractButton.LEADING);
		addButton.setVerticalTextPosition(AbstractButton.CENTER);
		addButton.setHorizontalTextPosition(AbstractButton.LEADING);
		deleteButton.setVerticalTextPosition(AbstractButton.CENTER);
		deleteButton.setHorizontalTextPosition(AbstractButton.LEADING);	
	}

	private void initPanel() {
		panel.setLayout(flowLayout);
	    panel.add(comp,flowLayout);
	    panel.add(playButton,flowLayout);
	    panel.add(stopButton,flowLayout);
	    panel.add(addButton,flowLayout);
	    panel.add(deleteButton,flowLayout);
	    panel.add(ballColorComboBox,flowLayout);
	}
	
	private void initFrame() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void registerButtonListener(ButtonActionListener buttonListener) {
		playButton.addActionListener(buttonListener);
		stopButton.addActionListener(buttonListener);
		addButton.addActionListener(buttonListener);
		deleteButton.addActionListener(buttonListener);
	}
	
	public void draw() {
		frame.repaint();
	}
	
	public void setBallManager(BallGroupManager ballGroupManager) {
		comp.setBallGroupManager(ballGroupManager);
	}

	public String getSelectedColor() {
		return ballColorComboBox.getSelectedItem().toString();
	}

	private String convertTypeColorToString(Color color) {
		String colorName = null;
		
		if(Color.BLACK.equals(color))
			colorName = "black";
		else if(Color.BLUE.equals(color))
			colorName = "blue";
		else if(Color.RED.equals(color))
			colorName = "red";
		else if(Color.GREEN.equals(color))
			colorName = "green";
		else if(Color.CYAN.equals(color))
			colorName = "cyan";
		else if(Color.GRAY.equals(color))
			colorName = "gray";
		else if(Color.MAGENTA.equals(color))
			colorName = "magenta";
		else if(Color.ORANGE.equals(color))
			colorName = "orange";
		else if(Color.WHITE.equals(color))
			colorName = "white";
		else if(Color.PINK.equals(color))
			colorName = "pink";
		else
			colorName = "null";
		
		return colorName;
	}
	
}
