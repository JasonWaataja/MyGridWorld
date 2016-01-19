package tron;

import info.gridworld.world.World;
import info.gridworld.world.*;
import info.gridworld.grid.*;

import java.util.ArrayList;

import javax.swing.KeyStroke;

import info.gridworld.actor.*;

public class TronWorld extends ActorWorld {
	
	public static final int GRID_LENGTH = 20;
	
	private ArrayList<TronPlayer> players;
	private TronGame game;
	
	public TronWorld(TronGame game) {
		super(new BoundedGrid<Actor>(GRID_LENGTH, GRID_LENGTH));
		this.game = game;
		players = new ArrayList<TronPlayer>();
	}
	
    public boolean keyPressed(String description, Location loc)
    {
        KeyStroke stroke = KeyStroke.getKeyStroke(description);
        int keyCode = stroke.getKeyCode();
        for (TronPlayer player : players) {
        	player.processKeyCode(keyCode);
        }
        return true;
    }
    
    public void add(Location loc, Actor occupant) {
    	super.add(loc, occupant);
    	if (occupant instanceof TronPlayer) {
    		players.add((TronPlayer) occupant);
    	}
    }
    
    public void step() {
    	super.step();
    	ArrayList<TronPlayer> alivePlayers = new ArrayList<TronPlayer>();
    	for (TronPlayer player : players) {
    		if (player.isAlive()) {
    			alivePlayers.add(player);
    		}
    	}
    	if (alivePlayers.size() == 1) {
    		game.win(alivePlayers.get(0));
    	}
    	if (alivePlayers.size() == 0 && players.size() > 0) {
    		game.tie();
    	}
    }
}