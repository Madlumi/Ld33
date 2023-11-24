package net.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Key implements KeyListener{


		public boolean[] keys = new boolean [600];
		public boolean left,right,up,down,space,enter,confirm,esc,shift,
		one,two,three,four,five,six,seven,eight,nine,zero,q,e,plus,minus,g,t,delete,qm;
		
		public void tick(){
			left = keys[KeyEvent.VK_A]||keys[KeyEvent.VK_LEFT]||keys[KeyEvent.VK_NUMPAD4]||keys[KeyEvent.VK_NUMPAD7]||keys[KeyEvent.VK_NUMPAD1];
			up = keys[KeyEvent.VK_W]||keys[KeyEvent.VK_UP]||keys[KeyEvent.VK_NUMPAD7]||keys[KeyEvent.VK_NUMPAD8]||keys[KeyEvent.VK_NUMPAD9];
			down = keys[KeyEvent.VK_S]||keys[KeyEvent.VK_DOWN]||keys[KeyEvent.VK_NUMPAD1]||keys[KeyEvent.VK_NUMPAD2]||keys[KeyEvent.VK_NUMPAD3];
			right = keys[KeyEvent.VK_D]||keys[KeyEvent.VK_RIGHT]||keys[KeyEvent.VK_NUMPAD9]||keys[KeyEvent.VK_NUMPAD6]||keys[KeyEvent.VK_NUMPAD3];
			space = keys[KeyEvent.VK_SPACE];
			enter = keys[KeyEvent.VK_ENTER];
			e = keys[KeyEvent.VK_E];
			q = keys[KeyEvent.VK_Q];
			for (int i =0; i < keys.length; i++){
				if (keys[i]);
			}
		}
		public void keyPressed(KeyEvent e) {

			keys[e.getKeyCode()] = true;
		}

		
		public void keyReleased(KeyEvent e) {
			
			keys[e.getKeyCode()] = false;
		}

		
		public void keyTyped(KeyEvent e) {
			
			//System.out.println(e.getKeyChar());
		}
}
