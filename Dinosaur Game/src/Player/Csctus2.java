package Player;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import gfx.Assets;

public class Csctus2 
{
	public static int x;
	private static int boundsy;
	public static int width;
	private static int height;
	static Rectangle rec;
	private static int  died = 1;
	private Bat bat = new Bat();
	
	public Csctus2(int r)
	{
		//x = r;
		x = -60;
		boundsy = 400+15;
		width = 21-3;
		height = 26+15;
		rec = new Rectangle(x+3, boundsy, width-3, height);
	}
	
	public void tick(int r)
	{
		if(died == 3)
		{
			x = -100;
			died = 1;
		}
		else if(died == 1)
		{
			x -= 8;
			if(x < -50)
			{
				x = 800+r;
				if(bat.getx() > x && bat.getx()-x < 250)
				{
					x += bat.getx()+700;
				}
				if(bat.getx() < x && x-bat.getx() < 250)
				{
					x += 700;
				}
			}
			rec = new Rectangle(x+3, boundsy, width-3, height);
		}
		else if(died == 2)
		{
			rec = new Rectangle(-100, boundsy, width-3, height);
		}
	}
	
	public void render(Graphics g)
	{
		g.drawImage(Assets.cactus, x, 400, 21*3, 26*3, null);
	}
	
	public static int getx()
	{
		return x;
	}
	
	public static void setdied(int boo)
	{
		died = boo;
	}
}
