import java.awt.Color;

public class QuickSort extends Sort{

	public QuickSort(Data[] array, Window window) {
		super(array, window);
	}
	@Override
	public void sort() {
		sort(0,array.length-1);
	}
	private void sort(int low, int high) {
		if(low < high) {
			int index = partition(low,high);
			sort(low,index-1);
			sort(index+1,high);
		}
	}
	public int partition(int low, int high) {
		int i = low-1;
		for(int j = low; j < high; j++) {
			if(array[j].getValue() <= array[high].getValue()) {
				comparisons++;
				i++;
				swap(i, j,WAIT_TIME);
			}
		}
		swap(i+1,high,WAIT_TIME);
		return i+1;
		
	}
	public static void main(String[] args) {
		Data[] array = Sort.initializeData(500);
		QuickSort sort = new QuickSort(array,new Window(new Display(array,Color.WHITE),1516,421));
		long start = System.nanoTime();
		sort.sort();
		long end = System.nanoTime();
		double time = (end-start)/1000000000.0;
		System.out.printf("Comparisons: %d, Swaps: %d, Time: %f seconds\n",sort.getComparisons(),sort.getSwaps(),time);
	}

}
