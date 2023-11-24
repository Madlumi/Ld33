package net.game;

import java.util.Map;
import java.util.Random;
import java.util.logging.Level;


public class Player {

	public static double x=32,y=Main.h-48,size=1,speed=.7,spitSpeed=2,spitF=.3,hpR=2,jump;
	public static int exp=5,mxp=25,spitCool=0,spitCoolM=30,hp=40,dmgD=10,jumpM=32,jumpS=1,fall,jumpL,hpM=40,dmg=0,rdmg=2,dmgW=10,attackP=5,attackp1=10,attackp2=10,attackphase=0,att,spitSpread=10,spitLife=60,spitAmmount=20;
	public static boolean m= false,attacking=false,flip=false,roll=false;
	
	private static Random R = new Random();
	public static boolean backD;
	public static int rage;
	public static int c1=0xff00ff00,c2=0xff00ffff,c3=0xffffff00,c4=0xffff00ff;
	
	public static void tick(){
		if(hp<0){
			Main.menu=true;
		}
		
		if(Main.t%(30/hpR)==1&&hp<hpM){
			hp++;
		}
		if(spitCool>0){
			spitCool--;
		}
		
		if(jumpL>0){
			jumpL-=jumpS;
			y-=jumpS;
			fall+=jumpS;
		}else if(fall>0){
			fall-=jumpS;
			y+=jumpS;
			if(fall==0){
				World.shake(2*jumpS);
				for(int j =0;j<Human.n;j++){
					if(Human.alive[j]){
						if(x>Human.x[j]-16*jumpS&&x<Human.x[j]+24+16*jumpS){
					
							Human.dmg(j, 25);
							rage++;
						}
					}
				}
			

				for(int j =0;j<Tank.n;j++){
					if(Human.alive[j]){
						if(x>Tank.x[j]-16*jumpS&&x<Tank.x[j]+24+16*jumpS){
					
							Human.dmg(j, 25);
							rage++;
						}
					}
				}
				
				
				for(int j =0;j<Soldier.n;j++){
					if(Soldier.alive[j]){
						if(x>Soldier.x[j]-16*jumpS&&x<Soldier.x[j]+24+16*jumpS){
					
							Soldier.dmg(j, 25);
							rage++;
							
						}
					}
				}
			}
		}
		
		if(roll){if(Main.t%5==1)jumpL+=1;}
		
		if(Main.k.down&&!attacking&&Ui.skill[4]==2){		
			roll=true;
		}else{roll=false;
		}
		if(exp>=mxp&&Ui.level<4){
			exp=0;
			mxp*=2;
			Ui.level++;
			Main.menu=true;
			World.map[((int)x/World.ts)+(7)*(1024)]=-102;
		}
		if(Main.k.up&&!attacking&&jumpL<=0&&fall<=0){
			jumpL=jumpM;
		}
		
		if(Main.k.left&&!attacking){
			x-=speed;
			m=true;
			flip=true;
		}else if(Main.k.right&&!attacking){
			x+=speed;
			m=true;
			flip=false;
		}else{
			m=false;
		}
		
		if(Main.k.e&&!attacking&&spitCool<=0){
			for(int i=0;i<spitAmmount;i++){
				Part.spawn((int)x+8, (int)y+4, 1000, 5, spitSpeed+(double)(R.nextInt(3))/10, (double)(R.nextInt(spitSpread*2)-spitSpeed+1)/100+spitF, true, spitLife);
				
			}
			hp-=2;
			spitCool=spitCoolM;
		}
		if(Main.k.space&&!attacking){
			attacking=true;
			attackphase=1;
		}
		if(attacking){
			if(att<attackp1&&attackphase==1){
				att++;
				
			}else if(attackphase==1){
				attackphase=2;
					att=0;
				
			}else if(att<attackp2&&attackphase==2){
				att++;
				
			}else if(attackphase==2){
				attackphase=0;
				att=0;
				attacking=false;
				
			}
		}
		if(dmg>0){
			if(dmgW>0){
				dmgW--;
			}else{
				dmg--;
				hp--;
				dmgW=2;
				if(dmg<=0){
					dmgW=10;
				}
			}
			
		}
		
		
	}
	public static void render(){
		

		
		int xx=(int)x;
		int yy=(int)y;
		if(Ui.level==-1){
		if(attacking){
			if(attackphase==1){
				Screen.renderTile(xx, yy, Sprite.pl1_1A, 1000, false,flip);
				Screen.renderTile(xx, yy+16, Sprite.pl1_2A, 1000, false,flip);
			}else if(attackphase==2){
				Screen.renderTile(xx, yy, Sprite.pl1_1A2, 1000, false,flip);
				Screen.renderTile(xx, yy+16, Sprite.pl1_2A2, 1000, false,flip);
			}
		}else if(!m){
		Screen.renderTile(xx, yy, Sprite.pl1_1, 1000, false,flip);
		Screen.renderTile(xx, yy+16, Sprite.pl1_2, 1000, false,flip);
		}else{
			if(Main.t%(60/speed)<30/speed){
				Screen.renderTile(xx, yy, Sprite.pl1_1M, 1000, false,flip);
				Screen.renderTile(xx, yy+16, Sprite.pl1_2M, 1000, false,flip);
			}else{
				Screen.renderTile(xx, yy, Sprite.pl1_1, 1000, false,flip);
				Screen.renderTile(xx, yy+16, Sprite.pl1_2, 1000, false,flip);
			}
		}
		
		}else if(Ui.level==0){ 
			
			if(fall>0){
				Screen.renderGS(xx, yy+16, Sprite.pl2_2J, 1000, false,flip,c1,c2,c3,c4);
				Screen.renderGS(xx, yy-8, Sprite.pl2_1J, 1000, false,flip,c1,c2,c3,c4);
			}else if(attacking){
				 if(attackphase==1){
					 Screen.renderGS(xx, yy+16, Sprite.pl2_2A, 1000, false,flip,c1,c2,c3,c4);
						Screen.renderGS(xx, yy-8, Sprite.pl2_1A, 1000, false,flip,c1,c2,c3,c4);
				}else if(attackphase==2){
					Screen.renderGS(xx, yy+16, Sprite.pl2_2A2, 1000, false,flip,c1,c2,c3,c4);
					Screen.renderGS(xx, yy-8, Sprite.pl2_1A2, 1000, false,flip,c1,c2,c3,c4);
				}
			}else if(!m){
				
				
		
			Screen.renderGS(xx, yy+16, Sprite.pl2_2, 1000, false,flip,c1,c2,c3,c4);
			Screen.renderGS(xx, yy-8, Sprite.pl2_1, 1000, false,flip,c1,c2,c3,c4);
			}else{
				if(Main.t%(60/speed)<30/speed){
					Screen.renderGS(xx, yy+16, Sprite.pl2_2M, 1000, false,flip,c1,c2,c3,c4);
					Screen.renderGS(xx, yy-8, Sprite.pl2_1M, 1000, false,flip,c1,c2,c3,c4);
				}else{
					Screen.renderGS(xx, yy+16, Sprite.pl2_2, 1000, false,flip,c1,c2,c3,c4);
					Screen.renderGS(xx, yy-8, Sprite.pl2_1, 1000, false,flip,c1,c2,c3,c4);
				}
			}
			
			
			
	}else if(Ui.level==1) {
		
		

		if(fall>0){
			Screen.renderGS(xx, yy+16, Sprite.pl3_2J, 1000, false,flip,c1,c2,c3,c4);
			Screen.renderGS(xx, yy-8, Sprite.pl3_1J, 1000, false,flip,c1,c2,c3,c4);
		}else if(attacking){
			 if(attackphase==1){
				 Screen.renderGS(xx, yy, Sprite.pl3_2A, 1000, false,flip,c1,c2,c3,c4);
					Screen.renderGS(xx, yy-32, Sprite.pl3_1A, 1000, false,flip,c1,c2,c3,c4);
			}else if(attackphase==2){
				Screen.renderGS(xx, yy, Sprite.pl3_2A2, 1000, false,flip,c1,c2,c3,c4);
				Screen.renderGS(xx, yy-32, Sprite.pl3_1A2, 1000, false,flip,c1,c2,c3,c4);
			}
		}else if(!m){
			
			
	
		Screen.renderGS(xx, yy, Sprite.pl3_2, 1000, false,flip,c1,c2,c3,c4);
		Screen.renderGS(xx, yy-32, Sprite.pl3_1, 1000, false,flip,c1,c2,c3,c4);
		}else{
			if(Main.t%(60/speed)<30/speed){
				Screen.renderGS(xx, yy, Sprite.pl3_2M, 1000, false,flip,c1,c2,c3,c4);
				Screen.renderGS(xx, yy-32, Sprite.pl3_1M, 1000, false,flip,c1,c2,c3,c4);
			}else{
				Screen.renderGS(xx, yy, Sprite.pl3_2, 1000, false,flip,c1,c2,c3,c4);
				Screen.renderGS(xx, yy-32, Sprite.pl3_1, 1000, false,flip,c1,c2,c3,c4);
			}
		}
		
		
		
		
		
	}else if(Ui.level==2) {
		
		

		if(fall>0){
			Screen.renderGS(xx, yy+16, Sprite.pl4_2J, 1000, false,flip,c1,c2,c3,c4);
			Screen.renderGS(xx, yy-8, Sprite.pl4_1J, 1000, false,flip,c1,c2,c3,c4);
		}else if(attacking){
			 if(attackphase==1){
				 Screen.renderGS(xx, yy-16, Sprite.pl4_2A, 1000, false,flip,c1,c2,c3,c4);
					Screen.renderGS(xx, yy-64, Sprite.pl4_1A, 1000, false,flip,c1,c2,c3,c4);
			}else if(attackphase==2){
				Screen.renderGS(xx, yy-16, Sprite.pl4_2A2, 1000, false,flip,c1,c2,c3,c4);
				Screen.renderGS(xx, yy-64, Sprite.pl4_1A2, 1000, false,flip,c1,c2,c3,c4);
			}
		}else if(!m){
			
			
	
		Screen.renderGS(xx, yy-16, Sprite.pl4_2, 1000, false,flip,c1,c2,c3,c4);
		Screen.renderGS(xx, yy-64, Sprite.pl4_1, 1000, false,flip,c1,c2,c3,c4);
		}else{
			if(Main.t%(60/speed)<30/speed){
				Screen.renderGS(xx, yy-16, Sprite.pl4_2M, 1000, false,flip,c1,c2,c3,c4);
				Screen.renderGS(xx, yy-64, Sprite.pl4_1M, 1000, false,flip,c1,c2,c3,c4);
			}else{
				Screen.renderGS(xx, yy-16, Sprite.pl4_2, 1000, false,flip,c1,c2,c3,c4);
				Screen.renderGS(xx, yy-64, Sprite.pl4_1, 1000, false,flip,c1,c2,c3,c4);
			}
		}
		
		
		
		
		
}else{
		
		if(roll){
			if(Main.t%(10/speed)<5/speed){
				Screen.renderGS(xx, yy-64, Sprite.pl5_2R, 1000, false,flip,c1,c2,c3,c4);
			}else{
				Screen.renderGS(xx, yy-64, Sprite.pl5_1R, 1000, false,flip,c1,c2,c3,c4);

			}

		}else if(fall>0){
			Screen.renderGS(xx, yy+16, Sprite.pl5_2J, 1000, false,flip,c1,c2,c3,c4);
			Screen.renderGS(xx, yy-8, Sprite.pl5_1J, 1000, false,flip,c1,c2,c3,c4);
		}else if(attacking){
			 if(attackphase==1){
				 Screen.renderGS(xx, yy-32, Sprite.pl5_2A, 1000, false,flip,c1,c2,c3,c4);
					Screen.renderGS(xx, yy-96, Sprite.pl5_1A, 1000, false,flip,c1,c2,c3,c4);
			}else if(attackphase==2){
				Screen.renderGS(xx, yy-32, Sprite.pl5_2A2, 1000, false,flip,c1,c2,c3,c4);
				Screen.renderGS(xx, yy-96, Sprite.pl5_1A2, 1000, false,flip,c1,c2,c3,c4);
			}
		}else if(!m){
			
			
	
		Screen.renderGS(xx, yy-32, Sprite.pl5_2, 1000, false,flip,c1,c2,c3,c4);
		Screen.renderGS(xx, yy-96, Sprite.pl5_1, 1000, false,flip,c1,c2,c3,c4);
		}else{
			if(Main.t%(60/speed)<30/speed){
				Screen.renderGS(xx, yy-32, Sprite.pl5_2M, 1000, false,flip,c1,c2,c3,c4);
				Screen.renderGS(xx, yy-96, Sprite.pl5_1M, 1000, false,flip,c1,c2,c3,c4);
			}else{
				Screen.renderGS(xx, yy-32, Sprite.pl5_2, 1000, false,flip,c1,c2,c3,c4);
				Screen.renderGS(xx, yy-96, Sprite.pl5_1, 1000, false,flip,c1,c2,c3,c4);
			}
		}
	}
	}
	
}
