import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	
	Game game;
	
	public KeyInput(Game game) {
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e) {//new class bc, nnot just player but also hay menu...
		game.keyPressed(e);
	}
	public void keyReleased(KeyEvent e) {
		game.keyReleased(e);
		
	}

}
