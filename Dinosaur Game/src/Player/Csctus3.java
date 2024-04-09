package Player;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import gfx.Assets;

public class Csctus3 
{
	private static int x, boundsy, width, height, died = 1;
	static Rectangle rec;
	
	public Csctus3(int r)
	{
		//x = Csctus2.getx()+30;
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
			died = 1;
			x = Csctus2.getx()+30;
		}
		else if(died == 1)
		{
			x = Csctus2.getx()+30;
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
	
	public static void setdied(int boo)
	{
		died = boo;
	}
}
