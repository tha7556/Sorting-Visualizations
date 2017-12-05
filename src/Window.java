import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	private Display display;
	public Window(Display display, int width, int height) {
		this.display = display;
		add(display);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width,height);
		setVisible(true);
	}
	public Display getDisplay() {
		return display;
	}
	public static void main(String[] args) {
		Data[] array = new Data[10];
		int width = 50;
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			array[i] = new Data(i*width+1,0,width,r.nextInt(500));
		}
		Window window = new Window(new Display(array,Color.black),400,400);
	}

}
