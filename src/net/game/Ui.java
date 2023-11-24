package net.game;

public class Ui {

	
	
	public static int[] skillx=new int[15],skilly=new int[15],skill=new int[5];
	public static int level=-1;
	private static boolean rendertxt;
	private static int txt;
	public static void render(){
		for(int i= 0; i<Player.hpM/4;i++){
			Screen.renderTile(i*8+(Player.hpM%4)*2, 0, Sprite.hpE, 3000, true,false);
		}
		Screen.renderTile(-(8-(Player.hpM%4)*2), 0, Sprite.hpE, 3000, true,false);
		
		for(int i= 0; i<Player.hp/4;i++){
			Screen.renderTile(i*8+(Player.hp%4)*2, 0, Sprite.hpD, 3001, true,false);
		}
		Screen.renderTile(-(8-(Player.hp%4)*2), 0, Sprite.hpD, 3001, true,false);
		
		for(int i= 0; i<(Player.hp-Player.dmg)/4;i++){
			Screen.renderTile(i*8+((Player.hp-Player.dmg)%4)*2, 0, Sprite.hpF, 3002, true,false);
		}
		Screen.renderTile(-(8-((Player.hp-Player.dmg)%4)*2), 0, Sprite.hpF, 3002, true,false);
	}

	

	public static void upgradeMT() {
		
		
	}
	public static void upgradeMR() {
		
		
		
		if(rendertxt){
			if(txt==00)Screen.renderTile(Main.m.getx()/3+3, Main.m.gety()/3+3, Sprite.txt00, 10004, true, false);
			if(txt==01)Screen.renderTile(Main.m.getx()/3+3, Main.m.gety()/3+3, Sprite.txt01, 10004, true, false);
			if(txt==02)Screen.renderTile(Main.m.getx()/3+3, Main.m.gety()/3+3, Sprite.txt02, 10004, true, false);

			if(txt==10)Screen.renderTile(Main.m.getx()/3+3, Main.m.gety()/3+3, Sprite.txt10, 10004, true, false);
			if(txt==11)Screen.renderTile(Main.m.getx()/3+3, Main.m.gety()/3+3, Sprite.txt11, 10004, true, false);
			if(txt==12)Screen.renderTile(Main.m.getx()/3+3, Main.m.gety()/3+3, Sprite.txt12, 10004, true, false);

			if(txt==20)Screen.renderTile(Main.m.getx()/3+3, Main.m.gety()/3+3, Sprite.txt20, 10004, true, false);
			if(txt==21)Screen.renderTile(Main.m.getx()/3+3, Main.m.gety()/3+3, Sprite.txt21, 10004, true, false);
			if(txt==22)Screen.renderTile(Main.m.getx()/3+3, Main.m.gety()/3+3, Sprite.txt22, 10004, true, false);

			if(txt==30)Screen.renderTile(Main.m.getx()/3+3, Main.m.gety()/3+3, Sprite.txt30, 10004, true, false);
			if(txt==31)Screen.renderTile(Main.m.getx()/3+3, Main.m.gety()/3+3, Sprite.txt31, 10004, true, false);
			if(txt==32)Screen.renderTile(Main.m.getx()/3+3, Main.m.gety()/3+3, Sprite.txt32, 10004, true, false);

			if(txt==40)Screen.renderTile(Main.m.getx()/3+3, Main.m.gety()/3+3, Sprite.txt40, 10004, true, false);
			if(txt==41)Screen.renderTile(Main.m.getx()/3+3, Main.m.gety()/3+3, Sprite.txt41, 10004, true, false);
			if(txt==42)Screen.renderTile(Main.m.getx()/3+3, Main.m.gety()/3+3, Sprite.txt42, 10004, true, false);

		}
		int xx=16;
		int yy=16;
		Screen.renderTile(xx, yy, Sprite.uppmenu, 10000, true, false);
		Screen.renderTile(xx, yy, Sprite.uppmenu, 10000, true, false);

		
		Screen.renderTile(skillx[0]+xx, skilly[0]+yy, Sprite.stoneskin, 10001, true, false);
		Screen.renderTile(skillx[1]+xx, skilly[1]+yy, Sprite.lavaskin, 10001, true, false);
		Screen.renderTile(skillx[2]+xx, skilly[2]+yy, Sprite.noskin, 10001, true, false);
		
		Screen.renderTile(skillx[3]+xx, skilly[3]+yy, Sprite.nofood, 10001, true, false);
		Screen.renderTile(skillx[4]+xx, skilly[4]+yy, Sprite.acid, 10001, true, false);
		Screen.renderTile(skillx[5]+xx, skilly[5]+yy, Sprite.fastfire, 10001, true, false);
		
		Screen.renderTile(skillx[6]+xx, skilly[6]+yy, Sprite.back, 10001, true, false);
		Screen.renderTile(skillx[7]+xx, skilly[7]+yy, Sprite.born, 10001, true, false);
		Screen.renderTile(skillx[8]+xx, skilly[8]+yy, Sprite.stronglegs, 10001, true, false);
		
		Screen.renderTile(skillx[9]+xx, skilly[9]+yy, Sprite.exoskel, 10001, true, false);
		Screen.renderTile(skillx[10]+xx, skilly[10]+yy, Sprite.knifeh, 10001, true, false);
		Screen.renderTile(skillx[11]+xx, skilly[11]+yy, Sprite.alum, 10001, true, false);
		
		Screen.renderTile(skillx[12]+xx, skilly[12]+yy, Sprite.spikearm, 10001, true, false);
		Screen.renderTile(skillx[13]+xx, skilly[13]+yy, Sprite.chainacid, 10001, true, false);
		Screen.renderTile(skillx[14]+xx, skilly[14]+yy, Sprite.roll, 10001, true, false);
		for(int i = 0;i<4-level;i++){
			Screen.renderTile(skillx[14-i*3]+xx, skilly[14-i*3]+yy, Sprite.locked, 10002, true, false);
			Screen.renderTile(skillx[13-i*3]+xx, skilly[13-i*3]+yy, Sprite.locked, 10002, true, false);
			Screen.renderTile(skillx[12-i*3]+xx, skilly[12-i*3]+yy, Sprite.locked, 10002, true, false);
		}
		for(int i = 0;i<level;i++){
			if(skill[i]!=0)Screen.renderTile(skillx[0+i*3]+xx, skilly[0+i*3]+yy, Sprite.locked, 10002, true, false);
			if(skill[i]!=1)Screen.renderTile(skillx[1+i*3]+xx, skilly[1+i*3]+yy, Sprite.locked, 10002, true, false);
			if(skill[i]!=2)Screen.renderTile(skillx[2+i*3]+xx, skilly[2+i*3]+yy, Sprite.locked, 10002, true, false);
		}
		if(!Main.menu){
			if(skill[level]!=0)Screen.renderTile(skillx[0+level*3]+xx, skilly[0+level*3]+yy, Sprite.locked, 10002, true, false);
			if(skill[level]!=1)Screen.renderTile(skillx[1+level*3]+xx, skilly[1+level*3]+yy, Sprite.locked, 10002, true, false);
			if(skill[level]!=2)Screen.renderTile(skillx[2+level*3]+xx, skilly[2+level*3]+yy, Sprite.locked, 10002, true, false);
		}

	}



	public static void ini() {
		int skilln=0;
		for(int y = 0;y<128;y++){
			for(int x = 0;x<128;x++){
				
				if(Sprite.uppmenu.pixels[x+y*128]==0xff0000ff){
					
					skillx[skilln]=x;
					skilly[skilln]=y;
					skilln++;
				}
			}
		}
	}



	public static void click(int x, int y, int b) {
		x-=48;
		y-=48;
		if(y/3>(skilly[(level)*3])&&y/3<(skilly[(level)*3]+16)){
			if(x/3>(skillx[(level)*3])&&x/3<(skillx[(level)*3]+16)){
				
				skill[level]=0;
				learn(level*10);
				Main.menu=false;
			}
			if(x/3>(skillx[(level)*3+1])&&x/3<(skillx[(level)*3+1]+16)){
				skill[level]=1;
				learn(level*10+1);
				Main.menu=false;

			}
			if(x/3>(skillx[(level)*3+2])&&x/3<(skillx[(level)*3+2]+16)){
				skill[level]=2;
				learn(level*10+2);
				Main.menu=false;

			}
			
			
		}
		
		
	}



	private static void learn(int i) {
		if(i==00){
			Player.hpM*=1.5;
			Player.c1=0xff333333;
			Player.c2=0xff555555;
			Player.c3=0xff999999;
			Player.c4=0xffaaaaaa;
			
		}else if(i==01){
			Player.dmg+=5;
			Player.c1=0xffff0000;
			Player.c2=0xffff2200;
			Player.c3=0xffaa0000;
			Player.c4=0xffff4400;
		}else if(i==02){
			Player.speed+=0.3;
			
			Player.c1=0xff880000;
			Player.c2=0xff770000;
			Player.c3=0xffaa0000;
			Player.c4=0xffffffff;
		}else if(i==10){
			Player.hpR+=2.;
			
			
			
		}else if(i==11){
			Player.rdmg+=3;
		}else if(i==12){
			Player.spitCoolM/=4;
			
			
		}else if(i==20){
			Player.backD=true;
		}else if(i==21){
			Player.rage*=2;
		}else if(i==22){
			Player.jumpM*=2;
			Player.jumpS*=2;
			
		}else if(i==30){
			Player.hpM*=3;
			}else if(i==31){
			Player.dmg+=10;
		}else if(i==32){
			Player.speed*=2;
		}
			
		
		
	}



	public static void hover(int x, int y, int b) {
		x-=48;
		y-=48;
		rendertxt=false;
		for(int i= 0;i<5;i++){
			if(y/3>(skilly[(i)*3])&&y/3<(skilly[(i)*3]+16)){
				if(x/3>(skillx[(i)*3])&&x/3<(skillx[(i)*3]+16)){
					rendertxt=true;
					txt=10*i+0;
					
				}
				if(x/3>(skillx[(i)*3+1])&&x/3<(skillx[(i)*3+1]+16)){
					rendertxt=true;

					txt=10*i+1;
				}
				if(x/3>(skillx[(i)*3+2])&&x/3<(skillx[(i)*3+2]+16)){
					rendertxt=true;

					txt=10*i+2;
				}
				
				
				//System.out.println(Main.t);
			}
		}
		
		
	}
}

