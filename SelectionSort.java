// Arshiya Ansari
// aa9yk
// The selection sort algorithm was adopted from the Wikipedia page with some help from geeksforgeeks.org. 


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class SelectionSort {
	// Variable instantiation
	private int[] arr;
	private int markedPos = -1;
	private int sortedPos = -1;
	private JComponent comp;
	private static final int delay = 20; // Speed of the animation

	// Selection sorter constructor 
	public SelectionSort(int[] array, JComponent component) 
	{
		this.arr = array;
		comp = component;
	}

	// Sort method for selection sorter (uses the algorithm) 
	public void sort() throws InterruptedException 
	{ 
		for (int i = 0; i < arr.length; i++) 
		{
			int p = minPos(i);

			// Switches the values 
			int temp = arr[p];
			if(arr[p]>arr[i]) 
			{
				temp = arr[i];
			}
			arr[p] = arr[i];
			arr[i] = temp;
			sortedPos++;
		}
	}

	// Sort() method uses this to find the min position of the array
	public int minPos(int j) throws InterruptedException 
	{
		int min = j;
		for (int i = j + 1; i < arr.length; i++) 
		{

			if(arr[i] < arr[min]) 
			{
				min = i; 
			}
			markedPos = i;

			pause(2);
		}
		return min;
	}

	// Used to slow the animation of insertion sorter down 
	public void pause (int count) throws InterruptedException 
	{ 
		comp.repaint();
		Thread.sleep(count*delay);
	}

	// Method that draws the rectangles and boxes for the bubble sorter component. 
	// I chose to use a highlighting tool to show the sorting, which is also written in this method. Rectangles are highlighted in Black, and finalized in Green. 
	public void draw(Graphics g) 
	{
		int deltaXPos = 10;
		for(int i = 0; i < arr.length; i++) 
		{
			if(i <= sortedPos) 
			{ 
				g.setColor(Color.GREEN);
			}
			else if (i == markedPos) 
			{
				g.setColor(Color.BLACK);
			}
			else 
			{
				g.setColor(Color.GRAY);
			}

			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(7));
			g2.drawLine(10 + i * deltaXPos, 155, 10 + i * deltaXPos,55 - arr[i]);
			Graphics2D g3 = (Graphics2D) g;
			g3.setStroke(new BasicStroke(2));
			g3.setColor(Color.black);
			g3.drawLine(5, 200, 510, 200);
			g3.drawLine(5, 0, 510, 0);
			g3.drawLine(5, 0, 5, 200);
			g3.drawLine(510, 0, 510, 200);
		}
	}


}
