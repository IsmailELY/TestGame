package dev.codenmore.tilegame.states;

import java.awt.Graphics;

import dev.codenmore.tilegame.Handler;

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
	protected Handler handler;
	
	public State(Handler handler)
	{
		this.handler=handler;
	}
	
	abstract public void render(Graphics g);
	
	abstract public void tick();

}
