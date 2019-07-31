import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.gameproject.src.main.classes.EntityA;
import com.gameproject.src.main.classes.EntityB;

//MASTER EDIT

public class Game extends Canvas implements Runnable {
	
	public static final int WIDTH= 320;
	public static final int HEIGHT  = WIDTH /12 *9;
	public static final int SCALE = 2;
	public final String TITLE = "Level8";
	
	private boolean running = false;
	private Thread thread;
	//bufferedimage: load/buffer the image before projecting it:
	private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet = null;
	private BufferedImage background = null;
	private boolean shooting = false;
	
	private int type=0;
	
	private Physics physics;
	public Player p;
	public Controller c;
	private Textures tex;
	private LevelDesign ld;
	private JLabel score;
	private Animation anim;
	public ArrayList<EntityA> ea;
	public ArrayList<EntityB> eb;
	private Menu menu;
	private Credits credits;
	public static enum STATE{
		MENU,
		GAME,
		CREDITS
	};
	public static STATE state = STATE.MENU;
	
	
	public STATE getState() {
		return state;
	}


	public void setState(STATE state) {
		this.state = state;
	}
	static STATE State;
	

	
	
	//temp
//	private BufferedImage player;
	
	private void init() {
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			spriteSheet = loader.loadImage("/SpriteSheet2End.png");//das gesamte Raster geladen
			background = loader.loadImage("/Background.png");		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		tex = new Textures(this);
		menu=new Menu();
		credits=new Credits();
		p= new Player (200,200,tex);//this: reference auf Game und die getSpriteSheetMethode, 200 und 200 Koordinante 
		
		c=new Controller(this);/////gGE�NDERT
//		physics = new Physics(this); 
		eb=c.GetListB();
		addKeyListener(new KeyInput(this));
		addMouseListener(new MouseInput(this));
		ld = new LevelDesign(c, this,10);
//		c.addEnemy(new Enemy(300, 0,tex));
		ld.startLevel1();
		
	}

	
	private synchronized void start() {
		if(running)
			return;
		
		running=true;
		thread = new Thread(this);
		thread.start();
	}
	
	private synchronized void stop() {
		if(!running)
			return;
		
		running = false;
		try {
			thread.join();//wait for them to die?
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
		
	}
	
	public void run() {//the thread interface method
		init();//load complete SpriteSheet
		long lastTime=System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		while(running) {
			long now = System.nanoTime();
			delta += (now  - lastTime) /ns;
			lastTime=now;
			if(delta >=1) { //das ist 60 mal in der Sekunde 
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " Ticks and Fps " + frames);
				updates=0;
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() { //everything in game what updates
		if(state==State.GAME) {
		c.tick();
//		if (Physics.collision(p, c.GetListB()) == true) {// Player Check
//			System.out.println("Du lutscher");
//
//		}
//		if (Physics.collision2(c.GetListA(), c.GetListB()) == true) {// bullet check
//			System.out.println("Du lutscher");
//		}
	}
	}
//
//    the jframe constructs a bufferstrategy when you call createbufferstrategy(2);.
//    the bufferstrategy knows that it belongs to that specific instance of jframe. 
//    you are retrieving it and storing it in the bs field.
//    when it comes time to draw your stuff, you are retrieving a graphics2d from bs. 
//    this graphics2d object is tied to one of the internal buffers owned by bs. 
//    as you draw, everything goes into that buffer.
//    when you finally call bs.show(), bs will cause the buffer that you just drew
//    to become the current buffer for the jframe. 
//    it knows how to do this because (see point 1) it knows what jframe it is in service to.

	
	public void render() { //everything in game what renders/darstellen
		BufferStrategy bs = this.getBufferStrategy();//returns no if not created
			if(bs==null) {
				createBufferStrategy(3);//have 3 images loaded (1 projeced & 2 loaded)
				return;
			}
		Graphics g = bs.getDrawGraphics();//create grapic context to draws our buffers
		
		
		
		/////////////////////////////////
		//Here we can draw stuff
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(),this); //Das kleiner Grundimage wird mit getWidth und Height auf die Gr��e des Fensters gebracht

		g.drawImage(background, 0,0,null);
		if(state==State.GAME) {

		c.render(g);
		

		
		} else if (state==State.MENU) {
			
			menu.render(g);
		}else if (state==State.CREDITS) {
			credits.render(g);
		}
		//////////////////////////////////////////
		
		
		
		g.dispose();
		bs.show(); //make the buffer free again?
		
		
	}
	
	public void keyPressed(KeyEvent e) {//new class bc, not just player but also hay menu...
		
		if(state==State.GAME) {

		int key = e.getKeyCode();
		if(key==KeyEvent.VK_RIGHT) {
			p.setVelX(5);
			p.setAllSignalsOff();
			p.setSignalRight(true);
		}else if(key==KeyEvent.VK_LEFT) {
			p.setVelX(-5);
			p.setAllSignalsOff();
			p.setSignalLeft(true);
//		}else if(key==KeyEvent.VK_LEFT&& !p.isLeft()) {
//			p.setAllOff();
//			p.setLeft(true);
		}else if(key==KeyEvent.VK_UP) {
			p.setVelY(-5);
			p.setAllSignalsOff();
			p.setSignalUp(true);
		}else if(key==KeyEvent.VK_DOWN){
			p.setVelY(5);
			p.setAllSignalsOff();
			p.setSignalDown(true);
		}else if(key==KeyEvent.VK_SPACE && !shooting) {
			c.addEnt(new Bullet(p.getX(),p.getY()-16,tex,this,type));
			shooting= true;
		}else if(key==KeyEvent.VK_ESCAPE) {
			setState(STATE.MENU);
		}else if(key==KeyEvent.VK_X) {
			if(type==0) {
				this.type=1;
			}else if(type==1) {
				this.type=0;
			}
		}else if(key==KeyEvent.VK_C && p.getShield()==false) {
			p.setShield(true);
			p.setTime((long)System.currentTimeMillis());
		}

		}
	}
	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(state==State.GAME) {
		if(key==KeyEvent.VK_RIGHT) {
			p.setVelX(0);// notwendig da velx sonst auf +5 bleibt
		}else if(key==KeyEvent.VK_LEFT) {
			p.setVelX(0);
		}else if(key==KeyEvent.VK_UP) {
			p.setVelY(0);
		}else if(key==KeyEvent.VK_DOWN){
			p.setVelY(0);
		}else if(key==KeyEvent.VK_SPACE) {
			shooting= false;
		}
		}
	}



	public static void main(String args[]) {
		Game game = new Game();
		
		game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();

	}
	public BufferedImage getSpriteSheet() {
		return spriteSheet;
		
	}	public Textures getTextures() {
		return tex;
	}
	
	public Player getPlayer() {
		return(this.p);
	}

}
