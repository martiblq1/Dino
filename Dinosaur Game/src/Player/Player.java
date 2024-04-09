package Player;
import java.awt.Graphics;
import java.awt.Rectangle;

import gfx.Animation;
import gfx.Assets;
import main.Game;
import main.Input;
import main.Launcher;
import main.Window;

public class Player
{	
	private static Animation walking, sneaking;
	private static int timer, br, move, brMax;
	private static double up;
	private static double y;
	private static Input input;
	private static boolean falling, jumped, restarted, sneaked;
	public static boolean died;
	Rectangle rec, rec2;
	
	public Player()
	{
		walking = new Animation(200, Assets.walking);
		sneaking = new Animation(200, Assets.walking_down);
		y = 400;
		falling = false;
		up = 280;
		timer = 2;
		br = 0;
		move = 8;
		brMax = 8;
		rec = new Rectangle(200, (int) (y), 21*3-21, 26*3-4);
		rec2 = new Rectangle(200, (int) (y), 21*3-21, 26*3-4);
		died = false;
		restarted = false;
		sneaked = false;
	}
	
	public void tick()
	{
		getInput();
		walking.tick();
		sneaking.tick();
		rec = new Rectangle(200, (int) (y), 21*3-21, 26*3-4);
		rec2 = new Rectangle(200, (int) (y), 21*3+17, 26*3);
		if(rec.intersects(Csctus.rec) || rec.intersects(Csctus2.rec) || rec.intersects(Csctus3.rec))
		{
			die();
		}
		else if(rec.intersects(Bat.rec) && !sneaked)
		{
			die();
		}
	}
	
	public static void getInput()
	{
		if(jumped && !died)
		{
			if(y == up && !died)
			{
				falling = true;
				br = 0;
			}
			else if(y == 400 && falling && !died)
			{
				falling = false;
				jumped = false;
				timer = 2;
				br = 0;
				return;
			}
			
			if(y > up && !falling && br <= 12 && !died)//4
			{
				move = 8;
				y -= move;
				br++;//64- 8, 56- 4
			}
			else if(y > up && !falling && br > 12 && !died)
			{
				move = 4;
				y -= move;
			}
			else if(y > up && falling && br > 12 && !died)
			{
				timer = 0;
				br = 0;
			}
			else if(y >= up && falling && timer == 0 && br <= 1 && !died)
			{
				move = 4;
				y += move;
				br++;
			}
			else if(y >= up && falling && timer == 0 && br > 1 && !died)
			{
				move = 8;
				y += move;
			}
			else if(y >= up && falling && timer > 0 && !died)
			{
				timer = 0;
				br = 0;
			}
			//System.out.println(move);
			/*if(y > up && !falling)//4
			{
				move = 10;
				y -= move;
			}
			else if(y >= up && falling)
			{
				move = 8;
				y += move;
				br++;
			}*/
		}
		
		if(died && restarted)
		{
			died = false;
			restarted = false;
			y = 400;
			Csctus.setdied(3);
			Csctus2.setdied(3);
			Csctus3.setdied(3);
			Ground.setdied(3);
			Ground2.setdied(3);
			Clouds.setdied(0);
			Clouds2.setdied(0);
			Clouds3.setdied(0);
			Clouds4.setdied(0);
			Bat.setdied(3);
		}
		else if(!died && restarted)
		{
			restarted = false;
		}
		
		if(sneaked)
		{
			
		}
	}
	
	public static void render(Graphics g)
	{
		//g.drawImage(walking.getCurrentFrame(), 100, 100, 21*3, 26*3, null);
		if((jumped || falling) && !died)
		{
			g.drawImage(Assets.dinosaur, 200, (int) (y), 21*3, 26*3, null);
		}
		else if(sneaked && !died)
		{
			g.drawImage(sneaking.getCurrentFrame(), 200, (int) (y)+32, 34*3, 16*3, null);
		}
		else if(!died)
		{
			g.drawImage(walking.getCurrentFrame(), 200, 400, 21*3, 26*3, null);
		}
		else if(died)
		{
			g.drawImage(Assets.dinosaur, 200, (int) (y), 21*3, 26*3, null);
		}
	}
	
	public void die()
	{
		died = true;
		Csctus.setdied(2);
		Csctus2.setdied(2);
		Csctus3.setdied(2);
		Ground.setdied(2);
		Ground2.setdied(2);
		Clouds.setdied(1);
		Clouds2.setdied(1);
		Clouds3.setdied(1);
		Clouds4.setdied(1);
		Bat.setdied(2);
	}
	
	public static double gety()
	{
		return y;
	}
	
	public void setjumped(boolean jumped)
	{
		this.jumped = jumped;
	}
	
	public void setrestarted(boolean restart)
	{
		this.restarted = restart;
	}
	
	public void setsneaked(boolean sneak)
	{
		this.sneaked = sneak;
	}
}
