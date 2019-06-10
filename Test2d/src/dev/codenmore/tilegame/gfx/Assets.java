package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets 
{
	public static final int p_width=64,p_height=66;
	public static final int t_width=16,t_height=16;
	
	public static BufferedImage[][] player_form = new BufferedImage[4][9];
	public static BufferedImage[][] gobelin_form = new BufferedImage[4][9];
	public static BufferedImage sand[] = new BufferedImage[9];
	public static BufferedImage ice[] = new BufferedImage[9];
	public static BufferedImage magma[] = new BufferedImage[9];
	public static BufferedImage grass[] = new BufferedImage[9];
	public static BufferedImage rock[] = new BufferedImage[9];
	public static BufferedImage tree;
	public static BufferedImage startButton[] = new BufferedImage[2],settingButton[] = new BufferedImage[2];
	
	public static void init()
	{
		SpriteSheet player = new SpriteSheet(ImageLoader.loadImage("/textures/player_sheet.png"));
		SpriteSheet gobelin = new SpriteSheet(ImageLoader.loadImage("/textures/gobelin_sheet.png"));
		SpriteSheet Sand = new SpriteSheet(ImageLoader.loadImage("/textures/Desert_1.png"));
		SpriteSheet Ice = new SpriteSheet(ImageLoader.loadImage("/textures/Ice_1_3.png"));
		SpriteSheet Magma = new SpriteSheet(ImageLoader.loadImage("/textures/Lava_2.png"));
		SpriteSheet Grass = new SpriteSheet(ImageLoader.loadImage("/textures/Grass_1.png"));
		SpriteSheet Rock = new SpriteSheet(ImageLoader.loadImage("/textures/Rocks_1.png"));
		SpriteSheet Tree = new SpriteSheet(ImageLoader.loadImage("/textures/tree.png"));
		SpriteSheet UI = new SpriteSheet(ImageLoader.loadImage("/textures/Ui_sheet.png"));
		//tree
		tree = Tree.crop(0, 0, 95, 95);
		
		//button
		startButton[0] = UI.crop(0,49, 190, 49);
		startButton[1] = UI.crop(0, 99, 190, 44);
		settingButton[1] = UI.crop(0, 144, 190, 45);
		settingButton[0] = UI.crop(0, 190, 190, 47);

		
		//player
		for(int j = 0 ; j<9; j++)
		{
			for(int i=0; i<4; i++)
			{
				player_form[i][j]=player.crop(j*p_width, i*p_height, p_width, p_height);
			}
			
		}
		
		//gobelin
		for(int j = 0 ; j<9; j++)
		{
			for(int i=0; i<4; i++)
			{
				gobelin_form[i][j]=gobelin.crop(j*p_width, i*p_height, p_width, p_height);
			}
			
		}
		
		//sand
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				sand[i*3+j] = Sand.crop(j*t_width, i*t_height,t_width-1, t_height-1);
			}
		}
		
		//ice
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				ice[i*3+j] = Ice.crop(j*t_width, i*t_height,t_width-1, t_height-1);
			}
		}
		
		//Magma
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				magma[i*3+j] = Magma.crop(j*t_width, i*t_height,t_width-1, t_height-1);
			}
		}
		
		//Grass
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				grass[i*3+j] = Grass.crop(j*t_width, i*t_height,t_width-1, t_height-1);
			}
		}
		
		//Rocks
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				rock[i*3+j] = Rock.crop(j*t_width, i*t_height,t_width-1, t_height-1);
			}
		}
		
		
	}
}
