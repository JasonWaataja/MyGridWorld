package tron;

import info.gridworld.grid.*;
import info.gridworld.actor.*;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class TronGame {
	
	TronWorld world;
	
	private TronPlayer p1;
	private TronPlayer p2;
	
	public TronGame() {
		p1 = new TronPlayer(KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D);
		p1.setColor(Color.BLUE);
		p1.setName("Player1");
		p2 = new TronPlayer();
		p2.setColor(Color.ORANGE);
		p2.setName("Player2");
		
		world = new TronWorld(this);
		world.add(new Location(5, 5), p1);
		world.add(new Location(10, 10), p2);
		
		world.show();
		
		//p1.setFrame(world.getFrame());
		//p2.setFrame(world.getFrame());
	}

	public static void main(String[] args) {
		TronGame game = new TronGame();
	}
	
	public void exitGame() {
		System.exit(0);
	}
	
	public void win(TronPlayer player) {
		JOptionPane.showMessageDialog(new JFrame(), "Player " + player.getName() + " Won");
		exitGame();
	}
	
	public void tie() {
		JOptionPane.showMessageDialog(new JFrame(), "No Player won");
		exitGame();
	}
}
