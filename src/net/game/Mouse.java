package net.game;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener,MouseMotionListener{
	public static int x,y,b;

	public int getx(){
		
		return x;
		
	}
	public int gety(){
		
		return y;
		
	}
	public int getb(){
		
		return b;
		
	}
	
	public void mouseClicked(MouseEvent e) {
		b=e.getButton();

		x=e.getX();
		y=e.getY();
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		b=e.getButton();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		b=e.getButton();
		x=e.getX();
		y=e.getY();
	
		if(Main.menu){
			Ui.click(x,y,b);
		}
		//Build.clicked=false;
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		x=e.getX();
		y=e.getY();		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		x=e.getX();
		y=e.getY();		
		b=e.getButton();
		
		if(Main.menu||Main.k.q){
			Ui.hover(x,y,b);
		}
	}



}