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
		setResizable(false);
		setVisible(true);
	}
	public Display getDisplay() {
		return display;
	}
	public void swap(int i, int j) {
		display.swap(i, j);
	}
	public void swap(int i, int j, long time) {
		display.swap(i, j,time);
	}
	public static void main(String[] args) {
		int n = 500;
		Data[] array = new Data[n];
		Random r = new Random();
		for(int i = 0; i < n; i++) {
			array[i] = new Data(i,r.nextInt(90)+10,Color.BLUE);
		}
		Window window = new Window(new Display(array,Color.WHITE),1516,421);
	}

}
