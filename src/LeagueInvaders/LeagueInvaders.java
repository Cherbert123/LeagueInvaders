package LeagueInvaders;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	JFrame frame;
	GamePanel gprun;
public static void main(String[] args) {
	final int x = 500;
	final int y = 800;
	LeagueInvaders toRun = new LeagueInvaders();
	
	toRun.setup();
}
public LeagueInvaders(){
	frame = new JFrame();
	gprun = new GamePanel();
}
public void setup(){
	frame.add(gprun);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gprun.startGame();
}
}
