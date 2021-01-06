package rollingBall;

import java.awt.Color;
import java.util.LinkedList;

public class BallGroupManager {
	
	private BallGroup redBallGroup;
	private BallGroup blueBallGroup;
	private BallGroup greenBallGroup;
	private BallGroup pinkBallGroup;
	
	private LinkedList<BallGroup> ballGroupList;
	
	public LinkedList<BallGroup> getBallGroupList() {
		return ballGroupList;
	}

	public BallGroupManager() {
		redBallGroup 	= new BallGroup(Color.RED);
		blueBallGroup 	= new BallGroup(Color.BLUE);
		greenBallGroup 	= new BallGroup(Color.GREEN);
		pinkBallGroup 	= new BallGroup(Color.PINK);
		ballGroupList 	= new LinkedList<BallGroup>();
		addBallGroupToList();
	}
	
	private void addBallGroupToList() {
		ballGroupList.add(redBallGroup);
		ballGroupList.add(blueBallGroup);
		ballGroupList.add(greenBallGroup);
		ballGroupList.add(pinkBallGroup);
	}

	public void addBallToGroup(Color color) {
		Ball ball = new Ball();
		BallGroup ballGroup = getBallGroupByColor(color);
		ballGroup.getBallList().add(ball);
	}
	
	public void removeBallFromGroup(Color color) {
		BallGroup ballGroup = getBallGroupByColor(color);
		ballGroup.getBallList().removeLast();
	}
	
	public void playBallGroup(Color color) {
		BallGroup ballGroup = getBallGroupByColor(color);
		ballGroup.setPlay(true);
	}
	
	public void stopBallGroup(Color color) {
		BallGroup ballGroup = getBallGroupByColor(color);
		ballGroup.setPlay(false);
	}
	
	public int getBallNumber(Color color) {
		BallGroup ballGroup = getBallGroupByColor(color);
		return ballGroup.getBallList().size();
	}

	public BallGroup getRedBallGroup() {
		return redBallGroup;
	}

	public BallGroup getBlueBallGroup() {
		return blueBallGroup;
	}

	public BallGroup getGreenBallGroup() {
		return greenBallGroup;
	}
	
	private BallGroup getBallGroupByColor(Color color) {
		BallGroup ballGroup = null;
		for(int i=0; i<ballGroupList.size(); i++) {
			if(color==ballGroupList.get(i).getColor())
				ballGroup = ballGroupList.get(i);
		}
		return ballGroup;
	}
	
	
}
