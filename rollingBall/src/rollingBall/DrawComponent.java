package rollingBall;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

public class DrawComponent extends JComponent {
	
	BallGroupManager ballGroupManager;
	
	public Dimension getPreferredSize() {
		return new Dimension(Core.WIDTH,Core.HEIGHT);
	}
	
	@Override
	public void paint(Graphics g) {
		Ball ball;	
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Core.WIDTH, Core.HEIGHT);


		for(int j=0; j<ballGroupManager.getBallGroupList().size();j++) {
			
			BallGroup colorBallGroup = ballGroupManager.getBallGroupList().get(j);
			
			for(int i=0; i<colorBallGroup.getBallListSize(); i++) {
				ball = colorBallGroup.getBallList().get(i);
				g.setColor(colorBallGroup.getColor());
				g.fillOval(ball.getBallPosX()-10, ball.getBallPosY()-10, 20, 20);
			}
		}
	}

	public void setBallGroupManager(BallGroupManager ballGroupManager) {
		this.ballGroupManager = ballGroupManager;
	}
	
}
