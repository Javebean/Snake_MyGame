package com.example.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.example.util.Global;

public class Function extends JPanel{
	private JPanel scorePanel = null;
	private JPanel stratOrpause=null;
	private JPanel changeColor = null;
	private JPanel changeSpeed = null;
/*	private JButton jb1 = new JButton();
	private JButton jb2 = new JButton();
	private JButton jb3 = new JButton();*/
	private JLabel score;
	public Function(){
		scorePanel  =  new JPanel();
		stratOrpause = new JPanel();
		changeColor = new JPanel();
		changeSpeed = new JPanel();
		
		score = new JLabel();
		score.setSize(Global.CELL_SIZE*Global.WIDTH/2,50);
		scorePanel.add(score);
		score.setText("0");
		
		setLayout();
	}
	
	
	
	private void setLayout() {
		this.setLayout(new GridLayout(2, 2));
		this.add(scorePanel);
		this.add(stratOrpause);
		this.add(changeColor);
		this.add(changeSpeed);
	/*	stratOrpause.add(jb1);
		changeColor.add(jb2);
		changeSpeed.add(jb3);*/
		
		
		
	}



	public void addScore(){
		score.setText((Integer.parseInt(score.getText())+100)+"");
	}
	
	public void showYouAreDie(){
		score.setText("you are die!!");
	}
}
