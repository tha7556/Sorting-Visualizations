import java.awt.Color;

public class SelectionSort extends Sort{

	
	public SelectionSort(Data[] array,Window window) {
		super(array,window);
	}
	public void sort() {
		for(int current = 0; current < array.length; current++) {
			int currentMin = current;
			for(int i = current; i < array.length; i++) {
				comparisons++;
				if(array[i].getValue() < array[currentMin].getValue()) {
					currentMin = i;
				}
			}
			swap(current, currentMin,WAIT_TIME);
		}
	}
	public static void main(String[] args) {
		Data[] array = Sort.initializeData(500);
		SelectionSort sort = new SelectionSort(array,new Window(new Display(array,Color.WHITE),1516,421));
		long start = System.nanoTime();
		sort.sort();
		long end = System.nanoTime();
		double time = (end-start)/1000000000.0;
		System.out.printf("Comparisons: %d, Swaps: %d, Time: %f seconds\n",sort.getComparisons(),sort.getSwaps(),time);
	}
}
