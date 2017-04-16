package LeagueInvaders;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	JFrame frame;
	GamePanel gprun;
	static final int WIDTH = 500;
	static final int HEIGHT = 800;
public static void main(String[] args) {
	
	LeagueInvaders toRun = new LeagueInvaders();
	
	toRun.setup();
}
public LeagueInvaders(){
	frame = new JFrame();
	gprun = new GamePanel();
}
public void setup(){
	frame.setSize(WIDTH, HEIGHT);
	frame.add(gprun);
	frame.addKeyListener(gprun);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gprun.startGame();
}

}
