package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Game;

public abstract class State 
{
	private static State currentstate=null;

	public static State getState() 
	{
		return currentstate;
	}
	
	public static void setState(State state) 
	{
		State.currentstate = state;
	}
	
	//Class
	private Game game;
	
	public State(Game game)
	{
		this.game=game;
	}
	
	abstract public void render(Graphics g);
	
	abstract public void tick();

}
