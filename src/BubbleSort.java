import java.awt.Color;

public class BubbleSort extends Sort {

	public BubbleSort(Data[] array, Window window) {
		super(array, window);
	}

	@Override
	public Data[] sort() {
		boolean swap = true;
		while(swap) {
			swap = false;
			for(int i = 0; i < array.length-1; i++) {
				if(array[i].getValue() > array[i+1].getValue()) {
					swap(i, i+1,1);
					swap = true;
				}
			}
		}
		
		return array;
	}
	public static void main(String[] args) {
		Data[] array = Sort.initializeData(500);
		BubbleSort sort = new BubbleSort(array,new Window(new Display(array,Color.WHITE),1516,421));
		sort.sort();
	}

}
