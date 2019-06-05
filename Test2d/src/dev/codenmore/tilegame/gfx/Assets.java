package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets 
{
	public static final int p_width=32,p_height=48;
	
	public static BufferedImage p_front,p_back,p_left,p_right;
	public static BufferedImage grass,cliff,sand;
	
	public static void init()
	{
		SpriteSheet player = new SpriteSheet(ImageLoader.loadImage("/textures/player_assets.png"));
		SpriteSheet Tiles = new SpriteSheet(ImageLoader.loadImage("/textures/100tile.png"));
		
		//what so called player
		p_front = player.crop(0,0,p_width,p_height);
		p_back = player.crop(p_width,0,p_width,p_height);
		p_left = player.crop(0, p_height, p_width,p_height);
		p_right = player.crop(p_width, p_height, p_width, p_height);
		
		//tiles
		grass = Tiles.crop(0, 0, p_width-1, p_width-1);
		cliff = Tiles.crop(p_width, 0, p_width-1, p_width-1);
		sand = Tiles.crop(2*p_width, 0, p_width-1, p_width-1);
		
		
		
		
		
	}
}
