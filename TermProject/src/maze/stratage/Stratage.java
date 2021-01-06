package maze.stratage;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import maze.search.SearchNode;

public abstract class Stratage {
	protected LinkedList<SearchNode>				fringe;
	protected LinkedList<SearchNode>				candidate;
	protected LinkedList<SearchNode>				solution;
	private int iterIndex = 0;
	public static int space;
	public Stratage() {
		fringe = new LinkedList<SearchNode>();
		candidate = new LinkedList<SearchNode>();
		solution = new LinkedList<SearchNode>();

	}
	public void setInitialNode(SearchNode initialNode) {
		fringe.add(initialNode);
	}
	public void clearCandidate() {
		candidate.clear();
	}
	public int SearchIndex() {
		return 0;
	}
	
	public abstract SearchNode getNextNode();

	public abstract void putFringe(SearchNode[] children);
	public SearchNode[] getCandidate() {
		return candidate.toArray(new SearchNode[candidate.size()]);
	}
	public void makeSolution(SearchNode goalNode) {
		SearchNode node = goalNode;
		while(node.getParent()!=null) {
			solution.add(node);
			SearchNode parentNode = node.getParent();
			node = parentNode;
		}
		solution.add(node);
	}
	public SearchNode[] getSolution() {
		if(solution.isEmpty()) {
			return null;
		}
		return solution.toArray(new SearchNode[solution.size()]);
	}
	public int getFringeSize() {
		
		return fringe.size();
	}
	public int depthFind(SearchNode node) {
		return 0;
	}
	
//Astar
	public SearchNode[] linkedListtoArray() {
		SearchNode[] kk = null;
		return kk;
	}

	public void sortFringe(SearchNode[] fringeArray) {}
	
	public void clearFringe() {}
	
//Greed	
	public void sortChildren(SearchNode[] children) {};

	
	
	
	
}
