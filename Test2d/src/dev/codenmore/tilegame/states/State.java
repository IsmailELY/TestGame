package dev.codenmore.tilegame.states;

import java.awt.Graphics;

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
	
	abstract public void render(Graphics g);
	
	abstract public void tick();

}
