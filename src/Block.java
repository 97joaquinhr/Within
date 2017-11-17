import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends GameObject {
	
	private int mapX, mapY;
	private Camera c1;
	
	public Block(int x, int y, int sizeX, int sizeY, Color color,Camera c1) {
		super();
		this.mapX = x;
		this.mapY = y;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.color = color;
		this.rect = new Rectangle(x,y,sizeX,sizeY);
		this.c1 = c1;
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
		x = mapX - c1.getX();
		y = mapY - c1.getY();
		//rect.setLocation(x, y);
	}

}
