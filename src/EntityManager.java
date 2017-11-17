/*
* Actualizado el 27/octubre/2017 16:45 hrs
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class EntityManager {
	
	GameStateContext gc;
	private Hero hero;
	private ArrayList<Enemy> enemigos = new ArrayList<Enemy>();
	private Block piso;
	private Block piso2;
	private Block col;
	private ImageLoader img = ImageLoader.getInstance();
	private BackGround bd;
	private Camera cam;
	Enemy go;
	
	
	
	public EntityManager() {
		
		this.hero = new Hero(200, 200);

		Enemy tmp = EnemyFactory.getInstance().getEnemy(400,287,50,100,Color.RED);
		//TODO corregir size
		enemigos.add(tmp);
		cam = new Camera(hero);
		this.piso = new Block(0,500,5000,50,Color.WHITE, cam);
		this.piso2 = new Block(1950,500,1600,50,Color.WHITE, cam);
		this.col = new Block(2650,70,50,500,Color.WHITE, cam);
		bd = new BackGround(cam);
	}
	
	public void paint(Graphics g){
		
		bd.paint(g);
		col.paint(g);
		//piso.paint(g);
		hero.paint(g);
		piso2.paint(g);
		//for(int i = 0; i<enemigos.size();i++){
		//	go = enemigos.get(i);
		//	go.paint(g);	
		//}
	}
	
	public void update(){
		hero.update();
		piso.update();
		piso2.update();
		col.update();
		cam.update();
		bd.update();
		for(int i = 0; i<enemigos.size();i++){
			go = enemigos.get(i);
			go.update();
			
		}
		checkCollision();
		checkCollisionPiso();
		checkCollisionPared();
	}
	
	public void keyboard(int k){
			hero.move(k);
	}
	public void keyboardReleased(int k){
		hero.move(k);
	}
	public void checkCollision(){
		for(int i = 0; i<enemigos.size();i++){
			go = enemigos.get(i);
			if(hero.rect.intersects(go.getRect())){
				go.setMoveX(-1*go.getMoveX());
				//hero.setOffx(0);
			}
			
			
		}
		
	}
	public void checkCollisionPiso(){
		if(hero.getRect().intersects(piso.getRect()) || hero.getRect().intersects(piso2.getRect())){
			hero.setFloorCollide(true);
		}
		else{
			hero.setFloorCollide(false);
		}
	}
	
	public void checkCollisionPared(){
		if(hero.getRect().intersects(col.getRect())){
			//hero.setFloorCollide(true);
			hero.setWallCollide(true);
			hero.setSide(col.getRect().getCenterX());
		}
		else{
			hero.setSide(-250);
			hero.setWallCollide(false);
		}
	}
}