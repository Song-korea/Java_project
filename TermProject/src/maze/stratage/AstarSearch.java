package maze.stratage;

import java.util.Arrays;
import java.util.Collections;

import maze.search.SearchNode;

public class AstarSearch extends Stratage{
	

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

	//LinkedList to Array
	public SearchNode[] linkedListtoArray() {
	Object[] objectArray = fringe.toArray();
	int length = objectArray.length;
	SearchNode[] fringeArray = new SearchNode[length];
	
	for(int k = 0; k<length; k++) {
		fringeArray[k] = (SearchNode) objectArray[k];
		}
	return fringeArray;       		
	}

	 //fringe 정렬
	public void sortFringe(SearchNode[] fringeArray) {
		
																//일단 어떻게하냐  ----- 프린지의 노드들에 뎁스를 다시 각각 구하고 ok 
																//다시 휴리스틱 계산  여기서 하고
		
																	//정렬까지 여기서 하기 
		
		Arrays.sort(fringeArray,Collections.reverseOrder());
	}
	// fringe 클리어
	public void clearFringe() {
		fringe.clear();
	}

	
	
	public int SearchIndex() {
		return 5;
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
