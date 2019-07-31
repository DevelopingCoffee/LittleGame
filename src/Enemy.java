import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.gameproject.src.main.classes.EntityB;

public class Enemy extends GameObject implements EntityB {

	

	private int type;
	private boolean boss;
	
	private Textures tex;
	
	
	public Enemy (double x, double y, Textures tex, int type, boolean boss) {
		super(x,y);
		this.tex=tex;
		this.type=type;
		this.boss=boss;

	}
	
	
	public void tick() {
		
		if(!boss) {
		if(type==1) {
		this.y +=3;
	}else {
		this.y +=1;
	}} else {
		if (y<30) {
			this.y +=1;
		}
		this.x++;	
	}
	}
		
		
		
	
	
	
	public void render(Graphics g) {
		
		g.drawImage(tex.enemyList.get(type),(int)x, (int)y,null);
	}

	public double getY() {
		return y;
	}

	public double getX() {
		return x;
	}
	
	public int getType() {
		return this.type;
	}


	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, tex.getEnemyWidth(type), tex.getEnemyHeight(type));
	}
	


}
