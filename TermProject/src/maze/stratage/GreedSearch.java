package maze.stratage;

import java.util.Arrays;
import java.util.Collections;

import maze.search.SearchNode;

public class GreedSearch extends Stratage{
	

	@Override
	public SearchNode getNextNode() {           //���� ��� ��°�
		SearchNode node = fringe.remove();
		this.candidate.add(node);
		space++;
		return node;
	}

	@Override
	public void putFringe(SearchNode[] children) {  //fringe�� �ִ°Ÿ� �ٲٴ°� �´µ�
		for (SearchNode node : children) { 
			if(isVisited(node)){                //�湮 �������� fringe.addFirst(node)
				continue;			
			}
			
			fringe.addFirst(node);     //�̺κ��� �ϳ��� ���°ǵ� �� �ְ� BFS�� ��ȯ
		}
	}

	 //children ����
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
