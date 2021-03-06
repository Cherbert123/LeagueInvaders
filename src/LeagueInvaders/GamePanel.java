package LeagueInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{  
Timer framerate;
GameObject go;
final int MENU_STATE = 0;
final int GAME_STATE = 1;
final int END_STATE = 2;
int currentState = MENU_STATE;
Font titleFont;
Font subtitleFont;
Rocketship rocket = new Rocketship(250,700,50,50);
ObjectManager om = new ObjectManager();
public static BufferedImage alienImg;
public static BufferedImage rocketImg;
public static BufferedImage bulletImg;
String leagueInvadersT;

public GamePanel(){
	framerate = new Timer(1000/60, this);
	go = new GameObject();
	titleFont = new Font("Arial",Font.PLAIN,48);
	subtitleFont = new Font("Arial",Font.PLAIN,24);
	om.addObject(rocket);
	try {
		alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
		rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
		bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

public void actionPerformed(ActionEvent e) {
repaint();
if(currentState == MENU_STATE){
	updateMenuState();
}else if(currentState == GAME_STATE){
	updateGameState();
}else if(currentState == END_STATE){
	updateEndState();
}
}
public void startGame(){
	framerate.start();
}
public void paintComponent(Graphics g){
if(currentState == MENU_STATE){
	drawMenuState(g);
}else if(currentState == GAME_STATE){
	drawGameState(g);
}else if(currentState == END_STATE){
	drawEndState(g);
}
}

@Override
public void keyTyped(KeyEvent e) {
	System.out.println("Key was Typed: " + e);
	
}

@Override
public void keyPressed(KeyEvent e) {
	System.out.println("Key was pressed: " + e);
	if(e.getKeyCode() == 10){
		if(currentState == END_STATE){
			System.out.println("t1");
			currentState = MENU_STATE;
		} else if(currentState == MENU_STATE){
			currentState = GAME_STATE;
			System.out.println("t2");
		} else if(currentState == GAME_STATE){
			currentState = END_STATE;
			System.out.println("t3");
		}
	}
	if(e.getKeyCode() == 39){
		rocket.right = true;
		rocket.update();
	}
	if(e.getKeyCode() == 37){
		rocket.left = true;
		rocket.update();
	}
	if(e.getKeyCode() == 38){
		rocket.up = true;
		rocket.update();
	}
	if(e.getKeyCode() == 40){
	rocket.down = true;
	rocket.update();
	}
	if(e.getKeyCode() == 32){
		om.addObject(new Projectile(rocket.x + 20 , rocket.y, 10, 10));

	}
	
	}

@Override
public void keyReleased(KeyEvent e) {
	System.out.println("Key was Released: " + e);
	if(e.getKeyCode() == 39){
		rocket.right = false;
		rocket.update();
	}
	if(e.getKeyCode() == 37){
		rocket.left = false;
		rocket.update();
	}
	if(e.getKeyCode() == 38){
		rocket.up = false;
		rocket.update();
	}
	if(e.getKeyCode() == 40){
	rocket.down = false;
	rocket.update();
	}
}
public void updateMenuState(){
	
}
public void updateGameState(){
om.update();
om.manageEnemies();
om.randomizeE();
om.enemyTimer = om.enemyTimer - om.getScore() * 2;
om.checkCollision();
om.getScore();
	if(rocket.isAlive == false){
		currentState = END_STATE;
		om.reset();
		rocket = new Rocketship(250,700,50,50);
		om.addObject(rocket);
	}
}
public void updateEndState(){
	
}
public void drawMenuState(Graphics g){
	leagueInvadersT = "League Invaders";
	g.setColor(Color.ORANGE);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setFont(titleFont);
	g.setColor(Color.WHITE);
	g.drawString(leagueInvadersT, 75, 350);
	g.setFont(subtitleFont);
	g.drawString("(press enter to begin)", 125, 400);
	om.setScore(0);
}
public void drawGameState(Graphics g){
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	om.draw(g);
}
public void drawEndState(Graphics g){
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 
	g.setFont(titleFont);
	g.setColor(Color.WHITE);
	g.drawString("Game Over", 75, 350);
	g.setFont(subtitleFont);
	g.drawString("(press enter to restart)", 75, 400);
}
}
