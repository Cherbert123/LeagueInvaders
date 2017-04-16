package LeagueInvaders;

import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	public GameObject(){
		
	}
	public void update(){
		x++;
		y++;
	}
	public void draw(Graphics g){
		g.fillRect(x, y, 100, 100);
	}
}
