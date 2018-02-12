package window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;

import javax.swing.JPanel;
import board.Board;
import game_controller.GameController;

public class GamePanel extends JPanel {
	
	private final int WIDTH_UNIT_TIMES = 19;
	private final int HEIGHT_UNIT_TIMES = 22;
	private int unitSize;
	
	// public methods
	public void addBoard() throws IOException{
		Board board = new Board(unitSize);
		this.add(board);
		int boardWidth = WIDTH_UNIT_TIMES * unitSize;
		int boardHeight = HEIGHT_UNIT_TIMES * unitSize;
		board.setBounds((this.getWidth() - boardWidth) / 2,
						(this.getHeight() - boardHeight) / 2,
						boardWidth,
						boardHeight);
	}
	
	// constructors
	public GamePanel(int unitSize) {
		this.unitSize = unitSize;
		this.setLayout(null);
		this.setBackground(Color.BLACK);
	}
}
