package net.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;





	



	public class Main extends Canvas implements Runnable{
		private static final long serialVersionUID = 1L;
		
		
		public static int w = 1023/3;
		public static int h = 639/3,tileS=16;
		public static int scale =3,t,th,tm,ts;

		//public static boolean t2m=false,t22=true,gameTime=true;;
		
		
		
		public static int fps, ups,bC = 0,kam=0;
		
		public static Thread thread;
		private JFrame frame;
			
		public static boolean showStats=true;

		
		
		public static int mob = 0;
		
		
		private boolean running = false;
		public boolean deBug = false;
			
		
		
		
		
		
		public static Random R=  new Random();
		
		private BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		
		
		
		
		
		
		public Main(){
			Dimension size = new Dimension(w * scale, h * scale);
			setPreferredSize(size);
			
			frame = new JFrame();

			
		}
		
		
		public synchronized void stop(){
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//TODO add mouse and keyboard
		public static 	Key k = new Key();
		public static 	Mouse m = new Mouse();


		public static boolean menu;
		public void run(){
			
			long lastTime = System.nanoTime();
			long timer =  System.currentTimeMillis();
			final double ns = 1000000000.0 / 60.0;
			double delta = 0;
			int frames = 0;
			int ticks = 0;
			requestFocus();	
			Screen.Screen();
			addKeyListener(k);
			addMouseListener(m);
			addMouseMotionListener(m);
			//TODO add listeners
			Ui.ini();
		
			while (running){
				
				long now = System.nanoTime();
				delta += (now - lastTime) / ns;
				lastTime = now;
				
				while (delta >= 1){
					tick();
					
					t+=1;
					if(t%60==0){
						ts++;
					}
					if(ts>=60){
						tm++;
						ts=0;
					}
					if(tm>=60){
						th++;
						tm=0;
					}
					ticks ++;
					delta --;
				}
				render();
				frames++;
				
				if (System.currentTimeMillis() - timer > 1000){
					timer += 1000;
					ups = ticks;
					fps = frames;
					ticks = 0;
					frames = 0;

				}

			}
			stop();
		}
		public void tick(){
			k.tick();
		
			if(menu){
				Ui.upgradeMT();
			}else{
			Player.tick();
			
			Part.tick();
			Human.tick();
			World.tick();
			Soldier.tick();
			Tank.tick();
			 if(R.nextInt(64)==1){
					Human.spawn(Screen.xo+w+16, h-48, 1000, 1, 50);
			}
			 if(R.nextInt(100)==1&&Ui.level>=0){
				Soldier.spawn(Screen.xo+w+16, h-48, 1000, 1, 150);
			}
			 if(R.nextInt(196)==1&&Ui.level>=1){
			 Tank.spawn(Screen.xo+w+16, h-48, 1000, 1, 500);
			 }
			}
			
		}
		

		

		public void render(){
			
			BufferStrategy bs = getBufferStrategy();
			if (bs == null){
				createBufferStrategy(2);
				return;
			}	
			Screen.clear(0xff3333aa);
			if(menu||k.q){
				Ui.upgradeMR();
			}
			Player.render();
			World.render();
			Ui.render();
			Part.render();
			Human.render();
			Soldier.render();
			Tank.render();
			if(Player.hp<=0){
				Screen.renderTile(64, 10, Sprite.dead, 10020, true,false);

			}
			for(int i = 0;i<w;i++){
				
				Screen.pixels[h*w-w+i]=0xffaaaaaa;
				Screen.pixels[h*w-2*w+i]=0xffaaaaaa;
				Screen.pixels[h*w-3*w+i]=0xffaaaaaa;
			}
			for(int j = 0;j<(w/100)*Player.exp;j++){
					if(h*w-w+j<w*h)Screen.pixels[h*w-w+j]=0xff0000ff;
					if(h*w-w+j<w*h)Screen.pixels[h*w-2*w+j]=0xff7777ff;
			}
			for (int i = 0;i < pixels.length; i++){
				pixels[i] = Screen.pixels[i];
				Screen.layer[i]=0;
			}
			
			Graphics g = bs.getDrawGraphics();
			
			
			g.drawImage(image, 0, 0, getWidth(), getHeight(),null);
			g.setColor(Color.white);
			
			g.dispose();
			bs.show();
		}
		
		
		
		
		
		public static void main(String[] args){
			Main m = new Main();
			m.frame.setResizable(false);
			m.frame.setTitle("LD33");
			m.frame.add(m);
			m.frame.pack();
			m.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			m.frame.setLocationRelativeTo(null);
			m.frame.setVisible(true);
			m.start();
		}


		public synchronized void start (){
			running = true;
			thread = new Thread(this, "	Main");
			thread.start();
		}


		public static void mbutt() {
			

		}
		
	
}
