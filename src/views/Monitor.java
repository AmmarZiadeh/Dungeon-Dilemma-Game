package views;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Monitor extends Dimension{

	private static final long serialVersionUID = 1L;
	private Dimension screenSize;
	private int screenWidth;
	private int screenHeight;
	
	public Monitor() {
		
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = (int) screenSize.getWidth();
		screenHeight = (int) screenSize.getHeight();
		
	}
	
	public int getScreenWidth() {
		
		return screenWidth;
		
	}
	
	public int getMidX() {
		
		return screenWidth/2;
		
	}
	
	public int getScreenHeight() {
		
		return screenHeight;
		
	}
	
	public int getMidY() {
		
		return screenHeight/2;
		
	}

}
