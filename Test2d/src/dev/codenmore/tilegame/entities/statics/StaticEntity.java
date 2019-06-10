package dev.codenmore.tilegame.entities.statics;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;

public abstract class StaticEntity extends Entity 
{
	public static final int DEFAULT_RESPAWN = 60000;
	protected long lastTime,timer,respawn;

	public static final int DEFAULT_HEALTH = 10;	
	
	public StaticEntity(Handler handler, float x, float y, int width, int height) 
	{
		super(handler, x, y, width, height,DEFAULT_HEALTH);
		lastTime = System.currentTimeMillis();
		timer=0;
		respawn = DEFAULT_RESPAWN;
	}

}
