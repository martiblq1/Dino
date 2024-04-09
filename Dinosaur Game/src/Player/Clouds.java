package Player;

import java.awt.Graphics;
import java.util.Random;

import gfx.Assets;

public class Clouds 
{	
	private static int index, x, size, died;
	private static Random ra = new Random();
	
	public Clouds(int r)
	{
		index = r;
		x = ra.nextInt(800)+801;
		size = ra.nextInt(3)+4;
		died = 0;
	}
	
	public static void tick()
	{
		if(died == 0)
		{
			x -= 3;
			if(x < -20)
			{
				x = ra.nextInt(3000)+801;
				size = ra.nextInt(3)+4;
			}
		}
	}
	
	public static void render(Graphics g)
	{
		g.drawImage(Assets.clouds[index], x, 50, 7*size, 15*size, null);
		//g.drawImage(Assets., x, 50, 7*3, 15*3, null);
	}
	
	public static void setdied(int boo)
	{
		died = boo;
	}
}
