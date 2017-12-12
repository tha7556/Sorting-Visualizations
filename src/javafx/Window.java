package javafx;


import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Window extends Application{

	private Data[] data;
    @Override 
    public void start(Stage stage) {
    	
    	
    	initializeData(100,Color.RED);
    	BorderPane border = new BorderPane();
        Scene scene = new Scene(border,1000,600);
        
        HBox layout = new HBox(0);
        layout.setPadding(new Insets(0,0,0,0));
        layout.setRotate(180);
        border.setBottom(layout);
        for(Data rect : data) {
        	//System.out.println((rect.getValue()/100.0));
        	rect.heightProperty().bind(scene.heightProperty().multiply(rect.getValue()/100.0).add(10));
        	rect.widthProperty().bind(scene.widthProperty().divide(data.length).subtract(.2));
        	layout.getChildren().add(rect);
        }
        
        //scene.setFill(Color.RED);
        stage.setTitle("Please help");
        stage.setScene(scene);
        stage.show();
    }
    public void initializeData(int n, Color color) {
    	Random rand = new Random();
    	data = new Data[n];
    	for(int i = 0; i < n; i++) {
    		data[i] = new Data(rand.nextInt(100),color);
    		if(i == 0 || i == n-1) {
    			data[i].changeColor(Color.BLUE);
    			System.out.println("bla");
    		}
    	}
    }
    public void initializeData() {
    	int[] values = {1,10,20,30,40,50,60,70,80};
    	data = new Data[values.length];
    	for(int i = 0; i < values.length; i++) {
    		data[i] = new Data(values[i],Color.BLACK);
    	}
    }
    public static void main(String[] args) {  
    	Window.launch(args);
    	}

}
