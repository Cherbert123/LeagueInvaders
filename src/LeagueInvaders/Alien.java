package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{
	int speed;
	public Alien(int x, int y, int width, int height){
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 10;
		
	}
	public void update(){
		super.update();
		y += speed;
		if(y <= 0){
			isAlive = false;
		}
	}
	public void draw(Graphics g){
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}
}
