package bounceBallMody;
 
public class Ball {
    
    public int ballRadius; //�� ������
    public float ballPosX; //�� ������
    public float ballPosY;
    
    private float ballSpeedX; // ����  X�� �ӵ�
    private float ballSpeedY; // ����  Y�� �ӵ�
    
    private DrawComponent p;
 
    public Ball() {
        this.ballRadius = 10;
        this.ballPosX = 50;
        this.ballPosY = 50;
        this.ballSpeedX = 100;
        this.ballSpeedY = 10;
        p = new DrawComponent();
    }
 
    
    public void moveBall() {   	
        ballPosX +=ballSpeedX;
        ballPosY +=ballSpeedY;
         
         if(ballPosX-ballRadius<=0)
             ballSpeedX = -ballSpeedX;
         
         if(ballPosY-ballRadius<=0)
             ballSpeedY = -ballSpeedY;
         
         if(ballPosX + ballRadius >= p.getBoxSizeX()) {
             ballSpeedX = -ballSpeedX;             
         }        
         if((ballPosY + ballRadius) >= p.getBoxSizeY()) {
             ballSpeedY = -ballSpeedY;
         }
    }
    
    
}