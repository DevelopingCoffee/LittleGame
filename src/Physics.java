import java.util.LinkedList;

import com.gameproject.src.main.classes.EntityA;
import com.gameproject.src.main.classes.EntityB;

public class Physics {
	
	Game game;
	
	public Physics (Game game) {
		this.game=game;
	}

	public static boolean collision(EntityA enta, LinkedList<EntityB> entab) {
		for(int i=0; i<entab.size();i++) {
			if(enta.getBounds().intersects(entab.get(i).getBounds()))
				return true;
		}
		
		return false;
	}
//
//	public static int collisionEntaB(EntityA enta, LinkedList<EntityB> entab) {
//		for (int i = 0; i < entab.size(); i++) {
//			if (enta.getBounds().intersects(entab.get(i).getBounds()))
//				return i;
//		}
//
//	}
	
	
	
	public static boolean collision2(LinkedList<EntityA> entaa, LinkedList<EntityB> entab) {
		
		for(int j=0; j<entaa.size();j++) {
		for(int i=0; i<entaa.size();i++) {
			if(entaa.get(j).getBounds().intersects(entab.get(i).getBounds()))
				return true;
		}
		}
		return false;
	}
	
	
}
