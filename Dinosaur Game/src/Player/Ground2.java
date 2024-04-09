package Player;

import java.awt.Graphics;

import gfx.Assets;

public class Ground2 
{
	private static int x, died = 1;
	
	public Ground2()
	{
		x = 800;
	}
	
	public static void tick()
	{
		if(died == 3)
		{
			died = 1;
		}
		else if(died == 1)
		{
			x -= 8;
			if(x < -796)
			{
				x = 800;
			}
		}
	}
	
	public static void render(Graphics g)
	{
		g.drawImage(Assets.ground, x, 415, 800, 15*6, null);
	}
	
	public static void setdied(int boo)
	{
		died = boo;
	}
}
