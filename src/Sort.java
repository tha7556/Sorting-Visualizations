import java.awt.Color;
import java.util.Arrays;
import java.util.Random;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;

public abstract class Sort {
	protected Data[] array;
	protected Window window;
	protected int comparisons, swaps;
	protected final int WAIT_TIME = 1;
	
	public Sort(Data[] array,Window window) {
		this.array = Arrays.copyOf(array,array.length);
		this.window = window;	
		comparisons = 0;
		swaps = 0;
	}
	public abstract void sort();
	public int getComparisons() {
		return comparisons;
	}
	public int getSwaps() {
		return swaps;
	}
	public Window getWindow() {
		return window;
	}
	public Data[] getArray() {
		return array;
	}
	public void swap(int i, int j) {
		window.swap(i, j);
		swaps++;
	}
	public void swap(int i, int j, long time) {
		window.swap(i, j, time);
		swaps++;
	}
	public static Data[] initializeData(int n) {
		Data[] array = new Data[n];
		Random r = new Random();
		for(int i = 0; i < n; i++) {
			array[i] = new Data(i,r.nextInt(90)+10,Color.BLUE);
		}
		return array;
	}
	public static void beep(int hz, int msecs, double vol) {
		try {
			byte[] buf = new byte[1];
			AudioFormat af = new AudioFormat(8000f,8,1,true,false);
			SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
			sdl.open(af);
			sdl.start();
			for(int i = 0; i < msecs*8; i++) {
				double angle = i / (8000f / hz) * 2.0 * Math.PI;
				buf[0] = (byte)(Math.sin(angle)*127.0 * vol);
				sdl.write(buf, 0, 1);
			}
			sdl.drain();
			sdl.stop();
			sdl.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
