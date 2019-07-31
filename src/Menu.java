import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {

	
	public Rectangle playButton = new Rectangle(Game.WIDTH/2 +120,150,100,50);
	public Rectangle creditButton = new Rectangle(Game.WIDTH/2 +120,250,100,50);
	public Rectangle exitButton = new Rectangle(Game.WIDTH/2 +120,350,100,50);
	
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		
		
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Level 8",Game.WIDTH/2+90, 100);

		Font fnt1 = new Font("arial", Font.BOLD, 30);
		Font fnt2 = new Font("arial", Font.BOLD, 22);
		g.setFont(fnt1);
		g.drawString("Play", playButton.x+20, playButton.y+35);
		g.setFont(fnt2);
		g.drawString("Credits", creditButton.x+15, creditButton.y+35);
		g.setFont(fnt1);
		g.drawString("Quit", exitButton.x+20, exitButton.y+35);
		g2d.draw(playButton);
		g2d.draw(creditButton);
		g2d.draw(exitButton);
		
	}
}
