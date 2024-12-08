package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import entities.*;

import javax.swing.JPanel;

public class AppPanel extends JPanel implements ActionListener{
	
	private Timer timer;
	public final int TILE_SIZE = 100;
	public final int COLUMNS = 8;
	public final int ROWS = 7;
	public final int SCREEN_HEIGHT = TILE_SIZE * ROWS;
	public final int SCREEN_WIDTH = TILE_SIZE * COLUMNS;
	public final int DELAY = 16;
	public static int Score = 0;
	public static int Lives = 0;
	
	Player player;
	Ball ball;
	ArrayList<Blocks> blockList;
	KeyBindings key;
	
	boolean isRunning = false,gameOver = false;

	AppPanel(){
		System.out.println("Called");
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		key = new KeyBindings();
		player = new Player(this,key,ball);
		blockList = new ArrayList<>();
		blockList.add(new Blocks(this));
		addBlocks();
		ball = new Ball(this,key,player,blockList);
		this.setFocusable(true);
		this.addKeyListener(key);
		startGame();
	}

	public void startGame() {
		timer = new Timer(DELAY,this);
		timer.start();
	}
	
	public void update() {
		player.update();
		ball.update();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		player.drawPlayer(g);
		ball.drawball(g);
		for(var blocks:blockList) {
			blocks.drawBlocks(g);
		};
		g.setColor(Color.black);
		g.setFont(new Font("Ink Free", Font.BOLD, 35));
		g.drawString("Score : " +Score , TILE_SIZE/4, TILE_SIZE/4+10);
		g.drawString("Lives : " +Lives , SCREEN_WIDTH-2*TILE_SIZE, TILE_SIZE/4+10);
	}
	
	public void addBlocks() {
		for(int i = 0;i<(12*COLUMNS)+3;i++) {
			blockList.add(new Blocks(blockList.getLast(),this));
		}
	}
	

	public void gameover() {
		if(Lives==-1) {
			gameOver = true;
		}
	}
	
	public void restartgame() {
		if(gameOver&&KeyBindings.R) {
			System.out.println("Called");
			gameOver=false;
			Score=0;
			Lives=4;
			blockList.clear();
			blockList.add(new Blocks(this));
			addBlocks();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(!gameOver) {
			update();
		}	
		gameover();
		restartgame();
		repaint();
	}
	
}
