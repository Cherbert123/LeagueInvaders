package LeagueInvaders;

public class Projectile extends GameObject{
	int speed;
	public Projectile(){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 10;
		
	}
	public void update(){
		y -= speed;
	}
}
