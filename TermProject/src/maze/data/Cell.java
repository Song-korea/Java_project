package maze.data;

import maze.MazeSolver;
import maze.search.SearchNode;

public class Cell {
	
	private final int				posX;
	private final int				posY;
	private final double 			distance;
	private final int 				endX;
	private final int 				endY;
	private boolean					upOpened;
	private boolean					downOpened;
	private boolean					rightOpened;
	private boolean					leftOpened;
	
	public Cell(int x, int y) {
		this.posX = x;
		this.posY = y;
		this.endX = MazeSolver.size-1;
		this.endY = MazeSolver.size-1;
		this.distance = Math.sqrt(Math.pow(endX-x,2)+Math.pow(endY-y,2));
		this.upOpened = false;
		this.downOpened = false;
		this.rightOpened = false;
		this.leftOpened = false;
	}
	

	public double getEvaluationFunction(SearchNode node) {
		double evaluationF = 0;
		int depth2=0;
		depth2 = depthFind(node);
		
		if(MazeSolver.SearchIndex==4)
			depth2=0;
		
		evaluationF =  (depth2 + (node.getState().getCell().getDistance()));
		
		return evaluationF;
	}

	public int depthFind(SearchNode node) {
		int depth = 0;
		
		SearchNode searchParent = node;
		while(searchParent.getParent()!=null) {
		searchParent = searchParent.getParent();
		depth ++;
		}
	
		return depth;
	}
	

	public double getDistance() {
		return distance;
	}
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
	public boolean isUpOpened() {
		return upOpened;
	}
	public void upOpen() {
		this.upOpened = true;
	}
	public boolean isDownOpened() {
		return downOpened;
	}
	public void downOpen() {
		this.downOpened = true;
	}
	public boolean isRightOpened() {
		return rightOpened;
	}
	public void rightOpen() {
		this.rightOpened = true;
	}
	public boolean isLeftOpened() {
		return leftOpened;
	}
	public void leftOpen() {
		this.leftOpened = true;
	}
	
	
	

}
