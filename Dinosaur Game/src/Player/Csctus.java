package Player;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import gfx.Assets;

public class Csctus 
{
	private static int boundsy, width, height;
	public static int xA;
	static Rectangle rec;
	private static Random ra = new Random();
	private static int died = 1;
	private static Bat bat;
	
	public Csctus(int r)
	{
		//x = r;
		xA = -60;
		boundsy = 400+15;
		width = 21-3;
		height = 26-15;
		rec = new Rectangle(xA+3, boundsy, width-3, height);
		bat = new Bat();
	}
	
	public void tick(int r)
	{
		if(died == 3)
		{
			xA = -80;
			died = 1;
		}
		else if(died == 1)
		{
			xA -= 8;
			if(xA < -50)
			{
				xA = 800+r;
				if(bat.getx() > xA && bat.getx()-xA < 250)
				{
					xA += bat.getx()+700;
				}
				if(bat.getx() < xA && xA-bat.getx() < 250)
				{
					xA += 700;
				}
			}
			if(xA > Csctus2.x && xA-Csctus2.x < 250)
			{
				xA += Csctus2.x+250;
			}
			if(xA < Csctus2.x && Csctus2.x-xA < 250)
			{
				xA += Csctus2.x+350;
			}
			rec = new Rectangle(xA+3, boundsy, width-3, height);
		}
		else if(died == 2)
		{
			rec = new Rectangle(-80, boundsy, width-3, height);
		}
	}
	
	public void render(Graphics g)
	{
		g.drawImage(Assets.cactus, xA, 400, 21*3, 26*3, null);
	}
	
	/*public static int getx()
	{
		return x;
	}*/
	
	public static void setdied(int boo)
	{
		died = boo;
	}
}
