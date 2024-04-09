package gfx;
import java.awt.image.BufferedImage;

public class Assets
{
	public static BufferedImage dinosaur, cactus, ground, background;
	public static BufferedImage[] walking = new BufferedImage[2];
	public static BufferedImage[] clouds = new BufferedImage[4];
	public static BufferedImage[] walking_down = new BufferedImage[2];
	public static BufferedImage[] bat = new BufferedImage[2];
	
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/sprite_sheet.png"));
		dinosaur = sheet.crop(0, 0, 21, 26);
		walking[0] = sheet.crop(21+1, 0, 21, 26);
		walking[1] = sheet.crop(2*21+2, 0, 21, 26);
		cactus = sheet.crop(3*21+3, 0, 21, 26);
		ground = sheet.crop(0, 26+1, 4*21+3, 15);
		clouds[0] = sheet.crop(4*21+4, 26+1, 7, 15);
		clouds[1] = sheet.crop(4*21+4+7+1, 26+1, 7, 15);
		clouds[2] = sheet.crop(4*21+4+2*7+2, 26+1, 7, 15);
		clouds[3] = sheet.crop(4*21+4+3*7+3, 26+1, 7, 15);
		walking_down[0] = sheet.crop(0, 26+15+2, 21+13, 16);
		walking_down[1] = sheet.crop(21+13+1, 26+15+2, 21+13, 16);
		bat[0] = sheet.crop(4*21+4, 0, 22, 26);
		bat[1] = sheet.crop(4*21+5+22, 0, 22, 26);
		background = sheet.crop(0, 0, 2, 2);
	}
}
