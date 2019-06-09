package dev.codenmore.tilegame.states;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.ImageLoader;

public class MenuState extends State 
{
	private boolean pressed;
	
	public MenuState(Handler handler)
	{
		super(handler);
		this.pressed = false;
	}
	
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(ImageLoader.loadImage("/textures/menu.jpg"),0,0,null);
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX()>252 && handler.getMouseManager().getMouseX()<352 && handler.getMouseManager().getMouseY()>315 && handler.getMouseManager().getMouseY()<340)
		{
			g.drawImage(Assets.button[1],252,315,100,25,null);
		}
		else
		{
			g.drawImage(Assets.button[0],252,312,100,28,null);
		}
	}

	@Override
	public void tick() 
	{
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX()>252 && handler.getMouseManager().getMouseX()<352 && handler.getMouseManager().getMouseY()>315 && handler.getMouseManager().getMouseY()<340)
		{
			pressed = true;
		}
		if(!handler.getMouseManager().isLeftPressed() && pressed)
		{
			State.setState(handler.getGame().gameState);
		}
	}

}
