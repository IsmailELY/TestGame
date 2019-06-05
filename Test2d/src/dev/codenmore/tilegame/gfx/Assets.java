package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets 
{
	public static final int p_width=32,p_height=48;
	
	public static BufferedImage p_front,p_back,p_left,p_right;
	
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player_assets.png"));
		
		p_front = sheet.crop(0,0,p_width,p_height);
		p_back = sheet.crop(p_width,0,p_width,p_height);
		p_left = sheet.crop(0, p_height, p_width,p_height);
		p_right = sheet.crop(p_width, p_height, p_width, p_height);
		
		
	}
}
