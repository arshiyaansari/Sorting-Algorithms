//Arshiya Ansari
//aa9yk

// The bubble sort algorithm was adopted from the Wikipedia page with some help from sites such as the algolist.com and algostructure.com. 

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class BubbleSort {
	// Variable instantiation  
	private int[] arr;
	private int markedPos = -1;
	private int sortedPos = 50;
	private static final int delay = 20; // Speed of the animation 
	private JComponent comp;

	// Bubble sorter constructor 
	public BubbleSort(int[] val, JComponent component) 
	{
		this.arr = val;
		comp = component;
	}

	// Sort method for bubble sorter (uses the algorithm) 
	public void sort() throws InterruptedException
	{
		while(sortedPos != 0)
		{

			for(int i = 1; i < sortedPos; i++)
			{
				// Switches the values 
				int p = maxPos(i);
				int temp = arr[p];
				if(arr[i] < arr[i-1]) 
				{
					temp = arr[i];
					arr[i] = arr[i -1];
					arr[i-1] = temp;
				}
			}
			sortedPos--;
		}
	}

	// Sort() method uses this to find the max position of the array
	public int maxPos(int j) throws InterruptedException 
	{ 
		int min = j;
		for (int i = 0; i < j; i++) 
		{

			if (arr[i] < arr[min]) 
			{
				min = i;
			}
			markedPos = i;
		} 
		pause(2); 
		return min;
	}

	// Used to slow the animation of bubble sorter down 
	public void pause(int count) throws InterruptedException 
	{
		comp.repaint();
		Thread.sleep(count * delay);
	}


	// Method that draws the rectangles and boxes for the bubble sorter component. 
	// I chose to use a highlighting tool to show the sorting, which is also written in this method. Rectangles are highlighted in Black, and finalized in Red. 
	public void draw(Graphics g) 
	{ 
		int deltaXPos = 10;
		for (int i = 0; i < arr.length; i++) 
		{
			if (i == markedPos) 
			{
				g.setColor(Color.BLACK);
			}
			else if (i >= sortedPos) 
			{
				g.setColor(Color.RED);
			} 
			else 
			{
				g.setColor(Color.GRAY);
			}
			if (sortedPos == 0) 
			{
				g.setColor(Color.RED);
			}

			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(7));
			g2.drawLine(10 + i * deltaXPos, 155, 10 + i * deltaXPos, 55 - arr[i]);
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



