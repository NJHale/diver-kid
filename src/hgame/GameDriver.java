package hgame;
import javax.swing.*;
import java.awt.*;

public class GameDriver
{
	public static void main(String[] args)
	{
		JFrame world = new JFrame();
		world.setTitle("S_GAME(alpha)");
		world.setSize(800, 600);
		
		world.add(new Env(Color.lightGray), BorderLayout.CENTER);
		world.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		world.setVisible(true);
	}
}