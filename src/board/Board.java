package board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import entity.Ball;
import entity.Enemy;
import entity.Pacman;
import entity.SuperBall;
import entity.Wall;
import game_controller.GameController;
import game_controller.Supervisor;
import integer.IntRef;
import movement.Direction;

public class Board extends JPanel implements Supervisor {
	
	private int u;
	private Pacman pacman;
	GameController gameController;
	private List<Wall> wallList;
	private List<Ball> ballList;
	private List<SuperBall> superBallList;
	private List<Enemy> enemyList;
	
	//private methods	
	private void createWalls(){
		wallList.add(new Wall(  0 * u,  0 * u, 19 * u,  1 * u));
		wallList.add(new Wall(  0 * u, 21 * u, 19 * u,  1 * u));
		
		wallList.add(new Wall(  0 * u,  1 * u,  1 * u, 20 * u));
		wallList.add(new Wall( 18 * u,  1 * u,  1 * u, 20 * u));
		
		wallList.add(new Wall(  2 * u,  2 * u,  2 * u,  2 * u));
		wallList.add(new Wall( 15 * u,  2 * u,  2 * u,  2 * u));
		
		wallList.add(new Wall(  5 * u,  2 * u,  3 * u,  2 * u));	
		wallList.add(new Wall( 11 * u,  2 * u,  3 * u,  2 * u));
		
		wallList.add(new Wall(  9 * u,  1 * u,  1 * u,  3 * u));
		
		wallList.add(new Wall(  2 * u,  5 * u,  2 * u,  1 * u));
		wallList.add(new Wall( 15 * u,  5 * u,  2 * u,  1 * u));
		
		wallList.add(new Wall(  5 * u,  5 * u,  1 * u,  5 * u));
		wallList.add(new Wall( 13 * u,  5 * u,  1 * u,  5 * u));
		
		wallList.add(new Wall(  7 * u,  5 * u,  5 * u,  1 * u));
		
		wallList.add(new Wall(  9 * u,  6 * u,  1 * u,  2 * u));
		
		wallList.add(new Wall(  6 * u,  7 * u,  2 * u,  1 * u));
		wallList.add(new Wall( 11 * u,  7 * u,  2 * u,  1 * u));
		
		wallList.add(new Wall(  1 * u,  7 * u,  3 * u,  3 * u));
		wallList.add(new Wall( 15 * u,  7 * u,  3 * u,  3 * u));
		
		wallList.add(new Wall(  7 * u,  9 * u,  2 * u,  1 * u));
		wallList.add(new Wall( 10 * u,  9 * u,  2 * u,  1 * u));
		
		wallList.add(new Wall(  7 * u, 10 * u,  1 * u,  1 * u));
		wallList.add(new Wall( 11 * u, 10 * u,  1 * u,  1 * u));
		
		wallList.add(new Wall(  7 * u, 11 * u,  5 * u,  1 * u));
		
		wallList.add(new Wall(  1 * u, 11 * u,  3 * u,  3 * u));
		wallList.add(new Wall( 15 * u, 11 * u,  3 * u,  3 * u));
		
		wallList.add(new Wall(  5 * u, 11 * u,  1 * u,  3 * u));
		wallList.add(new Wall( 13 * u, 11 * u,  1 * u,  3 * u));
		
		wallList.add(new Wall(  7 * u,  13 * u, 5 * u,  1 * u));
		
		wallList.add(new Wall(  9 * u,  14 * u, 1 * u,  2 * u));
		
		wallList.add(new Wall(  2 * u, 15 * u,  1 * u,  1 * u));
		wallList.add(new Wall( 16 * u, 15 * u,  1 * u,  1 * u));
		
		wallList.add(new Wall(  3 * u, 15 * u,  1 * u,  3 * u));
		wallList.add(new Wall( 15 * u, 15 * u,  1 * u,  3 * u));
		
		wallList.add(new Wall(  5 * u, 15 * u,  3 * u,  1 * u));
		wallList.add(new Wall( 11 * u, 15 * u,  3 * u,  1 * u));

		wallList.add(new Wall(  1 * u, 17 * u,  1 * u,  1 * u));
		wallList.add(new Wall( 17 * u, 17 * u,  1 * u,  1 * u));
		
		wallList.add(new Wall(  7 * u, 17 * u,  5 * u,  1 * u));
		
		wallList.add(new Wall(  5 * u, 17 * u,  1 * u,  2 * u));
		wallList.add(new Wall( 13 * u, 17 * u,  1 * u,  2 * u));
		
		wallList.add(new Wall(  9 * u, 18 * u,  1 * u,  2 * u));
		
		wallList.add(new Wall(  2 * u, 19 * u,  6 * u,  1 * u));
		wallList.add(new Wall( 11 * u, 19 * u,  6 * u,  1 * u));
	}
	
	private void createBalls(){
		ballList.add(new Ball(  2 * u,  1 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  3 * u,  1 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  4 * u,  1 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  5 * u,  1 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  6 * u,  1 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  7 * u,  1 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  8 * u,  1 * u,  1 * u,  1 * u));	
		ballList.add(new Ball( 10 * u,  1 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 11 * u,  1 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 12 * u,  1 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 13 * u,  1 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 14 * u,  1 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 15 * u,  1 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 16 * u,  1 * u,  1 * u,  1 * u));
		
		ballList.add(new Ball(  1 * u,  2 * u,  1 * u,  1 * u));	
		ballList.add(new Ball(  4 * u,  2 * u,  1 * u,  1 * u));	
		ballList.add(new Ball(  8 * u,  2 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 10 * u,  2 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 14 * u,  2 * u,  1 * u,  1 * u));	
		ballList.add(new Ball( 17 * u,  2 * u,  1 * u,  1 * u));
		
		ballList.add(new Ball(  1 * u,  3 * u,  1 * u,  1 * u));	
		ballList.add(new Ball(  4 * u,  3 * u,  1 * u,  1 * u));	
		ballList.add(new Ball(  8 * u,  3 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 10 * u,  3 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 14 * u,  3 * u,  1 * u,  1 * u));	
		ballList.add(new Ball( 17 * u,  3 * u,  1 * u,  1 * u));
		
		ballList.add(new Ball(  1 * u,  4 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  2 * u,  4 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  3 * u,  4 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  4 * u,  4 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  5 * u,  4 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  6 * u,  4 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  7 * u,  4 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  8 * u,  4 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  9 * u,  4 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 10 * u,  4 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 11 * u,  4 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 12 * u,  4 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 13 * u,  4 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 14 * u,  4 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 15 * u,  4 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 16 * u,  4 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 17 * u,  4 * u,  1 * u,  1 * u));
		
		ballList.add(new Ball(  1 * u,  5 * u,  1 * u,  1 * u));	
		ballList.add(new Ball(  4 * u,  5 * u,  1 * u,  1 * u));	
		ballList.add(new Ball(  6 * u,  5 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 12 * u,  5 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 14 * u,  5 * u,  1 * u,  1 * u));	
		ballList.add(new Ball( 17 * u,  5 * u,  1 * u,  1 * u));

		ballList.add(new Ball(  1 * u,  6 * u,  1 * u,  1 * u));	
		ballList.add(new Ball(  2 * u,  6 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  3 * u,  6 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  4 * u,  6 * u,  1 * u,  1 * u));	
		ballList.add(new Ball(  6 * u,  6 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  7 * u,  6 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 11 * u,  6 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 12 * u,  6 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 14 * u,  6 * u,  1 * u,  1 * u));	
		ballList.add(new Ball( 15 * u,  6 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 16 * u,  6 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 17 * u,  6 * u,  1 * u,  1 * u));
		
		ballList.add(new Ball(  4 * u,  7 * u,  1 * u,  1 * u));	
		ballList.add(new Ball(  8 * u,  7 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 10 * u,  7 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 14 * u,  7 * u,  1 * u,  1 * u));	

		ballList.add(new Ball(  4 * u,  8 * u,  1 * u,  1 * u));	
		ballList.add(new Ball(  6 * u,  8 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  7 * u,  8 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  8 * u,  8 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  9 * u,  8 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 10 * u,  8 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 11 * u,  8 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 12 * u,  8 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 14 * u,  8 * u,  1 * u,  1 * u));
		
		ballList.add(new Ball(  4 * u,  9 * u,  1 * u,  1 * u));	
		ballList.add(new Ball(  6 * u,  9 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 12 * u,  9 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 14 * u,  9 * u,  1 * u,  1 * u));
		
		ballList.add(new Ball(  2 * u, 10 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  3 * u, 10 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  4 * u, 10 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  5 * u, 10 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  6 * u, 10 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 12 * u, 10 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 13 * u, 10 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 14 * u, 10 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 15 * u, 10 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 16 * u, 10 * u,  1 * u,  1 * u));
		
		ballList.add(new Ball(  4 * u, 11 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  6 * u, 11 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 12 * u, 11 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 14 * u, 11 * u,  1 * u,  1 * u));
		
		ballList.add(new Ball(  4 * u, 12 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  6 * u, 12 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  7 * u, 12 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  8 * u, 12 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 10 * u, 12 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 11 * u, 12 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 12 * u, 12 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 14 * u, 12 * u,  1 * u,  1 * u));
		
		ballList.add(new Ball(  4 * u, 13 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  6 * u, 13 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 12 * u, 13 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 14 * u, 13 * u,  1 * u,  1 * u));
		
		ballList.add(new Ball(  1 * u, 14 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  2 * u, 14 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  3 * u, 14 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  4 * u, 14 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  5 * u, 14 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  6 * u, 14 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  7 * u, 14 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  8 * u, 14 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 10 * u, 14 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 11 * u, 14 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 12 * u, 14 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 13 * u, 14 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 14 * u, 14 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 15 * u, 14 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 16 * u, 14 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 17 * u, 14 * u,  1 * u,  1 * u));
		
		ballList.add(new Ball(  1 * u, 15 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  4 * u, 15 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  8 * u, 15 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 10 * u, 15 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 14 * u, 15 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 17 * u, 15 * u,  1 * u,  1 * u));
		
		ballList.add(new Ball(  1 * u, 16 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  2 * u, 16 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  4 * u, 16 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  5 * u, 16 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  6 * u, 16 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  7 * u, 16 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  8 * u, 16 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 10 * u, 16 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 11 * u, 16 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 12 * u, 16 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 13 * u, 16 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 14 * u, 16 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 16 * u, 16 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 17 * u, 16 * u,  1 * u,  1 * u));
		
		ballList.add(new Ball(  2 * u, 17 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  4 * u, 17 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  6 * u, 17 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 12 * u, 17 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 14 * u, 17 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 16 * u, 17 * u,  1 * u,  1 * u));
		
		ballList.add(new Ball(  1 * u, 18 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  2 * u, 18 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  3 * u, 18 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  4 * u, 18 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  6 * u, 18 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  7 * u, 18 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  8 * u, 18 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 10 * u, 18 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 11 * u, 18 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 12 * u, 18 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 14 * u, 18 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 15 * u, 18 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 16 * u, 18 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 17 * u, 18 * u,  1 * u,  1 * u));
		
		ballList.add(new Ball(  1 * u, 19 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  8 * u, 19 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 10 * u, 19 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 17 * u, 19 * u,  1 * u,  1 * u));
		
		ballList.add(new Ball(  2 * u, 20 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  3 * u, 20 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  4 * u, 20 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  5 * u, 20 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  6 * u, 20 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  7 * u, 20 * u,  1 * u,  1 * u));
		ballList.add(new Ball(  8 * u, 20 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 10 * u, 20 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 11 * u, 20 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 12 * u, 20 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 13 * u, 20 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 14 * u, 20 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 15 * u, 20 * u,  1 * u,  1 * u));
		ballList.add(new Ball( 16 * u, 20 * u,  1 * u,  1 * u));
	}
	
	private void createSuperBalls(){
		superBallList.add(new SuperBall(   1 * u,  1 * u,  1 * u,  1 * u));
		superBallList.add(new SuperBall(  17 * u,  1 * u,  1 * u,  1 * u));
		superBallList.add(new SuperBall(   1 * u, 10 * u,  1 * u,  1 * u));
		superBallList.add(new SuperBall(  17 * u, 10 * u,  1 * u,  1 * u));
		superBallList.add(new SuperBall(   1 * u, 20 * u,  1 * u,  1 * u));
		superBallList.add(new SuperBall(  17 * u, 20 * u,  1 * u,  1 * u));
	}
	
	private void createEnemies(){
		enemyList.add(new Enemy(  8 * u,  6 * u,  1 * u,  1 * u, "green"));
		enemyList.add(new Enemy( 10 * u,  6 * u,  1 * u,  1 * u, "blue"));
		enemyList.add(new Enemy(  9 * u, 12 * u,  1 * u,  1 * u, "magenta"));
		enemyList.add(new Enemy(  9 * u, 16 * u,  1 * u,  1 * u, "red"));
	}
	
	private void createPacman() throws IOException{
		pacman = new Pacman(  9 * u, 20 * u,  1 * u,  1 * u);
	}
	
	// public methods
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		pacman.draw(g2);
		wallList.forEach(w -> w.draw(g2));
		ballList.forEach(b -> b.draw(g2));
		superBallList.forEach(sb -> sb.draw(g2));
		enemyList.forEach(e -> e.draw(g2));
		if(pacman.isDead()){
			gameController.stopTimer();
			g2.setColor(Color.RED);
			g2.drawString("Pora¿ka!", 100, 100);
		}
		else if(Ball.counter <= 0){
			gameController.stopTimer();
			g2.setColor(Color.RED);
			g2.drawString("Zwyciêstwo!", 100, 100);
		}
	}

	@Override
	public void verify(IntRef result) {
		Optional<Wall> outputWall = wallList.stream().filter(w -> w.getRect().intersects(pacman.getRect())).findAny();
		if(outputWall.isPresent())
			pacman.backup();
		Optional<Ball> outputBall = ballList.stream().filter(b -> b.getRect().intersects(pacman.getRect())).findAny();
		if(outputBall.isPresent()){
			Ball ball = outputBall.get();
			ball.decCounter();
			result.val += ball.getPoints(); 
			ballList.remove(ball);
		}
		Optional<SuperBall> outputSuperBall = superBallList.stream().filter(b -> b.getRect().intersects(pacman.getRect())).findAny();
		if(outputSuperBall.isPresent()){
			SuperBall superBall = outputSuperBall.get();
			superBall.decCounter();
			pacman.setPowerUp(superBall.getPowerUp());
			enemyList.forEach(e -> e.setScare(superBall.getPowerUp()));
			result.val += outputSuperBall.get().getPoints(); 
			superBallList.remove(superBall);
		}
		for(Enemy e: enemyList){
			outputWall = wallList.stream().filter(w -> w.getRect().intersects(e.getRect())).findAny();
			if(outputWall.isPresent()){;
				e.backup();
				e.setDirection(Direction.getRandomDirection());
			}
		}
		if(outputBall.isPresent()){
			Ball ball = outputBall.get();
			ball.decCounter();
			result.val += ball.getPoints(); 
			ballList.remove(ball);
		}
		Optional<Enemy> outputEnemy = enemyList.stream().filter(e -> e.getRect().intersects(pacman.getRect())).findAny();
		if(outputEnemy.isPresent()){
			Enemy enemy = outputEnemy.get();
			if(pacman.isPoweredUp())
				enemyList.remove(enemy);
			else
				pacman.setDead(true);
		}
		repaint();
	}
	
	// constructors
	public Board(int unit) throws IOException{
		this.setBackground(Color.BLACK);
		
		this.u = unit;
		wallList = new ArrayList<>(43);
		ballList = new ArrayList<>(200);
		superBallList = new ArrayList<>(8);
		enemyList = new ArrayList<>(6);
		createWalls();
		createBalls();
		createSuperBalls();
		createEnemies();
		createPacman();
		gameController = new GameController(this);
		gameController.addObs(pacman);
		enemyList.forEach(e -> gameController.addObs(e));
		DirectionAction actionUp = new DirectionAction(Direction.UP);
		DirectionAction actionRight = new DirectionAction(Direction.RIGHT);
		DirectionAction actionDown = new DirectionAction(Direction.DOWN);
		DirectionAction actionLeft = new DirectionAction(Direction.LEFT);
		
		InputMap imap = this.getInputMap(JComponent.WHEN_FOCUSED);
		imap.put(KeyStroke.getKeyStroke("UP"), "up");
		imap.put(KeyStroke.getKeyStroke("RIGHT"), "right");
		imap.put(KeyStroke.getKeyStroke("DOWN"), "down");
		imap.put(KeyStroke.getKeyStroke("LEFT"), "left");
		
		ActionMap amap = this.getActionMap(); 
		amap.put("up", actionUp);
		amap.put("right", actionRight);
		amap.put("down", actionDown);
		amap.put("left", actionLeft);
	}
	
	// inner classes
	private class DirectionAction extends AbstractAction{
		
		private Direction direction; 
		
		public DirectionAction(Direction direction){
			this.direction = direction;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			pacman.setDirection(direction);
		}
		
	}
}
