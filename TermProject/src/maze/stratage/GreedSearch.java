package maze.stratage;

import java.util.Arrays;
import java.util.Collections;

import maze.search.SearchNode;

public class GreedSearch extends Stratage{
	

	@Override
	public SearchNode getNextNode() {           //다음 노드 얻는거
		SearchNode node = fringe.remove();
		this.candidate.add(node);
		space++;
		return node;
	}

	@Override
	public void putFringe(SearchNode[] children) {  //fringe에 넣는거를 바꾸는게 맞는데
		for (SearchNode node : children) { 
			if(isVisited(node)){                //방문 안했으면 fringe.addFirst(node)
				continue;			
			}
			
			fringe.addFirst(node);     //이부분이 하나만 들어가는건데 다 넣고 BFS로 변환
		}
	}

	 //children 정렬
	public void sortChildren(SearchNode[] children) {
		Arrays.sort(children,Collections.reverseOrder());
	}
	
	public int SearchIndex() {
		return 4;
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

}
