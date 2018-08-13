// Arshiya Ansari
// aa9yk

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SortingView {

	public static int[] arrayRandomizer() // Creates an array that will be sorted using the different sorting algorithms 
	{ 
		int[] values = new int[50];
		ArrayList<Integer> val = new ArrayList<Integer>();
		for(int i=0; i<50;i++) {
			val.add(i+1);
		}
		Collections.shuffle(val); // Shuffles the values 
		for(int i=0; i<val.size();i++) {
			values[i] = val.get(i);
		}
		return values;
	}

	public static int[] arrayCopier(int[] arr) // Creates duplicates of the original array so algorithms are sorting the same array -- allows me to swerve on the locks 
	{ 
		int[] array = new int[50];
		for(int i = 0; i<50;i++) {
			array[i] = arr[i];
		}
		return array;
	}

	public static void main(String[] args) {
		// Creates my arrays 
		int[] array1 = arrayRandomizer();
		int[] array2 = arrayCopier(array1);
		int[] array3 = arrayCopier(array1);

		// Sets up my JFrame
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("SORTING ALGORITHMS");
		frame.setLayout(new BorderLayout());
		frame.setSize(520, 900);
		frame.setLocationRelativeTo(null);

		// Sets up my panels, labels, and components 
		JPanel panel = new JPanel(new GridLayout(3, 1)); 
		JPanel panel2 = new JPanel(new GridLayout(3,1));
		JPanel panel3 = new JPanel(new GridLayout(3,1));	
		JPanel centerPanel = new JPanel();
		JPanel finalPanel = new JPanel();
		JLabel bubbleSort = new JLabel("BUBBLE SORT");
		bubbleSort.setHorizontalAlignment(JLabel.CENTER);
		bubbleSort.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 36));
		JLabel selectSort = new JLabel("SELECTION SORT");
		selectSort.setHorizontalAlignment(JLabel.CENTER);
		selectSort.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 36));
		JLabel insertSort = new JLabel("INSERTION SORT");
		insertSort.setHorizontalAlignment(JLabel.CENTER);
		insertSort.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 36));

		SelectionSortComp sortComp = new SelectionSortComp(array1); 
		BubbleSortComp bubbleComp = new BubbleSortComp(array2);
		InsertionSortComp insertComp = new InsertionSortComp(array3);

		// Adds elements to the panels and frame
		panel.add(bubbleSort, BorderLayout.CENTER);
		panel.add(bubbleComp, BorderLayout.CENTER);
		panel2.add(insertSort, BorderLayout.CENTER);
		panel2.add(insertComp, BorderLayout.CENTER);
		panel3.add(selectSort, BorderLayout.CENTER);
		panel3.add(sortComp, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(3,0));
		centerPanel.add(panel, BorderLayout.CENTER);
		centerPanel.add(panel2, BorderLayout.CENTER);
		centerPanel.add(panel3, BorderLayout.CENTER);
		finalPanel.setLayout(new BorderLayout());
		finalPanel.add(centerPanel, BorderLayout.CENTER);
		frame.add(finalPanel, BorderLayout.CENTER);
		frame.setVisible(true);

		// Triggers the animations of each sorting component to start
		sortComp.startAnimation();
		bubbleComp.startAnimation();
		insertComp.startAnimation();
	}
}

