package com.example.modle;

import java.awt.Graphics;
import java.awt.Point;

import com.example.util.Global;

public class Food extends Point{
	public void newFood(Point p){
		this.setLocation(p);
	}
	
	public boolean isEatFood(Snake snake){
		return this.equals(snake.getHead());
	}
	
	public void drawMe(Graphics g){
		g.fill3DRect(x*Global.CELL_SIZE, y*Global.CELL_SIZE,
				Global.CELL_SIZE, Global.CELL_SIZE, true);
	}
}
