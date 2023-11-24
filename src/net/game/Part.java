package net.game;

public class Part {
	public static int n=10000;
	public static int[] id= new int[n],type= new int[n],z= new int[n],life= new int[n];
	public static double[] x= new double[n],y= new double[n],xm= new double[n],ym= new double[n];
	public static boolean[] alive= new boolean[n], prior= new boolean[n];
	public static void spawn(int xx,int yy,int zz,int Type,double xmm,double ymm,boolean Prior,int lifeT){
		boolean done=false;
		for(int i = 0; i < n;i++){
			if(!alive[i]){
				x[i]=xx;
				y[i]=yy;
				xm[i]=xmm;
				ym[i]=ymm;
				type[i]=Type;
				z[i]=zz;
				prior[i]=Prior;
				id[i]=i;
				alive[i]=true;
				life[i]=lifeT;

				done=true;
				break;
			}
		}
		if(!done){
			for(int i = 0; i < n;i++){
				if(!prior[i]){
					x[i]=xx;
					y[i]=yy;
					xm[i]=xmm;
					ym[i]=ymm;
					type[i]=Type;
					z[i]=zz;
					prior[i]=Prior;
					id[i]=i;
					alive[i]=true;
					life[i]=lifeT;

					done=true;
					break;
				}
			}
		}
	}
	
	
	public static void tick(){
		for(int i = 0; i < n;i++){
			if(alive[i]){
				if(type[i]>100){
					ym[i]+=.05;
					
					if(y[i]>512*World.ts-16){
						ym[i]=0;
					}
				}
				if(type[i]==21){
					if(x[i]>Player.x&&x[i]<Player.x+16&&Player.fall<8){
						Player.dmg +=1;
						life[i]=0;
					}
				}
				if(type[i]==5){
					
					ym[i]*=1.01;
					
					if(y[i]>512*World.ts-16){
						life[i]=0;
					}
					for(int j =0;j<Human.n;j++){
						if(Human.alive[j]){
							if(x[i]>Human.x[j]&&x[i]<Human.x[j]+16){
						
								Human.dmg(j, Player.rdmg);
								life[i]=0;
							}
						}
					}
					
				}
				x[i]+=xm[i];
				y[i]+=ym[i];
				life[i]--;
				if(life[i]<=0){
					alive[i]=false;
				}
			}
		}
	}
	public static void render(){
		for(int i = 0; i < n;i++){
			if(alive[i]){
				if(type[i]==0){
					
					Screen.renderTile((int)x[i], (int)y[i], Sprite.airPart, z[i], false,false);
				}
				if(type[i]==1){
					
					Screen.renderTile((int)x[i], (int)y[i], Sprite.hit8, z[i], false,false);
				}

				if(type[i]==2){
					
					Screen.renderTile((int)x[i], (int)y[i], Sprite.hit16, z[i], false,false);
				}
				if(type[i]==5){
					
					Screen.renderTile((int)x[i], (int)y[i], Sprite.acidPart, z[i], false,false);
				}else if(type[i]==101){
					Screen.renderTile((int)x[i], (int)y[i], Sprite.blood, z[i], false,false);
				}else if(type[i]==102){
					Screen.renderTile((int)x[i], (int)y[i], Sprite.blood2, z[i], false,false);
				}else if(type[i]==103){
					Screen.renderTile((int)x[i], (int)y[i], Sprite.blood3, z[i], false,false);
				}else if(type[i]==21){
					Screen.renderTile((int)x[i], (int)y[i], Sprite.bullet, z[i], false,false);
				}
			}
		}
	}
}








