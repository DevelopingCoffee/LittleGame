import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import com.gameproject.src.main.classes.EntityA;

public class Player extends GameObject implements EntityA {

	private double velX = 0;
	private double velY = 0;
	private int type = 0;
	private boolean shield = false;
	private long time;


	public void setShield(boolean b) {
		this.shield = b;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public boolean getShield() {
		return shield;
	}

	private Textures tex;
	private Animation anim1;
	private Animation anim2;
	BufferedImage player1;
	BufferedImage player2;

//	private AffineTransform at = new AffineTransform();

	public Player(double x, double y, Textures tex) {
		super(x, y);
		this.tex = tex;
		anim1 = new Animation(1, tex.player1.get(0), tex.player1.get(1), tex.player1.get(2));
		anim2 = new Animation(1, tex.shields1.get(0), tex.shields1.get(1));
		player1 = tex.player1.get(0);
		player2 = tex.player2.get(0);
	}

	public void tick() {
		x += velX;// velocity method is faster, since it doesnt require a set and get interaction
		y += velY;

		anim1.runAnimation();

		if (shield) {
			anim2.runAnimation();

//			System.out.println((System.currentTimeMillis()-time)>5000);

			if ((System.currentTimeMillis() - time) > 5000)
				shield = false;
		}
	if(signalDown==true&&!alreadyDown) {
		player1=rotateDown(tex.player1.get(0));
		player2=rotateDown(tex.player2.get(0));
		anim1 = new Animation(1, rotateDown(tex.player1.get(0)), rotateDown(tex.player1.get(1)), rotateDown(tex.player1.get(2)));
		anim2 = new Animation(1, rotateDown(tex.shields1.get(0)), rotateDown(tex.shields1.get(1)));
		setAllAlreadyOff();
		alreadyDown=true;
	}else if(signalUp==true&&!alreadyUp) {
		player1=rotateUp(tex.player1.get(0));
		player2=rotateUp(tex.player2.get(0));
		anim1 = new Animation(1, rotateUp(tex.player1.get(0)), rotateUp(tex.player1.get(1)), rotateUp(tex.player1.get(2)));
		anim2 = new Animation(1, rotateUp(tex.shields1.get(0)), rotateUp(tex.shields1.get(1)));
		setAllAlreadyOff();
		alreadyUp=true;
	}else if(signalLeft==true&&!alreadyLeft) {
		player1=rotateLeft(tex.player1.get(0));
		player2=rotateLeft(tex.player2.get(0));
		anim1 = new Animation(1, rotateLeft(tex.player1.get(0)), rotateLeft(tex.player1.get(1)), rotateLeft(tex.player1.get(2)));
		anim2 = new Animation(1, rotateLeft(tex.shields1.get(0)), rotateLeft(tex.shields1.get(1)));
		setAllAlreadyOff();
		alreadyLeft=true;
	}else if(signalRight==true&&!alreadyRight) {
		player1=rotateRight(tex.player1.get(0));
		player2=rotateRight(tex.player2.get(0));
		anim1 = new Animation(1, rotateRight(tex.player1.get(0)), rotateRight(tex.player1.get(1)), rotateRight(tex.player1.get(2)));
		anim2 = new Animation(1, rotateRight(tex.shields1.get(0)), rotateRight(tex.shields1.get(1)));
		setAllAlreadyOff();
		alreadyRight=true;
	}



		if (x <= 0)
			x = 0;
		if (x > 640 - 20)
			x = 640 - 20;
		if (y <= 0)
			y = 0;
		if (y > 480 - 32)
			y = 480 - 32;
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if(velY<0) {
			g2d.drawImage(anim1.getCurrentImg(), (int)x, (int)y, null);/////hier if Velx >0 choose other
		}else {
			g2d.drawImage(player1, (int)x, (int)y, null);/////hier if Velx >0 choose other
		}
		if(shield) {
			g2d.drawImage(anim2.getCurrentImg(), (int)x, (int)y, null);
		}
	}


	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, tex.getPlayerWidth(type), tex.getPlayerHeight(type));
	}

}
