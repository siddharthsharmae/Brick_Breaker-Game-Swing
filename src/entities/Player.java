package entities;

import java.awt.Color;
import java.awt.Graphics;

import main.AppPanel;
import main.KeyBindings;

public class Player extends Entity {
	AppPanel appPanel;
	KeyBindings key;
	boolean ownmove=true;
	Ball ball;
	
	public Player(AppPanel appPanel,KeyBindings key,Ball ball){
		this.appPanel = appPanel;
		this.key = key;
		setdefaultvalues();
	}
	
	public void setdefaultvalues() {
		this.x = appPanel.SCREEN_WIDTH/2;
		this.y=appPanel.SCREEN_HEIGHT-appPanel.TILE_SIZE/2;
		this.width = appPanel.TILE_SIZE+25;
		this.height = appPanel.TILE_SIZE/4;
	}
	public void update() {
		if(!key.up && ownmove) {
			if(x>(appPanel.SCREEN_WIDTH-this.width)) {
				movex=false;
			}
			if(x<0) {
				movex=true;
			}
			if(movex) {
				x+=speedx;
			}
			else {
				x-=speedx;
			}
			}
		else {
		ownmove=false;
		}
		
		if(key.right && !(this.x>appPanel.SCREEN_WIDTH-this.width)) {
			x+=this.speedx;
		}
		 if(key.left && !(this.x<0)) {
			x-=this.speedx;
		}
		 
	}
	public void drawPlayer(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
	}
}
