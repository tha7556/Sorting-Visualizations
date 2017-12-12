import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Data {
	private int value,x;
	private Color color;
	public Data(int x, int value,Color color) {
		
		this.value = value;
		this.color = color;
		this.x = x;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int newValue) {
		this.value = newValue;
	}
	public Color getColor() {
		return color;
	}
	public void changeColor(Color color) {
		this.color = color;
	}
	public void draw(Graphics g,int windowHeight, int width) {
		Graphics2D g2 = (Graphics2D)g;
		int x0 = 0;
		int y0 = windowHeight;
		int rectX = x0 + (x*width);
        
        double height = windowHeight * (value/100.0);
        int rectY = (int) (y0 - height);
		Rectangle rect = new Rectangle(rectX,rectY,width,(int)height);
		
		g2.setColor(color);
		g2.fill(rect);
		
		//g2.setColor(Color.black);
		g2.draw(rect);
		
	}

}
