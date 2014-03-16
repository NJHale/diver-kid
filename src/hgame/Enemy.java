package hgame;
import java.io.*;

public class Enemy extends Entity{
	
	public Enemy() throws IOException{
		x = 400;
		y = 300;
		velocity = 3;//default Enemy speed
		health = 10000;
		power = 9001; // =]
		range = 10;
		direction = 180;
		sprite = new EnemySprite();
		sprite.setX(x);
		sprite.setY(y);
	}
	
	public void move(int a, int b) throws IOException{
		double c = Math.sqrt(Math.pow(b - y, 2) + Math.pow(a - x, 2));
		double dx = (a - x)/c;
		double dy = (b - y)/c;
		
		x += dx*velocity;
		y += dy*velocity;
		
		if(dx <= 0){
			sprite.changeImg("left");
			direction = 180;
		} else{
			sprite.changeImg("right");
			direction = 360;
		}
		move();
	}
	
	public void move() throws IOException{
		sprite.setX(x);
		sprite.setY(y);
	}

	public void takeDmg(int dmg) throws IOException{
		health -= dmg;
		
		if(direction == 180)
			sprite.changeImg("leftHarmed");
		else if(direction == 360)
			sprite.changeImg("rightHarmed");
		else
			throw new IOException("BAD_DIRECTION");
		
		if(isDead())
			sprite.changeImg("Dead");
		
		System.out.println(health);
	}

	public int attack() throws IOException {
		return power;
	}

}
