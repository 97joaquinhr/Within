import java.awt.BorderLayout;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

import javax.swing.JFrame;

public class MyWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	MyCanvas canvas;
	
	public MyWindow(){
		super();
		setLayout(new BorderLayout());
		canvas = new MyCanvas();
		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		add(canvas,BorderLayout.CENTER);
		threadExecutor.execute(canvas);
		
		threadExecutor.shutdown();//No funciona
	}
}
//Listo