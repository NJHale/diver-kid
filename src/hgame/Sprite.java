package hgame;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;

public abstract class Sprite {
	
	protected File imgFile;
	protected BufferedImage spriteSheet, curImg,upAttk, downAttk, leftAttk, rightAttk, upHarmed, downHarmed, leftHarmed, rightHarmed, dead;
	protected BufferedImage[] left, right, up, down;
	protected int x, y, width, height, step, nStep;
	
	/** Default Sprite Constructor creates Sprite and instantiates sprite images for each state **/
	public Sprite() {
		step = 0;
		nStep = 3;
		left = new BufferedImage[2];
		right = new BufferedImage[2];
		up = new BufferedImage[2];
		down = new BufferedImage[2];
	}
	
	/** Graphics fill method **/
	public void fill(Graphics g){
		g.drawImage(curImg, x, y, width, height, null);// ImageObserver is not needed for a BufferedImage input.
	}
	
	/** Adjusts x value of Sprite location **/
	public void setX(int n){
		x = n;
	}
	
	/** Adjust y value of Sprite location **/
	public void setY(int n){
		y = n;
	}
	
	/** Returns x value for Sprite location */
	public int getX(){
		return x;
	}
	
	/** Returns y value for Sprite location */
	public int getY(){
		return y;
	}
	
	/** Returns width */
	public int getWidth(){
		return width;
	}
	
	/** Returns height */
	public int getHeight(){
		return height;
	}
	
	/** Abstract method for changing the Sprite's current image **/
	public abstract void changeImg(String s);
}
