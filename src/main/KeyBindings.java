package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBindings implements KeyListener{
	public static boolean up=false,down=false,left=false,right=false,R=false;
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if(key==KeyEvent.VK_LEFT) left = true;
		if(key==KeyEvent.VK_RIGHT) right = true;
		if(key==KeyEvent.VK_UP) up = true;
		if(key==KeyEvent.VK_DOWN) down = true;
		if(key==KeyEvent.VK_R) R = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if(key==KeyEvent.VK_LEFT) left = false;
		if(key==KeyEvent.VK_RIGHT) right = false;
		if(key==KeyEvent.VK_UP) up = false;
		if(key==KeyEvent.VK_DOWN) down = false;
	}

}
