import java.awt.Color;

public class HeapSort extends Sort{

	public HeapSort(Data[] array, Window window) {
		super(array, window);
	}

	@Override
	public void sort() {
		for(int i = (array.length-1) / 2; i >= 0; i--) {
			toHeap(array.length-1,i);
		}
		for(int i = array.length-1; i > 0; i--) {
			swap(0,i);
			toHeap(i,0);
		}
    }

    void toHeap(int heapSize, int root) {
        int max = root; 
        int left = 2*root + 1; 
        int right = 2*root + 2;
 
        if (left < heapSize && array[left].getValue() > array[max].getValue()) {
            max = left;
            comparisons++;
        }
        if (right < heapSize && array[right].getValue() > array[max].getValue()) {
            max = right;
            comparisons++;
        }
        if (max != root) {
            swap(max,root);
            toHeap(heapSize, max);
        }
    }
	public static void main(String[] args) {
		Data[] array = Sort.initializeData(500);
		HeapSort sort = new HeapSort(array,new Window(new Display(array,Color.WHITE),1516,421));
		long start = System.nanoTime();
		sort.sort();
		long end = System.nanoTime();
		double time = (end-start)/1000000000.0;
		System.out.printf("Comparisons: %d, Swaps: %d, Time: %f seconds\n",sort.getComparisons(),sort.getSwaps(),time);
	}

}
