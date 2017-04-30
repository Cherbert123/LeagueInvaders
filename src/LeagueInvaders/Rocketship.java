package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	
int speed;
boolean up = false;
boolean down = false;
boolean right = false;
boolean left = false;
	public Rocketship(int x, int y, int width, int height){
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 5;
	}
	public void update(){
		super.update();
		if(up){
			y-=speed;
		}
		if(down){
			y+=speed;
		}
		if(right){
			x+=speed;
		}
		if(left){
			x-=speed;
		}
		if(y > 725){
			y = 725;
		}
		if(y < 600){
			y = 600;
		}
		if(x > 430){
			x = 430;
		}
		if(x < 10){
			x = 10;
		}			
	}
	public void draw(Graphics g){
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}
}
