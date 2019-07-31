package com.gameproject.src.main.classes;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public interface EntityA {

	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract double getX();
	public abstract double getY();
	abstract Rectangle getBounds();
	

	
	
	
}
