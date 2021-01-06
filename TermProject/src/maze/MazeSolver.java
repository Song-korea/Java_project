package maze;

import java.util.Arrays;
import java.util.LinkedList;

import maze.data.Cell;
import maze.data.Maze;
import maze.search.SearchNode;
import maze.search.State;
import maze.stratage.AstarSearch;
import maze.stratage.BreadthFirstSearch;
import maze.stratage.DepthFirstSearch;
import maze.stratage.GreedSearch;
import maze.stratage.IterativeDeepningSearch;
import maze.stratage.Stratage;
import maze.view.MazeFrame;

public class MazeSolver {
	private Maze			maze;
	private MazeFrame		view;
	public static int 		size = 30;	
	public static int 		depth = 1;
	public static int 		SearchIndex = 0;
	public MazeSolver() {
		view = new MazeFrame();
		
		init();
	}
	
	
	private void init() {
		for(int i = 0; i< 10; i++) {
			makeMaze();
			Stratage s = new IterativeDeepningSearch();    //탐색방법
			s.space = 0;
			view.setStratage(s);
			solveMaze(s);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	
	private void makeMaze() {
		maze = new Maze();
		maze.initMaze(size, size);
		view.setMaze(maze);
		while(maze.makeMaze()) {
			view.drawMaze();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Maze Generated!!");
	}


	private void solveMaze(Stratage s) {
		
		SearchNode n = makeInitialNode(); 
		s.setInitialNode(n);
		long startTime = System.currentTimeMillis();
		int maxFringeSize = 0;
		int depthIndex=1;
		int iterIndex=0;
	
		SearchIndex = s.SearchIndex();
		
		
		while(true) {
			//////////////iterative//////////
			if(SearchIndex == 3) {
			if(s.getFringeSize()==0) {
				s.space=0;
				depthIndex++;
				s.clearCandidate();
				s.setInitialNode(n);
			}
			}
			///////////////////////////////////
			
			
			SearchNode currentNode = s.getNextNode();
			
			Cell c = currentNode.getState().getCell();
//			int curX = c.getPosX();
//			int curY = c.getPosY();
//			System.out.println("(" +curX +","+curY+")");
			
////////////////////////////////////////depth 구하기 ////////////////////////////////////	
			if(SearchIndex==3) {
				depth = 0;			 			
				SearchNode searchParent = currentNode; 
				while(searchParent!=null) {
				searchParent = searchParent.getParent();
				depth ++;
				}
				if(SearchIndex ==3) {//iterative
					if(depthIndex == depth) {
						iterIndex = 1;
					}
				}
//				System.out.println("detph = " + depth);
			}

			/////////////////////////////////////////
//				if(SearchIndex==5) {
//					System.out.println(" depth =" + s.depthFind(currentNode) + "           HF = " + c.getEvaluationFunction(currentNode));
//				}
//				else if(SearchIndex==4) {
//				
//					System.out.println("EvaluationFunction = " +c.getEvaluationFunction(currentNode));
//				}
////				System.out.println(" ");
			 

			if(goalTest(currentNode)) {
				s.makeSolution(currentNode);
				
				break;
			}  
			
			SearchNode[] children = expandNode(currentNode);
			
			
			
			//GreedSearch 
			//Greed Search인 경우 children의 거리에 따라 정렬 후 s.putFringe 실행
			if(SearchIndex==4) {
				s.sortChildren(children);

			}
			//iterativeSearch 
			//iterIndex=1이면 s.putFringe(children)을 한 번 쉰다.
			if(iterIndex == 1) {
				iterIndex = 0;
			}
			else
			s.putFringe(children);
//////////////////////Astar///////////////
			if(SearchIndex==5) {
			SearchNode[] fringeArray = s.linkedListtoArray();
			s.clearFringe();
			
			s.sortFringe(fringeArray);
			s.putFringe(fringeArray);
			
			}
////////////////
			
			
			
			int currentFringeSize = s.getFringeSize();
			if(maxFringeSize<currentFringeSize) {
				maxFringeSize = currentFringeSize;
			}
			view.drawMaze();
			try {
				Thread.sleep(1); // 시간
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
						
			
			
		int complexity = s.space + s.getFringeSize();
			
		
		
		
		long endTime = System.currentTimeMillis();
		System.out.println("Time Complexity : " +(endTime-startTime));
		System.out.println("space complexity = " + complexity);
		
		view.drawMaze();
		System.out.println("Maze Solved!!");
		
	}

	private SearchNode[] expandNode(SearchNode n) {

		LinkedList<SearchNode> expand = new LinkedList<SearchNode>();
		Cell c = n.getState().getCell();
		int currentX = c.getPosX();
		int currentY = c.getPosY();
		
		if(c.isLeftOpened()&&currentX!=0){
			expand.add(new SearchNode(n, new State(maze.getCell(currentX-1,currentY))));
		}
		if(c.isUpOpened()&&currentY!=0){
			expand.add(new SearchNode(n, new State(maze.getCell(currentX,currentY-1))));
		}
		if(c.isRightOpened()&&currentX!=maze.getWidth()-1){
			expand.add(new SearchNode(n, new State(maze.getCell(currentX+1,currentY))));
		}
		if(c.isDownOpened()&&currentY!=maze.getHeight()-1){
			expand.add(new SearchNode(n, new State(maze.getCell(currentX,currentY+1))));
		}
		n.setChildren(expand.toArray(new SearchNode[expand.size()]));
		SearchNode[] children = expand.toArray(new SearchNode[expand.size()]);
		
		return children;
		
	}


	private boolean goalTest(SearchNode currentNode) {
		Cell c = currentNode.getState().getCell();
		int x = c.getPosX();
		int y = c.getPosY();
		if(x==maze.getWidth()-1&&y==maze.getHeight()-1) {
			return true;
		}else {
			return false;
		}
		
	}


	private SearchNode makeInitialNode() {
		Cell c = maze.getCell(0, 0);
		return new SearchNode(null, new State(c));
		
	}


	public static void main(String[] args) {
		new MazeSolver();
	}
}
