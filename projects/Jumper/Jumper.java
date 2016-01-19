import info.gridworld.grid.*;
import info.gridworld.actor.*;
import info.gridworld.world.*;
import java.awt.Color;

//A Jumper is an actor that jumps around by 2 spaces, and only one if it can't. If it can't move at all, then it turns.k
public class Jumper extends Actor {

	//constructor that sets color to given arg
	public Jumper(Color jumperColor) {
		setColor(jumperColor);
	}

	//no arg constructor that defaults to red
	public Jumper() {
		this(Color.RED);
	}

	// moves 2 if it can, if it can't, then it moves 1, if it can't, then it turns
	public void act() {
		if (canMoveTwo()) {
			moveTwo();
		} else if (canMoveOne()) {
			moveOne();
		} else {
			turn();
		}
	}

	public boolean canMoveTwo() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return false;
		Location loc = getLocation();
		Location nextTwo = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
		if (!gr.isValid(nextTwo))
			return false;
		Actor atNextTwo = gr.get(nextTwo);
		return (atNextTwo == null) || (atNextTwo instanceof Flower);
	}

	public boolean canMoveOne() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return false;
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if (!gr.isValid(next))
			return false;
		Actor neighbor = gr.get(next);
		return (neighbor == null) || (neighbor instanceof Flower);
	}

	public void moveTwo() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location loc = getLocation();
		Location nextTwo = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
		if (gr.isValid(nextTwo))
			moveTo(nextTwo);
		else
			removeSelfFromGrid();
	}

	public void moveOne() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location loc = getLocation();
		Location nextTwo = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
		if (gr.isValid(nextTwo))
			moveTo(nextTwo);
		else
			removeSelfFromGrid();
	}

	public void turn() {
		setDirection(getDirection() + Location.HALF_RIGHT);
	}
}
