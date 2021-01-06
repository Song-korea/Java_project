package bounceBall;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class BounceBall extends JFrame{
	private JFrame frame;
	private final static int WindowX = 600; //창 X, Y 크기
	private final static int WindowY = 400;
	private final int ballRadius = 10; //공 반지름
	
	private float ballPosX = ballRadius; //볼 시작점
	private float ballPosY = ballRadius;
	
	 private float ballSpeedX = 10; // 공의  X축 속도
	 private float ballSpeedY = 10; // 공의  Y축 속도

    public BounceBall() {
        frame = new JFrame("공굴리기");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //위의 옵션으로 닫지 않으면 프로세스에 계속 돌아간다고 함
        
        DrawPannel pannel = new DrawPannel();        
        pannel.setPreferredSize(new Dimension(WindowX,WindowY));
        //패널 사이즈
        frame.add(pannel);
        frame.pack();
        //프레임 구성요소에 맞게 크기가 만들어짐
        
		frame.setVisible(true);

        this.init();
    }
    public void init() {
		 
	 	while(true) {
		 ballPosX +=ballSpeedX;
		 ballPosY +=ballSpeedY;
		 
		 if(ballPosX-ballRadius==0)
			 ballSpeedX = -ballSpeedX;
		 
		 if(ballPosY-ballRadius==0)
			 ballSpeedY = -ballSpeedY;
		 
		 if(ballPosX + ballRadius >= WindowX) {
			 ballSpeedX = -ballSpeedX;
			 
		 }
		 
		 if((ballPosY + ballRadius) >= WindowY) {
			 ballSpeedY = -ballSpeedY;
			 
		 }
		 			 
		 frame.repaint();
		 try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	}
 }

    class DrawPannel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.GREEN); // 초록색으로 채움
			g.fillRect(0, 0, WindowX, WindowY); // 직사각형

			g.setColor(Color.RED); // 빨간색으로 채움
			g.fillOval((int) (ballPosX - ballRadius), (int) (ballPosY - ballRadius),
			    (int) (2 * ballRadius-1), (int) (2 * ballRadius-1)); // 원

        }
    }


    public static void main(String[] args) {
        new BounceBall();
    }
}


