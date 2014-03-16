package hgame;
import java.io.*;

public abstract class Entity {
	
	protected int x, y, velocity, health, power, range, direction;
	protected Sprite sprite;
	
	
	public Entity() throws IOException{
		x = 50;//dummy values
		y = 50;
	}
	
	public int getX(){
		return x;
	}
	
	public void setX(int a){
		x = a;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int a){
		y = a;
	}
	
	public void setDir(int dir){
		direction = dir;
	}
	
	public int getPower(){
		return power;
	}
	
	public void setPower(int p){
		power = p;
	}
	
	public int getRange(){
		return range;
	}
	
	public void setRange(int r){
		range = r;
	}
	
	public boolean inArea(int a, int b){
		int w = sprite.getWidth();
		int h = sprite.getHeight();
		
		if((a >= x && a <= x + w) && (b >= y && b <= y + h))
			return true;
		return false;
	}
	
	public boolean isDead(){
		return(health <= 0);
	}
	
	public Sprite getSprite(){
		return sprite;
	}
	
	public abstract void takeDmg(int dmg) throws IOException;
	
	public abstract int attack() throws IOException;
	
	public abstract void move() throws IOException;

	
}
