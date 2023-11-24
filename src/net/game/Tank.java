package net.game;

import java.util.Random;

public class Tank {
	public static int n=5;
	public static int[] id= new int[n],type= new int[n],z= new int[n],life= new int[n],down= new int[n],shoot= new int[n],
			c1 = new int[n],c2 = new int[n],c3 = new int[n],c4 = new int[n],mov = new int[n];
	public static double[] x= new double[n],y= new double[n],xm= new double[n],ym= new double[n];
	public static boolean[] alive= new boolean[n],sex= new boolean[n],flip= new boolean[n];
	public static void spawn(int xx,int yy,int zz,int diff,int lifeT){
		
		for(int i = 0; i < n;i++){
			if(!alive[i]){
				x[i]=xx;
				y[i]=yy;
				type[i]=0;
				z[i]=zz;
			
				id[i]=i;
				alive[i]=true;
				life[i]=lifeT;

				c1[i]=0xff003900;
				c2[i]=0xfff1ca9b;
				c3[i]=0xff003900;
				c4[i]=0xff007f00;
				
				
				break;
			}
		}
		
	}
	private static Random R = new Random();
	
	public static void tick(){
		
		for(int i = 0; i < n;i++){
			if(alive[i]){
				if(x[i]<Screen.xo)life[i]=0;
				if(down[i]>0){
					
					down[i]--;
					xm[i]=0;
					ym[i]=0;
					flip[i]=false;
				}
				if(Player.attackphase==2){
					if(Player.flip){
						if(x[i]<Player.x&&x[i]>Player.x-16){
							life[i]-=Player.dmgD;
							Player.rage++;
							Part.spawn((int)x[i]+8, (int)y[i]+8, 1000, 1, 0, 0, true, 60);
							down[i]=60;xm[i]=0;
							ym[i]=0;
						}
					}else{
						if(x[i]>Player.x&&x[i]<Player.x+32){
							life[i]-=Player.dmgD;
							Player.rage++;
							
							Part.spawn((int)x[i]+8, (int)y[i]+8, 1000, 1, 0, 0, true, 60);
							down[i]=60;xm[i]=0;
							ym[i]=0;
						}
					}
				}
				if(x[i]>Player.x+16){
					x[i]+=xm[i];
				}else{
					x[i]+=.1;
				}
				y[i]+=ym[i];
				
				
				if(shoot[i]<=0){
					Part.spawn((int)x[i], (int)y[i], 1010, 21, -1.5, 0, true, 600);
					shoot[i]=60;
				}
				
				if(shoot[i]>0){
					shoot[i]--;
				}
				
				if(life[i]<=0){
					alive[i]=false;
					down[i]=-1;
					Player.exp+=5;
					for(int l = 0; l<100;l++){
						Part.spawn((int)x[i], (int)y[i], 1000, 101, (double)(R.nextInt(40)-20)/10, (double)(R.nextInt(40)-20)/10, false, R.nextInt(120));
						Part.spawn((int)x[i], (int)y[i], 1000, 102, (double)(R.nextInt(40)-20)/10, (double)(R.nextInt(40)-20)/10, false, R.nextInt(120));
						
			

					}
				}
			}
		}
	}
	public static void dmg(int id, int dmg){
		System.out.println(life[id]);
		life[id]=life[id]-dmg;
		System.out.println(life[id]);
		for(int l = 0; l<2;l++){
			Part.spawn((int)x[id], (int)y[id], 1000, 101, (double)(R.nextInt(40)-20)/10, (double)(R.nextInt(40)-20)/10, false, R.nextInt(120));
		}
		if(life[id]<=0){
			alive[id]=false;
			down[id]=-1;
			Player.exp+=5;
			for(int l = 0; l<100;l++){
				Part.spawn((int)x[id], (int)y[id], 1000, 101, (double)(R.nextInt(40)-20)/10, (double)(R.nextInt(40)-20)/10, false, R.nextInt(120));
				Part.spawn((int)x[id], (int)y[id], 1000, 102, (double)(R.nextInt(40)-20)/10, (double)(R.nextInt(40)-20)/10, false, R.nextInt(120));
				
	

			}
		}
		down[id]=60;
		xm[id]=0;
		ym[id]=0;
	}
	public static void render(){
		for(int i = 0; i < n;i++){
			if(alive[i]){
				Screen.renderGS((int)x[i], (int)y[i]-64, Sprite.tank, z[i], false,flip[i],c1[i],c2[i],c3[i],c4[i]);
			}
		}
	}
}








