import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

public class ImageLoader {
	private Hashtable <String, BufferedImage> images = new Hashtable<String, BufferedImage>();
	private static ImageLoader instance;
	
	 public static synchronized ImageLoader getInstance(){
			if(instance == null){
			    instance = new ImageLoader();
			}
			return instance;
	    }
	
	
	private ImageLoader(){
		try {
			images.put("enemy", ImageIO.read(ImageLoader.class.getResourceAsStream("rsrc/Tile1.png")));
			images.put("hero", ImageIO.read(ImageLoader.class.getResourceAsStream("rsrc/idle.gif")));
			images.put("attack", ImageIO.read(ImageLoader.class.getResourceAsStream("rsrc/attack.png")));
			images.put("background", ImageIO.read(ImageLoader.class.getResourceAsStream("rsrc/fondo.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
	public BufferedImage getImage(String k){
		return images.get(k);
	}
}
