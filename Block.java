import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends GameObject {
	
	public Block(int x, int y, int sizeX, int sizeY, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.color = color;
		this.rect = new Rectangle(x,y-5,sizeX,sizeY);
		this.pic = null;
	}
	
	public void setRect(Rectangle rect) {
		this.rect = rect;
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.fillRect(x, y, sizeX, sizeY);

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
