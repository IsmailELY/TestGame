package dev.codenmore.tilegame;

import dev.codenmore.tilegame.gfx.GameCamera;
import dev.codenmore.tilegame.input.KeyManager;
import dev.codenmore.tilegame.worlds.World;

public class Handler 
{
	private Game game;
	private World world;
	
	public Handler(Game game) 
	{
		this.game=game;
	}

	public int getWidth()
	{
		return this.game.getWidth();
	}
	
	public int getHeight()
	{
		return this.game.getHeight();
	}
	
	public KeyManager getKeyManager()
	{
		return game.getKeyManager();
	}
	
	public GameCamera getGameCamera()
	{
		return game.getGameCamera();
	}
	
	public Game getGame() 
	{
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
}
