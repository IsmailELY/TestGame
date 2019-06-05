package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Game;
import dev.codenmore.tilegame.entities.*;
import dev.codenmore.tilegame.tiles.Tile;

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
		for(int i=0;i<22;i++)
		{
			for (int j=0;j<12;j++)
				Tile.tiles[0].render(g, i*32, j*32);	
			Tile.tiles[1].render(g,32*i , 12*32);
		}
		player.render(g);
	}

	@Override
	public void tick() 
	{
		player.tick();
	}
	
}
