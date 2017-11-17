import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Enemy extends GameObject {
	private int moveX;
	private ImageLoader img;
	public Enemy(int x, int y, int sizeX, int sizeY, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.color = color;
		this.rect = new Rectangle(x,y,sizeX,sizeY);
		this.pic = null;
		this.moveX=5;
		img=ImageLoader.getInstance();
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
	
	
	public int getMoveX() {
		return moveX;
	}
	public void setMoveX(int moveX) {
		this.moveX = moveX;
	}
	public void idle(){
		this.color=Color.BLACK;
	}

	
	public void paint(Graphics g){//Paint the buffered image instead for next iteration
		g.drawImage(img.getImage("enemy"), x, y, null);
	}

	public void attack(){//TODO real attack
		
	}
	public void movement(){
		x+=moveX;
		if(this.x>600){
			moveX=-5;
		}
		else if(this.x<400){
			moveX=5;
		}
	}
	@Override
	public void update() {
		movement();
		rect.setLocation(x,y);
		
	}
}
