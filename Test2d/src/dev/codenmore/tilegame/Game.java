package dev.codenmore.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import dev.codenmore.tilegame.states.*;
import dev.codenmore.tilegame.d.*;
import dev.codenmore.tilegame.gfx.*;

public class Game implements Runnable
{
	private Display display;
	public int width,height;
	public Thread thread;
	public boolean running = false;
	public String title;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//states
	private State gameState;
	private State menuState;
	private State settingState;
	
	public Game(String title,int width,int height)
	{
		this.height=height;
		this.width=width;
		this.title=title;
	}
	
	private void init ()
	{
		display = new Display(title, width, height);
		Assets.init();
		gameState = new GameState();
		menuState = new MenuState();
		settingState = new SettingState();
		
		State.setState(gameState);
	}
	
	private void tick ()
	{
		if (State.getState()!=null)
			State.getState().tick();
	}
	
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		if (bs==null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		if (State.getState()!=null)
			State.getState().render(g);
		
		bs.show();
		g.dispose();
	}
	
	public void run() 
	{	
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta=0;
		long now;
		long lastTime = System.nanoTime();
		
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			lastTime = now;
			
			if(delta>=1)
			{
				tick();
				render();
				delta--;
			}
			
		}
		
		stop();
	}
	
	public synchronized void start()
	{
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop()
	{
		if (!running)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
