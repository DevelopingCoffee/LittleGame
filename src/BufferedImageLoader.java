import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferedImageLoader {
	
	private BufferedImage image;
	public BufferedImage loadImage(String path) throws IOException {
		image = ImageIO.read(getClass().getResource(path));
		
		//normalerweise ist es so, dass du getClass().getResource() nur auf Package-Ebene verwendest. Sprich, wenn du z.B. eine Text-, Bild-Datei laden willst, die in einem Package liegt.
		// Vorteil: Wird mit in die Jar-Datei gepackt!!
		return image;
	}

}
