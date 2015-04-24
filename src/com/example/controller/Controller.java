package com.example.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.example.listener.snakeListener;
import com.example.modle.Food;
import com.example.modle.Ground;
import com.example.modle.Snake;
import com.example.view.Function;
import com.example.view.gamePanel;

public class Controller extends KeyAdapter implements snakeListener {
	
	private Snake snake;
	private Food food;
	private Ground ground;
	private gamePanel gamepanel;
	private Function function;
	
	public Controller(Snake snake, Food food, Ground ground, gamePanel gamepanel, Function function) {
		super();
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.gamepanel = gamepanel;
		this.function = function;
	}


	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			snake.changeDirection(Snake.UP);
			break;
		case KeyEvent.VK_DOWN:
			snake.changeDirection(Snake.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			snake.changeDirection(Snake.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			snake.changeDirection(Snake.RIGHT);
			break;
		case KeyEvent.VK_PAGE_UP:
			snake.addSpeed();
			break;
		case KeyEvent.VK_PAGE_DOWN:
			snake.slowSpeed();
			break;
		default:
			break;
		}
	}


	@Override
	public void snakeMove(Snake snake) {
		if(food.isEatFood(snake)){
			function.addScore();
			snake.eatFood();
			food.newFood(snake.nextFood());
		}
		if(ground.isSnakeEatStock(snake)){
			snake.die();
			function.showYouAreDie();
		}
		if(snake.isEatBody()){
			snake.die();
			System.out.println("zz");
			function.showYouAreDie();
		}
		gamepanel.dispaly(snake, food, ground);
	}
	
	public void newGame(){
		snake.startMove();
		food.newFood(snake.nextFood());
	}
	
}
