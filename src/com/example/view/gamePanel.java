package com.example.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.example.modle.Food;
import com.example.modle.Ground;
import com.example.modle.Snake;
import com.example.util.Global;

public class gamePanel extends JPanel {
	private Snake snake;
	private Food food;
	private Ground ground;
	
	public void dispaly(Snake snake ,Food food ,Ground ground){
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		repaint();
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fill3DRect(0, 0, Global.CELL_SIZE*Global.WIDTH, Global.CELL_SIZE*Global.HIGHT, true);
		
		if(snake!=null&&food!=null&&ground!=null){
			snake.drawMe(g);
			food.drawMe(g);
			ground.drawMe(g);
		}
			
		
	}
	
	
}
