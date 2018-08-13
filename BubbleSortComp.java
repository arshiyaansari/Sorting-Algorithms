// Arshiya Ansari
// aa9yk
import java.awt.Graphics;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class BubbleSortComp extends JComponent{
	
	// Variable instantiation  
	private BubbleSort bSorter;

	// Constructor for the JComponent of the bubble sorter 
	public BubbleSortComp(int[] num)
	{
		bSorter = new BubbleSort(num, this);
	}

	// Calls on the draw function to draw the bubble sorter component
	public void paintComponent(Graphics g) 
	{
		bSorter.draw(g);
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
					bSorter.sort();
					repaint();
				} catch (InterruptedException e) 
				{
					
				}
			}
		}
		Runnable run = new AnimationRunnable();
		Thread t = new Thread(run); // Starts new thread for the bubble sort algorithm
		t.start();
	}
}
