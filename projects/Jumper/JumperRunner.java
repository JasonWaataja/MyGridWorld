import info.gridworld.world.*;
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.awt.Color;

public class JumperRunner {

	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		Jumper alice = new Jumper();
		Jumper bob = new Jumper(Color.BLUE);
		world.add(new Location(7, 8), alice);
		world.add(new Location(5, 5), bob);
		bob.setDirection(Location.SOUTHEAST);
		world.show();
	}
}
