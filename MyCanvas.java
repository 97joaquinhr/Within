import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MyCanvas extends Canvas implements  Runnable {

	private static final long serialVersionUID = 1L;
	private GameStateContext context;
	private volatile boolean running = false;
	private volatile boolean gameOver = false;
	private volatile boolean isPaused = false;
	private Thread animator;
	BufferedImage image;

	

	public MyCanvas() {
		super();
		setFocusable(true);
		context=new GameStateContext();
		addKeyListener(context);
	}
	BufferedImage im=new BufferedImage(1080,640,BufferedImage.TYPE_INT_RGB);
	public void paint(Graphics g) {
		Graphics b= im.createGraphics();
		b.setColor(Color.GRAY);
		b.fillRect(0,0,1080,640);
		context.paint(b);
		g.drawImage(im, 0, 0, null);
	}
	public void update(Graphics g){
		paint(g);
	}
	private void startGame(){
		if(animator == null || !running){
			animator = new Thread(this);
			animator.start();
		}
	}//startGame()
	
	public void stopGame(){
		running = false;
	}//stopGame()

	@Override
	public void run() {
		running=true;
		while (running) {
			gameupdate();
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	public void gameupdate(){ //Example of animation running in the back
		context.update();
		
	}
}