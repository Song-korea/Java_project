package maze.search;

import maze.data.Cell;

public class State {
	private final Cell				cell;
	
	public State(Cell c) {
		this.cell = c;
	}

	public Cell getCell() {
		return this.cell;
	}

}
