package net.game;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private String path;
	public final int SIZE;
	public int[] pixels;
	
	public static SpriteSheet tiles = new SpriteSheet("/tiles.png",256);
	public static SpriteSheet part = new SpriteSheet("/part.png",256);
	public static SpriteSheet enviorment = new SpriteSheet("/enviorment.png",256);
	public static SpriteSheet ui = new SpriteSheet("/ui.png",512);

	public static SpriteSheet player3 = new SpriteSheet("/Player3.png",128);
	public static SpriteSheet player4 = new SpriteSheet("/Player4.png",196);

	public static SpriteSheet player5 = new SpriteSheet("/Player5.png",256);

	public static SpriteSheet ico = new SpriteSheet("/ico.png",64);
	public static SpriteSheet tank = new SpriteSheet("/tank.png",86);

	public SpriteSheet(String path, int size) {
		this.path = path;
	    SIZE = size;
		pixels = new int[SIZE * SIZE];
		load();
		
	}
	
	private void load(){
		try {
			BufferedImage image= ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
