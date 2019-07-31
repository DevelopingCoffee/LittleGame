import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation {

	private ArrayList<BufferedImage> imgList = new ArrayList<>();
	private int speed;
	private int count = 0;
	private int index = 0;
	private BufferedImage currentImg;

	public Animation(int speed, BufferedImage... img) {
		this.speed = speed;
		for (int i = 0; i < img.length; i++) {
			imgList.add(img[i]);
		}
	}
	

	public void runAnimation() {
		index++;
		if (index > speed) {
			index = 0;
			nextFrame();
		}
	}

	public void nextFrame() {
		for (int i = 0; i < imgList.size(); i++) {
			if (count == i)
				currentImg = imgList.get(i);
		}
		count++;

		if (count > imgList.size())
			count = 0;
	}

	public BufferedImage getCurrentImg() {
		return currentImg;
	}

	public void drawAnimation(Graphics g, double x, double y) {
		g.drawImage(currentImg, (int) x, (int) y, null);
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
//package com.game.src.libs;
//
//import java.awt.Graphics;
//import java.awt.image.BufferedImage;
//
//public class Animation {
//
//	private int speed;
//	private int frames;
//	private int index = 0;
//	private int count = 0;
//	

//	
//	public void runAnimation(){
//		index++;
//		if(index > speed){
//			index = 0;
//			nextFrame();
//		}	
//	}
//	

//	
//	public void drawAnimation(Graphics g, double x, double y){
//		g.drawImage(currentImg, (int)x - offset, (int)y, null);
//	}
//	
//	public void setCount(int count){
//		this.count = count;
//	}
//	public int getCount(){
//		return count;
//	}
//	public int getSpeed(){
//		return speed;
//	}
//	public void setSpeed(int speed){
//		this.speed = speed;
//	}
//	
//}