package com.example.modle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.example.listener.snakeListener;
import com.example.util.Global;


public class Snake {
	
	private boolean life = false;
	private LinkedList<Point> body = new LinkedList<Point>();
	private Set<snakeListener> listeners = new HashSet<snakeListener>();
	private int oldDirection;
	private int newDirection;
	public static final int UP = -1;
	public static final int DOWN = 1;
	public static final int LEFT = -2;
	public static final int RIGHT = 2;
	private Point tail;
	
	private int speed=600;
	
	public Snake(){
		init();
	}
	private void init() {
		int x = Global.WIDTH/2;
		int y = Global.HIGHT/2;
		body.addFirst(new Point(x, y));
		life =true;
		newDirection=oldDirection = RIGHT;
	}
	public void move(){
		if(oldDirection+newDirection!=0)
			oldDirection = newDirection;
		
		int x = this.getHead().x;
		int y = this.getHead().y;
		switch (oldDirection) {
		case UP:
			y--;
			break;
		case DOWN:
			y++;
			break;
		case LEFT:
			x--;
			break;
		case RIGHT:
			x++;
			break;

		default:
			break;
		}
		
		body.addFirst(new Point(x, y));
		tail = body.removeLast();
	}
	
	public void eatFood(){
		body.addLast(tail);
	}
	
	public void changeDirection(int direction){
		this.newDirection = direction;
	}
	
	public boolean isEatBody(){
		for(int x=1;x<body.size();x++)
			if(this.getHead().equals(body.get(x)))
				return true;
		return false;
	}
	
	public  void drawMe(Graphics g){
		g.setColor(Color.GREEN);
		for(Point p : body)
			g.fill3DRect(p.x*Global.CELL_SIZE, p.y*Global.CELL_SIZE, Global.CELL_SIZE, Global.CELL_SIZE, true);
	}
	public Point getHead(){
		return body.getFirst();
	}
	public class keepMove implements Runnable{

		@Override
		public void run() {
			while(life){
				move();
				for(snakeListener l : listeners)
					l.snakeMove(Snake.this);
				try {
					Thread.sleep(speed);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	public void die(){
		life = false;
	}
	
	public void startMove(){
		new Thread(new keepMove()).start();
	}
	public void addSnakeListener(snakeListener lis){
		if(lis!=null)
			listeners.add(lis);
	}
	
	public Point nextFood(){
		Point nf = null;
		do{
			int x = (int)(Math.random()*(Global.WIDTH-2))+1;
			int y = (int)(Math.random()*(Global.HIGHT-2))+1;
			nf = new Point(x, y);
		}while(body.contains(nf));
		return nf;
	}
	
	public void addSpeed(){
		System.out.println(speed);
		speed-=100;
	}
	public void slowSpeed(){
		speed+=100;
	}
}
