import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

	Game game;

	public MouseInput(Game game) {
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

//	public Rectangle playButton = new Rectangle(Game.WIDTH/2 +120,150,100,50);
//	public Rectangle creditButton = new Rectangle(Game.WIDTH/2 +120,250,100,50);
//	public Rectangle exitButton = new Rectangle(Game.WIDTH/2 +120,350,100,50);
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		if (game.getState() == Game.STATE.MENU) {
			if (mx >= Game.WIDTH / 2 + 150 && mx <= Game.WIDTH / 2 + 250) {
				if (my >= 150 && my <= 200) {
					game.setState(Game.STATE.GAME);

				}
			}
			if (mx >= Game.WIDTH / 2 + 150 && mx <= Game.WIDTH / 2 + 250) {
				if (my >= 250 && my <= 300) {
					game.setState(Game.STATE.CREDITS);

				}
			}
			if (mx >= Game.WIDTH / 2 + 150 && mx <= Game.WIDTH / 2 + 250) {
				if (my >= 350 && my <= 400) {
					System.exit(1);

				}
			}
		}

		if (game.getState() == Game.STATE.CREDITS) {
			if (mx >= 480 && mx <= 605) {
				if (my >= 400 && my <= 450) {
					game.setState(Game.STATE.MENU);

				}

			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
