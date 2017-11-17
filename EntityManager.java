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
	
	
	public EntityManager() {
		
		this.hero = new Hero(200, 200, 60, 78, Color.BLACK);
		this.piso = new Block(0,500,1080,50,Color.WHITE);
		Enemy tmp = EnemyFactory.getInstance().getEnemy(400,287,50,100,Color.RED);
		//TODO corregir size
		enemigos.add(tmp);
		
	}
	Enemy go;
	public void paint(Graphics g){
		hero.paint(g);
		for(int i = 0; i<enemigos.size();i++){
			go = enemigos.get(i);
			go.paint(g);
			
		}
		piso.paint(g);
	}
	
	public void update(){
		hero.update();
		for(int i = 0; i<enemigos.size();i++){
			go = enemigos.get(i);
			go.update();
			
		}
		checkCollision();
		checkCollisionPiso();
	}
	public void keyboard(int k){
		if(!checkCollisionPiso() || k!=2)
			hero.move(k);
	}
	public void keyboardReleased(int k){
		hero.stop(k);
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
	public boolean checkCollisionPiso(){
		if(hero.getRect().intersects(piso.getRect())){
			hero.floorCollision();
			return true;
		}
		return false;
	}
}