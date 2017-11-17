import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Hero extends GameObject{
	private ImageLoader img;
	private boolean movingRight = false;
	private boolean wallCollide = false;
	private boolean movingLeft = false;
	private boolean jumping = false;
	private boolean floorCollide = false;
	private int movementX = 0;
	private double fall = 1.0/60.0;
	private int fallSpeed = 30;
	private float fallDistance = 0;
	private int topSpeed = 15;
	private int jumpHeight = -13;
	private int side = 0;

	
	public Hero(int x, int y) {
		img = ImageLoader.getInstance();
		this.x = x;
		this.y = y;
		this.rect = new Rectangle(x,y,95,160);
	}

	public void paint(Graphics g){//Paint the buffered image instead for next iteration
			g.drawImage(img.getImage("hero"), 200,344, null);
	}
	
	@Override
	public void update() {	
		fallDistance += fall * fallSpeed;
		
		updatePosition();
		
		x += movementX;
		if(!floorCollide){y += fallDistance;}
		else if(jumping) {fallDistance = jumpHeight; y+=fallDistance;}
		rect.setLocation(x, y);
	}

	public void move(int k){
		if(k == 1 && side!=2){movingRight = true;}
		if(k == 2){movingLeft = true;}
		if(k == 3){jumping = true;}
		
		if(k == -1){movingRight = false;}
		if(k == -2){movingLeft = false;}
		if(k == -3){jumping = false;}
	}
	
	private void updatePosition(){
		if(wallCollide){
			movementX = 0;
		}
		
		if(movementX < topSpeed && movingRight){movementX ++;}
		if(movementX > -1 *topSpeed && movingLeft){movementX --;}
		
		if(!movingLeft && !movingRight){
			if(movementX > 0){movementX--;}
			if(movementX < 0){movementX++;}
		}
		
		if(jumping && floorCollide){
			fallDistance = -100;
		}
		
	}
	
	public void setFloorCollide(boolean b){
		floorCollide  = b;
	}
	
	public void setWallCollide(boolean b){
		wallCollide  = b;
	}

	public void setSide(double d) {
		if(d == -250){
			side = 0;
		}
		else if(d > rect.getCenterX()){ //Collision is at the right side
			side = 2;
			movingRight = false;
		}
		else if(d < rect.getCenterX()){//Collision is at the left side
			side = 1;
		}
		System.out.println(side);
	}

	
}
	
