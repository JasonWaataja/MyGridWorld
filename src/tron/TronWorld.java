package tron;

import info.gridworld.world.World;
import info.gridworld.world.*;
import info.gridworld.grid.*;
import info.gridworld.actor.*;

public class TronWorld extends ActorWorld {
	
	public static final int GRID_LENGTH = 20;
	
	public TronWorld() {
		super(new BoundedGrid<Actor>(GRID_LENGTH, GRID_LENGTH));
	}
	
	
}
