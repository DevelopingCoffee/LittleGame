import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.text.html.parser.Entity;

import com.gameproject.src.main.classes.EntityA;
import com.gameproject.src.main.classes.EntityB;


public class Controller {
	
//	Game game;
//	Textures tex;
//	
//	public Controller(Game game,Textures tex){
//		for(int i=0; i<game.SCALE*game.WIDTH;i+=32) {
//			addEnemy(new Enemy(i, 0, tex));
//		}
//	}
	private Game game;
	private Player p;
	
	public Controller (Game game) {
		this.game=game;
		p = game.getPlayer();

	}
	private double HealthP=100;


	

	private ArrayList<EntityA> ea = new ArrayList<>();
	private ArrayList<EntityB> eb = new ArrayList<>();

	EntityA enta;
	EntityB entb;
	

	
	
	
	int enemyDeathCounter;
	
	public int getEnemyDeathCounter() {
		return enemyDeathCounter;
	}

	public void setEnemyDeathCounter(int number) {
		this.enemyDeathCounter = number;
	}
	
	

	public void tick() {
		// class A (bullets) tick and hit
		for (int i = 0; i < ea.size(); i++) {//for all bullets
			ea.get(i).tick();

			if (ea.get(i).getY() < 0) {
				ea.remove(i);
				i--;
			}

			else {
				for (int j = 0; j < eb.size(); j++) {
					if (ea.get(i).getBounds().intersects(eb.get(j).getBounds())) {
						System.out.println("hit");
						eb.remove(j);
						enemyDeathCounter += 1;
						System.out.println(enemyDeathCounter);
						if (game.getType() == 0) {
							ea.remove(i);
							i--;
							break;
						}
					}
				}
			}

			
			
		}
//		Player tick & CRASH
		p.tick();


		for (int j = 0; j < eb.size(); j++) {
		if (p.getBounds().intersects(eb.get(j).getBounds())) {
			System.out.println("hit");
			eb.remove(j);
			enemyDeathCounter +=1;
			if(!p.getShield()) {
			this.HealthP-=20;
			}
			System.out.println(enemyDeathCounter);

		}
		}
			

			
			
		
		
		
		// class B (enemyies) tick
		for (int i = 0; i < eb.size(); i++) {
			entb = eb.get(i);
			if (entb.getY() > 480) {
				eb.remove(i);
				enemyDeathCounter+=1;
			}

			entb.tick();
		}
	}

	public void render(Graphics g) {
		// class A (bullets) render
		for (int i = 0; i < ea.size(); i++) {
			enta = ea.get(i);
			enta.render(g);
		}
		// player render
		p.render(g);
		g.setColor(Color.BLACK);
		g.fillRect((int)p.getX()+5, (int)p.getY()-5, 25, 4);
		g.setColor(Color.GREEN);
		g.fillRect((int)p.getX()+5, (int)p.getY()-5, (int)(HealthP/100.0*25.0), 4);
		g.setColor(Color.WHITE);
		g.drawRect((int)p.getX()+5, (int)p.getY()-5, 25, 4);

		// class B (enemies) render
		for (int i = 0; i < eb.size(); i++) {
			entb = eb.get(i);
			entb.render(g);
		}
	}
	
	public void addEnt(EntityA block) { //hier if arraylist gerade oder ungerade add Bullet new instance
		ea.add(block);
	}
	
	public void removeEnt(EntityA block) {
		ea.remove(block);
	}

	public void addEnt(EntityB block) { //hier if arraylist gerade oder ungerade add Bullet new instance
		eb.add(block);
	}
	
	public void removeEnt(EntityB block) {
		eb.remove(block);
	}
	public ArrayList<EntityA> GetListA(){
		return ea;
	}
	public ArrayList<EntityB> GetListB(){
		return eb;
	}
}
