import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Credits {

	
	public Rectangle ReturnButton = new Rectangle(480,400,125,50);

	
	public void render(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		
		
		
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		Font fnt2 = new Font("arial", Font.BOLD, 25);

		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Level 8",Game.WIDTH/2+90, 100);
		g.setFont(fnt1);
		g.drawString("Programmed by DevelopingCoffee",75, 200);
		g.drawString("Thanks to RealTutsGML",75, 250);
		g.drawString("Version: 1.0.0",75, 300);
		g.drawString("Released in December 2018",75, 350);


		g2d.draw(ReturnButton);
		g.setFont(fnt2);
		g.drawString("Return",ReturnButton.x +20 ,ReturnButton.y+35);

		
	
		
	}
}
