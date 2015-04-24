package com.example.modle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import com.example.util.Global;

public class Ground {
	
	boolean stock[][] = new boolean[Global.WIDTH ][Global.HIGHT];
	public Ground(){
		for(int i=0;i<Global.WIDTH;i++){
			stock[i][0]=true;
			stock[i][Global.HIGHT-1]=true;
		}
		for(int i=0;i<Global.HIGHT;i++){
			stock[0][i]=true;
			stock[Global.WIDTH-1][i]=true;
		}
		
	}
	
	
	public boolean isSnakeEatStock(Snake snake){
		for(int i=0;i<Global.WIDTH;i++)
			for(int j=0;j<Global.HIGHT;j++)
				if(stock[i][j]&&(new Point(i,j).equals(snake.getHead())))
					return true;
		return false;
	}
	
	public void drawMe(Graphics g){
		g.setColor(Color.DARK_GRAY);
		for(int i=0;i<Global.WIDTH;i++)
			for(int j=0;j<Global.HIGHT;j++)
				if(stock[i][j])
					g.fill3DRect(i*Global.CELL_SIZE, j*Global.CELL_SIZE,
							Global.CELL_SIZE, Global.CELL_SIZE, true);
		
	}
}
