// Arshiya Ansari
// aa9yk

import java.awt.Graphics;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class SelectionSortComp extends JComponent{

	// Variable instantiation  
	private SelectionSort sorter;

	// Constructor for the JComponent of the selection sorter 
	public SelectionSortComp(int[] arr) 
	{
		sorter = new SelectionSort(arr, this);
	}

	// Calls on the draw function to draw the insertion sorter component
	public void paintComponent(Graphics g) 
	{
		sorter.draw(g);
	}

	// A method that when called will allow for the bubble sorting animation to actually start 
	public void startAnimation() 
	{
		class AnimationRunnable implements Runnable 
		{
			public void run() 
			{
				try 
				{
					sorter.sort();
					repaint();
				}
				catch(InterruptedException exception) 
				{

				}
			}
		}
		Runnable run = new AnimationRunnable();
		Thread t = new Thread(run); // Starts new thread for the insertion sort algorithm
		t.start();
	}

}