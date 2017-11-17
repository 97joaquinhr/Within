
public class Camera {

	private Hero p1;
	private int x,y,initialx, initialy;
	
	public Camera(Hero p1){
		x = -200;
		y = -200;
		initialx = 200;
		initialy = 344;
		this.p1 = p1;
		
	}
	
	public void update(){
		moveCamera();
	}
	
	public void moveCamera(){
		x = p1.getX()-initialx;
		y = p1.getY()-initialy;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
