package tron;

import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener;

import info.gridworld.actor.Actor;
import info.gridworld.grid.*;

public class TronPlayer extends Actor implements KeyListener {
	
	//key codes for each of the directions;
	private int upKey;
	private int downKey;
	private int leftKey;
	private int rightKey;
	
	/**
	 * represents whether or not the player has run into a wall or something yet.
	 */
	private boolean isAlive;
	
	/**
	 * constructor that sets each of the key codes to the args
	 * @param upKey
	 * @param downKey
	 * @param leftKey
	 * @param rightKey
	 */
	public TronPlayer(int upKey, int downKey, int leftKey, int rightKey) {
		setKeys(upKey, downKey, leftKey, rightKey);
		setDirection(Location.NORTH);
		isAlive = true;
		
	}
	
	/**
	 * constructor with default key codes set to the arrow keys
	 */
	public TronPlayer() {
		this(VK_UP, VK_DOWN, VK_LEFT, VK_RIGHT);
	}
	
	/**
	 * constructor that sets the initial direction
	 * @param startingDirection
	 */
	public TronPlayer(int startingDirection) {
		this();
		setDirection(startingDirection);
	}
	
	/**
	 * sets each of the 4 direction key codes to the arguments.
	 * @param upKey
	 * @param downKey
	 * @param leftKey
	 * @param rightKey
	 */
	public void setKeys(int upKey, int downKey, int leftKey, int rightKey) {
		this.upKey = upKey;
		this.downKey = downKey;
		this.leftKey = leftKey;
		this.rightKey = rightKey;
	}
	
	/**
	 * returns the key codes for each of the directions in the up down left right order.
	 * @return
	 */
	public int[] getKeyCodes() {
		return new int[]{upKey, downKey, leftKey, rightKey};
	}
	
	/**
	 * turns 90 degrees right
	 */
	public void turnRight() {
		setDirection((getDirection() + Location.HALF_RIGHT) % Location.FULL_CIRCLE);
	}
	
	/**
	 * turns 90 degrees left.
	 */
	public void turnLeft() {
		setDirection((getDirection() + Location.HALF_LEFT) % Location.FULL_CIRCLE);
	}
		
	@Override
	public void keyPressed(KeyEvent arg0) {
		int keyCode = arg0.getKeyCode();
		switch (keyCode) {
		
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * returns the direction that is assigned to the given key code, returns 0 for no match
	 * @param keyCode
	 * @return
	 */
	public int getDirectionFromKey(int keyCode) {
		if (keyCode == upKey) {
			return Location.NORTH;
		} else if (keyCode == downKey) {
			return Location.SOUTH;
		} else if (keyCode == leftKey) {
			return Location.WEST;
		} else if (keyCode == rightKey) {
			return Location.EAST;
		} else 
			return Location.NORTH;
	}
	
	public void move() {
		Grid<Actor> grid = getGrid();
		Location nextLocation = getLocation().getAdjacentLocation(getDirection());
		Location currentLocation = getLocation();
		if (grid.isValid(nextLocation) && grid.get(nextLocation) == null) {
			moveTo(nextLocation);
			//WallActor wall = new WallActor(getDirection());
			//wall.putSelfInGrid(grid, currentLocation);
		} else {
			destroy();
		}
	}
		
	public void destroy() {
		this.isAlive = false;
		this.removeSelfFromGrid();
	}
	
	public void act() {
		move();
	}
}
