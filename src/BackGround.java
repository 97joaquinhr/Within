import java.awt.Graphics;

public class BackGround extends GameObject {

	private ImageLoader img = ImageLoader.getInstance();
	private Camera c1;
	private int mapX, mapY;
	
	public BackGround(Camera c1){
		this.c1 = c1;
		mapX = 0;
		mapY = -1760;
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(img.getImage("background"), x, y, null);
	}

	@Override
	public void update() {
		scroll();
	}

	private void scroll() {
		x = mapX - c1.getX();
		y = mapY - c1.getY();
	}
	
	
}
