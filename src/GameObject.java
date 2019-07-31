import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class GameObject {
	public double x,y;
	public GameObject(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public Rectangle getBounds(int width, int height) {
		return new Rectangle((int)x, (int)y, width, height);
	}
	
	
	protected boolean signalUp=true;
	protected boolean signalDown=false;
	protected boolean signalLeft=false;
	protected boolean signalRight=false;
	
	protected boolean alreadyUp=true;
	protected boolean alreadyDown=false;
	protected boolean alreadyLeft=false;
	protected boolean alreadyRight=false;
	
	public void setAllSignalsOff() {
		signalUp=false;
		signalDown=false;
		signalLeft=false;
		signalRight=false;
	}
	
	public boolean isAlreadyUp() {
		return alreadyUp;
	}

	public void setAlreadyUp(boolean alreadyUp) {
		this.alreadyUp = alreadyUp;
	}

	public boolean isAlreadyDown() {
		return alreadyDown;
	}

	public void setAlreadyDown(boolean alreadyDown) {
		this.alreadyDown = alreadyDown;
	}

	public boolean isAlreadyLeft() {
		return alreadyLeft;
	}

	public void setAlreadyLeft(boolean alreadyLeft) {
		this.alreadyLeft = alreadyLeft;
	}

	public boolean isAlreadyRight() {
		return alreadyRight;
	}

	public void setAlreadyRight(boolean alreadyRight) {
		this.alreadyRight = alreadyRight;
	}

	public void setAllAlreadyOff() {
		alreadyUp=false;
		alreadyDown=false;
		alreadyLeft=false;
		alreadyRight=false;
	}


public BufferedImage rotateLeft(BufferedImage img) {
    AffineTransform transform = new AffineTransform();
    transform.rotate(Math.PI*3/2, img.getWidth()/2, img.getHeight()/2);
    AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
    img = op.filter(img, null);
    return(img);
 }
public BufferedImage rotateRight(BufferedImage img) {
    AffineTransform transform = new AffineTransform();
    transform.rotate(Math.PI/2, img.getWidth()/2, img.getHeight()/2);
    AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
    img = op.filter(img, null);
    return(img);
 }
public BufferedImage rotateUp(BufferedImage img) {
    AffineTransform transform = new AffineTransform();
    transform.rotate(0, img.getWidth()/2, img.getHeight()/2);
    AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
    img = op.filter(img, null);
    return(img);
 }
public BufferedImage rotateDown(BufferedImage img) {
    AffineTransform transform = new AffineTransform();
    transform.rotate(Math.PI, img.getWidth()/2, img.getHeight()/2);
    AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
    img = op.filter(img, null);
    return(img);
 }

public boolean isSignalUp() {
	return signalUp;
}

public void setSignalUp(boolean signalUp) {
	this.signalUp = signalUp;
}

public boolean isSignalDown() {
	return signalDown;
}

public void setSignalDown(boolean signalDown) {
	this.signalDown = signalDown;
}

public boolean isSignalLeft() {
	return signalLeft;
}

public void setSignalLeft(boolean signalLeft) {
	this.signalLeft = signalLeft;
}

public boolean isSignalRight() {
	return signalRight;
}

public void setSignalRight(boolean signalRight) {
	this.signalRight = signalRight;
}
	
	
	
	
	
}
