import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		MyWindow mw=new MyWindow();
		//int width=320,height=240;
		mw.setSize(1080,640);
		mw.setVisible(true);
		mw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mw.setAlwaysOnTop(true);
	}
}
