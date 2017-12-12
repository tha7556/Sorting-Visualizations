import java.awt.Color;

public class SelectionSort extends Sort{

	
	public SelectionSort(Data[] array,Window window) {
		super(array,window);
	}
	public Data[] sort() {
		for(int current = 0; current < array.length; current++) {
			int currentMin = current;
			for(int i = current; i < array.length; i++) {
				if(array[i].getValue() < array[currentMin].getValue()) {
					currentMin = i;
					comparisons++;
				}
			}
			swap(current, currentMin,50);
		}
		return array;
	}
	public static void main(String[] args) {
		Data[] array = Sort.initializeData(500);
		SelectionSort sort = new SelectionSort(array,new Window(new Display(array,Color.WHITE),1516,421));
		sort.sort();
	}
}
