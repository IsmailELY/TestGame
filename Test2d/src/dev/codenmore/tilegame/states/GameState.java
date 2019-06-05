package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.entities.*;

public class GameState extends State
{
	private Player player;
	
	public GameState(Game game)
	{
		super(game);
		this.player=new Player(game,0, 0, 100);
	}

	@Override
	public void render(Graphics g) 
	{
		player.render(g);
	}

	@Override
	public void tick() 
	{
		player.tick();
	}
	
}
