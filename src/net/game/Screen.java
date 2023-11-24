package net.game;


import java.util.Map;
import java.util.Random;

public class Screen {

	public static int width = Main.w, height =Main.h;
	
	public static int[] pixels,layer;

	
	private static Random random = new Random();

	public static int xo=48;

	public static int yo=0;
		
	public static void Screen(){
		layer  = new int[width * height];
		pixels  = new int[width * height];
		
	}
	
	public static void clear(int c){
		for (int i = 0;i<pixels.length;i++){
			pixels[i]=c;
		}
	}
	public static void renderTile(int xp, int yp, Sprite sprite,int z, boolean stat,boolean flip){
		/** test */
		if(!stat){
			xp-=xo;
		
		yp-=yo;
		}
		
		int ts=sprite.SIZE;
		
		for (int y = 0; y < sprite.SIZE; y++) {
			for (int x = 0; x < sprite.SIZE; x++) {

				if(flip){
					if((ts-x)+xp+(y+yp)*width>=0&&(ts-x)+xp+(y+yp)*width<pixels.length&&ts-x+xp<width&&ts-x+xp>=0){
					if(sprite.pixels[x + y * sprite.SIZE]!=0xffff00ff){						
						if(layer[(ts-x)+xp+(y+yp)*width]<z){	pixels[(ts-x)+xp+(y+yp)*width] = sprite.pixels[x + y * sprite.SIZE];
							layer[(ts-x)+xp+(y+yp)*width]=z;
						}
						
					}
					}
					
				}else{
					if((x)+xp+(y+yp)*width>=0&&(x)+xp+(y+yp)*width<pixels.length&&x+xp<width&&x+xp>=0){
						if(sprite.pixels[x + y * sprite.SIZE]!=0xffff00ff){						
							if(layer[(x)+xp+(y+yp)*width]<z){	pixels[(x)+xp+(y+yp)*width] = sprite.pixels[x + y * sprite.SIZE];
								layer[(x)+xp+(y+yp)*width]=z;
							}
							
						}
					}
				}
			}
		}
	
	}
	public static void renderGS(int xp, int yp, Sprite sprite,int z, boolean stat,boolean flip,int c1,int c2,int c3,int c4){
		/** test */
		xp-=xo;
		yp-=yo;
		
		
		int ts=sprite.SIZE;
		
		for (int y = 0; y < sprite.SIZE; y++) {
			for (int x = 0; x < sprite.SIZE; x++) {

				if(flip){
					if((ts-x)+xp+(y+yp)*width>=0&&(ts-x)+xp+(y+yp)*width<pixels.length&&ts-x+xp<width&&x+xp>=0){
					if(sprite.pixels[x + y * sprite.SIZE]!=0xffff00ff){						
						if(layer[(ts-x)+xp+(y+yp)*width]<z){	
							
							if(sprite.pixels[x + y * sprite.SIZE]==0xff333333){
								pixels[(ts-x)+xp+(y+yp)*width] = c1;
								
							}else if(sprite.pixels[x + y * sprite.SIZE]==0xff666666){
								pixels[(ts-x)+xp+(y+yp)*width] = c2;
								
							}else if(sprite.pixels[x + y * sprite.SIZE]==0xff999999){
								pixels[(ts-x)+xp+(y+yp)*width] = c3;
								
							}else if(sprite.pixels[x + y * sprite.SIZE]==0xff999999){
								pixels[(ts-x)+xp+(y+yp)*width] = c3;
								
							}else if(sprite.pixels[x + y * sprite.SIZE]==0xffcccccc){
								pixels[(ts-x)+xp+(y+yp)*width] = c4;
								
							}else{
								pixels[(ts-x)+xp+(y+yp)*width] = sprite.pixels[x + y * sprite.SIZE];
							}
							
							layer[(ts-x)+xp+(y+yp)*width]=z;
						}
						
					}
					}
					
				}else{
					if((x)+xp+(y+yp)*width>=0&&(x)+xp+(y+yp)*width<pixels.length&&x+xp<width&&x+xp>=0){
						if(sprite.pixels[x + y * sprite.SIZE]!=0xffff00ff){						
							if(layer[(x)+xp+(y+yp)*width]<z){	
								
								if(sprite.pixels[x + y * sprite.SIZE]==0xff333333){
									pixels[(x)+xp+(y+yp)*width] = c1;
									
								}else if(sprite.pixels[x + y * sprite.SIZE]==0xff666666){
									pixels[(x)+xp+(y+yp)*width] = c2;
									
								}else if(sprite.pixels[x + y * sprite.SIZE]==0xff999999){
									pixels[(x)+xp+(y+yp)*width] = c3;
									
								}else if(sprite.pixels[x + y * sprite.SIZE]==0xff999999){
									pixels[(x)+xp+(y+yp)*width] = c3;
									
								}else if(sprite.pixels[x + y * sprite.SIZE]==0xffcccccc){
									pixels[(x)+xp+(y+yp)*width] = c4;
									
								}else{
									pixels[(x)+xp+(y+yp)*width] = sprite.pixels[x + y * sprite.SIZE];
								}
								layer[(x)+xp+(y+yp)*width]=z;
							}
							
						}
					}
				}
			}
		}
	
	}
	
}









