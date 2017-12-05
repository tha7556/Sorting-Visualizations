import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;

public class Data extends Rectangle {
	private static final long serialVersionUID = 1L;
	private int value;
	private Color color;
	public Data(int x, int y, int width, int value,Color color) {
		super(x,y,width,value);
		this.value = value;
		this.color = color;
	}
	public Data(int x, int y, int width, int value) {
		this(x,y,width,value,Color.BLUE);
	}
	public int getValue() {
		return value;
	}
	public Color getColor() {
		return color;
	}
	public void changeColor(Color color) {
		this.color = color;
	}
	public void draw(Graphics g,int x0,int y0, int xScale, int yScale,int width) {
		Graphics2D g2 = (Graphics2D)g;
		
		int rectX = x0 + (int)(xScale * x);
        int rectY = y0 - (int)(yScale * y)-height;
		Rectangle rect = new Rectangle(rectX,rectY,width,height);
		
		g2.setColor(color);
		g2.fill(rect);
		
		g2.setColor(Color.black);
		g2.draw(rect);
		
	}

}
