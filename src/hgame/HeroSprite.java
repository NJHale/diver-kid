package hgame;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/** Concrete subclass of Sprite to be used with subsequent Hero object */
public class HeroSprite extends Sprite{
	
	/** Default constructor creates new HeroSprite object */
	public HeroSprite() throws IOException{
		width = 50;
		height = 75;
		
		imgFile = new File("diver.png");
		spriteSheet = ImageIO.read(imgFile);
		down[0] = spriteSheet.getSubimage(0, 0, 160, 240);
		down[1] = spriteSheet.getSubimage(160, 0, 160, 240);
		up[0] = spriteSheet.getSubimage(320, 0,160, 240);
		up[1] = spriteSheet.getSubimage(480, 0, 160, 240);
		left[0] = spriteSheet.getSubimage(640, 0, 160, 240);
		left[1] = spriteSheet.getSubimage(800, 0, 160, 240);
		right[0] = spriteSheet.getSubimage(960, 0, 160, 240);
		right[1] = spriteSheet.getSubimage(1120, 0 ,160, 240);
		upAttk = spriteSheet.getSubimage(160, 480, 160, 280);
		downAttk = spriteSheet.getSubimage(0, 480, 160, 280);
		leftAttk = spriteSheet.getSubimage(0,  760,  320,  240);
		rightAttk = spriteSheet.getSubimage(320,  760,  320,  240);
		downHarmed = spriteSheet.getSubimage(0, 240, 160, 240);
		upHarmed = spriteSheet.getSubimage(320, 240, 160, 240);
		leftHarmed = spriteSheet.getSubimage(640, 240, 160, 240);
		rightHarmed = spriteSheet.getSubimage(960, 240, 160, 240);
		curImg = down[0];
	}
	
	/** Concrete implementation of changeImg that changes Sprite pointed by curImg to a different one based on s, step, and nstep*/
	public void changeImg(String s){
		width = 50;
		height = 75;
		
		if(s.equals("dead"))
			curImg = dead;
		else if(s.equals("up"))
			curImg = up[step];
		else if(s.equals("left"))
			curImg = left[step];
		else if(s.equals("down"))
			curImg = down[step];
		else if(s.equals("right"))
			curImg = right[step];
		else if(s.equals("upHarmed"))
			curImg = upHarmed;
		else if(s.equals("downHarmed"))
			curImg = downHarmed;
		else if(s.equals("leftHarmed"))
			curImg = leftHarmed;
		else if(s.equals("rightHarmed"))
			curImg = rightHarmed;
		else if(s.equals("upAttk")){
			curImg = upAttk;
			height = 88;
		}
		else if(s.equals("downAttk")){
			curImg = downAttk;
			height = 88;
		}
		else if(s.equals("leftAttk")){
			curImg = leftAttk;
			width = 93;
			height = 70;
		}
		else if(s.equals("rightAttk")){
			curImg = rightAttk;
			width = 93;
			height = 70;
		}
		
		nStep--;
		if(nStep <= 0){
			if(step > 0)
				step--;
			else
				step++;
			nStep = 3;
		}
	}
}


