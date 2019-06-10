package dev.codenmore.tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{
	private boolean[] keys;
	public boolean up,down,left,right;
	public boolean basic_attack, spell_1;
	
	public KeyManager() 
	{
		keys = new boolean[256];
	}
	
	public void tick()
	{
		up = keys[KeyEvent.VK_UP];
		down =  keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		
		basic_attack = keys[KeyEvent.VK_Q];
		spell_1 = keys[KeyEvent.VK_W];
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		keys[e.getKeyCode()]=true;
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		keys[e.getKeyCode()]=false;
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}

}
