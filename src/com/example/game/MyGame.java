package com.example.game;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.border.Border;

import com.example.controller.Controller;
import com.example.modle.Food;
import com.example.modle.Ground;
import com.example.modle.Snake;
import com.example.util.Global;
import com.example.view.Function;
import com.example.view.gamePanel;

public class MyGame extends JFrame {
	public MyGame(){
		Snake snake = new Snake();
		Food food = new Food();
		Ground ground = new Ground();
		gamePanel gamePanel = new gamePanel();
		Function function = new Function();
		Controller controller = new Controller(snake, food, ground, gamePanel,function);
		this.add(gamePanel,BorderLayout.CENTER);
		this.add(function,BorderLayout.PAGE_END);
		gamePanel.setSize(Global.WIDTH*Global.CELL_SIZE, Global.HIGHT*Global.CELL_SIZE);
		function.setSize(Global.WIDTH*Global.CELL_SIZE,100);
		this.setSize(Global.WIDTH*Global.CELL_SIZE+10, Global.HIGHT*Global.CELL_SIZE+100+35);
		gamePanel.addKeyListener(controller);
		snake.addSnakeListener(controller);
		this.addKeyListener(controller);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		controller.newGame();
	}
	public static void main(String[] args) {
		new MyGame();
	}
}
