package bounceBallMody;
 
public class BallRolling {
    
    public Ball ball;
    private BallRollingFrame frame;
    
   
    
    public BallRolling(){ 	
    frame = new BallRollingFrame();
    ball = new Ball();
    
    frame.setBall(ball);
    this.init();
    }
    
    private void init() {
        while(true) {
            ball.moveBall();
            frame.repaint();
            
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {           
                e.printStackTrace();
            }
            
            }
    }
 
    
    public static void main(String[] args) {
        new BallRolling();
        
        System.out.println(start());

        
    }
    public static  boolean start() {
    	return !isStart();
    }
    
    public static boolean isStart() {
    	return true;
    }
 
}