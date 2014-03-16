 //Nick Hale
package hgame;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;

/** JPanel extended subclass that acts as game environment */
public class Env extends JPanel{
	private Entity hero, enemy;
	private BufferedImage backGround;
	private javax.swing.Timer timer, musicTimer;
	private Clip loopClip;
	
	/** Parameterized constructor creates pseudo environment for game-play */
	public Env(Color backColor) {
		
		setFocusable(true);
		setVisible(true);
		addKeyListener(new PlayerListener());
		try{
			hero = new Hero();
			enemy = new Enemy();
			File bF = new File("back.jpg");
			backGround = ImageIO.read(bF);
			MusicListener beatFish = new MusicListener();
			beatFish.loadMusic("loop.wav");
			musicTimer = new javax.swing.Timer(80716, beatFish);
			timer = new javax.swing.Timer(50, new GameListener());
			musicTimer.start();
			timer.start();
		}catch(IOException q) {
			q.printStackTrace();
		}
	}
	
	/** Inherited from Component; Paints images and other graphics to Component */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backGround, 0, 0, getWidth(), getHeight(), null);
		enemy.getSprite().fill(g);
		hero.getSprite().fill(g);
		
	}
	
	/** Is called at every nth iteration of a timer to allow player interaction with non-player entities */
	private class GameListener implements ActionListener{
		/** Allows non-player entity movement and player interaction with them */
		public void actionPerformed(ActionEvent e){
			try{
				if(!hero.inArea(enemy.getX(), enemy.getY()))
					((Enemy)enemy).move(hero.getX(), hero.getY());
				if(hero.inArea(enemy.getX() + enemy.getRange(), enemy.getY() + enemy.getRange()) || hero.inArea(enemy.getX() - enemy.getRange(), enemy.getY() - enemy.getRange()))
					hero.takeDmg(enemy.attack());
				
			}catch(IOException q){
				q.printStackTrace();
			}
			repaint();
		}
	}
	
	/** Nested class called on every nth iteration of a timer */
	private class MusicListener implements ActionListener{
	
		public void actionPerformed(ActionEvent e){
			try
		    {
				loadMusic("loop.wav");
		    }
		    catch (Exception q)
		    {
		       q.printStackTrace();
		    }
		}
		
		public void loadMusic(String fileName){
			try
		    {
				File mFile = new File(fileName);
				AudioInputStream stream = AudioSystem.getAudioInputStream(mFile);
			    AudioFormat format = stream.getFormat();
			    DataLine.Info info = new DataLine.Info(Clip.class, format);
			    loopClip = (Clip)AudioSystem.getLine(info);
			    loopClip.open(stream);
			    loopClip.start();
		    }
		    catch (Exception q)
		    {
		        q.printStackTrace();
		    }
		}
	}
	
	/** Picks up keyEvents and parses player input */
	private class PlayerListener implements KeyListener{
		/** Parses player input when key is pressed */
		public void keyPressed(KeyEvent e){
			try{
				if(e.getKeyCode() == KeyEvent.VK_W){
					hero.setDir(90);
					hero.move();
				} else if(e.getKeyCode() == KeyEvent.VK_A){
					hero.setDir(180);
					hero.move();
				} else if(e.getKeyCode() == KeyEvent.VK_S){
					hero.setDir(270);
					hero.move();
				} else if(e.getKeyCode() == KeyEvent.VK_D){
					hero.setDir(360);
					hero.move();
				} else if(e.getKeyCode() == KeyEvent.VK_SPACE){
					int dmg = hero.attack();
					if(enemy.inArea(hero.getX(), hero.getY()) || enemy.inArea(hero.getX() + hero.getRange(), hero.getY() + hero.getRange()) || enemy.inArea(hero.getX() - hero.getRange(), hero.getY() - hero.getRange())){
						enemy.takeDmg(dmg);
					}
				}
				repaint();
			}catch(IOException q) {
				q.printStackTrace();
			}
		}
		
		/** Empty concrete keyTyped allows PlayerListener to be non-abstract */
		public void keyTyped(KeyEvent e){
			//cheating
		}
		
		/** On release of space bar, hero moves forward */
		public void keyReleased(KeyEvent e){
			try{
				if(e.getKeyCode() == KeyEvent.VK_SPACE)
					hero.move();
			}catch(IOException q){
				q.printStackTrace();
			}
		}
	}
}