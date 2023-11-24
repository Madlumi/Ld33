package net.game;

import java.util.Random;

public class Human {
	public static int n=50;
	public static int[] id= new int[n],type= new int[n],z= new int[n],life= new int[n],down= new int[n],
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

				c1[i]=colourPick(1);
				c2[i]=colourPick(1);
				c3[i]=colourPick(1);
				c4[i]=colourPick(1);
				
				
				break;
			}
		}
		
	}
	private static Random R = new Random();
	private static int colourPick(int i){
		int c= R.nextInt(8);
		if(c==0){
			return 0xff0000ff;
		}else if(c==1){
			return 0xff00ff00;
		}else if(c==2){
			return 0xffff0000;
		}else if(c==3){
			return 0xffffff00;
		}else if(c==4){
			return 0xffff00ff;
		}else if(c==5){
			return 0xff00ffff;
		}else if(c==6){
			return 0xff999999;
		}else if(c==7){
			return 0xff555555;
		}
		return 0xffffffff;
		
	}
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
							
							Part.spawn((int)x[i]+8, (int)y[i]+8, 1000, 1, 0, 0, true, 60);
							down[i]=60;xm[i]=0;
							Player.rage++;
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
				
				if(R.nextInt(60)==1){
					mov[i]=R.nextInt(3);
					if(mov[i]==0){
						xm[i]=0;
						ym[i]=0;
					}else if(mov[i]==1){
						xm[i]=.5;
					
						flip[i]=false;
					}else if(mov[i]==2){
						xm[i]=-.5;
						flip[i]=true;
						
						
					}
				}
				if(life[i]<=0){
					alive[i]=false;
					down[i]=-1;
					Player.exp++;
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
			Player.exp++;
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
				if(type[i]==0){
					if(down[i]>0){
						Screen.renderGS((int)x[i], (int)y[i]+16, Sprite.humMD2, z[i], false,flip[i],c1[i],c2[i],c3[i],c4[i]);
						Screen.renderGS((int)x[i]-16, (int)y[i]+16, Sprite.humMD1, z[i], false,flip[i],c1[i],c2[i],c3[i],c4[i]);
					}else if(mov[i]==0){
						Screen.renderGS((int)x[i], (int)y[i]+16, Sprite.humM2, z[i], false,flip[i],c1[i],c2[i],c3[i],c4[i]);
						Screen.renderGS((int)x[i], (int)y[i], Sprite.humM1, z[i], false,flip[i],c1[i],c2[i],c3[i],c4[i]);
					}else{
						if(Main.t%30<15){
							Screen.renderGS((int)x[i], (int)y[i]+16, Sprite.humMM2, z[i], false,flip[i],c1[i],c2[i],c3[i],c4[i]);
							Screen.renderGS((int)x[i], (int)y[i], Sprite.humMM1, z[i], false,flip[i],c1[i],c2[i],c3[i],c4[i]);
						}else{
						Screen.renderGS((int)x[i], (int)y[i]+16, Sprite.humM2, z[i], false,flip[i],c1[i],c2[i],c3[i],c4[i]);
						Screen.renderGS((int)x[i], (int)y[i], Sprite.humM1, z[i], false,flip[i],c1[i],c2[i],c3[i],c4[i]);
						}
						
					}
					
					
					
				}
			}
		}
	}
}








