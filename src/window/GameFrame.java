package window;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

	private final int WIDTH_UNIT_TIMES = 21;
	private final int HEIGHT_UNIT_TIMES = 24;
	
	// constructors
	public GameFrame(int unit) throws IOException{
		int windowWidth = WIDTH_UNIT_TIMES * unit;
		int windowHeight = HEIGHT_UNIT_TIMES * unit;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(windowWidth, windowHeight);
		setLocation((screenSize.width - windowWidth) / 2, (screenSize.height - windowHeight) / 2);
		GamePanel game = new GamePanel(unit);
		setContentPane(game);
		
		setTitle("Pacman");
		setVisible(true);
		
		game.addBoard();
	}
}