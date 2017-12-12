package javafx;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Data extends Rectangle{
	private int value;
	private Color color;
	
	public Data(int value, Color color) {
		this.value = value;
		this.color = color;
		this.setFill(color);
	}
	public int getValue() {
		return value;
	}
	public void changeColor(Color color) {
		this.color = color;
		this.setFill(color);
	}
	public Color getColor() {
		return color;
	}

}
