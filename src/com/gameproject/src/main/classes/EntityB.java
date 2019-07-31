package com.gameproject.src.main.classes;
import java.awt.Graphics;
import java.awt.Rectangle;

public interface EntityB {

	
	public void tick();
	public void render(Graphics g);
	public double getX();
	public double getY();
	Rectangle getBounds();
}
