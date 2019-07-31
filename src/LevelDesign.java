import java.util.Random;

public class LevelDesign {

	
	Thread level1;
	Controller c;
	Game game;

	Random r = new Random();
	int enemies;
	int deathCounter;
	int level =1;
	
	
	public LevelDesign(Controller c, Game game, int enemies) {
		this.c=c;
		this.game=game;		
		this.enemies=enemies;
	}
	

	
	
	public void startLevel1() {
		level1 =new Thread(new Runnable() {
			public void run() {
				createEnemies(enemies,level);
				
				while(true) {
				try {
					level1.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if( game.c.getEnemyDeathCounter()>=enemies) {
					level+=1;
					game.c.setEnemyDeathCounter(0);
					enemies +=2; 
					createEnemies(enemies,level);
					
				}
				}
				
				
			}
		});
		level1.start();
	}

	


	private void createEnemies(int enemies, int level) {
		for(int i=0; i<enemies; i++) {
		try {
			level1.sleep(1000/level);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		c.addEnt(new Enemy(r.nextInt(game.WIDTH * game.SCALE),0,game.getTextures(),r.nextInt(4),false));

		}
	}
	
}

