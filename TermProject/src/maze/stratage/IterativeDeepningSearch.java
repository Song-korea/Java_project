package maze.stratage;

import maze.search.SearchNode;

public class IterativeDeepningSearch extends Stratage{
	

	@Override
	public SearchNode getNextNode() {           //다음 노드 얻는거
		SearchNode node = fringe.remove();
		this.candidate.add(node);
		space++;
		return node;
	}

	@Override
	public void putFringe(SearchNode[] children) {  
		for (SearchNode node : children) {
			if(isVisited(node)){                
				continue;
			}			
			fringe.addFirst(node);     
		}
	}
	
	private boolean isVisited(SearchNode node) {
		int nodeX = node.getState().getCell().getPosX();
		int nodeY = node.getState().getCell().getPosY();
		for (SearchNode n : candidate) {
			int inNodeX = n.getState().getCell().getPosX();
			int inNodeY = n.getState().getCell().getPosY();
			if(nodeX==inNodeX&&nodeY==inNodeY){
				return true;
			}
		}
		return false;
	}
	
	public int SearchIndex() {
		return 3;
	}

}
