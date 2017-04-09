package LeagueInvaders;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
Timer framerate;
public GamePanel(){
	framerate = new Timer(1000/60, this);
}

public void actionPerformed(ActionEvent e) {
System.out.println("Timer Done");
	
}
public void startGame(){
	framerate.start();
}
}
