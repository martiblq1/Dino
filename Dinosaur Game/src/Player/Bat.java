package Player;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import gfx.Animation;
import gfx.Assets;

public class Bat 
{
	private static Animation animation;
	private static int x, died;
	private static Random r;
	static Rectangle rec;
	
	public Bat()
	{
		animation = new Animation(200, Assets.bat);
		died = 1;
		r = new Random();
		rec = new Rectangle(x, 362, 19, 8);
	}
	
	public static void tick()
	{
		if(died == 1)
		{
			animation.tick();
			x -= 10;
			if(x < -60)
			{
				//x = r.nextInt(20000)+1;
				x = r.nextInt(20000)+801;
			}
			rec = new Rectangle(x+6, 380, 19, 60);
		}
		else if(died == 3)
		{
			x = -100;
			died = 1;
		}
		else if(died == 2)
		{
			rec = new Rectangle(-100, 380, 19, 60);
		}
	}
	
	public static void render(Graphics g)
	{
		g.drawImage(animation.getCurrentFrame(), x, 374, 22*3, 26*3, null);
	}
	
	public static void setdied(int boo)
	{
		died = boo;
	}
	
	public static int getx()
	{
		return x;
	}
}
