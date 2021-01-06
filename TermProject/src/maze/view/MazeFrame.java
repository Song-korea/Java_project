package maze.view;

import javax.swing.JFrame;

import maze.data.Maze;
import maze.stratage.Stratage;


public class MazeFrame {
	private JFrame			frame;
	private DrawComponent	comp;
	
	public MazeFrame() {
		frame = new JFrame("Maze Term Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		comp = new DrawComponent();
		frame.add(comp);
	}
	

	public void drawMaze() {
		
		frame.repaint();
		
	}
	public void setMaze(Maze maze){
		comp.setMaze(maze);
		frame.pack();
		frame.setVisible(true);
	}


	public void setStratage(Stratage stratage) {
		comp.setStratage(stratage);
		
	}


}
