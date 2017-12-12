import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Arrays;

import javax.swing.JComponent;

public class Display extends JComponent{
	private static final long serialVersionUID = 1L;
	private Data[] array;
	private Color background;
	
	public Display(Data[] array, Color background) {
		this.array = Arrays.copyOf(array, array.length);
		this.background = background;
	}
	public Data[] getArray() {
		return array;
	}
	public void swap(int i, int j, long time) {
		int temp = array[i].getValue();
		array[i].setValue(array[j].getValue());
		array[j].setValue(temp);
		Sort.beep(array[i].getValue()*50, 50, .5);
		repaint();
		/*try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}
	public void swap(int i, int j) {
		this.swap(i, j,1000);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(background);
		g.fillRect(getY(), getX(), getWidth(), getHeight());
		Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        
		for(Data d : array) {
			d.draw(g,getHeight(),getWidth()/array.length);
		}
	}

}
