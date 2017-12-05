import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JComponent;

public class Display extends JComponent{
	private static final long serialVersionUID = 1L;
	private Data[] array;
	private Color background;
	private final int PAD = 10;
	private int x0,y0, maxX, maxY;
	public Display(Data[] array, Color background) {
		this.array = Arrays.copyOf(array, array.length);
		maxX = 0;
		for(Data d : this.array) {
			if(d.getHeight() > maxY)
				maxY = (int) d.getHeight();
			maxX += d.getWidth();
		}
	}
	public Data[] getArray() {
		return array;
	}
	public void paintComponent(Graphics g) {
		x0 = PAD;
		y0 = getHeight() - PAD;
		int xScale = (getWidth() - 2*PAD)/maxX;
		int yScale = (getHeight() - 2*PAD)/maxY;
		g.setColor(background);
		g.fillRect(getY(), getX(), getWidth(), getHeight());
		for(Data d : array) {
			d.draw(g,x0,y0,xScale,yScale,getWidth()/array.length);
		}
	}

}
