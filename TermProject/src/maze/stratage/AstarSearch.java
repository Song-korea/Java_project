package maze.stratage;

import java.util.Arrays;
import java.util.Collections;

import maze.search.SearchNode;

public class AstarSearch extends Stratage{
	

	@Override
	public SearchNode getNextNode() {           //���� ��� ��°�
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

	 //fringe ����
	public void sortFringe(SearchNode[] fringeArray) {
		
																//�ϴ� ����ϳ�  ----- �������� ���鿡 ������ �ٽ� ���� ���ϰ� ok 
																//�ٽ� �޸���ƽ ���  ���⼭ �ϰ�
		
																	//���ı��� ���⼭ �ϱ� 
		
		Arrays.sort(fringeArray,Collections.reverseOrder());
	}
	// fringe Ŭ����
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
