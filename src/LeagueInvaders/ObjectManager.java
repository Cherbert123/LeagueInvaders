package LeagueInvaders;


import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;
	String enemyP = "0000110000";
	int enemyPCharToInt;
	int  enemyPL = 0;
	private int score = 0;
	
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	
	public ObjectManager() {
		objects = new ArrayList<GameObject>();
	}

	public void addObject(GameObject o) {
		objects.add(o);
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
		}
		
		purgeObjects();	
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}

	public void manageEnemies(){
		if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
			for(int i = 0; i < 10;i++){
				enemyPL = enemyP.substring(0, i).length();

				if(enemyP.charAt(i) == '1'){
					addObject(new Alien(enemyPL * 50, 0, 50, 50));
				}
				
			}
			
			
			enemyTimer = System.currentTimeMillis();
		}
	}
	public void randomizeE(){
		Random random = new Random();
		int rand = random.nextInt(10);
		if(rand == 1){
			enemyP = "1111111111";
		}else if(rand == 2){
			enemyP = "0001111000";	
		
		}else if(rand == 3){
			enemyP = "0000110000";
		
		}else if(rand == 4){
			enemyP = "1100000011";
		
		}else if(rand == 5){
			enemyP = "1000100011";
		
		}else if(rand == 6){
			enemyP = "0000011111";
		
		}else if(rand == 7){
			enemyP = "1111100000";
		
		}else if(rand == 8){
			enemyP = "1110000000";
		
		}else if(rand == 9){
			enemyP = "0000000111";
		
		}else if(rand == 0){
			enemyP = "1111001111";
		}
		}
	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				
				if(o1.collisionBox.intersects(o2.collisionBox)){
					if((o1 instanceof Alien && o2 instanceof Projectile) ||
					   (o2 instanceof Alien && o1 instanceof Projectile)){
						score++;
						System.out.println(score);
						o1.isAlive = false;
						o2.isAlive = false;
					}
					else if((o1 instanceof Alien && o2 instanceof Rocketship) ||
							(o2 instanceof Alien && o1 instanceof Rocketship)){
						o1.isAlive = false;
						o2.isAlive = false;
					}
	
				}
			}
		}
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int s){
		score = s;
	}
	
	public void reset(){
		objects.clear();
	}
}
