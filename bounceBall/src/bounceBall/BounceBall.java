package bounceBall;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class BounceBall extends JFrame{
	private JFrame frame;
	private final static int WindowX = 600; //â X, Y ũ��
	private final static int WindowY = 400;
	private final int ballRadius = 10; //�� ������
	
	private float ballPosX = ballRadius; //�� ������
	private float ballPosY = ballRadius;
	
	 private float ballSpeedX = 10; // ����  X�� �ӵ�
	 private float ballSpeedY = 10; // ����  Y�� �ӵ�

    public BounceBall() {
        frame = new JFrame("��������");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //���� �ɼ����� ���� ������ ���μ����� ��� ���ư��ٰ� ��
        
        DrawPannel pannel = new DrawPannel();        
        pannel.setPreferredSize(new Dimension(WindowX,WindowY));
        //�г� ������
        frame.add(pannel);
        frame.pack();
        //������ ������ҿ� �°� ũ�Ⱑ �������
        
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
            g.setColor(Color.GREEN); // �ʷϻ����� ä��
			g.fillRect(0, 0, WindowX, WindowY); // ���簢��

			g.setColor(Color.RED); // ���������� ä��
			g.fillOval((int) (ballPosX - ballRadius), (int) (ballPosY - ballRadius),
			    (int) (2 * ballRadius-1), (int) (2 * ballRadius-1)); // ��

        }
    }


    public static void main(String[] args) {
        new BounceBall();
    }
}


