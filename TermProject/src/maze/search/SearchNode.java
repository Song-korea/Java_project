package maze.search;

public class SearchNode implements Comparable<SearchNode> {
	private final SearchNode				parent;
	private SearchNode[]					children;
	
	private final State						state;
	
	public SearchNode(SearchNode parent, State s) {
		this.parent = parent;
		this.state = s;
	}

	public State getState() {
		return state;
	}
	
	public SearchNode getParent() { //�θ� ��� �޾ƿͼ� ���̵Ǹ� ��
		return parent;
	}

	public void setChildren(SearchNode[] array) {
		this.children = array;
	}
	public SearchNode[] getChildren() {
		return this.children;
	}


	////Astar
	@Override
	public int compareTo(SearchNode o) {
		
		if (this.getState().getCell().getEvaluationFunction(this) < o.getState().getCell().getEvaluationFunction(o)) {

			return -1;

		} else if (this.getState().getCell().getEvaluationFunction(this) == o.getState().getCell().getEvaluationFunction(o)) {

			return 0;

		} else {

			return 1;

		}

	}
	
	

	
	
}
