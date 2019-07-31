import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Textures {
	
	
	private SpriteSheet ss;
	List<BufferedImage> enemyList= new LinkedList<>(); 
	List<BufferedImage> bulletA= new LinkedList<>(); 
	List<BufferedImage> bulletB= new LinkedList<>(); 
	List<BufferedImage> player1= new LinkedList<>(); 
	List<BufferedImage> player2= new LinkedList<>(); 
	List<BufferedImage> shields1= new LinkedList<>(); 
	List<BufferedImage> shields2= new LinkedList<>(); 

	public Textures(Game game) {

		ss = new SpriteSheet(game.getSpriteSheet());
		getTextures();

	}
	
	
	private void getTextures() {
		player1.add(ss.grabImage(1, 1, 32, 32));
		player1.add(ss.grabImage(1, 7, 32, 32));
		player1.add(ss.grabImage(2, 7, 32, 32));
		player2.add(ss.grabImage(2, 2, 64, 64));
		player2.add(ss.grabImage(5, 5, 64, 64));
		player2.add(ss.grabImage(5, 7, 64, 64));
		
		bulletA.add(ss.grabImage(1,2, 32, 32));
		bulletA.add(ss.grabImage(1,3, 32, 32));
		bulletB.add(ss.grabImage(4,4, 32, 32));
		bulletB.add(ss.grabImage(5,4, 32, 32));
		
		enemyList.add(ss.grabImage(4, 1, 32, 32)); //probls
		enemyList.add(ss.grabImage(5, 1, 32, 32));
		enemyList.add(ss.grabImage(6, 1, 32, 32));
		enemyList.add(ss.grabImage(4, 2, 64, 64));
		enemyList.add(ss.grabImage(2, 1, 64, 32));
		enemyList.add(ss.grabImage(1, 4, 96, 96));
		
		shields1.add(ss.grabImage(4, 7, 32, 32));
		shields1.add(ss.grabImage(4, 8, 32, 32));
		shields2.add(ss.grabImage(7, 1, 64, 32));
		shields2.add(ss.grabImage(7, 2, 64, 32));
	}
	
	
	public int getEnemyWidth(int type) {
		if(type==0) {
			return 32;
		}else if(type==1) {
			return 32;
		}else if(type==2) {
			return 32;
		}else if(type==3) {
			return 32;
		}else if(type==4) {
			return 64;
		}else if(type==5) {
			return 64;
		}else if(type==6) {
			return 96;
		}else 
			return 0;
	}
	public int getEnemyHeight(int type) {
		if(type==0) {
			return 32;
		}else if(type==1) {
			return 32;
		}else if(type==2) {
			return 32;
		}else if(type==3) {
			return 32;
		}else if(type==4) {
			return 64;
		}else if(type==5) {
			return 32;
		}else if(type==6) {
			return 96;
		}else 
			return 0;
	}
	public int getBulletHW() {
		return 32;
	}
	public int getPlayerWidth(int type) {
		if(type==0) {
			return 32;
		}else
			return 64;
	}

	public int getPlayerHeight(int type) {
			if(type==0) {
				return 32;
			}else
				return 64;
	}

}
