package hgame;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/** Concrete subclass of Sprite to be used with subsequent Enemy object */
public class EnemySprite extends Sprite{
	
	/** Default constructor creates new EnemySprite object */
	public EnemySprite() throws IOException{
		//BastardFish Lives!
		width = 240;
		height = 80;
		imgFile = new File("bastard.png");
		spriteSheet = ImageIO.read(imgFile);
		left[0] = spriteSheet.getSubimage(0, 0, 480, 160);
		right[0] = spriteSheet.getSubimage(480, 0, 480, 160);
		leftHarmed = spriteSheet.getSubimage(0, 160, 480, 160);
		rightHarmed = spriteSheet.getSubimage(480, 160, 480, 160);
		curImg = left[0];
	}
	
	/** Concrete implementation of changeImg that changes sprite pointed by curImg to a different one based on parameter s */
	public void changeImg(String s){
		if(s.equals("dead"))
			curImg = dead;
		else if(s.equals("left"))
			curImg = left[0];
		else if(s.equals("right"))
			curImg = right[0];
		else if(s.equals("leftHarmed"))
			curImg = leftHarmed;
		else if(s.equals("rightHarmed"))
			curImg = rightHarmed;
		
	}

}
