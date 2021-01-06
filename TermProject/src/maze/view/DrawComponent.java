package maze.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

import maze.data.Cell;
import maze.data.Maze;
import maze.search.SearchNode;
import maze.stratage.Stratage;


public class DrawComponent extends JComponent {
	private static final int	CELLSIZE = 30;
	private Maze 				maze;
	private Stratage			stratage;
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(maze.getWidth()*CELLSIZE, maze.getHeight()*CELLSIZE);
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, maze.getWidth()*CELLSIZE, maze.getHeight()*CELLSIZE);
		g.setColor(Color.black);
		for(int i = 0; i < maze.getWidth(); i++){
			for(int j = 0; j < maze.getHeight(); j++){
				Cell c = maze.getCell(i, j);
				if(!c.isUpOpened()){
					g.drawLine(i*CELLSIZE, j*CELLSIZE, (i+1)*CELLSIZE-1, j*CELLSIZE);
				}
				if(!c.isDownOpened()){
					g.drawLine(i*CELLSIZE, (j+1)*CELLSIZE-1, (i+1)*CELLSIZE-1, (j+1)*CELLSIZE-1);
				}
				if(!c.isLeftOpened()){
					g.drawLine(i*CELLSIZE, j*CELLSIZE, i*CELLSIZE, (j+1)*CELLSIZE-1);
				}
				if(!c.isRightOpened()){
					g.drawLine((i+1)*CELLSIZE-1, j*CELLSIZE, (i+1)*CELLSIZE-1, (j+1)*CELLSIZE-1);
				}
			}
		}
		if(stratage!=null){
			SearchNode[] nodes = stratage.getCandidate();
			if(nodes!=null){
				g.setColor(Color.GRAY);
				for(SearchNode n : nodes){
					Cell c = n.getState().getCell();
					g.fillRect(c.getPosX()*CELLSIZE+CELLSIZE/10, c.getPosY()*CELLSIZE+CELLSIZE/10, CELLSIZE-2*(CELLSIZE/10), CELLSIZE-2*(CELLSIZE/10));
				}
			}
			SearchNode[] path = stratage.getSolution();
			if(path!=null){
				g.setColor(Color.BLACK);
				for(SearchNode n : path){
					Cell c = n.getState().getCell();
					g.fillOval(c.getPosX()*CELLSIZE+CELLSIZE*2/10, c.getPosY()*CELLSIZE+CELLSIZE*2/10, CELLSIZE-4*(CELLSIZE/10), CELLSIZE-4*(CELLSIZE/10));
				}
			}
		}
	}
	public void setMaze(Maze maze) {
		this.maze = maze;
		this.stratage=null;
		
	}

	public void setStratage(Stratage stratage2) {
		this.stratage = stratage2;
		
	}
}
