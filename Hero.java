import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Hero extends GameObject {
	private volatile int offx,offy;
	private int gravity;
	private int maxJumpHeight;
	private ImageLoader img;
	private int status;
	public Hero(int x, int y, int sizeX, int sizeY, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.color = color;
		this.rect = new Rectangle(x,y,sizeX,sizeY);
		this.pic = null;
		offx=0;
		offy=0;
		gravity = -8;
		status=0;
		img = ImageLoader.getInstance();
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}
	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
	public void setPic(BufferedImage pic) {
		this.pic = pic;
	}
	public void paint(Graphics g){//Paint the buffered image instead for next iteration
		if(status==0)
			g.drawImage(img.getImage("hero"), x+sizeX, y-sizeY, null);
		else
			g.drawImage(img.getImage("attack"), x+sizeX, y-sizeY, null);
	}

	public void attack1(){//TODO real attack1
		status=1;
		
	}
	public void attack2(){//TODO real attack 2
		this.color=Color.ORANGE;
	}
	
	public void idle(){
		status=0;
	}
	
	

	public int getOffx() {
		return offx;
	}
	public void setOffx(int offx) {
		this.offx = offx;
	}
	public int getOffy() {
		return offy;
	}
	public void setOffy(int offy) {
		this.offy = offy;
	}
	public void move(int k) {
		offx=0;
		offy=0;
		int c=5;
		switch(k){
		case 1://arriba
			jump();
			break;
		case 2://down
			offy=c;
			break;
		case 3://left
			offx=-c;
			break;
		case 4://right
			offx=c;
			break;
		case 5://c
			attack1();
			break;
		case 6://x
			attack2();
			break;
		default:
			break;
		}
	
	}
	private void jump() {
		if(gravity == 0){;
			gravity = 10;
			maxJumpHeight = y-100;
		}
		
	}
	public void stop(int k) {
		offx=0;
		offy=0;
		int c=5;
		switch(k){
		case 1://arriba
			c=-c;
			while(c<=0) {
				offy=c;
				c++;
			}
			idle();
			break;
		case 2://down
			while(c>=0) {
				offy=c;
				c--;
			}
			idle();
			break;
		case 3://left
			c=-c;
			while(c<=0) {
				offx=c;
				c++;
			}
			idle();
			break;
		case 4://right
			while(c>=0) {
				offx=c;
				c--;
			}
			idle();
			break;
		case 5://c
			idle();
			break;
		case 6://x
			idle();
		default:
			break;
		}
	}
	
	@Override
	public void update() {
		x+=offx;
		y+=offy-gravity;
		rect.setLocation(x,y);
		resetGravity();
		
	}
	private void resetGravity() {
		if(y <= maxJumpHeight){
			gravity = -8;
		}
		
	}
	public void floorCollision() {
		gravity = 0;
		offy = 0;
	}
	
}
