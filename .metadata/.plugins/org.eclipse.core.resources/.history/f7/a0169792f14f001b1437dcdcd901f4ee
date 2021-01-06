package rollingBall;

import java.awt.Color;

public class Core {//정보는 변수
	private View 								view;
	private BallGroupManager 					ballGroupManager;
	
	public static final int WIDTH = 780;
	public static final int HEIGHT = 480;
	
	public Core() {
		view = new View();
		ballGroupManager = new BallGroupManager();
		
		this.init();
		this.start();
	}

	private void init() {
		view.setBallManager(ballGroupManager);
		view.registerButtonListener(new ButtonActionListener(this));
	}

	private void start() {
		while(true) {
			
			for(int j=0; j<ballGroupManager.getBallGroupList().size();j++) {
				
				BallGroup colorBallGroup = ballGroupManager.getBallGroupList().get(j); 
				if(colorBallGroup.isPlay())
					moveBallGroup(colorBallGroup);
			}
			
			this.draw();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}
	
	private void moveBallGroup(BallGroup ballGroup) {
		Ball ball;
		
		for(int i=0; i<ballGroup.getBallListSize();i++) {
			ball = ballGroup.getBallList().get(i);
			moveBall(ball);
			reflectBall(ball);
		}
	}
	
	private void moveBall(Ball ball) {
			if(ball.isRight())
				ball.setBallPosX(ball.getBallPosX() + 1);
			else
				ball.setBallPosX(ball.getBallPosX() - 1);
			
			if(ball.isUp())
				ball.setBallPosY(ball.getBallPosY() + 1);
			else
				ball.setBallPosY(ball.getBallPosY() - 1);
	}

	private void reflectBall(Ball ball) {
			if(ball.getBallPosX() - 10 <=0 || ball.getBallPosX() + 10>= WIDTH)
				ball.setRight(!ball.isRight());
			if(ball.getBallPosY() - 10 <=0 || ball.getBallPosY() + 10>= HEIGHT)
				ball.setUp(!ball.isUp());
	}		
	
	private void draw() {
		view.draw();
	}

	public void clickedPlay() {
		playBall();
	}
	
	public void clickedStop() {
		stopBall();
	}
	
	public void clickedAdd() {
		Color selectedColor = convertTypeStringToColor(view.getSelectedColor());
		addBall(selectedColor);
	}
	
	public void clickedDelete() {
		Color selectedColor = convertTypeStringToColor(view.getSelectedColor());
		deleteBall(selectedColor);
	}
	
	private void addBall(Color selectedColor) {
		ballGroupManager.addBallToGroup(selectedColor);
	}
	
	private void deleteBall(Color selectedColor) {
		ballGroupManager.removeBallFromGroup(selectedColor);
	}
	
	private void playBall() {
		Color selectedColor = convertTypeStringToColor(view.getSelectedColor());
		ballGroupManager.playBallGroup(selectedColor);
	}
	
	private void stopBall() {
		Color selectedColor = convertTypeStringToColor(view.getSelectedColor());
		ballGroupManager.stopBallGroup(selectedColor);
	}
	
	private Color convertTypeStringToColor(String stringColor) {
		Color color = null;
	    switch (stringColor) {
	    case "black":
	        color = Color.BLACK;
	        break;
	    case "blue":
	        color = Color.BLUE;
	        break;
	    case "cyan":
	        color = Color.CYAN;
	        break;
	    case "darkgray":
	        color = Color.DARK_GRAY;
	        break;
	    case "gray":
	        color = Color.GRAY;
	        break;
	    case "green":
	        color = Color.GREEN;
	        break;
	    case "yellow":
	        color = Color.YELLOW;
	        break;
	    case "lightgray":
	        color = Color.LIGHT_GRAY;
	        break;
	    case "magneta":
	        color = Color.MAGENTA;
	        break;
	    case "orange":
	        color = Color.ORANGE;
	        break;
	    case "pink":
	        color = Color.PINK;
	        break;
	    case "red":
	        color = Color.RED;
	        break;
	    case "white":
	        color = Color.WHITE;
	        break;
	        }
	    return color;
	    }
	
	
	
	
	
	public static void main(String[] args) {
		new Core();
	}
		
}
