package tron;

import info.gridworld.grid.*;
import info.gridworld.actor.*;

import java.util.*;


public class TronGame {
	
	TronWorld world;
	
	private TronPlayer p1;
	private TronPlayer p2;
	
	public TronGame() {
		p1 = new TronPlayer();
		p2 = new TronPlayer();
		
		world = new TronWorld();
		world.add(new Location(5, 5), p1);
		world.add(new Location(10, 10), p2);
		
		world.show();
	}

	public static void main(String[] args) {
		TronGame game = new TronGame();
	}
}
