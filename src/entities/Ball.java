package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import main.*;

public class Ball extends Entity{

	AppPanel appPanel;
	KeyBindings key;
	Player player;
	ArrayList<Blocks> blockList;
	Ball ball;
	boolean launched=false;
	public Ball(AppPanel appPanel, KeyBindings key,Player player,ArrayList<Blocks> blockList){
		this.blockList = blockList;
		this.appPanel = appPanel;
		this.key = key;
		this.player = player;
		setdefaults();
	}
	
	private void setdefaults() {
			this.width = appPanel.TILE_SIZE / 6;
	        this.height = appPanel.TILE_SIZE / 6;
	        this.x = player.x + player.width / 2 - this.width / 2;
	        this.y = player.y - this.height; 
	        this.speedx=8;
	        this.speedy=10;
	}
	
	public void update() {
		if (!launched) {
            this.x = player.x + player.width / 2 - this.width / 2;
            this.y = player.y - this.height;
            if (key.up) {
                launched = true;  
            }
        } else {
        		this.y -= speedy; 
        		this.x +=speedx;
        		bounceWall();
        		bounceBlock();
        		bouncePlayer();
            if (this.y +this.height> appPanel.SCREEN_HEIGHT) {
                launched = false;  
                setdefaults();      
                appPanel.Lives--;
            }
        }
	}
	
	public void bouncePlayer() {
		if((this.y+this.height>player.y)&&!(this.y<player.y+player.height)&&(this.x-this.width<player.x+player.width)&&(this.x>player.x)) {
			this.speedy*=-1;
		}
	}
	
	public void bounceWall() {
    	if(this.y<0) {
    		this.speedy*=-1;
    	}
    	if(this.x<0||this.x>appPanel.SCREEN_WIDTH-this.width) {
    		speedx*=-1;
    	}
	}
	
	public void bounceBlock() {
		  Iterator<Blocks> iterator = blockList.iterator(); // Assuming blockList contains objects of a class Block
		    while (iterator.hasNext()) {
		        Blocks item = iterator.next();
		        boolean collisionX = this.x + this.width > item.x && this.x < item.x + item.sizex;
		        boolean collisionY = this.y + this.height > item.y && this.y < item.y + item.sizey;
		        if(collisionX && collisionY) {
			        if (Math.abs(this.y + this.height - item.y) < Math.abs(this.x + this.width - item.x)) {
		                // Ball is colliding from the top or bottom of the block
//			        	speedy += 0.5;
		                speedy *= -1; // Reverse vertical speed
		            } else {
		                // Ball is colliding from the left or right of the block
//		            	speedx+=0.5;
		                speedx *= -1; // Reverse horizontal speed
		            }
			        iterator.remove();
			        appPanel.Score++;
			        break;
		        }
		    }
	}
	
	public void drawball(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x, y, width, height);
	}
}
