package LeagueInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

public GamePanel(){
	framerate = new Timer(1000/60, this);
	go = new GameObject();
	titleFont = ();
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
	
}

@Override
public void keyReleased(KeyEvent e) {
	System.out.println("Key was Released: " + e);
	
}
public void updateMenuState(){
	
}
public void updateGameState(){
	
}
public void updateEndState(){
	
}
public void drawMenuState(Graphics g){
	g.setColor(Color.ORANGE);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);   
}
public void drawGameState(Graphics g){
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 
}
public void drawEndState(Graphics g){
	g.setColor(Color.RED);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 
}
}
