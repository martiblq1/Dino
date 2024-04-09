package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Player.Player;

public class Input implements KeyListener
{
	Player player;
	public boolean jumped, restart, sneak;
	
	public Input()
	{
		player = new Player();
		jumped = false;
		restart = false;
		sneak = false;
	}
	
	public void tick()
	{
		if(player.gety() == 400)
		{
			jumped = false;
			player.setjumped(jumped);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_UP && Player.gety() == 400)
		{
			jumped = true;
			player.setjumped(jumped);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN && Player.gety() == 400)
		{
			sneak = true;
			player.setsneaked(sneak);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			restart = true;
			player.setrestarted(restart);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_DOWN && Player.gety() == 400)
		{
			sneak = false;
			player.setsneaked(sneak);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}
	
}
