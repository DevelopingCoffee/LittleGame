import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.gameproject.src.main.classes.EntityA;

public class Bullet extends GameObject implements EntityA{

	private Textures tex;
	private int type = 0;
	private Game game;
	private boolean[] alreadyULDR;
	
	
	public Bullet(double x, double y, Textures tex, Game game, int type) {
		super(x,y);
		this.tex = tex;
		this.game=game;
		this.type=type;
		alreadyULDR = new boolean[4];
		alreadyULDR[0]=game.p.isAlreadyUp();
		alreadyULDR[1]=game.p.isAlreadyLeft();
		alreadyULDR[2]=game.p.isAlreadyDown();
		alreadyULDR[3]=game.p.isAlreadyRight(); 
	}
	
	
	
	
	public void tick() {
//		if(Physics.collision(this,game.eb)==true) {
//			System.out.println("hit");
		if(alreadyULDR[0]) {
			y -=10;
		} else if (alreadyULDR[1]) {
			x -=10;
		} else if (alreadyULDR[2]) {
			y +=10;
		} else if (alreadyULDR[3]) {
			x +=10;
		}


//		}
	}
	
	
	public void render(Graphics g) {
		if(alreadyULDR[0]) {
			g.drawImage(tex.bulletA.get(type),(int)x, (int)y,null);
		} else if (alreadyULDR[1]) {
			g.drawImage(rotateLeft(tex.bulletA.get(type)),(int)x, (int)y,null);
		} else if (alreadyULDR[2]) {
			g.drawImage(rotateDown(tex.bulletA.get(type)),(int)x, (int)y,null);
		} else if (alreadyULDR[3]) {
			g.drawImage(rotateRight(tex.bulletA.get(type)),(int)x, (int)y,null);
		}
	}
	
	public double getY() {
		return y;
	}
	
	public void setBullet(int type) {
		this.type=type;
	}


	
	public double getX() {
		return x;
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32,32);
	}
}
