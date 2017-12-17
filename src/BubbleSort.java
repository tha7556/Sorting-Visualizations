import java.awt.Color;

public class BubbleSort extends Sort {

	public BubbleSort(Data[] array, Window window) {
		super(array, window);
	}

	@Override
	public void sort() {
		boolean swap = true;
		while(swap) {
			swap = false;
			for(int i = 0; i < array.length-1; i++) {
				comparisons++;
				if(array[i].getValue() > array[i+1].getValue()) {
					swap(i, i+1,WAIT_TIME);
					swap = true;
				}
			}
		}
	
	}
	public static void main(String[] args) {
		Data[] array = Sort.initializeData(500);
		BubbleSort sort = new BubbleSort(array,new Window(new Display(array,Color.WHITE),1516,421));
		long start = System.nanoTime();
		sort.sort();
		long end = System.nanoTime();
		double time = (end-start)/1000000000.0;
		System.out.printf("Comparisons: %d, Swaps: %d, Time: %f seconds\n",sort.getComparisons(),sort.getSwaps(),time);
	}

}
