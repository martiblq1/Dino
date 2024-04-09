package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import Player.Bat;
import Player.Clouds;
import Player.Clouds2;
import Player.Clouds3;
import Player.Clouds4;
import Player.Csctus;
import Player.Csctus2;
import Player.Csctus3;
import Player.Ground;
import Player.Ground2;
import Player.Player;
import gfx.Assets;

public class Game implements Runnable 
{
	private Window window;
	private static Thread thread;
	private static boolean running = false;
	private BufferStrategy bs;
	private Graphics g;
	private Random r = new Random();
	private Player player = new Player();
	private Csctus2 cactus2 = new Csctus2(r.nextInt(800)+1);
	private Csctus3 cactus3 = new Csctus3(r.nextInt(800)+1);
	private Csctus cactus = new Csctus(r.nextInt(800)+1);
	private Ground ground = new Ground();
	private Ground2 ground2 = new Ground2();
	private Clouds cloud = new Clouds(r.nextInt(4));
	private Clouds2 cloud2 = new Clouds2(r.nextInt(4));
	private Clouds3 cloud3 = new Clouds3(r.nextInt(4));
	private Clouds4 cloud4 = new Clouds4(r.nextInt(4));
	private Bat bat = new Bat();
	private int rC = 0;
	
	public Game()
	{
		window = new Window();
		Assets.init();
	}
	
	public synchronized void start()
	{
		if(running == true)
		{
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() 
	{
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running == true)
		{
			now = System.nanoTime();
			delta += (now-lastTime)/timePerTick;
			timer += now-lastTime;
			lastTime = now;
			if(delta >= 1)
			{
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000)
			{
				//System.out.println("Ticks and frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}

	private void render() 
	{
		bs = window.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, 800, 800);
		//draw here
		g.drawImage(Assets.background, 0, 0, 800, 800, null);
		player.render(g);
		cactus2.render(g);
		cactus3.render(g);
		cactus.render(g);
		ground.render(g);
		ground2.render(g);
		bat.render(g);
		cloud.render(g);
		cloud2.render(g);
		cloud3.render(g);
		cloud4.render(g);
		//end of drawing
		bs.show();
		g.dispose();
	}

	private void tick()
	{
		player.tick();
		cactus.tick(r.nextInt(800)+1);
		cactus2.tick(r.nextInt(800)+1);
		cactus3.tick(r.nextInt(800)+1);
		ground.tick();
		ground2.tick();
		bat.tick();
		cloud.tick();
		cloud2.tick();
		cloud3.tick();
		cloud4.tick();
	}
	
	public static synchronized void stop()
	{
		if(running == false)
		{
			return;
		}
		try 
		{
			thread.join();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
