package dev.codenmore.tilegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.codenmore.tilegame.input.*;

import dev.codenmore.tilegame.states.*;
import dev.codenmore.tilegame.d.*;
import dev.codenmore.tilegame.gfx.*;

public class Game implements Runnable
{
	//attributes
	private Display display;
	private int width,height;
	
	public Display getDisplay() {
		return display;
	}

	public Thread getThread() {
		return thread;
	}

	public boolean isRunning() {
		return running;
	}

	public String getTitle() {
		return title;
	}

	public BufferStrategy getBs() {
		return bs;
	}

	public Graphics getG() {
		return g;
	}

	public State getGameState() {
		return gameState;
	}

	public State getMenuState() {
		return menuState;
	}

	public State getSettingState() {
		return settingState;
	}
	
	public int getWidth() 
	{
		return width;
	}

	public int getHeight() 
	{
		return height;
	}

	public Thread thread;
	public boolean running = false;
	public String title;
	
	//graphics
	private BufferStrategy bs;
	private Graphics g;
	
	//states
	private State gameState;
	private State menuState;
	private State settingState;
	
	//input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public KeyManager getKeyManager()
	{
		return keyManager;
	}
	
	public GameCamera getGameCamera()
	{
		return gameCamera;
	}
	
	public Game(String title,int width,int height)
	{
		this.height=height;
		this.width=width;
		this.title=title;
		this.keyManager  = new KeyManager();
	}
	
	private void init ()
	{
		display = new Display(title, width, height);
		display.getJFrame().addKeyListener(keyManager);
		Assets.init();
		
		this.handler = new Handler(this);
		gameCamera = new GameCamera(this,0, 0);		
		gameState = new GameState(this.handler);
		menuState = new MenuState(this.handler);
		settingState = new SettingState(this.handler);
		
		State.setState(gameState);
	}
	
	private void tick ()
	{
		keyManager.tick();
		
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
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		
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
