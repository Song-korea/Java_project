package maze.data;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

import maze.search.SearchNode;
import maze.search.State;


public class Maze {
	private Cell[][]				cells;
	
	private int						width;
	private int						height;
	
	private LinkedList<SearchNode>	fringe;
	private LinkedList<SearchNode>	checked;
	
	
	public void	initMaze(int width, int height) {
		this.width = width;
		this.height = height;
		cells = new Cell[width][height];
		for(int i = 0; i < width; i++){
			cells[i] = new Cell[height];
			for(int j = 0; j<height; j++){
				cells[i][j] = new Cell(i, j);
			}
		}
		fringe = new LinkedList<SearchNode>();
		checked = new LinkedList<SearchNode>();
		Random r = new Random();
		int startX = r.nextInt(width);
		int startY = r.nextInt(height);
		fringe.add(new SearchNode(null, new State(cells[startX][startY])));
	}

	public boolean makeMaze() {
		if(fringe.isEmpty()) {
			return false;
		}
		SearchNode node = fringe.getFirst();
		if(isVisited(node)) {
			fringe.remove(node);
			return true;
		}
		
		if(node.getParent()!=null) {
			connectWithParent(node);
		}
		checked.add(node);
		if(!isExpanded(node)) {
			expandAndPutFringe(node);
		}
		if(!isNoMoreVisitableChildren(node)){
			fringe.remove(node);
		}
		return true;
	}



	private boolean isNoMoreVisitableChildren(SearchNode node) {
		boolean haveMore = false;
		for(SearchNode n : node.getChildren()){
			if(!isVisited(n)){
				haveMore = true;
				break;
			}
		}		
		return haveMore;
	}

	private boolean isExpanded(SearchNode node) {
		return node.getChildren()!=null;
	}

	private boolean isVisited(SearchNode node) {
		int nodeX = node.getState().getCell().getPosX();
		int nodeY = node.getState().getCell().getPosY();
		for (SearchNode n : checked) {
			int inNodeX = n.getState().getCell().getPosX();
			int inNodeY = n.getState().getCell().getPosY();
			if(nodeX==inNodeX&&nodeY==inNodeY){
				return true;
			}
		}
		return false;
	}

	private void expandAndPutFringe(SearchNode node) {
		LinkedList<SearchNode> children = expand(node);
		Collections.shuffle(children);
		for (SearchNode child : children) {
			if(!isVisited(child)){
				fringe.addFirst(child);
			}
		}
		
	}

	private LinkedList<SearchNode> expand(SearchNode node) {

		int currentX = node.getState().getCell().getPosX();
		int currentY = node.getState().getCell().getPosY();
		LinkedList<SearchNode> expand = new LinkedList<SearchNode>();
		if(currentX!=0){
			expand.add(new SearchNode(node, new State(cells[currentX-1][currentY])));
		}
		if(currentY!=0){
			expand.add(new SearchNode(node, new State(cells[currentX][currentY-1])));
		}
		if(currentX!=width-1){
			expand.add(new SearchNode(node, new State(cells[currentX+1][currentY])));
		}
		if(currentY!=height-1){
			expand.add(new SearchNode(node, new State(cells[currentX][currentY+1])));
		}
		node.setChildren(expand.toArray(new SearchNode[expand.size()]));
		return expand;
	}

	private void connectWithParent(SearchNode node) {
		SearchNode parent = node.getParent();
		if(parent!=null){
			int px = parent.getState().getCell().getPosX();
			int py = parent.getState().getCell().getPosY();
			int cx = node.getState().getCell().getPosX();
			int cy = node.getState().getCell().getPosY();
			
			if(cx-1==px){
				node.getState().getCell().leftOpen();
				parent.getState().getCell().rightOpen();
			}
			if(cx+1==px){
				node.getState().getCell().rightOpen();
				parent.getState().getCell().leftOpen();
			}
			if(cy-1==py){
				node.getState().getCell().upOpen();
				parent.getState().getCell().downOpen();
			}
			if(cy+1==py){
				node.getState().getCell().downOpen();
				parent.getState().getCell().upOpen();
			}
		}
		
	}

	public Cell getCell(int posX, int posY) {
		return cells[posX][posY];
		
	}
	
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}

}
