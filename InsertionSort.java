// Arshiya Ansari
// aa9yk
// The insertion sort algorithm was adopted from the Wikipedia page with some help from sites such as the java2novice.com and geeksforgeeks.org. 

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class InsertionSort {

	// Variable instantiation  
	private int[] arr;
	private int markedPos= -1;
	private int count = 0;
	private static final int delay = 20; // Speed of the animation
	private JComponent comp;

	// Insertion sorter constructor 
	public InsertionSort(int[] val, JComponent component) 
	{
		this.arr = val;
		comp = component;
	}

	// Sort method for insertion sorter (uses the algorithm) 
	public void sort() throws InterruptedException 
	{
		for(int i = 1; i < arr.length; i++)
		{
			int k = arr[i];
			int j = i-1;
			while (j>= 0 && arr[j] > k)
			{
				arr[j+1] = arr[j];
				markedPos = j;
				j--;
				pause(2);
			}
			arr[j+1] = k;
			count++;
		}

	}

	// Used to slow the animation of insertion sorter down 
	public void pause(int count) throws InterruptedException 
	{ 
		comp.repaint();
		Thread.sleep(count * delay);
	}

	// Method that draws the rectangles and boxes for the bubble sorter component. 
	// I chose to use a highlighting tool to show the sorting, which is also written in this method. Rectangles are highlighted in Black, and finalized in Blue. 
	public void draw(Graphics g) 
	{ 
		int deltaX = 10;
		for (int i = 0; i < arr.length; i++) 
		{
			if (arr[i] == i+1 && i <= arr.length) 
			{
				g.setColor(Color.BLUE);
			}
			else if (i==markedPos) 
			{
				g.setColor(Color.BLACK);
			}else
			{
				g.setColor(Color.GRAY);
			}
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(7));
			g2.drawLine(10 + i * deltaX, 155, 10 + i * deltaX, 55 - arr[i]);
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
