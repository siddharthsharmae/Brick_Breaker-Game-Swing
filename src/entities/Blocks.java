package entities;

import java.awt.Color;
import java.awt.Graphics;

import main.AppPanel;

public class Blocks extends Entity{

	AppPanel appPanel;

	
	public Blocks(AppPanel appPanel){
		this.appPanel = appPanel;
		this.x = appPanel.TILE_SIZE/4;
		this.y = appPanel.TILE_SIZE/2;
		this.sizex = appPanel.TILE_SIZE/4;
		this.sizey=appPanel.TILE_SIZE/4;
	}
	
	public Blocks(Blocks block,AppPanel appPanel) {
		this.appPanel = appPanel;
		this.sizex = appPanel.TILE_SIZE/4;
		this.sizey=appPanel.TILE_SIZE/4;
		this.x+=block.x+sizex+5;
		if(this.x<appPanel.SCREEN_WIDTH-sizex) {
			this.y+=block.y;
		}
		else {
			this.x = appPanel.TILE_SIZE/4;
			this.y = block.y + sizey +5;
		}
	}
	
	public void collision() {
		
	}
	
	
	
	public void update(int rows,int cols) {
		
	}
	
//	public void drawAllBlocks(Graphics g) {
//		for(int i = 0;i<appPanel.SCREEN_WIDTH-sizex;i+=sizex+15) {
//			for(int j = 0;j<6*sizey;j+=sizey+15) {
//				x=i;
//				y=j;
//				drawBlocks(g);
//			}
//		}
//	}
	
	public void drawBlocks(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, sizex, sizey);
//		x+=sizex+5;
//		if(sizex<appPanel.SCREEN_WIDTH) {
//			y+=sizey+5;
//			x=0;
//		}
	}
}
