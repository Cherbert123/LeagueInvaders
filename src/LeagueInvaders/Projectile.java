package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	int speed;
	public Projectile(int x, int y, int width, int height){
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 10;
		
	}
	public void update(){
		super.update();
		y -= speed;
		if(y <= 0){
			isAlive = false;
		}
	}
	public void draw(Graphics g){
		g.drawImage(GamePanel.bulletImg, x, y, width, height, null);
	}
}
