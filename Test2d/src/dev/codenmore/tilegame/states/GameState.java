package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.worlds.*;

public class GameState extends State
{
	private World world;
	
	public GameState(Handler handler)
	{
		super(handler);
		world = new World(handler,"res/worlds/forest.txt");
		handler.setWorld(world);
	}

	@Override
	public void render(Graphics g) 
	{
		world.render(g);
	}

	@Override
	public void tick() 
	{
		world.tick();
	}
	
}
