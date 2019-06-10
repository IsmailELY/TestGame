package dev.codenmore.tilegame.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;
import dev.codenmore.tilegame.gfx.Animation;
import dev.codenmore.tilegame.gfx.Assets;

public class Player extends Creature {
	
	
	private Animation animDeath;
	private Animation[] anim = new Animation [4];
	private BufferedImage StopAnimation;
	
	public Player(Handler handler,float x, float y, int health) 
	{
		super(handler,x, y,Creature.DEFAULT_WIDTH*2,DEFAULT_HEIGHT*2, health);
		this.bounds.y=3*height/4;
		this.bounds.height=height/32;
		this.bounds.x=width/4;
		this.bounds.width=width/3+3;
		
		for (int i=0; i<4;i++)
		{
			anim[i] = new Animation(180, Assets.player_form[i],Assets.player_stop[i]);
		}
		
		
		animDeath = new Animation(300,Assets.DeathScene);
		StopAnimation = anim[body].StopFrame();	
	}

	@Override
	public void tick() 
	{
		//Animation
		for(Animation a : anim)
		{
			a.tick();
		}
		
		//Mouvement
		getInput();
		move();
		handler.getGameCamera().centerEntity(this);
		//Attacks
		checkAttack();
	}
	
	private void checkAttack() 
	{
		Rectangle cb = getCollisionBounds(0,0);
		Rectangle ar = new Rectangle();
		int arSize = bounds.width/4;
		
		if(handler.getKeyManager().basic_attack)
		{
			ar.height = arSize;
			ar.width = arSize;
			
			if(body==1) // up
			{
				ar.x = cb.x + cb.width/2 - arSize/2;
				ar.y = cb.y - arSize;
			}
			else if(body==0) //down
			{
				ar.x = cb.x + cb.width/2 - arSize/2;
				ar.y = cb.y + cb.height;
			}
			else if(body==2) //left
			{
				ar.x = cb.x - arSize;
				ar.y = cb.y + cb.height/2 - arSize/2;
			}
			else if(body==3) //right
			{
				ar.x = cb.x + cb.width ;
				ar.y = cb.y + cb.height/2 - arSize/2;
			}else
			{
				return;
			}
		}
		else if (handler.getKeyManager().spell_1)
		{
			
			if(body==1) // up
			{
				ar.height = height;
				ar.width = arSize;
				ar.x = cb.x + cb.width/2 - arSize/2;
				ar.y = cb.y - height;
			}
			else if(body==0) //down
			{
				ar.height = height;
				ar.width = arSize;
				ar.x = cb.x + cb.width/2 - arSize/2;
				ar.y = cb.y + cb.height;
			}
			else if(body==2) //left
			{
				ar.height = arSize;
				ar.width = height;
				ar.x = cb.x - height;
				ar.y = cb.y + cb.height/2 - arSize/2;
			}
			else if(body==3) //right
			{
				ar.height = arSize;
				ar.width = height;
				ar.x = cb.x + cb.width ;
				ar.y = cb.y + cb.height/2 - arSize/2;
			}else
			{
				return;
			}
		}
		for(Entity e : handler.getWorld().getEntityManager().getEntities())
		{
			if(e.equals(this))
				continue;
			
			if (ar.intersects(e.getCollisionBounds(0,0)))
			{
				e.hurt(strenght);
				return;
			}
		}
		
	}

	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		if (handler.getKeyManager().up )
			yMove = -speed;
		else if (handler.getKeyManager().down )
			yMove = +speed;	
		else if (handler.getKeyManager().left )
			xMove = -speed;
		else if (handler.getKeyManager().right)
			xMove = +speed;
	}

	private BufferedImage getCurrentAnimationFrame()
	{	
		if(xMove!=0 || yMove!=0)
		{
			if(xMove<0) 
				body=2; //left
			else if(xMove>0)
				body=3; //right
			if(yMove<0)
				body=1; //up
			else if(yMove>0)
				body=0; //down
			
			for(int i=0; i<4; i++)
			{
				if(i==body)
				{
					StopAnimation = anim[i].StopFrame();
					continue;
				}
				anim[i].setIndex(0);
			}
			return anim[body].getCurrentFrame();
		}
		return StopAnimation;
	}
	
	public void die()
	{
		x=0;
		y=0;
		
		while(!animDeath.isAnimated())
		{
			handler.getGame().getG().drawImage(animDeath.getCurrentFrame(),0,0,1000,660,null);
		}
	}
	
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(getCurrentAnimationFrame(),(int)(x - handler.getGameCamera().getxOffset()),(int)(y- handler.getGameCamera().getyOffset()),width,height,null);
	}
	
}
