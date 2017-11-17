import java.awt.Color;

public class EnemyFactory {
    private Enemy e;
    private static EnemyFactory instance;
    
    public static synchronized EnemyFactory getInstance(){
    	if(instance == null){
    	    instance = new EnemyFactory();
    	}
    	return instance;
    }
    public Enemy getEnemy(int x, int y,int sizeX,int sizeY, Color color){
    	e = new Enemy(x,y,sizeX,sizeY,color);
    	return e;
    	
    }
    

}
