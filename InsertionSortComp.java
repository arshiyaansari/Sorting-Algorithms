// Arshiya Ansari
// aa9yk

import java.awt.Graphics;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class InsertionSortComp extends JComponent{

	// Variable instantiation  
	private InsertionSort iSorter;

	// Constructor for the JComponent of the insertion sorter 
	public InsertionSortComp(int [] arr)
	{
		iSorter = new InsertionSort(arr, this);
	}

	// Calls on the draw function to draw the insertion sorter component
	public void paintComponent(Graphics g) 
	{
		iSorter.draw(g);
	}

	// A method that when called will allow for the insertion sorting animation to actually start
	public void startAnimation() 
	{
		class AnimationRunnable implements Runnable 
		{
			public void run() 
			{
				try 
				{
					iSorter.sort();
					repaint();
				} catch (InterruptedException e) 
				{

				}
			}
		}
		Runnable run = new AnimationRunnable();
		Thread t = new Thread(run); // Starts new thread for the insertion sort algorithm
		t.start();
	}
}
