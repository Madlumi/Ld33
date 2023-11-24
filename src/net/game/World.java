package net.game;

import java.util.Random;

public class World {
	
	private static int w=Main.w,h=Main.h,buildN=0;
	public static int ts=32;
	private static int bL=1,xf,yf;
	private static int mapS=0,mapSy=509-h/32;
	public static int[] map = new int[8*1024];
	private static boolean mapM=true;
	private static Random R = new Random();
	public static void tick(){
		
		
		if(xf>0){
			xf--;
			Screen.xo++;
		}
		if(yf>0){
			yf--;
			Screen.yo++;
		}
		for(int i = 0;i<3;i++ ){
		if((Screen.xo+xf)%ts==0&&mapM){
			for(int y=0;y<9;y++){
				for(int x=0;x<1024;x++){
				//map[x+y*1024]=map[x+1+y*1024];
				}
			}
			mapS++;
			bL--;
			mapM=false;
			
		}
		if((int)Player.x-w/2>Screen.xo){
			Screen.xo++;
			
			mapM=true;
				
				
		}
		}
		
		if(bL<900){
			build();
		}
		
	}
	public static void build(){
		int type = R.nextInt(3);
		int ww=R.nextInt(3)+2;
		int hh=R.nextInt(5)+3;
		int doorL=R.nextInt(ww);
		int doorH=R.nextInt(2);
		int windowSpacing = R.nextInt(3);
		

		
		
		for(int y=0;y<hh;y++){
			for(int x=0;x<ww;x++){
				
				
				if((bL)+x+(5-y)*(1024)>0){
				map[(bL)+x+(5-y)*(1024)]=1;
				if(x==doorL&&y==doorH)map[(bL)+x+(5-y)*(1024)]=2;
				else if(x==doorL&&y==doorH-1)map[(bL)+x+(5-y)*(1024)]=101;
				else if(x==doorL+1&&y==doorH-1)map[(bL)+x+(5-y)*(1024)]=102;
				else if(x==doorL-1&&y==doorH-1)map[(bL)+x+(5-y)*(1024)]=103;
				else if(windowSpacing!=0){
					if(x%windowSpacing==0)map[(bL)+x+(5-y)*(1024)]=201;//window
				}else{
					map[(bL)+x+(5-y)*(1024)]=201;//window
				}
				}
			//map[5+x+(y*(w/4))]=1;
				
				
				
			}
		}
		
		buildN+=ww+1;
		
		bL+=ww+1;
		map[(bL-1)+(5)*(1024)]=-1;
		
		
		
	}
	public static void render(){
		for(int i = -2;i<w/ts+2;i++){
			Screen.renderTile(i*ts-Screen.xo%ts, h-64, Sprite.groundT, 99, true,false);
			Screen.renderTile(i*ts-Screen.xo%ts, h-32, Sprite.groundB, 99, true,false);
		}
		
		
		
		
		
		for(int y = 0;y<7;y++){
			for(int x = 0+mapS;x<w/32+mapS+3;x++){
				
				if(map[(x)+y*1024]<0){
					Screen.renderTile(x*ts, y*32-8, Sprite.fence, 100, false,false);
				}
				
				if(map[(x)+y*1024]>0){
					Screen.renderTile(x*ts, y*32-8, Sprite.wall, 100, false,false);
				}
				if(map[(x)+y*1024]==2){
					Screen.renderTile(x*ts, y*32-8, Sprite.door, 101, false,false);
				}
				if(map[(x)+y*1024]==201){
					Screen.renderTile(x*ts, y*32-8, Sprite.window, 101, false,false);
				}
				if(map[(x)+y*1024]==101){
					Screen.renderTile(x*ts, y*32-8, Sprite.stairTop, 102, false,false);
				}else if(map[(x)+y*1024]==102){
					Screen.renderTile(x*ts, y*32-8, Sprite.stair, 102, false,false);
				}else if(map[(x)+y*1024]==103){
					Screen.renderTile(x*ts, y*32-8, Sprite.stair, 102, false,true);
				}
			}
			//Screen.renderTile(i*16, h-16, Sprite.brick, 100, true,false);
		}
	}
	public static void shake(int i) {
		Screen.xo-=i;
		Screen.yo-=i;
		xf+=i;
		yf+=i;
		
	}
}
