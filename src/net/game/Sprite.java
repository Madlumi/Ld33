package net.game;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	
	public static Sprite brick = new Sprite(16, 0, 0, SpriteSheet.tiles);	
	public static Sprite wall = new Sprite(32, 0, 0, SpriteSheet.enviorment);	
	public static Sprite stairTop = new Sprite(32, 1, 0, SpriteSheet.enviorment);	
	public static Sprite stair = new Sprite(32, 2, 0, SpriteSheet.enviorment);	

	public static Sprite window = new Sprite(32, 0, 1, SpriteSheet.enviorment);	

	public static Sprite door = new Sprite(32, 1, 1, SpriteSheet.enviorment);	
	public static Sprite fence = new Sprite(32, 2, 1, SpriteSheet.enviorment);	
	public static Sprite soda = new Sprite(32, 0, 2, SpriteSheet.enviorment);	
	public static Sprite sodaE = new Sprite(32, 1, 2, SpriteSheet.enviorment);	
	
	public static Sprite groundT = new Sprite(32, 0, 3, SpriteSheet.enviorment);	
	public static Sprite groundB = new Sprite(32, 0, 4, SpriteSheet.enviorment);	

	public static Sprite pl1_1 = new Sprite(16, 1, 0, SpriteSheet.tiles);	
	public static Sprite pl1_2 = new Sprite(16, 1, 1, SpriteSheet.tiles);	
	
	public static Sprite pl3_1 = new Sprite(32, 0, 0, SpriteSheet.player3);	
	public static Sprite pl3_2 = new Sprite(32, 0, 1, SpriteSheet.player3);	
	public static Sprite pl3_1M = new Sprite(32, 1, 0, SpriteSheet.player3);	
	public static Sprite pl3_2M = new Sprite(32, 1, 1, SpriteSheet.player3);	
	
	public static Sprite pl3_1A = new Sprite(32, 2, 0, SpriteSheet.player3);	
	public static Sprite pl3_2A = new Sprite(32, 2, 1, SpriteSheet.player3);	
	public static Sprite pl3_1A2 = new Sprite(32, 3, 0, SpriteSheet.player3);	
	public static Sprite pl3_2A2 = new Sprite(32, 3, 1, SpriteSheet.player3);	
	
	//public static Sprite pl3_1J = new Sprite(32, 9, 0, SpriteSheet.player3);	
	//public static Sprite pl3_2J = new Sprite(32, 9, 1, SpriteSheet.player3);
	
	public static Sprite pl4_1 = new Sprite(48, 0, 0, SpriteSheet.player4);	
	public static Sprite pl4_2 = new Sprite(48, 0, 1, SpriteSheet.player4);	
	public static Sprite pl4_1M = new Sprite(48, 1, 0, SpriteSheet.player4);	
	public static Sprite pl4_2M = new Sprite(48, 1, 1, SpriteSheet.player4);	
	
	public static Sprite pl4_1A = new Sprite(48, 2, 0, SpriteSheet.player4);	
	public static Sprite pl4_2A = new Sprite(48, 2, 1, SpriteSheet.player4);	
	public static Sprite pl4_1A2 = new Sprite(48, 3, 0, SpriteSheet.player4);	
	public static Sprite pl4_2A2 = new Sprite(48, 3, 1, SpriteSheet.player4);	
	
	public static Sprite pl5_1 = new Sprite(64, 0, 0, SpriteSheet.player5);	
	public static Sprite pl5_2 = new Sprite(64, 0, 1, SpriteSheet.player5);	
	public static Sprite pl5_1M = new Sprite(64, 1, 0, SpriteSheet.player5);	
	public static Sprite pl5_2M = new Sprite(64, 1, 1, SpriteSheet.player5);	
	
	public static Sprite pl5_1A = new Sprite(64, 2, 0, SpriteSheet.player5);	
	public static Sprite pl5_2A = new Sprite(64, 2, 1, SpriteSheet.player5);	
	public static Sprite pl5_1A2 = new Sprite(64, 3, 0, SpriteSheet.player5);	
	public static Sprite pl5_2A2 = new Sprite(64, 3, 1, SpriteSheet.player5);	
	
	public static Sprite pl4_1J = new Sprite(48, 0, 2, SpriteSheet.player4);	
	public static Sprite pl4_2J = new Sprite(48, 0, 3, SpriteSheet.player4);
	
	public static Sprite pl5_1J = new Sprite(64, 0, 2, SpriteSheet.player5);	
	public static Sprite pl5_2J = new Sprite(64, 0, 3, SpriteSheet.player5);
	
	public static Sprite pl5_1R = new Sprite(64, 2, 3, SpriteSheet.player5);	
	public static Sprite pl5_2R = new Sprite(64, 3, 3, SpriteSheet.player5);	

	
	
	public static Sprite pl2_1 = new Sprite(24, 5, 0, SpriteSheet.tiles);
	
	public static Sprite pl2_2 = new Sprite(24, 5, 1, SpriteSheet.tiles);
	
	public static Sprite pl2_1M = new Sprite(24, 6, 0, SpriteSheet.tiles);	
	public static Sprite pl2_2M = new Sprite(24, 6, 1, SpriteSheet.tiles);
	
	
	public static Sprite pl2_1A = new Sprite(24, 7, 0, SpriteSheet.tiles);	
	public static Sprite pl2_2A = new Sprite(24, 7, 1, SpriteSheet.tiles);
	public static Sprite pl2_1A2 = new Sprite(24, 8, 0, SpriteSheet.tiles);	
	public static Sprite pl2_2A2 = new Sprite(24, 8, 1, SpriteSheet.tiles);
	
	public static Sprite pl3_1J = new Sprite(32, 0, 2, SpriteSheet.player3);	
	public static Sprite pl3_2J = new Sprite(32, 0, 3, SpriteSheet.player3);

	public static Sprite pl2_1J = new Sprite(24, 9, 0, SpriteSheet.tiles);	
	public static Sprite pl2_2J = new Sprite(24, 9, 1, SpriteSheet.tiles);

	
	public static Sprite pl1_1M = new Sprite(16, 2, 0, SpriteSheet.tiles);	
	public static Sprite pl1_2M = new Sprite(16, 2, 1, SpriteSheet.tiles);	
	
	public static Sprite pl1_1M2 = new Sprite(16, 3, 0, SpriteSheet.tiles);	
	public static Sprite pl1_2M2 = new Sprite(16, 3, 1, SpriteSheet.tiles);	
	
	public static Sprite pl1_1A = new Sprite(16, 4, 0, SpriteSheet.tiles);	
	public static Sprite pl1_2A = new Sprite(16, 4, 1, SpriteSheet.tiles);	
	
	public static Sprite pl1_1A2 = new Sprite(16, 5, 0, SpriteSheet.tiles);	
	public static Sprite pl1_2A2 = new Sprite(16, 5, 1, SpriteSheet.tiles);	
	
	public static Sprite humM1 = new Sprite(16, 0, 2, SpriteSheet.tiles);	
	public static Sprite humM2 = new Sprite(16, 0, 3, SpriteSheet.tiles);	
	public static Sprite humMM1 = new Sprite(16, 1, 2, SpriteSheet.tiles);	
	public static Sprite humMM2 = new Sprite(16, 1, 3, SpriteSheet.tiles);	
	public static Sprite humMG = new Sprite(16, 4, 3, SpriteSheet.tiles);	

	public static Sprite humMD1 = new Sprite(16, 5, 3, SpriteSheet.tiles);	
	public static Sprite humMD2 = new Sprite(16, 6, 3, SpriteSheet.tiles);	
	
	public static Sprite hpF = new Sprite(8, 0, 2, SpriteSheet.tiles);	
	public static Sprite hpE = new Sprite(8, 1, 2, SpriteSheet.tiles);	
	public static Sprite hpD = new Sprite(8, 0, 3, SpriteSheet.tiles);	

	public static Sprite tank = new Sprite(86, 0, 0, SpriteSheet.tank);	

	
	
	public static Sprite uppmenu = new Sprite(128, 0, 0, SpriteSheet.ui);	
	public static Sprite dead = new Sprite(128, 3, 0, SpriteSheet.ui);	

	
	public static Sprite airPart = new Sprite(4, 0, 0, SpriteSheet.part);
	public static Sprite acidPart = new Sprite(4, 0, 1, SpriteSheet.part);	

	public static Sprite hit8 = new Sprite(8, 0, 1, SpriteSheet.part);	
	public static Sprite hit16 = new Sprite(16, 0, 1, SpriteSheet.part);	

	
	public static Sprite blood = new Sprite(4, 1, 0, SpriteSheet.part);	
	public static Sprite blood2 = new Sprite(4, 1, 1, SpriteSheet.part);	
	public static Sprite bullet = new Sprite(4, 2, 1, SpriteSheet.part);	

	public static Sprite blood3 = new Sprite(8, 1, 1, SpriteSheet.part);	

	
	
	
	
	
	public static Sprite stoneskin = new Sprite(16, 0, 0, SpriteSheet.ico);	
	public static Sprite lavaskin = new Sprite(16, 1, 0, SpriteSheet.ico);	
	public static Sprite noskin = new Sprite(16, 2, 0, SpriteSheet.ico);	

	public static Sprite nofood = new Sprite(16, 0, 1, SpriteSheet.ico);	
	public static Sprite acid = new Sprite(16, 1, 1, SpriteSheet.ico);	
	public static Sprite fastfire = new Sprite(16, 2, 1, SpriteSheet.ico);	
	
	public static Sprite back = new Sprite(16, 0, 2, SpriteSheet.ico);	
	public static Sprite born = new Sprite(16, 1, 2, SpriteSheet.ico);	
	public static Sprite stronglegs = new Sprite(16, 2, 2, SpriteSheet.ico);	
	
	public static Sprite exoskel = new Sprite(16, 0, 3, SpriteSheet.ico);	
	public static Sprite knifeh = new Sprite(16, 1, 3, SpriteSheet.ico);	
	public static Sprite alum = new Sprite(16, 2, 3, SpriteSheet.ico);	
	
	public static Sprite spikearm = new Sprite(16, 3, 0, SpriteSheet.ico);	
	public static Sprite chainacid = new Sprite(16, 3, 1, SpriteSheet.ico);	
	public static Sprite roll = new Sprite(16, 3, 2, SpriteSheet.ico);	
	
	public static Sprite locked = new Sprite(16, 3, 3, SpriteSheet.ico);	
	
	
	
	
	public static Sprite txt00 = new Sprite(64, 2, 0, SpriteSheet.ui);	
	public static Sprite txt01 = new Sprite(64, 3, 0, SpriteSheet.ui);	
	public static Sprite txt02 = new Sprite(64, 4, 0, SpriteSheet.ui);	

	public static Sprite txt10 = new Sprite(64, 2, 1, SpriteSheet.ui);	
	public static Sprite txt11 = new Sprite(64, 3, 1, SpriteSheet.ui);	
	public static Sprite txt12 = new Sprite(64, 4, 1, SpriteSheet.ui);	
	
	public static Sprite txt20 = new Sprite(64, 2, 2, SpriteSheet.ui);	
	public static Sprite txt21 = new Sprite(64, 3, 2, SpriteSheet.ui);	
	public static Sprite txt22 = new Sprite(64, 4, 2, SpriteSheet.ui);	
	
	public static Sprite txt30 = new Sprite(64, 2, 3, SpriteSheet.ui);	
	public static Sprite txt31 = new Sprite(64, 3, 3, SpriteSheet.ui);	
	public static Sprite txt32 = new Sprite(64, 4, 3, SpriteSheet.ui);	
	
	public static Sprite txt40 = new Sprite(64, 2, 4, SpriteSheet.ui);	
	public static Sprite txt41 = new Sprite(64, 3, 4, SpriteSheet.ui);	
	public static Sprite txt42 = new Sprite(64, 4, 4, SpriteSheet.ui);	
	

	public Sprite (int size, int x, int y, SpriteSheet sheet){
	    SIZE = size;
	    pixels = new int[SIZE * SIZE];
	    this.x = x * size;
	    this.y = y * size;
	    this.sheet = sheet;
	    load();
	}
	
	public Sprite (int size, int colour){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
	}
	
	private void setColour(int colour) {
		for (int i = 0; i < SIZE * SIZE; i++){
			pixels[i] = colour;
		}
		
	}

	private void load(){
		for (int y = 0;y < SIZE; y++ ) {
			for (int x = 0;x < SIZE; x++ ) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}

}
