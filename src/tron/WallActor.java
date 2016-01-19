package tron;

import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class WallActor extends Actor {
	
	public WallActor(int direction, Color color) {
		this.setDirection(direction);
		this.setColor(color);
	}
	
	public boolean isNorthSouth() {
		int direction = getDirection();
		if (direction == Location.NORTH || direction == Location.SOUTH)
			return true;
		else
			return false;
	}
	
	public boolean isEastWest() {
		int direction = getDirection();
		if (direction == Location.EAST || direction == Location.SOUTH)
			return true;
		else
			return false;
	}
}
