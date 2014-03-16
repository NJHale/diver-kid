package hgame;
import java.io.*;

public class Hero extends Entity{
	
	public Hero() throws IOException{
		velocity = 7;//default Hero speed
		health = 5;
		power = 5;
		range = 5;
		direction = 180;
		sprite = new HeroSprite();
		sprite.setX(x);
		sprite.setY(y);
		
	}
	
	public void move() throws IOException{

		if(direction == 90){
			y -= velocity;
			sprite.changeImg("up");
			sprite.setY(y);
		}
		else if(direction == 180){
			x -= velocity;
			sprite.changeImg("left");
			sprite.setX(x);
		}
		else if(direction == 270){
			y += velocity;
			sprite.changeImg("down");
			sprite.setY(y);
		}
		else if(direction == 360){
			x += velocity;
			sprite.changeImg("right");
			sprite.setX(x);
		}
		else
			throw new IOException("BAD_DIRECTION");
	}
	
	public void takeDmg(int dmg) throws IOException{
		health -= dmg;
		
		if(direction == 90)
			sprite.changeImg("upHarmed");
		else if(direction == 180)
			sprite.changeImg("leftHarmed");
		else if(direction == 270)
			sprite.changeImg("downHarmed");
		else if(direction ==360)
			sprite.changeImg("rightHarmed");
		else
			throw new IOException("BAD_DIRECTION");
		System.out.println(health);
		//if(isDead())
			//sprite.changeImg("Dead");
	}

	public int attack() throws IOException {
		if(direction == 90)
			sprite.changeImg("upAttk");
		else if(direction == 180)
			sprite.changeImg("leftAttk");
		else if(direction == 270)
			sprite.changeImg("downAttk");
		else if(direction ==360)
			sprite.changeImg("rightAttk");
		else 
			throw new IOException("BAD_DIRECTION");
		
		return power;
	}
}
