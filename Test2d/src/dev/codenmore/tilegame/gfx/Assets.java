package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets 
{
	public static final int p_width=32,p_height=57;
	
	public static BufferedImage p_front,p_back,p_left,p_right;
	public static BufferedImage grass,cliff,sand,lake,magma,grass_2,sand_2,magma_2;
	
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
		lake = Tiles.crop(3*p_width, 0, p_width-1, p_width-1);
		magma = Tiles.crop(4*p_width, 0, p_width-1, p_width-1);
		
		grass_2 = Tiles.crop(0, p_width, p_width-1, p_width-1);
		sand_2 = Tiles.crop(2*p_width, p_width, p_width-1, p_width-1);
		magma_2 = Tiles.crop(4*p_width, p_width, p_width-1, p_width-1);
		
		
		
		
		
	}
}
