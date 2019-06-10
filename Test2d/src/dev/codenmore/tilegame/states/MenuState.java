package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.gfx.ImageLoader;
import dev.codenmore.tilegame.ui.ClickListener;
import dev.codenmore.tilegame.ui.UIImageButton;
import dev.codenmore.tilegame.ui.UIManager;

public class MenuState extends State 
{
	private UIManager uiManager;

	public MenuState(Handler handler)
	{
		super(handler);
		this.uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(252*5/3,315*5/3,100*5/3,25*5/3, Assets.startButton,new ClickListener()
				{
					@Override
					public void onClick() 
					{
						handler.getMouseManager().setUIManager(null);
						State.setState(handler.getGame().gameState);
					}
				}
		));
		uiManager.addObject(new UIImageButton(252*5/3,350*5/3,100*5/3,25*5/3, Assets.settingButton,new ClickListener()
		{
			@Override
			public void onClick() 
			{
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().settingState);
			}
		}
));
	}
	
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(ImageLoader.loadImage("/textures/menu.jpg"),0,0,1000,660,null);
		uiManager.render(g);
	}

	@Override
	public void tick() 
	{
		 uiManager.tick();
	}

}
