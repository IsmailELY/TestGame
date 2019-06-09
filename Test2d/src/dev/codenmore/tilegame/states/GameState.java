package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.*;
import dev.codenmore.tilegame.worlds.*;

public class GameState extends State
{
	private Player player;
	private World world;
	
	public GameState(Handler handler)
	{
		super(handler);
		world = new World(handler,"res/worlds/ice.txt");
		handler.setWorld(world);
		this.player=new Player(handler, world.getSpawnX()*32,world.getSpawnY()*32, 100);
	}

	@Override
	public void render(Graphics g) 
	{
		world.render(g);
		player.render(g);
	}

	@Override
	public void tick() 
	{
		world.tick();
		player.tick();
	}
	
}
