package bounceBallMody;
 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
 
import javax.swing.JComponent;
import javax.swing.JPanel;
        
public class DrawComponent extends JComponent {
 
    private final int BoxSizeX = 600; //창 X, Y 크기
    private final int BoxSizeY = 400;
    private Ball             ball;
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(BoxSizeX,BoxSizeY);
    }
    
 
    @Override
    public void paint(Graphics g){
        
         g.setColor(Color.GREEN); // 초록색으로 채움
         g.fillRect(0, 0, BoxSizeX, BoxSizeY); // 직사각형
       
         g.setColor(Color.RED); // 빨간색으로 채움
         
 
         g.fillOval((int) (ball.ballPosX - ball.ballRadius), 
                 (int) (ball.ballPosY - ball.ballRadius),
                (int) (2 * ball.ballRadius-1), (int) (2 * ball.ballRadius-1)); // 원
 
    }
    
    public void setBall(Ball ball) {
        this.ball = ball;
    }
    
    public int getBoxSizeX() {
        return BoxSizeX;
    }
 
    public int getBoxSizeY() {
        return BoxSizeY;
    }
}